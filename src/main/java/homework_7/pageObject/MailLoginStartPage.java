package homework_7.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MailLoginStartPage extends MailMenu {

    @FindBy(css = "#PH_user-email")
    private WebElement userEmailField;

    public MailLoginStartPage(WebDriver driver) {
        super(driver);
    }

    public String getUserEmailField() {
        return wait.until(elementToBeClickable(userEmailField)).getText();
    }


}
