package pages;

import helpers.HelperRandomClass;
import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RegistrationPage {

    public static By USERNAME = Locators.get("UserNameField");
    public static By EMAIL = Locators.get("UserEmailField");
    public static By PASSWORD = Locators.get("UserPasswordField");
    public static By PASSWORD_CONFIRMATION = Locators.get("UserPasswordConfirmationField");
    public static By FIRST_NAME = Locators.get("UserFirstNameField");
    public static By LAST_NAME = Locators.get("UserLastNameField");
    public static By CURRENT_POSITION = Locators.get("UserCurrentPositionField");
    public static By AGREE_CHECKBOX = Locators.get("UserAgreementCheckbox");
    public static By SUBMIT_BUTTON = Locators.get("SubmitButton");
    public static By COMPANY_DROPDOWN_LABEL = Locators.get("UserCompanyDropDownLabel");
    public static By COMPANY_DROPDOWN_INPUT = Locators.get("UserCompanyDropDownInput");
    public static By COMPANY_DROPDOWN_RESULT = Locators.get("UserCompanyDropDownResult");

    private static List<String> itCompanies = Arrays.asList("itransition", "issoft", "epam", "viber", "belhard");


    public static void setRegistrationForm(WebDriver driver) {

        String password = HelperRandomClass.getRandomPassword();

        driver.findElement(USERNAME).sendKeys(HelperRandomClass.getRandomUserName());
        driver.findElement(EMAIL).sendKeys(HelperRandomClass.getRandomEmail());
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(PASSWORD_CONFIRMATION).sendKeys(password);
        driver.findElement(FIRST_NAME).sendKeys(HelperRandomClass.getRandomFirstName());
        driver.findElement(LAST_NAME).sendKeys(HelperRandomClass.getRandomLastName());
        driver.findElement(CURRENT_POSITION).sendKeys(HelperRandomClass.getRandomString());
        driver.findElement(AGREE_CHECKBOX).click();
        selectCompany(getRandomCompany(itCompanies),driver);
        driver.findElement(SUBMIT_BUTTON).click();
        
    }

    public static void selectCompany(String company, WebDriver driver) {

        driver.findElement(COMPANY_DROPDOWN_LABEL).click();
        driver.findElement(COMPANY_DROPDOWN_INPUT).sendKeys(company);
        driver.findElement(COMPANY_DROPDOWN_RESULT).click();
    }

    private static String getRandomCompany(List<String> list) {

        Random randomizer = new Random();

        return  list.get(randomizer.nextInt(list.size()));
    }


}
