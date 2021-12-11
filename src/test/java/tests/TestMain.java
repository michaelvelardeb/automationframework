package tests;

import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestMain {
    TestManager tm;

@BeforeMethod(alwaysRun = true)
void setUpTestManager(Method method) {

    tm = TestManager.initializeTestManager();
    Reporter.log("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
}

@AfterMethod(alwaysRun = true)
void closeTestManager() {
        tm.dos.closeDriver();
}







}
