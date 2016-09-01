package pages;


import helperClass.HelperRandomClass;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage {
    public static String titleRandomItem;
    public static String randomFriendName = HelperRandomClass.getRandomStringOfLetters();
    public static String randomFriendEmail = HelperRandomClass.getRandomEmail();
    private static By RESULT_PRODUCT_NAME = Locators.get("ResultProductName");
    private static By RESULT_DRESS_SEARCHING = Locators.get("ResultDressSearchingLink");
    private static By ADD_TO_CART = Locators.get("AddToCartButton");
    private static By CONTINUE_SHOPPING = Locators.get("ContinueShoppingButton");
    private static By SHOPPING_CART = Locators.get("ShoppingCartLink");
    private static By CART_BLOCK_PRODUCT_NAME = Locators.get("CartBlockProductNameLink");
    private static By REMOVE_FROM_CART = Locators.get("RemoveFromCartBlockLink");
    private static By TITLE_SHOPPING_CART = Locators.get("TitleShoppingCartLink");
    private static By PROCEED_TO_CHECKOUT = Locators.get("ProceedToCheckoutButton");
    private static By VIEW_ITEM = Locators.get("ViewItemButton");
    private static By SEND_TO_A_FRIEND = Locators.get("SendToFriendLink");
    private static By FRIEND_NAME = Locators.get("FriendNameLink");
    private static By FRIEND_EMAIL = Locators.get("FriendEmailLink");
    private static By SEND_EMAIL = Locators.get("SendEmailButton");
    private static By SENDING_MESSAGE = Locators.get("SendingMessageBox");
    private static By SUBMIT = Locators.get("SubmitButton");

    public static boolean verifySuccessSearch(WebDriver driver,String searchItem){
        return driver.findElement(RESULT_PRODUCT_NAME).getAttribute("title").contains(searchItem);
    }

    public enum  ChooseActions{addToCart,viewItem};

    public static void chooseRandomItem(WebDriver driver,ChooseActions action){
        int allFoundItems = driver.findElements(RESULT_DRESS_SEARCHING).size();

        int numberRandomFoundItem = HelperRandomClass.getRandomFoundItem(allFoundItems);

        WebElement randomFoundItem = driver.findElements(RESULT_DRESS_SEARCHING).get(numberRandomFoundItem);
        titleRandomItem = randomFoundItem.getAttribute("title");

        Actions actions = new Actions(driver);
        actions.moveToElement(randomFoundItem).build().perform();
        if(action==ChooseActions.addToCart) {
            driver.findElements(ADD_TO_CART).get(numberRandomFoundItem).click();
        } else if(action==ChooseActions.viewItem) {
            driver.findElements(VIEW_ITEM).get(numberRandomFoundItem).click();
        }
    }

    public static void sendWithFriend(WebDriver driver){
        driver.findElement(SEND_TO_A_FRIEND).click();
    }

    public static void enterFriendsContactAndSending(WebDriver driver){
        driver.findElement(FRIEND_NAME).sendKeys(randomFriendName);
        driver.findElement(FRIEND_EMAIL).sendKeys(randomFriendEmail);
        driver.findElement(SEND_EMAIL).click();
    }

    public static boolean verifySendingLetter(WebDriver driver){
        WebElement submit = driver.findElement(SUBMIT);
        if(driver.findElement(SENDING_MESSAGE).getText().contains("Your e-mail has been sent successfully")){
            submit.click();
            return true;
        }
        return false;
    }

    public static void chooseContinueShopping(WebDriver driver){
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public static void chooseProceedToCheckOut(WebDriver driver){
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public static boolean verifySuccessAddingToCart(WebDriver driver){
        WebElement shoppingCart = driver.findElement(SHOPPING_CART);
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).build().perform();
        return driver.findElement(CART_BLOCK_PRODUCT_NAME).getAttribute("title").contains(titleRandomItem);
    }

    public static void removeItemFromCart(WebDriver driver){
        WebElement shoppingCart = driver.findElement(SHOPPING_CART);
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).build().perform();
        driver.findElement(REMOVE_FROM_CART).click();
    }

    public static boolean verifyRemoveItemFromCart(WebDriver driver){
        return driver.findElement(TITLE_SHOPPING_CART).getText().contains("(empty)") ;
    }

}
