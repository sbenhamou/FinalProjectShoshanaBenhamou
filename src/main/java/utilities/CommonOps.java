package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.DesktopFlows;
import workflows.ElectronFlows;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

    /*
    #########################################################################
    Method Name: getData
    Method Description: This Method get the data from xml configuration file
    Method Parameters: String
    Method Return: String
    #########################################################################
    */
    public static String getData (String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e) {
            System.out.println("Error reading XML file: " + e);
        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    /*
    ############################################################################################################
    Method Name: initBrowser
    Method Description: This Method initializes the web driver according to the type of browser chosen for testing
    Method Parameters: String
    Method Return: no value return
    ############################################################################################################
    */
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
//        else if (browserType.equalsIgnoreCase("ie"))
//            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initAtidStore();
        action = new Actions(driver);
    }

    /*
    #########################################################################
    Method Name: initChromeDriver
    Method Description: This Method initializes the driver for Chrome Browser
    Method Parameters: no parameters
    Method Return: WebDriver
    #########################################################################
    */
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /*
    #########################################################################
    Method Name: initChromeDriver
    Method Description: This Method initializes the driver for Firefox Browser
    Method Parameters: no parameters
    Method Return: WebDriver
    #########################################################################
    */
    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

//Comment : Not relevant since 15/06/2022
//    public static WebDriver initIEDriver(){
//        WebDriverManager.iedriver().setup();
//        WebDriver driver = new InternetExplorerDriver();
//        return driver;
//    }

    /*
    #############################################################
    Method Name: initMobile
    Method Description: This Method initializes the mobile driver
    Method Parameters: no parameter
    Method Return: no value return
    #############################################################
    */
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);;
        }
        ManagePages.initExperiBank();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        action = new Actions(mobileDriver);
    }
    /*
   #############################################################
   Method Name: initApi
   Method Description: This Method initializes the api request
   Method Parameters: no parameter
   Method Return: no value return
   #############################################################
   */
    public static void initApi(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
    }
    /*
   #############################################################
   Method Name: initElectron
   Method Description: This Method initializes the electron driver
   Method Parameters: no parameter
   Method Return: no value return
   #############################################################
   */
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
//        driver = new ChromeDriver(dc); Deprecated API Usage
        driver = new ChromeDriver(opt);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    /*
    #############################################################
    Method Name: initDesktop
    Method Description: This Method initializes the desktop driver
    Method Parameters: no parameter
    Method Return: no value return
    #############################################################
    */
    public static void initDesktop(){
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium Server, see details: " + e);
        }

        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    /*
    #############################################################
    Method Name: startSession
    Method Description: This Method starts the session
    Method Parameters: String
    Method Return: no value return
    #############################################################
    */
    public void startSession(String PlatformName){
        platform = PlatformName;
        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initApi();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"),getData("DBPassWord"));
    }

    @AfterClass
    /*
    #############################################################
    Method Name: closeSession
    Method Description: This Method closes the session
    Method Parameters: no parameter
    Method Return: no value return
    #############################################################
    */
    public void closeSession(){
        ManageDB.closeConnection();
        if(!platform.equalsIgnoreCase("api")){
            if(!platform.equalsIgnoreCase("mobile"))
                {driver.quit();}
            else{
                mobileDriver.quit();}
        }
    }

    @BeforeMethod
    /*
    #############################################################
    Method Name: beforeMethod
    Method Description: This Method runs before each method
    Method Parameters: String
    Method Return: no value return
    #############################################################
    */
    public void beforeMethod(Method method){
        if(!platform.equalsIgnoreCase("api")){
            try{
                MonteScreenRecorder.startRecord(method.getName());}
            catch (Exception e)
            {e.printStackTrace();}
        }

    }

    @AfterMethod
   /*
   #############################################################
   Method Name: afterMethod
   Method Description: This Method runs after each method
   Method Parameters: String
   Method Return: no value return
   #############################################################
   */
    public void afterMethod(){
        if(platform.equalsIgnoreCase("web"))
            {driver.get(getData("url"));}
        else if(platform.equalsIgnoreCase("electron")) {
            ElectronFlows.emptyList();}
        else if(platform.equalsIgnoreCase("desktop")) {
            DesktopFlows.emptyField();
        }
    }

}
