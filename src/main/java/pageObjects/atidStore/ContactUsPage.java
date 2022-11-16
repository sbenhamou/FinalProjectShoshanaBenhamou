package pageObjects.atidStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactUsPage {
    @FindBy(how = How.ID, using = "wpforms-confirmation-15")
    public WebElement mes_contactConfirmation;

    @FindBy(how = How.ID, using = "wpforms-15-field_0")
    public WebElement txt_name;

    @FindBy(how = How.ID, using = "wpforms-15-field_4")
    public WebElement txt_email;

    @FindBy(how = How.ID, using = "wpforms-15-field_2")
    public WebElement txt_mess;

    @FindBy(how = How.ID, using = "wpforms-submit-15")
    public WebElement but_submit;

}
