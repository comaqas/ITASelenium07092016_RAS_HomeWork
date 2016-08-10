import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest extends TestBase {

    public static final String BASE_LINK = "https://dev.by/";

    @Test
    public void navigateToRegistrationLinkTest() {

        driver.get(BASE_LINK);
        driver.findElement(MainPage.REGISTRATION_LINK).click();

        RegistryPage.PopulateRegistryForm(driver);
        Assert.assertTrue(driver.findElement(MainPage.CONFIRMATION_REGISTRATION_POPUP_MESSAGE).isDisplayed(), "Popup is not displayed");

    }
}
