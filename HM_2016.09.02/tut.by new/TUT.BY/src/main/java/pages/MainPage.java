package pages;


import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private static By ENTER = Locators.get("EnterLink");
    private static By LOGIN = Locators.get("LoginLink");
    private static By PASSWORD = Locators.get("PasswordLink");
    private static By SUBMIT = Locators.get("SubmitLink");
    private static By MAIL_LINK = Locators.get("MailLink");
    private static By LOGO_TUT_BY = Locators.get("LogoTUTBYImage");

    public static void enterTheEmail(WebDriver driver, String userLogin, String userPassword){
        driver.findElement(ENTER).click();
        driver.findElement(LOGIN).sendKeys(userLogin);
        driver.findElement(PASSWORD).sendKeys(userPassword);
        driver.findElement(SUBMIT).click();
        driver.findElement(MAIL_LINK).click();
    }

    public static boolean isDisplayedLogo(WebDriver driver) {
        if (!driver.findElement(LOGO_TUT_BY).isDisplayed()) {
            return false;
        }
        return true;
    }
}

