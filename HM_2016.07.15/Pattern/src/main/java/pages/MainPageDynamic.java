package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPageDynamic {
    private final By LOGIN = By.id("mailbox__login");
    private final By PASSWORD = By.id("mailbox__password");
    private final By SUBMIT = By.id("mailbox__auth__button");
    private WebDriver driver;

    public MainPageDynamic(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLogin(String Login) {
        WebElement searchField = driver.findElement(LOGIN);
        searchField.sendKeys(Login);

    }

    public void enterPassword(String Password) {
        WebElement searchField = driver.findElement(PASSWORD);
        searchField.sendKeys(Password);

    }

    public void ClickSubmit() {
        WebElement searchButton = driver.findElement(SUBMIT);
        searchButton.click();

    }

    public boolean titleTheSameAs(String HomePageTitle) {
        if (!driver.getTitle().equals(HomePageTitle)) {
            return false;
        }
        return true;
    }
}