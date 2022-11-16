package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

public class Functions extends CommonOps {

    @Step("Return error message displayed")
    public static String isErrorMessage()
    {
        String result;
        if(driver.getPageSource().contains("Send Message")){
            result = "false";
        }
        else{
            result = "true";
        }
        return result;
    }
}
