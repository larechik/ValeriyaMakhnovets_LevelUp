package homework_7.base;

import homework_7.pageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {
    protected WebDriver driver;
    protected SoftAssertions softAssertions;
    protected String login = "makhnovets1995@mail.ru";
    protected String password = ".34EY9zk%(%n.bs";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

