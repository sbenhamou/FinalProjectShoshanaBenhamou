package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Login to ExperiBank")
    public static void loginExperiBank(String username, String password){
        MobileActions.updateText(experiLogin.txt_username, username);
        MobileActions.updateText(experiLogin.txt_password, password);
        MobileActions.tap(experiLogin.btn_login);
    }

    @Step("Business Flow: Make a payment - Select Country")
    public static void makePaymentSelectCountry(String phone, String name, String amount, int num) {
        MobileActions.tap(experiHome.btn_payment);
        MobileActions.updateText(experiPayment.txt_phone, phone);
        MobileActions.updateText(experiPayment.txt_name, name);
        MobileActions.updateText(experiPayment.txt_amount, amount);
        MobileActions.tap(experiPayment.btn_country);
        MobileActions.tap(country.list_country.get(num));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        MobileActions.tap(experiPayment.btn_payment);
        MobileActions.tap(experiPayment.btn_confirmPayment);
        }

    @Step("Business Flow: Make a payment - Fill Country")
    public static void cancelPaymentFillCountry(String phone, String name, String amount, String country) {
        MobileActions.tap(experiHome.btn_payment);
        MobileActions.updateText(experiPayment.txt_phone, phone);
        MobileActions.updateText(experiPayment.txt_name, name);
        MobileActions.updateText(experiPayment.txt_amount, amount);
        MobileActions.updateText(experiPayment.txt_country, country);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        MobileActions.tap(experiPayment.btn_payment);
        MobileActions.tap(experiPayment.btn_cancelPayment);
        MobileActions.tap(experiPayment.btn_cancel);
    }

    @Step("Business Flow: Get the balance amount")
    public static String getBalanceAmount(){
        String dollar = experiHome.txt_balance.getText();
        String amountText = dollar.split(" ")[3].split("[.]")[0];
        return amountText;
    }

}
