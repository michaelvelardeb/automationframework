package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


import java.io.IOException;


public class TestManager {
    DriverOperations dos;
    Reporter reporter;

    public static TestManager initializeTestManager() {
        TestManager tm = new TestManager();
        WebDriver driver = null;

        PropertyValues properties = new PropertyValues();
        try {
            properties.getPropValues();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        switch (properties.browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
        }

        tm.dos = DriverOperations.initializeDriverOperations(driver);
        tm.reporter = new Reporter();
        return tm;

    }
}
