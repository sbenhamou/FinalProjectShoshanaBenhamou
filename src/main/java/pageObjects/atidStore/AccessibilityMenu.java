package pageObjects.atidStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AccessibilityMenu {
    @FindBy(how = How.CLASS_NAME, using = "pojo-a11y-toolbar-text")
    public List<WebElement> list_accessibilities;
}
