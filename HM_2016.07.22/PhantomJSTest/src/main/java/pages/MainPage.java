package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    public static final By REGISTRATION_LINK = Locators.get("LoginLink");
    public static final By CONFIRMATION_REGISTRATION_POPUP_MESSAGE = Locators.get("ConfirmationRegistryPopup");


    public static void clickRegistrationLink(WebDriver driver){

        driver.findElement(REGISTRATION_LINK).click();

    }

    public static boolean isMessageDisplayed(WebDriver driver) {

        return driver.findElement(CONFIRMATION_REGISTRATION_POPUP_MESSAGE).isDisplayed();
    }

}
