import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SingleTest {

    @Test
    public void verifyCellText(){
        open("http://6.pogoda.by/");
        $$(By.cssSelector("[id=\"forecast\"] tr")).get(0).shouldHave(Condition.text("Облачность, погодные явления и осадки"));
    }

    @Test
    public void  verifyTableSize(){
        open("http://6.pogoda.by/");
        $$(By.cssSelector("[id=\"forecast\"] tr")).shouldHave(size(31));
        $$(By.xpath(".//*[@id='forecast']/tbody/tr[1]/td")).shouldHave(size(6));
    }
}
