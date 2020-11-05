package homework_7.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailOpenLetterPage extends MailMenu{

    @FindBy(css = ".letter-contact")
    private WebElement addressField;

    @FindBy(css = ".thread__subject")
    private WebElement subjectField;

    @FindBy(css = ".letter-body")
    private WebElement letterBodyField;

    @FindBy(css = "[title='Удалить']")
    private WebElement delLetterButton;

    public MailOpenLetterPage(WebDriver driver) {
        super(driver);
    }

    public String getAddressField() {
        return wait.until(ExpectedConditions.elementToBeClickable(addressField)).getAttribute("title");
    }

    public String getSubjectField() {
        return wait.until(ExpectedConditions.elementToBeClickable(subjectField)).getText();
    }

    public String getLetterBodyField() {
        return wait.until(ExpectedConditions.elementToBeClickable(letterBodyField)).getText();
    }

    public void deleteLetter(){
        wait.until(ExpectedConditions.elementToBeClickable(delLetterButton)).click();
    }
}
