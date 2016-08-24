package core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MainPage;
import pages.RegistrationPage;
import pages.SettingsPage;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    String myPassword = "bcgfytw1992";
    String myEmail = "artemrudzko@mail.ru";

    @BeforeTest
    public void setUp(){
        Configuration.startMaximized = true;
        open("https://mail.ru/");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Configuration.startMaximized = true;
        open("https://mail.ru/");
        RegistrationPage.enterMyEmail(myEmail,myPassword);
        MainPage.goToSettingsPage();
        SettingsPage.uploadBlackSquare();
        MainPage.leave();
    }
}
