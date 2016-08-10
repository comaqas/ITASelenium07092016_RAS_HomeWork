import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RegistryPage {

    public static final By USERNAME = Locators.get("UserName");
    public static final By EMAIL = Locators.get("UserEmail");
    public static final By PASSWORD = Locators.get("Password");
    public static final By PASSWORD_CONFIRMATION = Locators.get("PasswordConfirmation");
    public static final By FIRSTNAME = Locators.get("UserFirstName");
    public static final By LASTNAME = Locators.get("UserLastName");
    public static final By CURRENT_POSITION = Locators.get("UserCurrentPosition");
    public static final By COMPANY_DROPDOWN_LABEL = Locators.get("UserCompanyDropDownLabel");
    public static final By COMPANY_DROPDOWN_INPUT = Locators.get("UserCompanyDropDownInput");
    public static final By COMPANY_DROPDOWN_RESULT_ITEM = Locators.get("UserCompanyDropDownResult");
    public static final By AGREE_CHECKBOX = Locators.get("AgreedWithCheckbox");
    public static final By SUBMIT_BUTTON = Locators.get("SubmitBlueButton");
    public static final By CHOISE_MALE = Locators.get("ChoiseMale");
    public static final By UPLOAD_AVATAR_LINK = Locators.get("UpLoadAvatarLink");


    private static List<String> itCompanies = Arrays.asList("itransition", "issoft", "epam", "viber", "belhard");

    public static void PopulateRegistryForm(WebDriver driver) {

        String password = HelperRandomClass.getPassword();

        driver.findElement(USERNAME).sendKeys(HelperRandomClass.getUsername());
        driver.findElement(EMAIL).sendKeys(HelperRandomClass.getRandomEmail());
        driver.findElement(CHOISE_MALE).click();
        driver.findElement(UPLOAD_AVATAR_LINK).sendKeys("C:\\111.JPG");
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(PASSWORD_CONFIRMATION).sendKeys(password);
        driver.findElement(FIRSTNAME).sendKeys(HelperRandomClass.getFirstName());
        driver.findElement(LASTNAME).sendKeys(HelperRandomClass.getLastName());
        driver.findElement(CURRENT_POSITION).sendKeys(HelperRandomClass.getRandomString());
        SelectCompany(GetRandomCompany(itCompanies), driver);
        driver.findElement(AGREE_CHECKBOX).click();
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public static void SelectCompany(String company, WebDriver driver) {
        driver.findElement(COMPANY_DROPDOWN_LABEL).click();
        driver.findElement(COMPANY_DROPDOWN_INPUT).sendKeys(company);
        driver.findElement(COMPANY_DROPDOWN_RESULT_ITEM).click();
    }

    private static String GetRandomCompany(List<String> list) {
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }
}
