package tests;

import org.testng.annotations.*;

public class TestMain {
    TestManager tm;

@BeforeMethod
void setUpTestManager() {
    tm = TestManager.initializeTestManager();
}

@AfterMethod
void closeTestManager() {
        tm.dos.closeDriver();
}







}
