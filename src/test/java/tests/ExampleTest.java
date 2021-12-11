package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


public class ExampleTest extends TestMain {

    @Test(groups={"smoke", "smoke2"})
    public void exampleTest() {
        tm.dos.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }

    @Test(groups={"smoke"})
    public void exampleTest2() {
        tm.dos.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }
}
