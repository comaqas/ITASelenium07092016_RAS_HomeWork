package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageFlow {
    private final By LOGIN = By.id("mailbox__login");
    private final By PASSWORD = By.id("mailbox__password");
    private final By SUBMIT = By.id("mailbox__auth__button");
    private WebDriver driver;

    public MainPageFlow(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageFlow enterLogin(String Login) {
        WebElement searchField = driver.findElement(LOGIN);
        searchField.sendKeys(Login);
        return this  ;

    }

    public MainPageFlow enterPassword(String Password) {
        WebElement searchField = driver.findElement(PASSWORD);
        searchField.sendKeys(Password);
        return this;

    }

    public MainPageFlow ClickSubmit() {
        WebElement searchButton = driver.findElement(SUBMIT);
        searchButton.click();
        return this;

    }

    public boolean titleTheSameAs(String HomePageTitle) {
        if (!driver.getTitle().equals(HomePageTitle)) {
            return false;
        }
        return true;
    }
}