package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class CheckoutPage extends BaseClass {

	public WebDriver d;
	public CheckoutPage(WebDriver d)
	{
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(css="input[placeholder$='Select Country']")
	WebElement country;
	
	@FindBy(css="button.ta-item")
	List<WebElement> l;
	
	@FindBy(css="a.btnn")
	WebElement click;
	public void selectCountry(String name)
	{
		Actions a=new Actions(d);
		a.moveToElement(country).click().sendKeys(name).perform();
		
		for(WebElement e:l)
		{
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("india"))
			{
				System.out.println(e.getText()+"===============");
				e.click();
				break;
			}
		}
	}
	
	public void sub()
	{
		visibleElement(click);
		click.click();
	}
}
//Actions a=new Actions(d);
//a.moveToElement(d.findElement(By.cssSelector("input[placeholder$='Select Country']"))).click().sendKeys("ind").perform();
//List<WebElement> country=d.findElements(By.cssSelector("button.ta-item"));
//for(WebElement e:country)
//{
//	System.out.println(e.getText());
//	if(e.getText().equalsIgnoreCase("india"))
//	{
//		System.out.println(e.getText()+"===============");
//		e.click();
//		break;
//	}
//}
//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btnn")));
//d.findElement(By.cssSelector("a.btnn")).click();