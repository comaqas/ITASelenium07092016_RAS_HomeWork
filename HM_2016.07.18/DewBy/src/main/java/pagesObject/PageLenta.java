package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLenta  {
    private static final By LOGO = By.cssSelector(".header-logo[href=\"https://dev.by/\"]");

    public static boolean containsAnItem(WebDriver driver) {
        if (!driver.findElement(LOGO).isDisplayed()) {
            return false;
        }
        return true;
    }
}
