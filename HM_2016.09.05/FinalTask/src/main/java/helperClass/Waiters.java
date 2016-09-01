package helperClass;

import core.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.Thread.sleep;


public class Waiters {
    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").
                                toString().equals("complete");
                    }
                };
        try {
            sleep(1000);
            WebDriverWait wait = new WebDriverWait(TestBase.driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public static void waitForJquery() throws InterruptedException {
        (new WebDriverWait(TestBase.driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor)webDriver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
        Thread.sleep(500);
    }
}
