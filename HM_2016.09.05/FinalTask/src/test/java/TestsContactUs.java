import core.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.MainPage;
import reporting.Listener;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(Listener.class)

public class TestsContactUs extends TestBase {
    private String myEmail = TestBase.MY_EMAIL;
    static final String TEXT_FROM_LETTER = "Hellow World,example";
    static final String TEXT_FAILED = "";

    @Test
    public void sendMessageTest(){
        MainPage.goToContactUs(driver);
        ContactUsPage.sentMessage(driver,myEmail, TEXT_FROM_LETTER);
        assertTrue(ContactUsPage.successPopapMessageIsDysplaed(driver));
        MainPage.goToMainPage(driver);
    }

    @Test
    public void failedToSendMessageTest(){
        MainPage.goToContactUs(driver);
        ContactUsPage.sentMessage(driver,myEmail, TEXT_FAILED);
        ContactUsPage.alertDangerIsDysplaed(driver);
        MainPage.goToMainPage(driver);
    }
}
