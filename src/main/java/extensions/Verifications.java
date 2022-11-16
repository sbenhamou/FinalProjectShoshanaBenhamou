package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;
import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Visibility of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems){
        for(WebElement elem:elems){
            softAssert.assertTrue(elem.isDisplayed(),"Sory " + elem.getText() + " not displayed.");
        }
        softAssert.assertAll("Some elements aren't displayed.");
    }

    public static void verifyUrlPage(String expectedUrl) {
        assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
    public static void verifyContainsPage(String expectedText) {
        assertTrue(driver.getPageSource().contains(expectedText));
    }

    @Step("Verify Visibility of Element")
    public static void visibilityOfElement(WebElement elem)
    {
        assertTrue(elem.isDisplayed());
    }

    //Using to verify non visible Element
    @Step("Verify non Visibility of Element")
    public static void nonVisibilityOfElement(WebElement elem)
    {
        assertFalse(elem.isDisplayed());
    }

    @Step("Verify expected result")
    public static void verifyResult(String result, String expectedResult){
        assertEquals(result,expectedResult);
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo")+expectedImageName+".png");
        } catch (FindFailed e) {
            System.out.println("Error Comparing Image File: " + e);
            fail("Error Comparing Image File: " + e);
        }
    }

    @Step("Verify Title's article contains")
    public static void verifyTitleContains(List<WebElement> elems, String product){
        for (WebElement elem: elems){
            softAssert.assertTrue(elem.getText().contains(product));
        }
        softAssert.assertAll("Some elements are invalid.");
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected){
        assertTrue(actual.contains(expected));
    }

    @Step("Verify Text within Element")
    public static void verifyTextInElement(WebElement elem, String expected){
        assertEquals(elem.getText(),expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected){
        assertEquals(actual, expected);
    }

}
