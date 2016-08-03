package block;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Navigation Block")
@Block(@FindBy(css = ".menu"))


public class NavigationBlock extends HtmlElement {

    @Name("Tape")
    @FindBy(css = "[title=\"Лента\"]")
    private Link tapeLink;
    @Name("Company")
    @FindBy(css = "[href=\"https://companies.dev.by/\"]")
    private Link companyLink;
    @Name("Salary")
    @FindBy(css = "[href=\"https://salaries.dev.by/\"]")
    private Link salaryLink;
    @Name("Jobs")
    @FindBy(css = "[href=\"https://jobs.dev.by/\"]")
    private Link jobsLink;

    public void clickTape() {
        tapeLink.click();
    }

    public void clickCompany(){
        this.companyLink.click();
    }

    public void clickSalary(){
        this.salaryLink.click();
    }

    public void clickJobs(){
        this.jobsLink.click();
    }

    public Rectangle getRect() {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
