package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {
    @Test(description ="Test01 - Verify page empty")
    @Description("This test verifies that the page is empty from tasks")
    public void test01_verifyNoTask() {
        Verifications.verifyContainsPage("There's no task");
    }
    @Test(description ="Test02 - Add and verify new task")
    @Description("This test adds a new task and verifies it")
    public void test02_addNVerifyTask() {
        ElectronFlows.addNewTask("Finish my Final Project");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }

    @Test(description ="Test03 - Add and verify several tasks")
    @Description("This test adds a tasks and verifies it")
    public void test03_addNVerifyTasks() {
        ElectronFlows.addNewTask("Finish my Final Project1");
        ElectronFlows.addNewTask("Finish my Final Project2");
        ElectronFlows.addNewTask("Finish my Final Project6");
        ElectronFlows.addNewTask("Finish my Final Project4");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 4);
    }

    @Test(description ="Test04 - verify color filter tasks")
    @Description("This test verifies the filter task by color")
    public void test04_verifyColorFilterTasks() {
        ElectronFlows.addNewTask("Finish my Final Project1");
        ElectronFlows.addNewTask("Finish my Final Project2");
        ElectronFlows.addColorTask ("Finish my Final Project6", 4);
        ElectronFlows.filterColorTask(5);
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }
}
