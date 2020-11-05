package homework_7.task_1;

import homework_7.base.BaseTest;
import homework_7.pageObject.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_7.task_1.Task1DataProvider#letterData")
    public void task1Test(String address,String subject,String letter){
        //Войти в почту
        MailHomePage homePage = new MailHomePage(driver);
        homePage.open();
        MailLoginStartPage mailLoginStartPage = homePage.login(login,password);

        //Assert, что вход выполнен успешно
        assertThat(mailLoginStartPage.getUserEmailField()).isEqualTo(login);

        //Создать новое письмо (заполнить адресата, тему письма и тело)
        MailWriteLetterPage writeLetterPage= mailLoginStartPage.writeLetter();
        writeLetterPage.createLetter(address,subject,letter);

        //Сохранить его как черновик
        mailLoginStartPage = writeLetterPage.saveAndCloseLetter();

        //Verify, что письмо сохранено в черновиках
        MailSavedLetterListPage savedLetterPage= mailLoginStartPage.goToSaveLetter();
        softAssertions.assertThat(savedLetterPage.getAddressToFromListLetter(1)).isEqualTo(address);
        MailOpenSaveLetterPage openSavedLetter=savedLetterPage.getLetterFromModify(1);
        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        softAssertions.assertThat(openSavedLetter.getAddressField()).isEqualTo(address);
        softAssertions.assertThat(openSavedLetter.getSubjectField()).isEqualTo(subject);
        softAssertions.assertThat(openSavedLetter.getLetterField()).isEqualTo(letter);

        //Отправить письмо
        savedLetterPage= openSavedLetter.sendAndCloseLetter();

        //Verify, что письмо исчезло из черновиков
        softAssertions.assertThat(savedLetterPage.getEmptyFieldMessage())
                .isEqualTo("У вас нет незаконченных\nили неотправленных писем");

        //Verify, что письмо появилось в папке отправленные
        mailLoginStartPage = savedLetterPage.goToSendLetter();
        softAssertions.assertThat(mailLoginStartPage.getAddressToFromListLetter(1)).isEqualTo(address);

        // Выйти из учётной записи
        mailLoginStartPage.logout();

        softAssertions.assertAll();
    }
}
