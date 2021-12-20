package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DriverOperations {
    WebDriver driver;

    public static DriverOperations initializeDriverOperations(WebDriver driver) {
        DriverOperations d_ops = new DriverOperations();
        d_ops.driver = driver;
        return d_ops;
    }

    public void navigateToUrl(String url) {
        this.driver.get(url);
    }

    public void closeDriver() {
        this.driver.quit();
    }

    public void clickButton(By by) {
        this.driver.findElement(by).click();
    }

    public void clickButton(WebElement button) {
        button.click();
    }

    public void enterText(By by, String text) {
        this.driver.findElement(by).sendKeys(text);
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
}
