package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPageSimpleFactory  {
    @FindBy(id = "mailbox__login")
    private WebElement searchField;
    @FindBy(id = "mailbox__password")
    private WebElement searchFieldPassword;
    @FindBy(id = "mailbox__auth__button")
    private WebElement searchButton;
    @FindBy(css = "[data-name=\"compose\"]")
    private WebElement writeLetter;



    public  void enterLogin(String Login) {
        searchField.sendKeys(Login);

    }

    public  void enterPassword(String Password) {

        searchFieldPassword.sendKeys(Password);

    }

    public  void clickSubmit() {

        searchButton.click();

    }

    public  boolean changed() {

        if(!writeLetter.isDisplayed()) {
            return false;
        }
        return true;
    }
}
