package flow;

import core.TestBase;
import org.testng.annotations.Test;
import pages.HomePageFlow;
import pages.MainPageFlow;
import static org.testng.Assert.assertTrue;

public class FlowPOTest extends TestBase {
    @Test
    public void loginTest(){
        MainPageFlow page = new MainPageFlow(driver);
        String HomePageTitle = "Входящие - Почта Mail.Ru";


        page
                .enterLogin("strong.zubovich@bk.ru")
                    .enterPassword("ZXCvbn123!")
                        .ClickSubmit();

        assertTrue(page.titleTheSameAs(HomePageTitle));
    }

    @Test(dependsOnMethods = {"loginTest"})
    public  void NomberOfLettersTest(){
        HomePageFlow page = new HomePageFlow(driver);
        page
                .numberOfLetters();

    }



}
