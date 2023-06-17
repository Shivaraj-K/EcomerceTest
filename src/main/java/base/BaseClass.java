package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver  d;
	public WebDriverWait w;
	public BaseClass(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
		w=new WebDriverWait(d,Duration.ofSeconds(30));
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement btn;
	
	@FindBy(css=".ng-tns-c31-1")
	WebElement in;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement order;
	
	public void order()
	{
		order.click();
	}
	public void cart()
	{
		invis(in);
		visibleElement(btn);
		btn.click();
	}
	
	public void visibleElement(WebElement ele)
	{
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void visible(By ele)
	{
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
	}
	
	public void invis(WebElement ele)
	{
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void allVisible(List<WebElement> ele)
	{
		w.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
}
