package pages;

import helpers.LocatorsParserHelper;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public static final By LOGIN_LINK = LocatorsParserHelper.get("LoginLink");
    public static final By PASSWORD_LINK = LocatorsParserHelper.get("PasswordLink");
    public static final By ENTER_MAIL_BUTTON = LocatorsParserHelper.get("EnterMailButton");

    public static void enterMyEmail(String login, String password){
        $(LOGIN_LINK).setValue(login);
        $(PASSWORD_LINK).setValue(password);
        $(ENTER_MAIL_BUTTON).click();
    }
}
