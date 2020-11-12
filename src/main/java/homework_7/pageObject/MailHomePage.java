package homework_7.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailHomePage {
    private static final String HOME_PAGE_URL = "https://mail.ru/";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#mailbox [name=login]")
    private WebElement loginField;

    @FindBy(css = "#mailbox [name=password]")
    private WebElement passwordField;



    public MailHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public MailHomePage open() {
        driver.navigate().to(HOME_PAGE_URL);
        return new MailHomePage(driver);
    }


    public MailLoginStartPage login(String login, String password) {
        WebElement loginWindow = wait.until(ExpectedConditions.elementToBeClickable(loginField));
        loginWindow.sendKeys(login);
        loginWindow.sendKeys(Keys.RETURN);

        WebElement passwordWindow = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordWindow.sendKeys(password);
        passwordWindow.sendKeys(Keys.RETURN);
        return new MailLoginStartPage(driver);
    }
}
