package tests;

import Utils.TestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.logging.Level;
import com.aventstack.extentreports.reporter.*;

public class TestMain {
    protected TestManager tm;
    ExtentSparkReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest test;

//@BeforeTest
//public void beforeSuite(){
//    String test = null;
//}
//
//@BeforeClass
//public void beforeClass() {
////    extentReports.attachReporter(htmlReporter);
//}




@BeforeClass(alwaysRun = true)
public void startReports() {
// initialize the HtmlReporter
//    htmlReporter  = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/Spark.html");

    //initialize ExtentReports and attach the HtmlReporter
    if(extentReports == null) {
        htmlReporter  = new ExtentSparkReporter("user/build/extent_report/" + new Random(100) +  "/");
//        htmlReporter  = new ExtentSparkReporter("user/build/extent_report/");

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

//    extentReports.attachReporter(htmlReporter);
    //configuration items to change the look and feel
    //add content, manage tests etc
    htmlReporter.config().setDocumentTitle("Extent Report Demo");
    htmlReporter.config().setReportName("Test Report");
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
}

//    @BeforeTest
//    public void startReport(String OS, String browser) {
//// initialize the HtmlReporter
////    htmlReporter  = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/Spark.html");
//        htmlReporter  = new ExtentSparkReporter("user/build/name/");
//        //initialize ExtentReports and attach the HtmlReporter
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(htmlReporter);
//        //configuration items to change the look and feel
//        //add content, manage tests etc
//        htmlReporter.config().setDocumentTitle("Extent Report Demo");
//        htmlReporter.config().setReportName("Test Report");
//        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//    }

@BeforeMethod(alwaysRun = true)
void setUpTestManager(Method method) {
//    test.getExtent().createTest(method.getName());
   test = extentReports.createTest(method.getName());
   test.info("BEGINNING TEST: " + method.getName());
   tm = new TestManager();
    try {
        tm = TestManager.initializeTestManager(test);
        tm.ao.logger.log(Level.INFO, "********************************************************************************************"
                + "\nset up complete using browser: " + tm.propertyValues.getBrowser()
                + "\n" + tm.ao.logger.getName()
                + "\nstarting test: " + method.getName()
                + "\n***************************************************************************************************");

    } catch (MalformedURLException e) {
        tm.ao.logger.log(Level.SEVERE, e.getMessage());
        test.info("Exception during TestManager Initialization................");
    }
}

@AfterMethod(alwaysRun = true)
void reportResults(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        }
        tearDown();
    }

//@AfterTest
public void tearDown() {
        //to write or update test information to reporter
//        extentReports.flush();
        tm.ao.logger.log(Level.INFO, "Test Complete Shutting down driver...............................");
        tm.ao.closeDriver();
    }

// TODO: 1/15/2022 TROUBLESHOOT EACH CLASS CREATING ITS OWN EXTENT REPORT
@AfterClass
public void afterClass () {
    extentReports.flush();
    }
}