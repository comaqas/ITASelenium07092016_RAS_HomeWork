import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import core.TasteBase;
import java.io.File;
import java.io.IOException;

public class PhantomTest extends TasteBase {

    @Test
    public void phantomJSTest() throws IOException {


        File firstScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(firstScreen,new File("F://mainPage.png"));

        MainPage.clickRegistrationLink(driver);

        File secondScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(secondScreen,new File("F://registrationPage.png"));

        RegistrationPage.setRegistrationForm(driver);

        File thirdScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(thirdScreen,new File("F://confirmPage.png"));

        MainPage.isMessageDisplayed(driver);

    }
}
