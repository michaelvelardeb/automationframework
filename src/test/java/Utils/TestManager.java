package Utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


public class TestManager {
    public AutomationOperations ao;
    public Reporter reporter;
    public PropertyValues propertyValues;

    public static TestManager initializeTestManager(ExtentTest test) throws MalformedURLException {
        TestManager tm = new TestManager();
        tm.reporter = new Reporter();
        WebDriver driver = null;

        PropertyValues properties = new PropertyValues();
        try {
            properties.getPropValues();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        switch (properties.BROWSER) {
//            case "chrome" -> driver = new ChromeDriver(new ChromeOptions().addArguments("headless"));
            case "chrome" -> driver = new ChromeDriver(new ChromeOptions());
            case "chromeR" -> driver = new RemoteWebDriver(new URL(properties.SELENIUM_HUB),new ChromeOptions());
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }

//        tm.ao.logger = Logger.getLogger("automation_logger");
        tm.ao = AutomationOperations.initializeAutomationOperations(driver, Logger.getLogger("automation_logger"), test);
        tm.propertyValues = properties;
        return tm;

    }
}
