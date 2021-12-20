package tests;

import Utils.TestManager;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;



public class TestMain {
    protected TestManager tm;

@BeforeMethod(alwaysRun = true)
void setUpTestManager(Method method) {
   tm = new TestManager();
    try {
        tm = TestManager.initializeTestManager();
//        tm.logger.log(Level.INFO, "**********************************************************"
//                + "\nset up complete using browser: "
//                + "\n" + tm.logger.getName()
//                + "\nstarting test: " + method.getName()
//                + "\n*******************************************************************************");

    } catch (MalformedURLException e) {
//        tm.logger.log(Level.SEVERE, e.getMessage());
    }

}

@AfterMethod(alwaysRun = true)
void closeTestManager() {
//        tm.logger.log(Level.INFO, "Test Complete Shutting down driver...............................");
        tm.dos.closeDriver();
    }
}
