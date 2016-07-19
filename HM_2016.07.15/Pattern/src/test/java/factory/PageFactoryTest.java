package factory;

import core.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePageSimpleFactory;
import pages.MainPageSimpleFactory;
import static org.testng.Assert.assertTrue;

public class PageFactoryTest extends TestBase {
    @Test
    public void loginTest(){
        MainPageSimpleFactory page = PageFactory.initElements(driver,MainPageSimpleFactory.class);
        String Login = "strong.zubovich@bk.ru";
        String Password = "ZXCvbn123!";
        page.enterLogin(Login);
        page.enterPassword(Password);
        page.clickSubmit();

        assertTrue(page.changed());
    }

    @Test(dependsOnMethods = {"loginTest"})
    public  void NumberOfLettersTest(){
        HomePageSimpleFactory page = PageFactory.initElements(driver,HomePageSimpleFactory.class);
        page.numberOfLetters();

    }
}
