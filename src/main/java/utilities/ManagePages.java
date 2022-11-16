package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.atidStore.*;

public class ManagePages extends Base {
    /*
    ########################################################################################
    Method Name: initAtidStore
    Method Description: This Method initializes the object pages of the Atid store Web Application
    Method Parameters: no parameter
    Method Return: no value
    ########################################################################################
    */
    public static void initAtidStore() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        storePage = PageFactory.initElements(driver, StorePage.class);
        accessibilityMenu = PageFactory.initElements(driver, AccessibilityMenu.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        contactUsPage = PageFactory.initElements(driver,ContactUsPage.class);
        fixMenu = PageFactory.initElements(driver, FixMenu.class);
    }

    /*
    ######################################################################################################
    Method Name: initExperiBank
    Method Description: This Method initializes the object pages of the ExperiBank mobile application
    Method Parameters: no parameter
    Method Return: no value
    ######################################################################################################
    */
    public static void initExperiBank(){
        experiHome = new pageObjects.experiBank.HomePage(mobileDriver);
        experiLogin = new pageObjects.experiBank.LoginPage(mobileDriver);
        experiPayment = new pageObjects.experiBank.MakePaymentPage(mobileDriver);
        country = new pageObjects.experiBank.CountryPage(mobileDriver);
    }

    /*
    ######################################################################################################
    Method Name: initToDo
    Method Description: This Method initializes the object page of the ToDOlist electron application
    Method Parameters: no parameter
    Method Return: no value
    ######################################################################################################
    */
    public static void initToDo(){
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    /*
    ######################################################################################################
    Method Name: initCalculator
    Method Description: This Method initializes the object page of the Calculator desktop application
    Method Parameters: no parameter
    Method Return: no value
    ######################################################################################################
    */
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
