package homework_6.task_3;

import homework_6.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test extends BaseTest {
    @Test
    public void test3() throws InterruptedException {

        login(login, password);
        assertThat(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#PH_user-email")))
                .getText()).isEqualTo(login);

        String address = login;
        String topic = "Bla";
        String letter = "blablabla";
        createLetter(address, topic, letter);
        sendLetter();

        driver.findElement(By.xpath("//div[contains(text(),'Входящие')]")).click();
        WebElement inputMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Письма себе')]")));
        softAssertions.assertThat(inputMessage.getText()).isEqualTo("Письма себе");
        inputMessage.click();

        WebElement sendLetter = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Valeriya Makhnovets <makhnovets1995@mail.ru>']")));
        softAssertions.assertThat(sendLetter.getText()).isEqualTo("Valeriya Makhnovets");
        sendLetter.click();
        softAssertions.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".thread__subject")))
                .getText()).isEqualTo(topic);
        softAssertions.assertThat(driver.findElement(By.cssSelector(".letter-contact")).getAttribute("title"))
                .isEqualTo(address);
        softAssertions.assertThat(driver.findElement(By.cssSelector(".letter-body")).getText().contains(letter))
                .isTrue();

        driver.findElement(By.cssSelector("[data-title-shortcut='Del']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Корзина')]"))).click();
        softAssertions.assertThat(wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[title='Valeriya Makhnovets <makhnovets1995@mail.ru>']"))).getText())
                .isEqualTo("Valeriya Makhnovets");
        softAssertions.assertAll();
    }

}
