package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers{

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[name='add-to-cart']")
	public WebElement addToCart;
	
	@FindBy(xpath = "//div[@class = 'woocommerce-notices-wrapper']")
	public WebElement itemAddedMessage;
	
	@FindBy(css = "i[class='klbth-icon-shopping-bag']")
	public WebElement viewCart;
	
	@FindBy(css = "i[class='klbth-icon-plus']")
	public WebElement addQuantity;
	
	@FindBy(xpath = "(//div[contains(@class,'cart_totals')]//span[@class='woocommerce-Price-amount amount'])[2]")
	public WebElement total;
	
	@FindBy(css="a[class='checkout-button button alt wc-forward']")
	public WebElement checkout;
	
	@FindBy(css="input[id='terms']")
	public WebElement acceptTerms;
	
	@FindBy(css="button[id='place_order']")
	public WebElement placeOrder;
}
