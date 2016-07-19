package dynamic;
import core.TestBase;
import org.testng.annotations.Test;
import pages.HomePageDynamic;
import pages.MainPageDynamic;
import static org.testng.Assert.assertTrue;


public class DynamicPOTest extends TestBase {

    @Test
    public void loginTest(){
        MainPageDynamic page = new MainPageDynamic(driver);
        String Login = "strong.zubovich@bk.ru";
        String Password = "ZXCvbn123!";
        String HomePageTitle = "Входящие - Почта Mail.Ru";
        page.enterLogin(Login);
        page.enterPassword(Password);
        page.ClickSubmit();

        assertTrue(page.titleTheSameAs(HomePageTitle));
    }

    @Test(dependsOnMethods = {"loginTest"})
    public  void NomberOfLettersTest(){
        HomePageDynamic page = new HomePageDynamic(driver);
        page.numberOfLetters();

    }



}
