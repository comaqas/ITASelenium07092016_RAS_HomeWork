package pagesObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageJobs {
    private static final By JOB_SEARCH = By.cssSelector(".column-left");

    public static boolean containsSraechField(WebDriver driver) {
        if (!driver.findElement(JOB_SEARCH).isDisplayed()) {
            return false;
        }
        return true;
    }
}

