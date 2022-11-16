package pageObjects.atidStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how= How.XPATH, using = "//span[text()='Shop Now']")
    public WebElement btn_shopNow;

 }
