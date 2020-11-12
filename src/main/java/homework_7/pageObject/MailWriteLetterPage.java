package homework_7.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailWriteLetterPage extends MailMenu {
    @FindBy(css = "[data-name='to'] input")
    private WebElement addressField;

    @FindBy(css = "input[name='Subject']")
    private WebElement subjectField;

    @FindBy(css = "[role='textbox']")
    private WebElement letterField;

    @FindBy(css = "[title='Сохранить']")
    private WebElement saveButton;

    @FindBy(css = "[title='Отправить']")
    private WebElement sendButton;

    @FindBy(css = "[title='Закрыть']")
    private WebElement closeButton;

    public MailWriteLetterPage(WebDriver driver) {
        super(driver);

    }

    public String getAddressField() {
        return addressField.getText();
    }

    public String getSubjectField() {
        return subjectField.getAttribute("value");
    }

    public String getLetterField() {
        return letterField.getText();
    }

    public MailWriteLetterPage createLetter(String address, String subject, String letter) {
        wait.until(ExpectedConditions.elementToBeClickable(addressField)).sendKeys(address);
        subjectField.sendKeys(subject);
        letterField.sendKeys(letter);
        return new MailWriteLetterPage(driver);
    }

    public MailLoginStartPage saveAndCloseLetter() {
        saveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        return new MailLoginStartPage(driver);
    }

    public MailLoginStartPage sendAndCloseLetter() {
        sendButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        return new MailLoginStartPage(driver);
    }
}
