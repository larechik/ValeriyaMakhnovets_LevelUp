package homework_7.base;

import homework_7.pageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssertions softAssertions;

    protected static String login;
    protected static String password;

    @BeforeAll
    public static void setProperties(){
        Properties mailProperties = new Properties();
        try {
            mailProperties.load(BaseTest.class.getClassLoader().getResourceAsStream("homework_7/mail.properties"));
        } catch (IOException e) {
            System.out.println("Unable to read mail properties file");
            e.printStackTrace();
        }
        login = mailProperties.getProperty("mail.login");
        password = mailProperties.getProperty("mail.password");
    }

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

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

}

