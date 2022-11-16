package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.atidStore.*;
import pageObjects.experiBank.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    // General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    // Web
    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    // Page objects Initializing - Web
    protected static pageObjects.atidStore.HomePage homePage;
    protected static StorePage storePage;
    protected static AccessibilityMenu accessibilityMenu;
    protected static CartPage cartPage;
    protected static ContactUsPage contactUsPage;
    protected static FixMenu fixMenu;

    // Page objects Initializing - Mobile
    protected static pageObjects.experiBank.HomePage experiHome;
    protected static LoginPage experiLogin;
    protected static MakePaymentPage experiPayment;
    protected static CountryPage country;

    // Page objects Initializing - Electron
    protected static pageObjects.todo.MainPage todoMain;

    // Page objects Initializing - Desktop
    protected static pageObjects.calculator.MainPage calcMain;
}