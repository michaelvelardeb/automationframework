package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;


public class ExampleTest2 extends TestMain {

    @Test(groups={"smoke", "regression"})
    public void exampleTest3() {
        tm.dos.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }

    @Test(groups={"TP-1029", "smoke2"})
    public void exampleTest4() {
        tm.dos.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }
}