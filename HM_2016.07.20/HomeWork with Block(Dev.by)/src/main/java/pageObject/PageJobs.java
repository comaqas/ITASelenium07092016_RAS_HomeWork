package pageObject;

import block.NavigationBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class PageJobs {
    private NavigationBlock navigationBlock;
    private static final By JOB_SEARCH = By.cssSelector(".column-left");

    public PageJobs(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void selcetPageJobs(){
        navigationBlock.clickJobs();
    }

    public static boolean containsSraechField(WebDriver driver) {
        if (!driver.findElement(JOB_SEARCH).isDisplayed()) {
            return false;
        }
        return true;
    }
}
