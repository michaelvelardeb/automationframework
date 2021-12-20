package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class ExampleTest extends TestMain {

    @Test(groups={"smoke", "smoke2", "smoke4"})
    public void exampleTest() {
        tm.dos.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }

    @Test(groups="smoke3")
    public void exampleTest2() {
        tm.dos.navigateToUrl("http://www.google.com");
        Random rd = new Random(); // creating Random object
        boolean status = rd.nextBoolean();
        Assert.assertTrue(status);
    }
}
