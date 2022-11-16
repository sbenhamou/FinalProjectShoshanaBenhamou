package extensions;


import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Insert Key Value")
    public static void insertKey(WebElement elem, Keys value){
        elem.sendKeys(value);
    }

    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for(char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch+"");
        }
    }

    // Using when select an element of DropDown List is requested
    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    // Using when clear text is requested
    @Step("Clear Text Element")
    public static void clear(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }

    // Using when mouse hover is requested with 2 web-elements
    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    // Using when mouse hover is requested with 1 web-element
    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }

    // Using when mouse hover is requested
    @Step("Drag and Drop Element")
    public static void dragNDrop(WebElement elem1, WebElement elem2){
        action.dragAndDrop(elem1,elem2).build().perform();
    }

    @Step("Get text of the field")
    public static String getTextField(WebElement elem){
        return elem.getText();
    }

}
