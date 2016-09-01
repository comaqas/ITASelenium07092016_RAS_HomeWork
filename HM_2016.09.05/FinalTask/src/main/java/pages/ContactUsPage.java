package pages;


import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private static By SUBJECT_HEADING = Locators.get("SubjectHeadingLink");
    private static By EMAIL_ADDRESS = Locators.get("EmailAddressLink");
    private static By ATTACH_FILE = Locators.get("FileUploadButton");
    private static By MESSAGE_FIELD = Locators.get("MessageField");
    private static By SENT_LETTER = Locators.get("SendLetterLink");
    private static By SUCCESS_POPAP_MESSAGE = Locators.get("SuccessPopapMessage");
    private static By ALERT_DANGER = Locators.get("AlertDanger");

    public static void sentMessage(WebDriver driver,String staticEmailAddress, String message){
        driver.findElement(SUBJECT_HEADING).sendKeys("Webmaster");
        driver.findElement(EMAIL_ADDRESS).clear();
        driver.findElement(EMAIL_ADDRESS).sendKeys(staticEmailAddress);
        driver.findElement(ATTACH_FILE).sendKeys("Example.txt");
        driver.findElement(MESSAGE_FIELD).sendKeys(message);
        driver.findElement(SENT_LETTER).click();
    }

    public static boolean successPopapMessageIsDysplaed(WebDriver driver){
        return driver.findElement(SUCCESS_POPAP_MESSAGE).getText().
                contains("Your message has been successfully sent to our team.");
    }

    public static boolean alertDangerIsDysplaed(WebDriver driver){
        return driver.findElement(ALERT_DANGER).getText().contains("The message cannot be blank.");
    }



}
