package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.BasePage;

//clase utilitare pentru setup

public class BaseTest {
	
	public static WebDriver driver;//instanta de browser
	//static ->obiectul e instantiat inainte de alte instantieri
	public BasePage app;
	
	//pentru a rula am nevoie obligatoriu de o metoda @Test
	
	@Parameters({"appURL"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String appURL) {
		
		//System.setProperty("webdriver.chrome.driver","path//chromedriver.exe");
		//comanda de mai sus e din versiunea 3. Incepand cu 4 nu mai e nevoie de path
		//Boni Garcia webdriver manager a facut o librarie 
		
		driver = new EdgeDriver();
		
		// clasa BaseTest e facuta ca si punct central pt a deschide /inchide browserul dintr-un singur loc
		
		driver.manage().window().maximize();//mareste fereastra de la browser
		
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicit

		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.get(appURL);
		
		app = new BasePage();
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);//bad practice
		driver.close();//inchide doar tabul curent
		//driver.quit();//inchide browserul indiferent cate taburi are deschise
	}

}
