package pageObject;

import block.NavigationBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class PageSalary {
    private NavigationBlock navigationBlock;
    private static final By SALARY_IN_IT = By.cssSelector(".info-count");

    public PageSalary(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void selectPageSalary(){
        navigationBlock.clickSalary();
    }


    public static boolean containsAnItem(WebDriver driver) {
        if (!driver.findElement(SALARY_IN_IT).isDisplayed()) {
            return false;
        }
        return true;
    }
}