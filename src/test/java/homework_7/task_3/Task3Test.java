package homework_7.task_3;

import homework_7.base.BaseTest;
import homework_7.pageObject.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test extends BaseTest{

    @ParameterizedTest()
    @MethodSource("homework_7.task_3.Task3DataProvider#letterData")
    public void task3Test(String address,String subject,String letter){
        //Войти в почту
        MailHomePage homePage = new MailHomePage(driver);
        homePage.open();
        MailLoginStartPage mailLoginStartPage = homePage.login(login,password);

        //Assert, что вход выполнен успешно
        assertThat(mailLoginStartPage.getUserEmailField()).isEqualTo(login);

        //Создать новое письмо (заполнить адресата, тему письма и тело)
        MailWriteLetterPage writeLetterPage= mailLoginStartPage.writeLetter();
        writeLetterPage.createLetter(address,subject,letter);

        //Отправить письмо
        writeLetterPage.sendAndCloseLetter();

        //Verify, что письмо появилось в папке Входящие
        MailInputLatterPage inputPage= mailLoginStartPage.goToInputLetter();
        inputPage.openLetterToMyself();
        softAssertions.assertThat(inputPage.getAddressToFromListLetter(1)).contains(address);

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        MailOpenLetterPage openLetter= inputPage.openLetter(1);
        softAssertions.assertThat(openLetter.getSubjectField()).isEqualTo(subject);
        softAssertions.assertThat(openLetter.getAddressField()).isEqualTo(address);
        softAssertions.assertThat(openLetter.getLetterBodyField().contains(letter)).isTrue();

        //Удалить письмо
        openLetter.deleteLetter();

        //Verify что письмо появилось в папке Корзина
        mailLoginStartPage.goToTrash();
        softAssertions.assertThat(mailLoginStartPage.getAddressToFromListLetter(1)).contains(address);

        //Выйти из учётной записи
        mailLoginStartPage.logout();

        softAssertions.assertAll();
    }
}
