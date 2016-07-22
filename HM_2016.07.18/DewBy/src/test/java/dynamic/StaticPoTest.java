package dynamic;

import core.TestBase;
import org.testng.annotations.Test;
import pagesElements.PageElement;
import pagesObject.PageCompany;
import pagesObject.PageJobs;
import pagesObject.PageLenta;
import pagesObject.PageSalary;

import static org.testng.Assert.assertTrue;

public class StaticPoTest extends TestBase {

    @Test
    public void SearchLogo(){
        PageElement.clickTape(driver);
        assertTrue(PageLenta.containsAnItem(driver));
    }
    @Test
    public void SearchIiSsoft(){
        PageElement.clickCompany(driver);
        assertTrue(PageCompany.containsCompany(driver));
    }
    @Test
    public void SearchSalaryInIT() {
        PageElement.clickSalary(driver);
        assertTrue(PageSalary.containsAnItem(driver));
    }
    @Test
    public void SearchJobs(){
        PageElement.clickJobs(driver);
        assertTrue(PageJobs.containsSraechField(driver));
    }
}
