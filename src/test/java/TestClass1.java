import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass1 extends TestMain {

    @Test(groups="smoke")
    public void navigateToUrl() {
        tm.dos.navigateToUrl("http://www.google.com");
        tm.dos.enterText(By.xpath("//input[@title='Search']"), "espn boxing schedule");
        tm.dos.pageWait(1);
        List<WebElement> searchResults = tm.dos.fineElements(By.xpath("//ul[@role='listbox']/li"));
        tm.dos.clickButton(searchResults.get(1));
    }
}
