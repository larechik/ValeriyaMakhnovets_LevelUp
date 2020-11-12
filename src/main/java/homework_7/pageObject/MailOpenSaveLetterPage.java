package homework_7.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailOpenSaveLetterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class, 'contacts')][@data-type='to']//span")
    private WebElement addressField;

    @FindBy(css = "input[name='Subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//*[contains(@id, 'BODY')]/div/div")
    private WebElement letterField;

    @FindBy(css = "[title='Сохранить']")
    private WebElement saveButton;

    @FindBy(css = "[title='Отправить']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@title='Закрыть']")
    private WebElement closeButton;

    public MailOpenSaveLetterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String getAddressField() {
        return wait.until(ExpectedConditions.visibilityOf(addressField)).getText();
    }

    public String getSubjectField() {
        return wait.until(ExpectedConditions.visibilityOf(subjectField)).getAttribute("value");
    }

    public String getLetterField() {
        return wait.until(ExpectedConditions.visibilityOf(letterField)).getText();
    }

    public MailSavedLetterListPage sendAndCloseLetter() {
        sendButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        return new MailSavedLetterListPage(driver);
    }

}
