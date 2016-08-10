package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    public TestBase(){
        driver = new FirefoxDriver();

    }
    @BeforeTest

    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest

    public void tearDown(){
        driver.close();
    }
}
