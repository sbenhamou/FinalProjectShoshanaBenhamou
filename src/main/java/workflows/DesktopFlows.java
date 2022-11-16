package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Clear Results Field")
    public static void emptyField() {
        UIActions.click(calcMain.btn_clear);
    }

    @Step("Calculate Addition - 5 + 9")
    public static void calculateAddition(){
        UIActions.click(calcMain.btn_five);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_nine);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Calculate Substraction - 86 - 4")
    public static void calculateSubstraction(){
        UIActions.click(calcMain.btn_eight);
        UIActions.click(calcMain.btn_six);
        UIActions.click(calcMain.btn_minus);
        UIActions.click(calcMain.btn_four);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Calculate Multiplication - 2 * 7")
    public static void calculateMultiplication(){
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_multi);
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Calculate Division - 12 / 3")
    public static void calculateDivision(){
        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_divi);
        UIActions.click(calcMain.btn_three);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Calculate Reciprocal")
    public static void reciprocal(){
        UIActions.click(calcMain.btn_reci);
    }
}
