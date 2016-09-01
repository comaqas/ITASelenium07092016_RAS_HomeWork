package reporting;


import core.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import java.text.DateFormat;
import java.util.Date;

import java.io.File;
import java.io.IOException;

public class Utils {
    @Attachment(value = "(0)", type = "image/pmg")

    public static byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void makeScreenShotInFolder(String name) throws IOException {
        Date now = new Date();
        File screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Screenshot\\"+name+DateFormat.getInstance().format(now)+
                System.currentTimeMillis()+".png"));
    }
}
