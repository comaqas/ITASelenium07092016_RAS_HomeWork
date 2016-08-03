package staticPo;


import block.NavigationBlock;
import core.TestBase;
import org.testng.annotations.Test;
import pageObject.PageCompany;
import pageObject.PageJobs;
import pageObject.PageLenta;
import pageObject.PageSalary;


import static org.testng.Assert.assertTrue;

public class BlockPoTest extends TestBase {

    private PageLenta pageLentas = new PageLenta(driver);
    private PageCompany pageCompany = new PageCompany(driver);
    private PageSalary pageSalarys = new PageSalary(driver);
    private PageJobs pageJobs = new PageJobs(driver);


    @Test
    public void SearchLogo(){

        pageLentas.clickPageLenta();
        assertTrue(pageLentas.containsAnItem(driver));

        pageCompany.SelectPageCompany();
        assertTrue(pageCompany.containsCompany(driver));

        pageSalarys.selectPageSalary();
        assertTrue(pageSalarys.containsAnItem(driver));

        pageJobs.selcetPageJobs();
        assertTrue(pageJobs.containsSraechField(driver));





    }
}
