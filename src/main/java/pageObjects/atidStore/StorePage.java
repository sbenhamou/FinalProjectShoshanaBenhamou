package pageObjects.atidStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class StorePage {

    @FindBy(how = How.ID, using = "wc-block-search__input-1")
    public WebElement txt_search;

    @FindBy(how = How.CLASS_NAME, using = "wc-block-product-search__button")
    public WebElement btn_search;

    @FindBy(how = How.CLASS_NAME, using = "orderby")
    public WebElement list_shopOrder;

    @FindBy(how = How.XPATH, using = "//button[text()='Add to cart']")
    public WebElement btn_addToCart;

    @FindBy(how = How.CLASS_NAME, using = "woocommerce-product-gallery__trigger")
    public WebElement item_loop;

    @FindBy(how = How.XPATH,using = "//p[@class='woocommerce-result-count']")
    public WebElement txt_searchResult;

    @FindBy(how = How.XPATH,using = "//ul[@class='products columns-4']/li")
    public List<WebElement> list_product;

    @FindBy(how = How.CSS,using = ".ast-cart-menu-wrap")
    public WebElement btn_suitcase;

    @FindBy(how = How.XPATH,using = "//a[@class='button wc-forward']")
    public WebElement btn_hoverAddCart;

    @FindBy(how = How.CLASS_NAME, using = "woocommerce-loop-product__title")
    public List<WebElement> list_titleProduct;



}
