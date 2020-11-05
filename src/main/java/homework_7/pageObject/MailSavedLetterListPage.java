package homework_7.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MailSavedLetterListPage extends MailMenu {

    @FindBy(css = ".octopus__title")
    private WebElement emptyPage;

    public MailSavedLetterListPage(WebDriver driver) {
        super(driver);
    }

    public String getEmptyFieldMessage() {
        wait.until(ExpectedConditions.visibilityOf(emptyPage));
        return emptyPage.getText();
    }

    public MailOpenSaveLetterPage getLetterFromModify(int number) {
        wait.until(elementToBeClickable(addressToList.get(number - 1))).click();
        return new MailOpenSaveLetterPage(driver);
    }
}
