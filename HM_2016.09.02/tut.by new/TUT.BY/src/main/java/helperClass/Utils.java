package helperClass;


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

    public static void shoot(String name) throws IOException {
        long curTime = System.currentTimeMillis();

        Date now = new Date(curTime);
        File screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
//        DateFormat.getInstance().format(now)
        FileUtils.copyFile(screenshot, new File("Screenshot\\" +name+System.currentTimeMillis()+".png"));
    }
}
