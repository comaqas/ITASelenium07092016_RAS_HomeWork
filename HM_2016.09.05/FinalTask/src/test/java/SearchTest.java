import core.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import reporting.Listener;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(Listener.class)

public class SearchTest extends TestBase {
    static final String BLOUSE = "Blouse";
    static final String T_SHIRTS = "T-shirts";
    static final String DRESS = "DRESS";

    @Test
    public void searchWomenBlouseTest(){
        MainPage.searchForItem(driver, BLOUSE);
        assertTrue(SearchPage.verifySuccessSearch(driver, BLOUSE));
        MainPage.goToMainPage(driver);
    }

    @Test
    public void searchWomenTshortsTest(){
        MainPage.chooseWomenTshort(driver);
        assertTrue(SearchPage.verifySuccessSearch(driver, T_SHIRTS));
        MainPage.goToMainPage(driver);
    }

    @Test
    public void shareProductWithFriendTest(){
        MainPage.searchForItem(driver, DRESS);
        SearchPage.chooseRandomItem(driver, SearchPage.ChooseActions.viewItem);
        SearchPage.sendWithFriend(driver);
        SearchPage.enterFriendsContactAndSending(driver);
        assertTrue(SearchPage.verifySendingLetter(driver));
        MainPage.goToMainPage(driver);
    }
}
