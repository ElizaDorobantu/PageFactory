package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ScreenShots;

public class LoginTest extends BaseTest{

	@Parameters({"user","pass"})
	@Test
	public void loginTest(String username,String password) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(username, password);
		assertTrue(app.checkElementIsDisplayed(app.myAccount.usernameGreetings));
		ScreenShots.screenshot(driver); 
		assertTrue(app.myAccount.usernameGreetings.isDisplayed()); 
		//cele 2 linii de mai sus cu assertTrue fac acelasi lucru
	}
	
//testul din PageObjectModel
//public void loginInApp(String user, String pass) {
//		
//		sendKeys(usernameField, user);
//		sendKeys(passwordField, pass);
//		click(loginButton);
//	}
}