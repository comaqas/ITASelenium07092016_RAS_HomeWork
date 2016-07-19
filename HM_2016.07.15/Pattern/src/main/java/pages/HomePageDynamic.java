package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageDynamic {
    private final By SELECT_ALL = By.cssSelector("[data-group=\"selectAll\"]");
    private final By BUTTON_ALL = By.cssSelector("[data-name=\"all\"]");
    private final By REALLY_ALL = By.cssSelector("[data-name=\"selectAllLetters\"]");
    private final By SEARCH_TEXT = By.cssSelector(".b-announcement__text");

    private WebDriver driver;

    public HomePageDynamic(WebDriver driver) {
        this.driver = driver;
    }

    public void numberOfLetters() {


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
