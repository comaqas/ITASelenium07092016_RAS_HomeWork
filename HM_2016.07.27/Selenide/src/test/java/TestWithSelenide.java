import core.TestBase;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import pages.SettingsPage;

public class TestWithSelenide extends TestBase {
    String login = "strong.zubovich@bk.ru";
    String password = "ZXCvbn123!";
    String myPassword = "bcgfytw1992";
    String myEmail = "artemrudzko@mail.ru";
    String subject = HelperRandomClass.getRandomSubject();

    @Test
    public void sendLetter(){
        RegistrationPage.enterMyEmail(login,password);
        MainPage.sendMail(myEmail,subject);
        MainPage.isSuccessRegistrationPopupMessageDisplayed();
        MainPage.leave();
    }

    @Test(dependsOnMethods={"sendLetter"})
    public void checkTheSentMessage(){
        RegistrationPage.enterMyEmail(myEmail,myPassword);
        MainPage.iReceivedALetter(subject);
        MainPage.numberOfLetters();
        MainPage.leave();
    }

    @Test
    public void uploadAvatar(){
        RegistrationPage.enterMyEmail(myEmail,myPassword);
        MainPage.goToSettingsPage();
        SettingsPage.uploadAvatar();
        SettingsPage.isSuccessUploadAvatarDisplaed();
        MainPage.leave();
    }
}
