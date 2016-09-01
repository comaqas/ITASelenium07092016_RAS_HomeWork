import core.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderHistoryPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import reporting.Listener;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(Listener.class)

public class TestsShopping extends TestBase {
    static final String DRESS = "Dress";
    static String myEmail = TestBase.MY_EMAIL;
    static String myPassword = TestBase.MY_PASSWORD;

    @Test
    public void DeleteItemFromShoppingCartTest(){
        MainPage.searchForItem(driver, DRESS);
        SearchPage.chooseRandomItem(driver, SearchPage.ChooseActions.addToCart);
        SearchPage.chooseContinueShopping(driver);
        SearchPage.verifySuccessAddingToCart(driver);
        SearchPage.removeItemFromCart(driver);
        SearchPage.verifyRemoveItemFromCart(driver);
        MainPage.goToMainPage(driver);
    }

    @Test
    public void proceedToCheckOutTest(){
        MainPage.searchForItem(driver, DRESS);
        SearchPage.chooseRandomItem(driver, SearchPage.ChooseActions.addToCart);
        SearchPage.chooseProceedToCheckOut(driver);
        ShoppingCartPage.purchaseItem(driver, myEmail, myPassword);
        assertTrue(OrderHistoryPage.verifyOrderReference(driver));
        MainPage.goToMainPage(driver);
        MainPage.signOut(driver);
    }

    @Test
    public void addingItemInWishlist(){
        MainPage.clickBestSellers(driver);
        MainPage.openQuickViewBlouse(driver);
        MainPage.addToWishlist(driver);
        assertTrue(MainPage.fancyBoxErrorIsDisplayed(driver));
        MainPage.goToMainPage(driver);
    }
}
