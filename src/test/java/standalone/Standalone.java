package standalone;

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

public class Standalone {

	@Test
	public void test()
	{
		String name="IPHONE 13 PRO";
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		WebDriver d=new ChromeDriver(c);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(30));
		d.get("https://rahulshettyacademy.com/client/");
		d.findElement(By.id("userEmail")).sendKeys("rahulshetty@gmail.com");
		d.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		d.findElement(By.id("login")).click();
		
		List<WebElement> l=d.findElements(By.cssSelector(".mb-3"));
		WebElement w1=l.stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
		w1.findElement(By.cssSelector(".btn:last-child")).click();
		
		w.until(ExpectedConditions.invisibilityOf(d.findElement(By.cssSelector(".ng-tns-c31-1"))));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink='/dashboard/cart']")));
		d.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		w.until(ExpectedConditions.visibilityOfAllElements(d.findElements(By.cssSelector("h3"))));
		List<WebElement> list=d.findElements(By.cssSelector("h3"));
		Boolean b=list.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name.toLowerCase()));
		
		Assert.assertTrue(b);
		
		d.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.cssSelector("input[placeholder$='Select Country']"))).click().sendKeys("ind").perform();
		List<WebElement> country=d.findElements(By.cssSelector("button.ta-item"));
		for(WebElement e:country)
		{
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("india"))
			{
				System.out.println(e.getText()+"===============");
				e.click();
				break;
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btnn")));
		d.findElement(By.cssSelector("a.btnn")).click();
		
		
		
	}
}
