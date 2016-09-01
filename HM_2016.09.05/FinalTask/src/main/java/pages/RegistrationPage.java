package pages;


import helperClass.HelperRandomClass;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    static final String STATIC_MY_NAME = "artem";
    static final String RANDOM_LAST_NAME = HelperRandomClass.getRandomStringOfLetters();
    static final String RANDOM_PASSWORD = HelperRandomClass.getRandomPassword();
    static final String RANDOM_DAY_OF_BIRTH = HelperRandomClass.getRandomDayOfBirth();
    static final String RANDOM_MONTH_OF_BIRH = HelperRandomClass.getRandomMonthOfBirh();
    static final String RANDOM_YEAR_OF_BIRTH = HelperRandomClass.getRandomYearOfBirth();
    static final String MY_COMPANY = "freeLancer";
    static final String MY_FIRST_ADDRESS = "Velikomorskaia str.";
    static final String secondAddress = "Stroiteley str";
    static final String MY_CITY = "Minsk";
    static final String MY_STATE = "Texas";
    static final String MY_POSTAL_CODE = "12345";
    static final String OTHER_INFORMATION = "Really, i am from Sparta";
    static final String MY_HOME_PHONE = "+10019548891325";
    static final String MY_MOBILE_PHONE = "+1-567-244-5678";
    static final String ALIAS_EMAIL = HelperRandomClass.getRandomEmail();
    private static By GENDER_MALE = Locators.get("MaleGenderCheckBox");
    private static By FIRST_NAME = Locators.get("FirstNameLink");
    private static By LAST_NAME = Locators.get("LastNameLink");
    private static By PASSWORD = Locators.get("PasswordLink");
    private static By DAY_OF_BIRTH = Locators.get("DayOfBirthDropdown");
    private static By MONTH_OF_BIRTH = Locators.get("MonthOfBirthDropdown");
    private static By YEAR_OF_BIRTH = Locators.get("YearOfBirthDropdown");
    private static By COMPANY_ADDRESS_FIELD = Locators.get("CompanyAddressFieldLink");
    private static By FIRST_ADDRESS = Locators.get("AddressLine1Link");
    private static By SECOND_ADDRESS = Locators.get("AddressLine2Link");
    private static By SELECT_CITY = Locators.get("SelectCityLink");
    private static By SELECT_STATE = Locators.get("SelectStateDropdown");
    private static By POSTAL_CODE = Locators.get("PostalCodeLink");
    private static By ADDITIONAL_INFORMATION = Locators.get("AdditionalInformationField");
    private static By HOME_PHONE = Locators.get("HomePhoneLink");
    private static By MOBILE_PHONE = Locators.get("MobilePhoneLink");
    private static By ALIAS_EMAIL_ADDRESS = Locators.get("AliasEmailAddressLink");
    private static By SUBMIT_REGISTER = Locators.get("SubmitRegisterButton");
    private static By INFORMATIVE_MESSAGE_MY_ACCOUNT = Locators.get("InfoAccountMessage");


    public static void createAccount(WebDriver driver){
        driver.findElement(GENDER_MALE).click();
        driver.findElement(FIRST_NAME).sendKeys(STATIC_MY_NAME);
        driver.findElement(LAST_NAME).sendKeys(RANDOM_LAST_NAME);
        driver.findElement(PASSWORD).sendKeys(RANDOM_PASSWORD);

        driver.findElement(DAY_OF_BIRTH).sendKeys(RANDOM_DAY_OF_BIRTH);
        driver.findElement(MONTH_OF_BIRTH).sendKeys(RANDOM_MONTH_OF_BIRH);
        driver.findElement(YEAR_OF_BIRTH).sendKeys(RANDOM_YEAR_OF_BIRTH);

        driver.findElement(COMPANY_ADDRESS_FIELD).sendKeys(MY_COMPANY);
        driver.findElement(FIRST_ADDRESS).sendKeys(MY_FIRST_ADDRESS);
        driver.findElement(SECOND_ADDRESS).sendKeys(secondAddress);
        driver.findElement(SELECT_CITY).sendKeys(MY_CITY);
        driver.findElement(SELECT_STATE).sendKeys(MY_STATE);
        driver.findElement(POSTAL_CODE).sendKeys(MY_POSTAL_CODE);

        driver.findElement(ADDITIONAL_INFORMATION).sendKeys(OTHER_INFORMATION);
        driver.findElement(HOME_PHONE).sendKeys(MY_HOME_PHONE);
        driver.findElement(MOBILE_PHONE).sendKeys(MY_MOBILE_PHONE);
        driver.findElement(ALIAS_EMAIL_ADDRESS).clear();
        driver.findElement(ALIAS_EMAIL_ADDRESS).sendKeys(ALIAS_EMAIL);

        driver.findElement(SUBMIT_REGISTER).click();
    }

    public static boolean verifyCreateAccount(WebDriver driver){
        return driver.findElement(INFORMATIVE_MESSAGE_MY_ACCOUNT).getText().contains("Welcome to your account." +
                " Here you can manage all of your personal information and orders.");
    }
}
