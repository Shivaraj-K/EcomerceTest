package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import base.TestBase;

public class LoginPage extends BaseClass {

	public WebDriver d;
	public ProductCatalog p;
	public TestBase t;
	public LoginPage l;
	public OrderPage o;
	public LoginPage(WebDriver d)
	{
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}
	

	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement pass;
	@FindBy(id="login")
	WebElement login;
	
//	public LoginPage loginIn() throws IOException
//	{
//		t=new TestBase();
//		d=t.initialize();
//		return l=new LoginPage(d);
//		
//	}
	public ProductCatalog loginApp(String user,String pswd)
	{
		userName.sendKeys(user);
		pass.sendKeys(pswd);
		login.click();
		 p=new  ProductCatalog(d);
		return p;
	}
	
	public boolean clickOrder(String name)
	{
		order();
		o=new OrderPage(d);
		return o.orderProducts(name);
	}
	
}
