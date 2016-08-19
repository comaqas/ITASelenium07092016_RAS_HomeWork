import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithSelenide {
    String login = "strong.zubovich@bk.ru";
    String password = "ZXCvbn123!";
    String myPassword = "bcgfytw1992";
    String myEmail = "artemrudzko@mail.ru";
    String subject = HelperRandomClass.getRandomSubject();
//    String mySubject = subject;
//    String text = HelperRandomClass.getRandomString();

    @BeforeTest
    public void setUp(){
        Configuration.startMaximized = true;
        open("https://mail.ru/");
    }


    @Test
    public void sendLetter() throws InterruptedException {
        $(By.id("mailbox__login")).setValue(login);
        $(By.id("mailbox__password")).setValue(password);
        $(By.id("mailbox__auth__button")).click();
        Thread.sleep(10000);

        $(By.cssSelector("a.b-toolbar__btn.js-shortcut")).click();
        $(By.cssSelector("[class=\"js-input compose__labels__input\"][data-original-name=\"To\"]")).setValue(myEmail);
        $(By.cssSelector("[ name=\"Subject\"]")).setValue(subject);
        $(By.cssSelector(".mceAction.mce_emotions[href=\"javascript:;\"]")).click();
        $(By.cssSelector(".emoji[src=\"https://img.imgsmail.ru/emoji/1f600.svg\"]")).click();
//        $(By.xpath(".//*[@id='tinymce']]")).setValue(text);
        $(By.cssSelector("[data-name=\"send\"]")).click();
        $(By.cssSelector("[class=\"message-sent__title\"]")).shouldBe(visible);
        $(By.cssSelector("[id=\"PH_logoutLink\"]")).click();
    }

    @Test(dependsOnMethods={"sendLetter"})
    public void checkTheSentMessage() throws InterruptedException {
        $(By.id("mailbox__login")).setValue(myEmail);
        $(By.id("mailbox__password")).setValue(myPassword);
        $(By.id("mailbox__auth__button")).click();

        Thread.sleep(10000);
        $$(By.cssSelector("[class=\"b-datalist__item__subj\"]")).get(0).shouldHave(Condition.text(subject));

        int letters;
        int page = 1;

        while (true){
            letters = $$(By.cssSelector("[class=\"b-datalist__item__panel\"]")).size();
            System.out.println(page++ + " a page has " + letters + " letters ");
            if (!$(By.cssSelector(".b-toolbar__btn.b-toolbar__btn_last.js-shortcut"))
                    .getAttribute("class").contains("b-toolbar__btn_disabled")){
                $(By.cssSelector("i.ico_toolbar_arrow_right")).click();
            } else
                break;
        }
        $(By.cssSelector("[id=\"PH_logoutLink\"]")).click();
    }

    @Test
    public void uploadAvatar() throws InterruptedException {
        $(By.id("mailbox__login")).setValue(myEmail);
        $(By.id("mailbox__password")).setValue(myPassword);
        $(By.id("mailbox__auth__button")).click();
        Thread.sleep(10000);
        $(By.cssSelector("[id=\"PH_authMenu\"]")).click();
        $(By.cssSelector("[href=\"https://e.mail.ru/settings/userinfo\"]")).click();
        Thread.sleep(10000);
        $(By.cssSelector(".js-upload.form__button_upload")).uploadFile(new File("C:\\111.JPG"));
        $(By.cssSelector("[data-fire=\"save\"]")).click();
        Thread.sleep(10000);
        $(By.cssSelector(".form__actions__inner button")).click();
        $(By.cssSelector(".settings__index__item__text.settings__index__item__text_oneline"))
                .shouldHave(Condition.text("Артём Рудько  (24 года) "));
        $(By.cssSelector("[id=\"PH_logoutLink\"]")).click();


    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Configuration.startMaximized = true;
        open("https://mail.ru/");
        $(By.id("mailbox__login")).setValue(myEmail);
        $(By.id("mailbox__password")).setValue(myPassword);
        $(By.id("mailbox__auth__button")).click();
        Thread.sleep(10000);
        $(By.cssSelector("[id=\"PH_authMenu\"]")).click();
        $(By.cssSelector("[href=\"https://e.mail.ru/settings/userinfo\"]")).click();
        Thread.sleep(10000);
        $(By.cssSelector(".js-upload.form__button_upload")).uploadFile(new File("C:\\11.JPG"));
        $(By.cssSelector("[data-fire=\"save\"]")).click();
        Thread.sleep(10000);
        $(By.cssSelector(".form__actions__inner button")).click();
    }
}
