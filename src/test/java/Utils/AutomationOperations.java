package Utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutomationOperations {
    WebDriver driver;
    public Logger logger;
    public ExtentTest test;

    public static AutomationOperations initializeAutomationOperations(WebDriver driver, Logger logger, ExtentTest test) {
        AutomationOperations d_ops = new AutomationOperations();
        d_ops.driver = driver;
        d_ops.logger = logger;
        d_ops.test = test;
        return d_ops;
    }

    public void navigateToUrl(String url) {
        this.driver.get(url);
        String logMessage = "Navigated to Url: -" + url;
        logMessage(Level.INFO, logMessage);

    }

    public void closeDriver() {
        this.driver.quit();
    }

    public void clickButton(By by) {
        this.driver.findElement(by).click();
        String logMessage = String.format("Button clicked: " + by.toString());
        this.logger.log(Level.INFO, logMessage);
    }

    public void clickButton(WebElement button) {
        button.click();
    }

    public void enterText(By by, String text) {
        this.driver.findElement(by).sendKeys(text);
        String logMessage = String.format("Entered text: %s to By: %s", text, by.toString());
        logMessage(Level.INFO, logMessage);
    }

    public List<WebElement> fineElements(By by) {
        return this.driver.findElements(by);
    }

    public void pageWait(int i) {

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // TODO: 1/15/2022 Screenshots will currently print the image as BASE64 String
    public String takeScreenShot() {
        TakesScreenshot newScreen = (TakesScreenshot) this.driver;
        return newScreen.getScreenshotAs(OutputType.BASE64);
    }

    private void logMessage(Level level, String logMessage) {
        this.logger.log(level, logMessage);
        this.test.info(logMessage);
    }
}
