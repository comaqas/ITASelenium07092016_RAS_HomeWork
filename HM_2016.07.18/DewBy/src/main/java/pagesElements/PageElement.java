package pagesElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageElement {
    private static final By TAPE = By.cssSelector("[href=\"https://dev.by/lenta\"]");
    private static final By COMPANY = By.cssSelector("[href=\"https://companies.dev.by/\"]");
    private static final By SALARY = By.cssSelector("[href=\"https://salaries.dev.by/\"]");
    private static final By JOBS = By.cssSelector("[href=\"https://jobs.dev.by/\"]");

    public static void clickTape(WebDriver driver) {
        WebElement searchField = driver.findElement(TAPE);
        searchField.click();

    }
    public static void clickCompany(WebDriver driver){
        WebElement searchField = driver.findElement(COMPANY);
        searchField.click();
    }
    public static void clickSalary(WebDriver driver){
        WebElement searchField = driver.findElement(SALARY);
        searchField.click();
    }
    public static void clickJobs(WebDriver driver){
        WebElement searhField = driver.findElement(JOBS);
        searhField.click();
    }
}
