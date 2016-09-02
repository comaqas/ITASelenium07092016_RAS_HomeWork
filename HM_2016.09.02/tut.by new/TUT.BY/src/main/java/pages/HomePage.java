package pages;


import helperClass.Waiters;
import locators.Locators;
import org.openqa.selenium.*;

public class HomePage {
    private static By WRITE_MAIL = Locators.get("WriteMail");
    private static By CHOOSE_EMAIL = Locators.get("ChooseEmail");
    private static By SUBJECT_LINK = Locators.get("SubjectLink");
    private static By WRITE_TEXT = Locators.get("TextField");
    private static By SEND_MAIL_BUTTON = Locators.get("SendMail");
    private static By POPAP_MESSAGE = Locators.get("PopapMessage");
    private static By USER_HEADER = Locators.get("UserHeaderLink");
    private static By EXIT = Locators.get("ExitLink");
    private static By MESSAGE_SUBJECT_LINK = Locators.get("MessageSubjectLink");
    private static By SENT_LETTERS_LINK = Locators.get("SentLettersLink");
    private static By MESSAGE_FROM_TEXT_LINK = Locators.get("MessageFromTextLink");
    private static By MESSAGE_CHECKBOX_LINK = Locators.get("MessageCheckboxLink");
    private static By DELETE_MESSAGE_LINK = Locators.get("DeleteMessageLink");
    private static By LETTER_SUCCESSFULLY_DELETED_POPAP = Locators.get("LetterSuccessfullyDeletet");

    public static void sendMail(WebDriver driver,String email,String subject, String textFromTextBody){
        driver.findElement(WRITE_MAIL).click();
        driver.findElement(SUBJECT_LINK).sendKeys(subject);
        driver.findElement(CHOOSE_EMAIL).sendKeys(email);
        driver.findElement(WRITE_TEXT).sendKeys(textFromTextBody);
        driver.findElement(SEND_MAIL_BUTTON).click();
        Waiters.waitForPageLoaded();
//        Thread.sleep(15000);
    }
    public static boolean verifySentEmail(WebDriver driver,String subject){
        driver.findElement(SENT_LETTERS_LINK).click();

        if(!driver.findElements(MESSAGE_SUBJECT_LINK).get(0).getAttribute("title").contains(subject)) {
            return false;
        }
        return true;
    }

    public static boolean popapMessageIsDisplayed(WebDriver driver){
        return driver.findElement(POPAP_MESSAGE).isDisplayed();
    }
    public static void returnToMainPage(WebDriver driver){
        driver.findElement(USER_HEADER).click();
        driver.findElement(EXIT).click();
        Waiters.waitForPageLoaded();
    }

    public static void checkMessage(WebDriver driver,String fullFirstUserLogin ,String subject){
        driver.findElements(MESSAGE_FROM_TEXT_LINK).get(0)
                .getAttribute("title").contains(fullFirstUserLogin);
        driver.findElements(MESSAGE_SUBJECT_LINK).get(0).getAttribute("title").contains(subject);
    }

    public static void deleteLetter(WebDriver driver){
        driver.findElements(MESSAGE_CHECKBOX_LINK).get(0).click();
        driver.findElement(DELETE_MESSAGE_LINK).click();
        driver.findElement(LETTER_SUCCESSFULLY_DELETED_POPAP).isDisplayed();
        Waiters.waitForPageLoaded();
    }

    public static boolean verifyRemoveTheCheckLetter(WebDriver driver,String subject){
        if(driver.findElements(MESSAGE_SUBJECT_LINK).get(0).getAttribute("title").contains(subject)){
            return false;
        }
        return true;
    }

}
