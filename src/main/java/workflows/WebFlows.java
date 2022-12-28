package workflows;

import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Submit message on Contact us")
    public static void submitMessage(String name, String email, String message)
    {
        UIActions.updateText(contactUsPage.txt_name, name);
        UIActions.updateText(contactUsPage.txt_email, email);
        UIActions.updateText(contactUsPage.txt_mess, message);
        UIActions.click(contactUsPage.but_submit);
    }

    @Step("Business Flow: Submit message on Contact us with DB data")
    public static void submitMessageWithDB()
    {
        List<String> cred = DBActions.getCredentials(getData("query"));
        UIActions.updateText(contactUsPage.txt_name, cred.get(0));
        UIActions.updateText(contactUsPage.txt_email, cred.get(1));
        UIActions.updateText(contactUsPage.txt_mess, cred.get(2));
        UIActions.click(contactUsPage.but_submit);
    }

    @Step("Business Flow: Search products in the store")
    public static void getProductList(String product)
    {
        UIActions.click(fixMenu.menu_store);
        UIActions.updateText(storePage.txt_search,product);
        UIActions.click(storePage.btn_search);
    }

    @Step("Business Flow: Choose item in the store")
    public static void chooseItem(String product, int x)
    {
        getProductList(product);
        UIActions.click(storePage.list_product.get(x));
    }

    @Step("Business Flow: Add product to the cart")
    public static void addProductToCart(String product)
    {
        getProductList(product);
        UIActions.click(storePage.list_product.get(0));
        UIActions.click(storePage.btn_addToCart);
    }

    @Step("Business Flow: Filter Items on Store")
    public static void filterItem(String product)
    {
        getProductList(product);
        UIActions.updateDropDown(storePage.list_shopOrder,"Sort by price: low to high");
    }

    @Step("Business Flow: Remote Item from cart")
    public static void remoteItem()
    {
        UIActions.mouseHover(storePage.btn_suitcase,storePage.btn_hoverAddCart);
        UIActions.click(cartPage.elem_remove);
    }


}
