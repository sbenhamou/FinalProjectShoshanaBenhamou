package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;

public class Listeners extends CommonOps implements ITestListener {

    /*
    ##################################################################
    Method Name: onStart
    Method Description: This Method prints line when starting execution
    Method Parameters: ITestContext
    Method Return: no value return
    ##################################################################
    */
    public void onStart(ITestContext execution){
        System.out.println("---------- Starting Execution ----------");
    }

    /*
    ##################################################################
    Method Name: onFinish
    Method Description: This Method prints line when ending execution
    Method Parameters: ITestContext
    Method Return: no value return
    ##################################################################
    */
    public void onFinish(ITestContext execution){
        System.out.println("---------- Ending Execution ----------");
    }

    /*
    ########################################################################
    Method Name: onTestStart
    Method Description: This Method prints line when starting test execution
    Method Parameters: ITestResult
    Method Return: no value return
    ########################################################################
    */
    public void onTestStart(ITestResult test){
        System.out.println("---------- Starting Test "+ test.getName() +" ----------");
    }

    /*
    ###############################################################################################
    Method Name: onTestSuccess
    Method Description: This Method prints line when test execution successed and stops recording
    Method Parameters: ITestResult
    Method Return: no value return
    ###############################################################################################
    */
    public void onTestSuccess(ITestResult test){
        System.out.println("---------- Test "+ test.getName() +" Passed ----------");
        if(!platform.equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Delete Recorded File
        File file = new File("./test-recordings/"+ test.getName() + ".avi");
        if(file.delete())
            System.out.println("File Deleted Successfully");
        else
            System.out.println("Failed to delete File");
    }

    /*
    ######################################################################################
    Method Name: onTestFailure
    Method Description: This Method prints line when test execution failed and stops recording
    Method Parameters: ITestResult
    Method Return: no value return
    #####################################################################################
    */
    public void onTestFailure(ITestResult test) {
        System.out.println("---------- Test " + test.getName() + " Failed ----------");
        if (!platform.equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    /*
    #####################################################################################################
    Method Name: nTestFailedButWithinSuccessPercentage
    Method Description: This Method prints line when test execution failed but within success percentage
    Method Parameters: ITestResult
    Method Return: no value return
    ####################################################################################################
    */
    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        System.out.println("---------- Test " + test.getName() + " Failed but within success percentage----------");
    }

    /*
    ########################################################################
    Method Name: onTestSkipped
    Method Description: This Method prints line when test execution skipped
    Method Parameters: ITestResult
    Method Return: no value return
    ########################################################################
    */
    public void onTestSkipped(ITestResult test){
        System.out.println("---------- Skipping Test: " + test.getName() + " ----------");
    }

    @Attachment(value="Page screenshot", type ="image/png")

    /*
    #############################################################################
    Method Name: saveScreenshot
    Method Description: This Method saves a screenshot when test execution failed
    Method Parameters: ITestContext
    Method Return: no value return
    #############################################################################
    */
    public byte[] saveScreenshot()
    {
        if(!platform.equalsIgnoreCase("mobile"))
            {
                return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            }
        else{
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
            }
    }
}

