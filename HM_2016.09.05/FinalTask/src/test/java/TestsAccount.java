import core.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.RegistrationPage;
import reporting.Listener;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(Listener.class)

public class TestsAccount extends TestBase {
    private  String myEmail = TestBase.MY_EMAIL;
    private  String myPassword = TestBase.MY_PASSWORD;

    @Test
    public void registrationTest(){
        MainPage.goToSignIn(driver);
        AccountPage.createAnAccount(driver);
        RegistrationPage.createAccount(driver);
        assertTrue(RegistrationPage.verifyCreateAccount(driver));
        MainPage.signOut(driver);
        MainPage.goToMainPage(driver);
    }

    @Test
    public void creatingNewWishListTest(){
        MainPage.goToSignIn(driver);
        AccountPage.signIn(driver, myEmail, myPassword);
        AccountPage.createNewWishList(driver);
        assertTrue(AccountPage.verifyCreatingWish(driver));
        AccountPage.removeWish(driver);
        assertTrue(AccountPage.verifyRemoveWish(driver));
        MainPage.goToMainPage(driver);
        MainPage.signOut(driver);
    }

    @Test
    public void failedChangeUserInformationTest(){
        MainPage.goToSignIn(driver);
        AccountPage.signIn(driver, myEmail, myPassword);
        AccountPage.changeMyPersonalInformation(driver, myPassword);
        assertTrue(AccountPage.failureMessageIsDisplayed(driver));
        MainPage.goToMainPage(driver);
        MainPage.signOut(driver);
    }

}
