package homework_7.task_2;

import homework_7.base.BaseTest;
import homework_7.pageObject.MailHomePage;
import homework_7.pageObject.MailLoginStartPage;
import homework_7.pageObject.MailOpenLetterPage;
import homework_7.pageObject.MailWriteLetterPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test extends BaseTest {
    private String address = login;
    private String subject = "Тест";
    private String letter = "blabla";

    @Test
    public void test2Test() {
        //Войти в почту
        MailHomePage homePage = new MailHomePage(driver);
        homePage.open();
        MailLoginStartPage mailLoginStartPage = homePage.login(login, password);

        //Assert, что вход выполнен успешно
        assertThat(mailLoginStartPage.getUserEmailField()).isEqualTo(login);

        //Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест) и тело)
        MailWriteLetterPage writeLetterPage = mailLoginStartPage.writeLetter();
        writeLetterPage.createLetter(address, subject, letter);

        //Отправить письмо
        writeLetterPage.sendAndCloseLetter();

        //Verify, что письмо появилось в папке отправленные
        mailLoginStartPage.goToSendLetter();
        softAssertions.assertThat(mailLoginStartPage.getAddressToFromListLetter(1)).isEqualTo(address);

        //Verify, что письмо появилось в папке «Тест»
        mailLoginStartPage.goToTestFolder();
        softAssertions.assertThat(mailLoginStartPage.getAddressToFromListLetter(1)).contains(address);

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        MailOpenLetterPage openLetter = mailLoginStartPage.openLetter(1);
        softAssertions.assertThat(openLetter.getSubjectField()).isEqualTo(subject);
        softAssertions.assertThat(openLetter.getAddressField()).isEqualTo(address);
        softAssertions.assertThat(openLetter.getLetterBodyField().contains(letter)).isTrue();

        //Выйти из учётной записи
        openLetter.logout();

        softAssertions.assertAll();
    }
}
