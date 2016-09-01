package reporting;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Utils.makeScreenshot("success screenshoot");
        try {
            Utils.makeScreenShotInFolder("success\\screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        Utils.makeScreenshot("failure screenshoot");
        try {
            Utils.makeScreenShotInFolder("failure\\screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
