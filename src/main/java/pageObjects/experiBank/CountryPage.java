package pageObjects.experiBank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import java.time.Duration;

public class CountryPage {
    private AppiumDriver mobileDriver;

    public CountryPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator( mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id="rowTextView")
    public List<AndroidElement> list_country;
}
