package pages;

import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private static By PROCEED_TO_CHECKOUT = Locators.get("ProceedToCheckout");
    private static By EMAIL = Locators.get("EmailLink");
    private static By PASSWORD = Locators.get("PasswordsLink");
    private static By SUBMIT_LOGIN = Locators.get("SubmitLoginButton");
    private static By PROCEED_ADDRESS = Locators.get("ProceedAddressButton");
    private static By CONFIRM_CHECKBOX = Locators.get("ConfirmCheckBox");
    private static By PROCEED_CARRIER = Locators.get("ProceedCarrierButton");
    private static By PAY_BY_BANK_WIRE = Locators.get("PayByBankWireButton");
    private static By CONFIRM_MY_ORDER = Locators.get("ConfirmMyOrderButton");
    private static By MESSAGE_ABOUT_BUYING = Locators.get("MessageAboutBuying");
    private static By BACK_TO_ORDERS = Locators.get("BackToOrdersButton");
    public static String orderReference;

    public static void purchaseItem(WebDriver driver, String myEmail, String myPassword){
        driver.findElement(PROCEED_TO_CHECKOUT).click();
        driver.findElement(EMAIL).sendKeys(myEmail);
        driver.findElement(PASSWORD).sendKeys(myPassword);
        driver.findElement(SUBMIT_LOGIN).click();
        driver.findElement(PROCEED_ADDRESS).click();
        driver.findElement(CONFIRM_CHECKBOX).click();
        driver.findElement(PROCEED_CARRIER).click();
        driver.findElement(PAY_BY_BANK_WIRE).click();
        driver.findElement(CONFIRM_MY_ORDER).click();
        String messageAboutBuying = driver.findElement(MESSAGE_ABOUT_BUYING).getText();

        String[] message = messageAboutBuying.split(" ");

        orderReference = message[36];

        driver.findElement(BACK_TO_ORDERS).click();
    }
}
