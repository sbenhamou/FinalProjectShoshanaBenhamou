package pageObjects.experiBank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class HomePage {

    private AppiumDriver mobileDriver;

    public HomePage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator( mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id="makePaymentButton")
    public AndroidElement btn_payment;

    @AndroidFindBy(id="mortageRequestButton")
    public AndroidElement btn_mortgageReq;

    @AndroidFindBy(id="expenseReportButton")
    public AndroidElement btn_expenseReport;

    @AndroidFindBy(id="logoutButton")
    public AndroidElement btn_logout;

    @AndroidFindBy(xpath="//*[contains(@text,'Your balance is:')]")
    public AndroidElement txt_balance;
}
