package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Functions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;
import java.util.concurrent.TimeUnit;


@Listeners(utilities.Listeners.class)
public class AtidStoreWeb extends CommonOps {

    @Test(description ="Test01 - Verify Accessibility of Shop Now button")
    @Description("This test verifies the Shop Now button")
    public void test01_verifyShopNowButton(){
        UIActions.click(homePage.btn_shopNow);
        Verifications.verifyUrlPage("https://atid.store/store/");
    }

    @Test(description="Test02 - Verify number's items after filter")
    @Description("This test verifies number of the items after setting filter")
    public void test02_verifyArticleNumber()
    {
        WebFlows.filterItem("Bracelet");
        Verifications.verifyResult(UIActions.getTextField(storePage.txt_searchResult).split(" ")[2],"3");
    }

    @Test(description="Test03 - Verify number of items for a product")
    @Description("This test verifies the amount of items for the same product")
    public void test03_verifyArticleNumber()
    {
        WebFlows.getProductList("Tshirt");
        Verifications.verifyResult(Integer.toString(storePage.list_product.size()),"7");
    }

    @Test(description="Test04 - Verify update to cart")
    @Description("This test verifies the amount of products in cart")
    public void test04_verifyUpdateCart()
    {
        WebFlows.addProductToCart("Shoes");
        Verifications.verifyResult(UIActions.getTextField(storePage.btn_suitcase),"1");
        WebFlows.remoteItem();
    }

    // Type of test using data provided by config.xml
    @Test(description="Test05 - Verify submit message on Contact Us page")
    @Description("This test verifies the possibility to send message on Contact Us Page")
    public void test05_verifyMessageSent() {
        UIActions.click(fixMenu.menu_contact);
        WebFlows.submitMessage(getData("ContactName"),getData("ContactEmail"), getData("ContactMessage"));
        Verifications.visibilityOfElement(contactUsPage.mes_contactConfirmation);
    }

    // Type of Test using dataprovider
    @Test(description="Test06 - Verify error message is shown when mandatory field missed (using DDT)", dataProvider = "data-provider-atidstore", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verifies if error message is shown when mandatory field missed")
    public void test06_verifyMessageSent(String name, String email, String message, String isTrue) {
        UIActions.click(fixMenu.menu_contact);
        WebFlows.submitMessage(name,email,message);
        Verifications.verifyResult(Functions.isErrorMessage(), isTrue);
    }

    // Kind of Tests using softassert
    @Test(description="Test07 - Verify valid result of research products (using softassert)")
    @Description("This test verifies the valid result of product's research on the store (using softassert)")
    public void test07_verifyResultResearch()
    {
        WebFlows.getProductList("Tshirt");
        Verifications.verifyTitleContains(storePage.list_titleProduct,"Tshirt");
    }

    @Test(description ="Test08 - Verify Accesibility Tools Elements")
    @Description("This test verifies all the accessibility tools elements (using soft assertion)")
    public void test08_verifyMenus(){
        UIActions.click(fixMenu.btn_accessibility);
        Verifications.visibilityOfElements(accessibilityMenu.list_accessibilities);
    }

    // Kind of visual Tests using Sikuli tool
    @Test(description = "Test09 - Verify Avatar Icone")
    @Description("This test verifies the avatar image on Home Page (using Sikuli tool)")
    public void test09_verifyAvatarIcon(){
        Verifications.visualElement("AtidStoreAvatar");
    }

    @Test(description = "Test10 - Verify Item's photo")
    @Description("This test verifies the photo of an item (using Sikuli tool)")
    public void test10_verifyItemPhoto(){
        WebFlows.chooseItem("Bracelet", 1);
        UIActions.click(storePage.item_loop);
        Verifications.visualElement("Bracelet");
    }
}
