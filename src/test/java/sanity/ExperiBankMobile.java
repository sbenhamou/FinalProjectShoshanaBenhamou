package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class ExperiBankMobile extends CommonOps {

    @Test(description ="Test01 - Verify Login Success")
    @Description("This test verifies that the login success")
    public void test01_verifyLogin(){
        MobileFlows.loginExperiBank("company","company");
        MobileActions.visibilityOfMobileElement(experiHome.btn_logout);
    }

    @Test(description ="Test02 - Verify amount balance when payment success (select country)")
    @Description("This test verifies amount balance when payment success (select ountry)")
    public void test02_verifyBalanceAmountPaymentSuccessed(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        String firstAmount = MobileFlows.getBalanceAmount();
        MobileFlows.makePaymentSelectCountry("0102030405","Shoshana","1",2);
        Verifications.verifyResult(Integer.toString(Integer.parseInt(firstAmount)-1), MobileFlows.getBalanceAmount());
    }

    @Test(description ="Test03 - Verify amount balance when payment cancelled (fill country)")
    @Description("This test verifies amount balance when payment cancelled (fill country)")
    public void test03_verifyBalanceAmountPaymentCanceled(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        String firstAmount = MobileFlows.getBalanceAmount();
        MobileFlows.cancelPaymentFillCountry("0102030405","Shoshana","1","Italy");
        Verifications.verifyResult(firstAmount, MobileFlows.getBalanceAmount());
    }
}
