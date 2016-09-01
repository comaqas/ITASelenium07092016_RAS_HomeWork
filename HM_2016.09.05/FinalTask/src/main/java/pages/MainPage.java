package pages;

import helperClass.Waiters;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    private static final String QUANTITY_ITEMS = "10";
    private static final String BLOUSE_SIZE = "L";
    private static By CONTACT_US = Locators.get("ContactUsLink");
    private static By SIGN_UN = Locators.get("LoginLink");
    private static By SEARCH_FIELD = Locators.get("SearchField");
    private static By SUBMIT_SEARCH = Locators.get("SubmitSearchButton");
    private static By MENU_CONTENT_WOMEN = Locators.get("MenuContentWomenLink");
    private static By SUBMENU_CONTENT_TSHIRTS = Locators.get("SubmenuContentTshirtsLink");
    private static By MAIN_PAGE = Locators.get("MainPageLink");
    private static By SIGN_OUT = Locators.get("SignOutWithAccountLink");
    private static By BEST_SELLERS = Locators.get("BestSellersLink");
    private static By QUICK_VIEW_BLOUSE = Locators.get("QuickViewBlouseLink");
    private static By QUANTITY_FIELD = Locators.get("QuantityField");
    private static By SIZE_FIELD = Locators.get("SizeField");
    private static By WHITE_COLOR_CHECKBOX = Locators.get("WhiteColorCheckBox");
    private static By ADD_TO_WISHLIST = Locators.get("AddToWishlistLink");
    private static By FANCYBOX_ERROR = Locators.get("FancyBoxErrorBox");
    private static By FANCYBOX_CLOSE = Locators.get("FancyBoxCloseButton");



    public static void goToContactUs(WebDriver driver){
        driver.findElement(CONTACT_US).click();
    }

    public static void goToSignIn(WebDriver driver){
        driver.findElement(SIGN_UN).click();
    }

    public static void searchForItem(WebDriver driver,String searchItem){
        driver.findElements(SEARCH_FIELD).clear();
        driver.findElement(SEARCH_FIELD).sendKeys(searchItem);
        driver.findElement(SUBMIT_SEARCH).click();
    }

    public static void chooseWomenTshort(WebDriver driver){
        WebElement womenContent = driver.findElement(MENU_CONTENT_WOMEN);
        Actions actions = new Actions(driver);
        actions.moveToElement(womenContent).build().perform();
        driver.findElement(SUBMENU_CONTENT_TSHIRTS).click();
    }

    public static void goToMainPage(WebDriver driver){
        Waiters.waitForPageLoaded();
        driver.findElement(MAIN_PAGE).click();
    }

    public static void signOut(WebDriver driver){
        driver.findElement(SIGN_OUT).click();
    }

    public static void clickBestSellers(WebDriver driver){
        driver.findElement(BEST_SELLERS).click();
    }

    public static void openQuickViewBlouse(WebDriver driver){
        driver.findElement(QUICK_VIEW_BLOUSE).click();
    }

    public static void addToWishlist(WebDriver driver){
        driver.findElement(QUANTITY_FIELD).clear();
        driver.findElement(QUANTITY_FIELD).sendKeys(QUANTITY_ITEMS);
        driver.findElement(SIZE_FIELD).sendKeys(BLOUSE_SIZE);
        driver.findElement(WHITE_COLOR_CHECKBOX).click();
        driver.findElement(ADD_TO_WISHLIST).click();
    }

    public static boolean fancyBoxErrorIsDisplayed(WebDriver driver){
        if(driver.findElement(FANCYBOX_ERROR).getText().contains("You must be logged in to manage your wishlist.")){
            driver.findElement(FANCYBOX_CLOSE).click();
            return true;
        }
        return false;
    }
}
