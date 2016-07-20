import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class BuyTelephone {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
        @Test
        public void BuyNewPhone () {

            driver.get("https://www.onliner.by/");
            WebElement ClickPhone = driver.findElement(By.cssSelector("[href=\'http://catalog.onliner.by/mobile\'] " +
                    ".project-navigation__sign"));
            ClickPhone.click();
            assertEquals(driver.getTitle(), "Купить мобильный телефон в Минске");

            WebElement phoneBrand = driver.findElement(By.cssSelector(".schema-filter__facet .schema-filter__list  " +
                    "[value='samsung']"));
            phoneBrand.click();

            WebElement priceFrom = driver.findElement(By.cssSelector(".schema-filter-control__item." +
                    "schema-filter__number-input.schema-filter__number-input_price[placeholder=\"от\"]"));
            priceFrom.sendKeys("1000");

            WebElement priceTo = driver.findElement(By.cssSelector(".schema-filter-control__item." +
                    "schema-filter__number-input.schema-filter__number-input_price[data-bind^=\"value: facet.value.to\"]"));
            priceTo.sendKeys("2000");

            WebElement chooseYear = driver.findElement(By.xpath("//Span[text()='2016']"));
            chooseYear.click();

            WebElement chooseOS = driver.findElement(
                    By.xpath(".//*[@id='schema-filter']/div[1]/div[4]/div[3]/ul/li[1]/label/span[2]"));
            chooseOS.click();

            WebElement chooseScreenSize = driver.findElement(By.xpath("//span[text()='4.5 - 5\"']"));
            chooseScreenSize.click();

            WebElement chooseScreenTechnology = driver.findElement(By.xpath("//span[text()='IPS']"));
            chooseScreenTechnology.click();

            WebElement chooseRAM = driver.findElement(By.xpath("//span[text()='4 ГБ и больше']"));
            chooseRAM.click();

            WebElement chooseFlashMemory = driver.findElement(By.xpath("//span[text()='16 ГБ']"));
            chooseFlashMemory.click();

            WebElement memoryCard = driver
                    .findElement(By.xpath(".//*[@id='schema-filter']/div[1]/div[10]/div[3]/div/label[1]"));
            memoryCard.click();

            WebElement chooseCamera = driver.findElement(By.xpath("//span[text()='8-10 Мп']"));
            chooseCamera.click();

            WebElement chooseSIM = driver.findElement(By.xpath("//span[text()='nano-SIM']"));
            chooseSIM.click();

            WebElement selectQuantitySIM = driver.findElement(By.xpath
                    (".//*[@id='schema-filter']/div[1]/div[13]/div[3]/div/label[2]"));
            selectQuantitySIM.click();

            WebElement chooseColor = driver.findElement(By.xpath("//span[text()='бежевый']"));
            chooseColor.click();

            WebElement chooseScreenResolution = driver.findElement(By.xpath("//Span[text()=\"1440x2560 (QHD) и более\"]"));
            chooseScreenResolution.click();

            WebElement chooseCapacity = driver.findElement(By.xpath("//Span[text()=\"3500 и более\"]"));
            chooseCapacity.click();

            driver.close();






        }
    }
