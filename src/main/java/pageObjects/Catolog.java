package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class Catolog extends BaseClass{

	public WebDriver d;
	public CheckoutPage c;
	public Catolog(WebDriver d)
	{
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(css="h3")
	List<WebElement> l;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement s;
	
	public List<WebElement> getProducts()
	{
		allVisible(l);
		return l;
	}
	
	public boolean getProduct(String name)
	
	{
		return getProducts().stream().anyMatch(p -> p.getText().equalsIgnoreCase(name.toLowerCase()));
	}
	
	public CheckoutPage sub()
	{
		
		s.click();
		return c=new CheckoutPage(d);
	}
}

//w.until(ExpectedConditions.visibilityOfAllElements(d.findElements(By.cssSelector("h3"))));
//List<WebElement> list=d.findElements(By.cssSelector("h3"));
//Boolean b=list.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name.toLowerCase()));