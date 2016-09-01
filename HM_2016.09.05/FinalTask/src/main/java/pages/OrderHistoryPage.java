package pages;


import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    private static By FIELDS_IN_ORDER_TABLE = Locators.get("FieldsInOrderTable");
    private static final String MY_ORDER_REFERENCE = ShoppingCartPage.orderReference;

    public static boolean verifyOrderReference(WebDriver driver){
        return driver.findElements(FIELDS_IN_ORDER_TABLE).get(0).getText().contains(MY_ORDER_REFERENCE);
    }
}
