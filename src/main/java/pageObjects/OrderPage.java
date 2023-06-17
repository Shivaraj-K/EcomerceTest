package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class OrderPage extends BaseClass {

	public WebDriver d;
	public OrderPage(WebDriver d)
	{
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	List<WebElement> l;
	
	public List<WebElement> displayProducts()
	{
		allVisible(l);
		return l;
	}
	public boolean orderProducts(String name)
	{
	return 	displayProducts().stream().anyMatch(p -> p.getText().equalsIgnoreCase(name.toLowerCase()));
	}
}
