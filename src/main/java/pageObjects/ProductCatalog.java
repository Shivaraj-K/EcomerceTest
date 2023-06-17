package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class ProductCatalog  extends BaseClass{

	public WebDriver d;
	public Catolog cat;
	public ProductCatalog(WebDriver d)
	{
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> l;
	
	By pro=By.cssSelector("b"); 
	By btn=By.cssSelector(".btn:last-child");
	
	public List<WebElement> getAllProducts()
	{
		allVisible(l);
		return l;
	}
	
	public WebElement getProduct(String name)
	{
		return getAllProducts().stream().filter(p -> p.findElement(pro).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	public Catolog  addcart(String name)
	{
		getProduct( name).findElement(btn).click();
		cart();
		return cat=new Catolog(d);
	}
}
