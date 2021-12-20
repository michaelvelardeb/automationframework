package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;


import java.io.IOException;
import java.net.MalformedURLException;


public class TestManager {
    public DriverOperations dos;
    public Reporter reporter;
    public PropertyValues propertyValues;

    public static TestManager initializeTestManager() throws MalformedURLException {
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
        switch (properties.browser) {
            case "chrome" -> driver = new ChromeDriver(new ChromeOptions().addArguments("headless"));
//            case "chrome" -> driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"),new ChromeOptions());
//            case "firefox" -> driver = new FirefoxDriver();
        }

        tm.dos = DriverOperations.initializeDriverOperations(driver);
        tm.propertyValues = properties;
        return tm;

    }
}
