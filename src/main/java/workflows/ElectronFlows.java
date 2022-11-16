package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps{

    @Step("Business Flow: Add New Tasks to the List")
    public static void  addNewTask(String taskName){
        UIActions.updateText(todoMain.txt_create, taskName);
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);
    }

    @Step("Count and Return Number of Tasks in List")
    public static int getNumberOfTasks(){
        return todoMain.list_task.size();
    }

    @Step("Empty List from Tasks")
    public static void emptyList(){
        for (int i = 0; i < getNumberOfTasks(); i++) {
             UIActions.mouseHover(todoMain.btn_delete);
             Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        }
    }

    @Step("Business Flow: Add Color Task to the List")
    public static void addColorTask(String taskName, int num){
        UIActions.updateText(todoMain.txt_create, taskName);
        UIActions.click(todoMain.btn_down);
        UIActions.click(todoMain.btn_colors.get(num));
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);
    }

    @Step("Business Flow: Mark completed Task in the List")
    public static void markCompletedTask(int num){
        UIActions.mouseHover(todoMain.checkbox_completed.get(num));
    }

    @Step("Business Flow: Filter Color Task in the List")
    public static void filterColorTask(int num){
        UIActions.click(todoMain.btn_left);
        UIActions.click(todoMain.btn_colors.get(num));
    }

}
