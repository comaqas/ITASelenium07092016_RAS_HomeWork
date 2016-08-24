package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.LocatorsParserHelper;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {
    public static final By UPLOAD_AVATAR = LocatorsParserHelper.get("UploadAvatarLink");
    public static final By SUBMIT_AVATAR = LocatorsParserHelper.get("SubmitAvatarLink");
    public static final By SAVE_CHANGES = LocatorsParserHelper.get("SaveChangesLink");
    public static final By VERIFY_TEXT_ON_PAGE = LocatorsParserHelper.get("VerifyTextOnPageLink");

    public static void uploadAvatar(){
        $(UPLOAD_AVATAR).uploadFile(new File("C:\\111.JPG"));
        $(SUBMIT_AVATAR).click();
        $(SAVE_CHANGES).waitUntil(Condition.visible,10000).click();
    }

    public static SelenideElement isSuccessUploadAvatarDisplaed(){
       return  $(VERIFY_TEXT_ON_PAGE).shouldHave(Condition.text("Артём Рудько  (24 года) "));
    }

    public static  void uploadBlackSquare(){
        $(UPLOAD_AVATAR).uploadFile(new File("C:\\11.JPG"));
        $(SUBMIT_AVATAR).click();
        $(SAVE_CHANGES).waitUntil(Condition.visible,10000).click();
    }
}
