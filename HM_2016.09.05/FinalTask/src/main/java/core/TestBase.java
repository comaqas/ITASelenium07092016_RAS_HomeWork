package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    protected static final String MY_EMAIL = "artemrudzko@tut.by";
    protected static final String MY_PASSWORD = "199999";

    @BeforeTest
    public void setUp(){
        File pathBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\bin\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();

    }


}
