package pagesObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCompany {
    private static final By NAME_OF_COMPANY = By.cssSelector("[data=\"ISsoft\"]");

    public static boolean containsCompany(WebDriver driver) {
        if (!driver.findElement(NAME_OF_COMPANY).isDisplayed()) {
            return false;
        }
        return true;
    }
}
