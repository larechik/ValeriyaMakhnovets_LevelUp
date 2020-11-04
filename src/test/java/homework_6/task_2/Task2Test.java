package homework_6.task_2;

import homework_6.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test extends BaseTest {
    @Test
    public void task2() throws InterruptedException {
        login(login, password);
        assertThat(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#PH_user-email")))
                .getText()).isEqualTo(login);

        String address = login;
        String topic = "Тест";
        String letter = "blablabla";
        createLetter(address, topic, letter);
        sendLetter();
        driver.findElement(By.xpath("//div[contains(text(),'Отправленные')]")).click();
        softAssertions.assertThat(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='makhnovets1995@mail.ru']")))
                .getText()).isEqualTo(address);

        driver.findElement(By.xpath("//div[contains(text(),'Тест')]")).click();
        WebElement sendLetter = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Valeriya Makhnovets <makhnovets1995@mail.ru>']")));
        softAssertions.assertThat(sendLetter.getText()).isEqualTo("Valeriya Makhnovets");
        sendLetter.click();
        softAssertions.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".thread__subject")))
                .getText()).isEqualTo(topic);
        softAssertions.assertThat(driver.findElement(By.cssSelector(".letter-contact")).getAttribute("title"))
                .isEqualTo(address);
        softAssertions.assertThat(driver.findElement(By.cssSelector(".letter-body")).getText().contains(letter))
                .isTrue();
        logout();
        softAssertions.assertAll();
    }
}
