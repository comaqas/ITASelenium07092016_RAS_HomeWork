package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.LocatorsParserHelper;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public static final By WRITE_LETTER_LINK = LocatorsParserHelper.get("WriteLetterLink");
    public static final By EMAIL_RECIPIENT = LocatorsParserHelper.get("EmailRecipient");
    public static final By EMAIL_SUBJECT = LocatorsParserHelper.get("EmailSubject");
    public static final By CHOOSE_SMILE = LocatorsParserHelper.get("ChooseSmileLink");
    public static final By CLICK_SMILE = LocatorsParserHelper.get("ClickSmileLink");
    public static final By SEND_MAIL = LocatorsParserHelper.get("SendLetterLink");
    public static final By MESSAGE_SENT_TITLE = LocatorsParserHelper.get("MessageSentTitleLink");
    public static final By EXIT = LocatorsParserHelper.get("ExitLink");
    public static final By INSPECTION_SUBJECT = LocatorsParserHelper.get("InspectionSubjectLink");
    public static final By ALL_LETTERS = LocatorsParserHelper.get("LettersSize");
    public static final By NEXT_PAGE_LETTERS_DISABLE = LocatorsParserHelper.get("NextPageWithLettersDisableLink");
    public static final By NEXT_PAGE_LETTERS = LocatorsParserHelper.get("NextPageWithLettersLink");
    public static final By PRIVATE_OPTION = LocatorsParserHelper.get("PrivateOptionLink");
    public static final By SETTINGS = LocatorsParserHelper.get("SettingLink");

    public static void sendMail(String myEmail, String subject){
        $(WRITE_LETTER_LINK).waitUntil(visible,10000).click();
        $(EMAIL_RECIPIENT).setValue(myEmail);
        $(EMAIL_SUBJECT).setValue(subject);
        $(CHOOSE_SMILE).click();
        $(CLICK_SMILE).click();
//        $(By.xpath(".//*[@id='tinymce']]")).setValue(text);
        $(SEND_MAIL).click();
    }

    public static SelenideElement isSuccessRegistrationPopupMessageDisplayed(){
        return $(MESSAGE_SENT_TITLE).shouldBe(visible);
    }

    public static void leave(){
        $(EXIT).click();
    }

    public static SelenideElement iReceivedALetter(String subject){
       return  $$(INSPECTION_SUBJECT).get(0).waitUntil(visible,10000).shouldHave(Condition.text(subject));
    }

    public static void numberOfLetters(){

        int letters;
        int page = 1;

        while (true){
            letters = $$(ALL_LETTERS).size();
            System.out.println(page++ + " a page has " + letters + " letters ");
            if (!$(NEXT_PAGE_LETTERS_DISABLE).getAttribute("class").contains("b-toolbar__btn_disabled")){
                $(NEXT_PAGE_LETTERS).click();
            } else
                break;
        }
    }

    public static void goToSettingsPage(){
        $(PRIVATE_OPTION).click();
        $(SETTINGS).click();
    }
}
