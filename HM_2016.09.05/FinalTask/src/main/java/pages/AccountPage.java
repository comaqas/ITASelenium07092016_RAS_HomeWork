package pages;


import helperClass.HelperRandomClass;
import helperClass.Waiters;
import locators.Locators;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    static final String RANDOM_WISH_LIST_NAME = HelperRandomClass.getRandomStringOfLetters();
    static final String RANDOM_EMAIL = HelperRandomClass.getRandomEmail();
    static final String RANDOM_NEW_PASSWORD = HelperRandomClass.getRandomPassword();
    private static By EMAIL_CREATE = Locators.get("EmailCreate");
    private static By SUBMIT_CREATE_ACCOUNT = Locators.get("SubmitCreateAccountButton");
    private static By EMAIL = Locators.get("EmailLink");
    private static By PASSWORD = Locators.get("PasswordsLink");
    private static By SUBMIT_LOGIN = Locators.get("SubmitLoginButton");
    private static By MY_WISHLIST = Locators.get("MyWishListLink");
    private static By NEW_NAME_WISHLIST = Locators.get("NameLink");
    private static By SUBMIT_WISHLIST = Locators.get("SubmitWishListButton");
    private static By WISHLIST_TABLE_FIELDS = Locators.get("WishlistTableFields");
    private static By DELETE_WISH = Locators.get("DeleteWishButton");
    private static By MY_PERSONAL_INFORMATION = Locators.get("MyPersonalInformationLink");
    private static By OLD_PASSWORD = Locators.get("OldPasswordField");
    private static By NEW_PASSWORD = Locators.get("PasswordsLink");
    private static By NEWSLETTER_CHECKBOX = Locators.get("NewsletterCheckbox");
    private static By RECEIVE_SPECIAL_OFFERS_CHECKBOX = Locators.get("ReceiveSpecialOffersCheckbox");
    private static By SAVE_BUTTON = Locators.get("SaveButton");
    private static By FAILURE_MESSAGE = Locators.get("FailureMessage");

    public static void createAnAccount(WebDriver driver) {
        driver.findElement(EMAIL_CREATE).sendKeys(RANDOM_EMAIL);
        driver.findElement(SUBMIT_CREATE_ACCOUNT).click();
    }

    public static void signIn(WebDriver driver, String myEmail, String myPassword) {
        driver.findElement(EMAIL).sendKeys(myEmail);
        driver.findElement(PASSWORD).sendKeys(myPassword);
        driver.findElement(SUBMIT_LOGIN).click();
    }

    public static void createNewWishList(WebDriver driver) {
        driver.findElement(MY_WISHLIST).click();
        driver.findElement(NEW_NAME_WISHLIST).sendKeys(RANDOM_WISH_LIST_NAME);
        driver.findElement(SUBMIT_WISHLIST).click();
    }

    public static boolean verifyCreatingWish(WebDriver driver) {
        return driver.findElements(WISHLIST_TABLE_FIELDS).get(0).getText().contains(RANDOM_WISH_LIST_NAME);
    }

    public static void removeWish(WebDriver driver){
        driver.findElement(DELETE_WISH).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static boolean verifyRemoveWish(WebDriver driver){
        Waiters.waitForPageLoaded();
        return driver.findElements(WISHLIST_TABLE_FIELDS).isEmpty();
    }

    public static void changeMyPersonalInformation(WebDriver driver, String myPassword){
        driver.findElement(MY_PERSONAL_INFORMATION).click();
        driver.findElement(OLD_PASSWORD).sendKeys(myPassword);
        driver.findElement(NEW_PASSWORD).sendKeys(RANDOM_NEW_PASSWORD);
        driver.findElement(NEWSLETTER_CHECKBOX).click();
        driver.findElement(RECEIVE_SPECIAL_OFFERS_CHECKBOX).click();
        driver.findElement(SAVE_BUTTON).click();
    }

    public static boolean failureMessageIsDisplayed(WebDriver driver){
        return driver.findElement(FAILURE_MESSAGE).getText().contains("The password and confirmation do not match.") ;
    }
}
