package homework_6.task_1;

import homework_6.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;


public class Task1Test  extends BaseTest {

    @Test
    public void task1() throws InterruptedException {

        login(login, password);
        assertThat(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#PH_user-email")))
                .getText()).isEqualTo(login);

        String address = "makhnovets1995@inbox.ru";
        String topic = "blabla";
        String letter = "blablabla";

        createLetter(address, topic, letter);
        saveLetter();
        closeLetter();

        driver.findElement(By.xpath("//div[contains(text(),'Черновики')]")).click();

        WebElement latter = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='makhnovets1995@inbox.ru']")));
        softAssertions.assertThat(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='makhnovets1995@inbox.ru']")))
                .getText()).isEqualTo(address);
        latter.click();

        softAssertions.assertThat(wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[contains(@class, 'contacts')][@data-type='to']//span"))).getText())
                .isEqualTo(address);
        softAssertions.assertThat(driver.findElement(By.xpath("//*[@name='Subject']")).getAttribute("value"))
                .isEqualTo(topic);
        softAssertions.assertThat(driver.findElement((By.xpath("//*[contains(@id, 'BODY')]/div/div"))).getText())
                .isEqualTo(letter);
        sendLetter();

        softAssertions.assertThat(wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".octopus__title"))).getText()).isEqualTo("У вас нет незаконченных\nили неотправленных писем");


        driver.findElement(By.xpath("//div[contains(text(),'Отправленные')]")).click();
        softAssertions.assertThat(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='makhnovets1995@inbox.ru']")))
                .getText()).isEqualTo(address);
        logout();
        softAssertions.assertAll();
    }

}
