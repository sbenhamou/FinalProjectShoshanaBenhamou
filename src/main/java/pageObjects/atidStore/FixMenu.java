package pageObjects.atidStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FixMenu {

    @FindBy(how = How.ID, using = "menu-item-45")
    public WebElement menu_store;

    @FindBy(how = How.ID, using = "menu-item-829")
    public WebElement menu_contact;

    @FindBy(how = How.CLASS_NAME, using = "pojo-a11y-toolbar-toggle")
    public WebElement  btn_accessibility;

}
