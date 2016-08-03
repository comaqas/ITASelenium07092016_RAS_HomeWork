package pageObject;

        import block.NavigationBlock;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class PageLenta {
    private NavigationBlock navigationBlock;
    private static final By LOGO = By.cssSelector(".header-logo[href=\"https://dev.by/\"]");

    public PageLenta(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void  clickPageLenta(){
        navigationBlock.clickTape();

    }

    public static boolean containsAnItem(WebDriver driver) {
        if (!driver.findElement(LOGO).isDisplayed()) {
            return false;
        }
        return true;
    }
}
