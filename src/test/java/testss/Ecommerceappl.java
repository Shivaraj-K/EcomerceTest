package testss;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.Catolog;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductCatalog;

public class Ecommerceappl extends TestBase {

	String name="IPHONE 13 PRO";
	@Test
	public void demo() throws IOException
	{
		
		//LoginPage l=loginIn();
		ProductCatalog pp=l.loginApp("rahulshetty@gmail.com", "Iamking@000");
		Catolog cat=pp.addcart(name);	 
		boolean b=cat.getProduct(name);
		Assert.assertTrue(b);
		CheckoutPage check=cat.sub();
		check.selectCountry("ind");
		check.sub();
	}
	
	@Test(dependsOnMethods="demo")
	public void ceckorders()
	{
		ProductCatalog pp=l.loginApp("rahulshetty@gmail.com", "Iamking@000");
		Assert.assertTrue(l.clickOrder(name));
	}
}
