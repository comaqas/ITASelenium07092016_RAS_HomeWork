package staticTest;

import core.TestBase;
import org.testng.annotations.Test;
import pages.HomePageStatic;
import pages.MainPageStatic;
import static org.testng.Assert.assertTrue;


public class StaticPOTest extends TestBase{

    @Test
    public void loginTest(){
        String Login = "strong.zubovich@bk.ru";
        String Password = "ZXCvbn123!";
        String HomePageTitle = "Входящие - Почта Mail.Ru";

        MainPageStatic.enterLogin(driver,Login);
        MainPageStatic.enterPassword(driver,Password);
        MainPageStatic.ClickSubmit(driver);

        assertTrue(MainPageStatic.titleTheSameAs(driver,HomePageTitle));
    }

    @Test(dependsOnMethods = {"loginTest"})
    public  void NomberOfLettersTest(){
        HomePageStatic.numberOfLetters(driver);


    }



}

