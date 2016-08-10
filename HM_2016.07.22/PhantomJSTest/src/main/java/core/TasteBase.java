package core;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class TasteBase {
    public static final  String BASE_LINK = "https://dev.by";

    protected PhantomJSDriver driver;
    @BeforeTest
    public void setUp(){

        System.setProperty("phantomjs.binary.path","C:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        driver = new PhantomJSDriver();

            driver.manage().window().maximize();
            driver.get(BASE_LINK);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }


    @AfterTest
   public void teardown() {

            driver.close();
    }
}
