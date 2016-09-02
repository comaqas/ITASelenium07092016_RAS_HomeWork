import core.TestBase;
import helperClass.Listener;
import helperClass.NewParser;
import pages.HomePage;
import pages.MainPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)

public class TutByTest extends TestBase {
    String[] userInfo = NewParser.getDataFrom(NewParser.Parsers.csv);
    String firstUserLogin = userInfo[0];
    String secondUserLogin = userInfo[2];
    String password = userInfo[1];
    String textFromTextBody = "Hello world";

    @DataProvider
    public Object[][] testDataSubject(){
        return new Object[][] {
            new Object[] {
                "firstSubject"},
            new Object[] {
                "secondSubject"},
            new Object[] {
                "thirdSubject"},
        };
        }

    @Test(dataProvider = "testDataSubject")
    public void sendLetterToYourself(String dataSubject){
        MainPage.enterTheEmail(driver,firstUserLogin,password);
        assertTrue(MainPage.isDisplayedLogo(driver));
        HomePage.sendMail(driver,firstUserLogin, dataSubject,textFromTextBody);
        assertTrue(HomePage.popapMessageIsDisplayed(driver));
        HomePage.verifySentEmail(driver,dataSubject);
        HomePage.returnToMainPage(driver);
    }

    @Test(dataProvider = "testDataSubject")
    public void sendLetterToSecondEmail(String dataSubject){
        MainPage.enterTheEmail(driver,firstUserLogin,password);
        assertTrue(MainPage.isDisplayedLogo(driver));
        HomePage.sendMail(driver,secondUserLogin,dataSubject,textFromTextBody);
        assertTrue(HomePage.popapMessageIsDisplayed(driver));
        HomePage.verifySentEmail(driver,dataSubject);
        HomePage.returnToMainPage(driver);

        MainPage.enterTheEmail(driver,secondUserLogin,password);
        assertTrue(MainPage.isDisplayedLogo(driver));
        HomePage.checkMessage(driver, firstUserLogin, dataSubject);
        HomePage.deleteLetter(driver);
        assertTrue(HomePage.verifyRemoveTheCheckLetter(driver, dataSubject));
        HomePage.returnToMainPage(driver);
    }
}

