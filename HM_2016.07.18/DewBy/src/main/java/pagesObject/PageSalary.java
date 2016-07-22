package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSalary {
    private static final By SALARY_IN_IT = By.cssSelector(".info-count");

    public static boolean containsAnItem(WebDriver driver) {
        if (!driver.findElement(SALARY_IN_IT).isDisplayed()) {
            return false;
        }
        return true;
    }
}
