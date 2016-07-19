import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class Email {
    WebDriver driver;
    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }
    @Test
    public void findElement() {
        driver.get("https://mail.ru/");
        WebElement Login = driver.findElement(By.id("mailbox__login"));
        Login.sendKeys("strong.zubovich@bk.ru");

        WebElement password = driver.findElement(By.id("mailbox__password"));
        password.sendKeys("ZXCvbn123!");

        WebElement button = driver.findElement(By.id("mailbox__auth__button"));
        button.click();

        int numberOfLetters = driver.findElements(By.cssSelector("[data-bem=\"b-datalist__item\"]")).size();
        System.out.println("Количество писем = "+numberOfLetters);

        assertEquals("Входящие - Почта Mail.Ru",driver.getTitle());

        driver.close();


    }
}
