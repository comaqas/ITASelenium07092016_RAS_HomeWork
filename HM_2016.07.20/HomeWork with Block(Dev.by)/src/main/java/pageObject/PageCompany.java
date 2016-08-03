package pageObject;


import block.NavigationBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class PageCompany {
    NavigationBlock navigationBlock;
    private static final By NAME_OF_COMPANY = By.cssSelector("[data=\"ISsoft\"]");

    public PageCompany(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void SelectPageCompany(){
        navigationBlock.clickCompany();
    }

    public static boolean containsCompany(WebDriver driver) {
        if (!driver.findElement(NAME_OF_COMPANY).isDisplayed()) {
            return false;
        }
        return true;
    }
}
