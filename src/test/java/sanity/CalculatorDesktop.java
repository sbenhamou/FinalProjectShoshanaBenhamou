package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Addition Command")
    @Description("This Test Verifies the Addition Command")
    public void test01_verifyAdditionCommand(){
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 14");
    }

    @Test(description = "Test02 - Verify Substraction Command")
    @Description("This Test Verifies the Substraction Command")
    public void test02_verifySubstractionCommand(){
        DesktopFlows.calculateSubstraction();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 82");
    }

    @Test(description = "Test03 - Verify Multiplication Command")
    @Description("This Test Verifies the Multiplication Command")
    public void test03_verifyMultiplicationCommand(){
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 14");
    }

    @Test(description = "Test04 - Verify Division Command")
    @Description("This Test Verifies the Division Command")
    public void test04_verifyDivisionCommand(){
        DesktopFlows.calculateDivision();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 4");
    }

    @Test(description = "Test05 - Verify Reciprocal Command on Zero")
    @Description("This Test Verifies the Reciprocal Command on Zero")
    public void test05_verifyReciprocalOnZeroCommand(){
        DesktopFlows.reciprocal();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is Cannot divide by zero");
    }
}
