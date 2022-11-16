package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class ExerciseAPI extends CommonOps {

    @Test(description = "Test 01: Verify value")
    @Description("This test verifies get value")
    public void test01_verifyValue() {
        ApiFlows.emptyStore();
        ApiFlows.putValue("test01", "value01");
        Verifications.verifyResult(ApiFlows.getValue("value[0]"), "value01");
    }

    @Test(description = "Test 02: Add value and verify value added")
    @Description("This test adds a value in the store and verifies the value has been added")
    public void test02_addNVerifyValue() {
        ApiFlows.putValue("main_test2", "value2");
        Verifications.verifyResult(ApiFlows.getValue("value[0]"), "value2");
    }

    @Test(description = "Test 03: Update value and verify value updated")
    @Description("This test update a value in the store and verifies the value has been updated")
    public void test03_updateNVerifyValue() {
        ApiFlows.updateValue("main_test2", "value_update2");
        Verifications.verifyResult(ApiFlows.getValue("value[0]"), "value_update2");
    }

    @Test(description = "Test 04: delete value and verify value deleted")
    @Description("This test delete a value from the store and verifies the value has been deleted")
    public void test04_deleteNVerifyValue() {
        ApiFlows.deleteValue("main_test2");
        Verifications.verifyResult(ApiFlows.getValue("value[0]"), "value01");
    }
}
