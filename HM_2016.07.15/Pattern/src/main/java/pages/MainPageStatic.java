package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageStatic {
    private static By LOGIN = By.id("mailbox__login");
    private static By PASSWORD = By.id("mailbox__password");
    private static By SUBMIT = By.id("mailbox__auth__button");




    public static void enterLogin(WebDriver driver,String Login) {
        WebElement searchField = driver.findElement(LOGIN);
        searchField.sendKeys(Login);

    }

    public static void enterPassword(WebDriver driver,String Password) {
        WebElement searchField = driver.findElement(PASSWORD);
        searchField.sendKeys(Password);

    }

    public static void ClickSubmit(WebDriver driver) {
        WebElement searchButton = driver.findElement(SUBMIT);
        searchButton.click();

    }

    public static boolean titleTheSameAs(WebDriver driver,String HomePageTitle) {
        if (!driver.getTitle().equals(HomePageTitle)) {
            return false;
        }
        return true;
    }
}