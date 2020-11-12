package homework_6.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssertions softAssertions;
    protected String login = "makhnovets1995@mail.ru";
    protected String password = ".34EY9zk%(%n.bs";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    public void login(String login, String password) throws InterruptedException {
        driver.get("https://mail.ru/");
        WebElement loginWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mailbox [name=login]")));
        loginWindow.sendKeys(login);
        loginWindow.sendKeys(Keys.RETURN);

        WebElement passwordWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mailbox [name=password]")));
        passwordWindow.sendKeys(password);
        passwordWindow.sendKeys(Keys.RETURN);
    }

    public void createLetter(String address, String topic, String letter) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".compose-button__txt")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-name='to'] input")))
                .sendKeys(address);
        driver.findElement(By.cssSelector("input[name='Subject']"))
                .sendKeys(topic);
        driver.findElement(By.cssSelector("[role='textbox']"))
                .sendKeys(letter);
    }

    public void saveLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Сохранить']"))).click();
    }

    public void sendLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Отправить']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Закрыть']"))).click();
    }

    public void closeLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Закрыть']"))).click();
    }

    public void logout() {
        driver.findElement(By.cssSelector("#PH_logoutLink")).click();

    }

}
