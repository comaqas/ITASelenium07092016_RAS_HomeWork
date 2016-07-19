package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageSimpleFactory {

    @FindBy(css = "[data-group=\"selectAll\"]")
    private WebElement SelectAll;
    @FindBy(css = "[data-name=\"all\"]")
    private WebElement ButtonAll;
    @FindBy(css = "[data-name=\"selectAllLetters\"]")
    private WebElement Really_all;
    @FindBy(css = ".b-announcement__text")
    private WebElement text;


    public void numberOfLetters() {

        SelectAll.click();
        ButtonAll.click();
        Really_all.click();

        String numberOfLetters = text.getText();
        String[] outPutMessage = numberOfLetters.split(" ");
        System.out.println("Количество писем = "+outPutMessage[1]);
    }
}


