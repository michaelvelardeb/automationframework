package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class ExampleTest extends TestMain {

    @Test(groups={"smoke", "smoke2", "smoke4"})
    public void exampleTest() {
        tm.ao.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }

    @Test(groups="smoke3")
    public void exampleTest2() {
        tm.ao.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        tm.ao.enterText(By.name("q"), "espn boxing schedule");
        tm.ao.enterText(By.name("q"), Keys.ENTER.toString());

        Assert.assertTrue(status);
    }
}
