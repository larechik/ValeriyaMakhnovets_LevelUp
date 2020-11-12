package homework_7.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailInputLatterPage extends MailMenu {
    @FindBy(css = ".js-letter-list-item")
    private WebElement letterForMyself;

    public MailInputLatterPage(WebDriver driver) {
        super(driver);
    }

    public MailInputLatterPage openLetterToMyself(){
        wait.until(ExpectedConditions.elementToBeClickable(letterForMyself)).click();
        return new MailInputLatterPage(driver);
    }


    ////*[@id="app-canvas"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/div[4]/div[2]/a/div[4]/div[1]/span
}
