package pageObjects.atidStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {

    @FindBy(how = How.CLASS_NAME, using = "remove")
    public WebElement elem_remove;

}
