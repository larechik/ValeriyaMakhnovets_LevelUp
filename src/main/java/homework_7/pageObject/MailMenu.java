package homework_7.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MailMenu {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = ".compose-button__txt")
    protected WebElement writeLetterButton;

    @FindBy(xpath = "//div[contains(text(),'Черновики')]")
    protected WebElement saveLetterButton;

    @FindBy(xpath = "//div[contains(text(),'Отправленные')]")
    protected WebElement sendLetterButton;

    @FindBy(xpath = "//div[contains(text(),'Тест')]")
    protected WebElement testFolderButton;

    @FindBy(xpath = "//div[contains(text(),'Входящие')]")
    protected WebElement inputLetterButton;

    @FindBy(xpath = "//div[contains(text(),'Корзина')]")
    protected WebElement trashButton;


    @FindBy(xpath = "//*[contains(@class, 'js-letter-list-item')]//span[contains(@title,'@')]")
    protected List<WebElement> addressToList;


    @FindBy(css = "#PH_logoutLink")
    protected WebElement logoutButton;

    public MailMenu(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }


    public MailWriteLetterPage writeLetter() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(writeLetterButton));
        writeLetterButton.click();
        return new MailWriteLetterPage(driver);
    }

    public MailSavedLetterListPage goToSaveLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(saveLetterButton)).click();
        return new MailSavedLetterListPage(driver);
    }

    public MailLoginStartPage goToSendLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(sendLetterButton)).click();
        return new MailLoginStartPage(driver);
    }

    public MailLoginStartPage goToTestFolder() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(testFolderButton)).click();
        return new MailLoginStartPage(driver);
    }

    public MailInputLatterPage goToInputLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(inputLetterButton)).click();
        return new MailInputLatterPage(driver);
    }

    public MailLoginStartPage goToTrash() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(trashButton)).click();
        return new MailLoginStartPage(driver);
    }

    public String getAddressToFromListLetter(int number) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(addressToList.get(number - 1)));
        return addressToList.get(number - 1).getAttribute("title");
    }

    public MailOpenLetterPage openLetter(int number) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(addressToList.get(number - 1)));
        addressToList.get(number - 1).click();
        return new MailOpenLetterPage(driver);
    }

    public MailHomePage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return new MailHomePage(driver);
    }

}
