package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ShopPage;
import utils.BaseTest;
import utils.ScreenShots;

public class TemaCurs34 extends BaseTest{
	

	@Parameters({"user","pass"})
	@Test(priority=1)
	public void loginTest(String username,String password){
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(username, password);
		assertTrue(app.checkElementIsDisplayed(app.myAccount.usernameGreetings));
		
		app.click(app.menu.searchInput);
		app.sendKeys(app.menu.searchInput, "Pretzels");
		Actions action =  new Actions(driver);
		action.
			moveToElement(app.menu.searchInput).
			sendKeys(app.menu.searchInput, Keys.ENTER).
			pause(Duration.ofSeconds(2)).
			perform();		

		app.click(app.shopPage.addToCart);
		System.out.println(app.shopPage.itemAddedMessage.getText().toString());
		assertTrue((app.shopPage.itemAddedMessage).getText().contains("“Rold Gold Tiny Twists Pretzels” has been added to your cart."));
		
		app.click(app.shopPage.viewCart);
		app.click(app.shopPage.addQuantity);
		System.out.println(app.shopPage.total.getText().toString());
	//	assertTrue((app.shopPage.total).getText().equals("$5.98"));
		
		app.click(app.shopPage.checkout);
		app.click(app.shopPage.acceptTerms);
		app.click(app.shopPage.placeOrder);
		assertTrue((app.shopPage.thankYouMessage).getText().equals("Thank you. Your order has been received."));
	}
}