package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy(how = How.CLASS_NAME, using = "taskWrapper_2u8dN")
    public List<WebElement> list_task;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_delete;

    @FindBy(how = How.CLASS_NAME, using = "downArrowIcon_3Zu5N")
    public WebElement btn_down;

    @FindBy(how = How.XPATH, using = "//span[@class='tag_21fhY']")
    public List<WebElement> btn_colors;

    @FindBy(how = How.CLASS_NAME, using = "leftArrowIcon_pDboD")
    public WebElement btn_left;

    @FindBy(how = How.CLASS_NAME, using = "//label[starts-with(@for,'toggle-')]")
    public List<WebElement> checkbox_completed;
}
