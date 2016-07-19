package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageStatic {
    private static By SELECT_ALL = By.cssSelector("[data-group=\"selectAll\"]");
    private static By BUTTON_ALL = By.cssSelector("[data-name=\"all\"]");
    private static By REALLY_ALL = By.cssSelector("[data-name=\"selectAllLetters\"]");
    private static By SEARCH_TEXT = By.cssSelector(".b-announcement__text");

    public static void numberOfLetters(WebDriver driver) {


        WebElement SelectAll = driver.findElement(SELECT_ALL);
        SelectAll.click();
        WebElement ButtonAll = driver.findElement(BUTTON_ALL);
        ButtonAll.click();
        WebElement Really_all = driver.findElement(REALLY_ALL);
        Really_all.click();

        WebElement text = driver.findElement(SEARCH_TEXT);
        String nomberOfLetters = text.getText();
        String[] outPutMessage = nomberOfLetters.split(" ");
        System.out.println("Количество писем = "+outPutMessage[1]);
    }
}
