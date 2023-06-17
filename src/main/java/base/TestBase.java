
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import pageObjects.LoginPage;

public class TestBase {

	public WebDriver d;
	public LoginPage l;
	public WebDriver initialize() throws IOException
	{
		Properties p=new Properties();
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\generic.properties");
		p.load(f);

		String bro=p.getProperty("browser");
		String url=p.getProperty("url");
		if(bro.equalsIgnoreCase("chrome"))
		{
			ChromeOptions c=new ChromeOptions();
			c.addArguments("--remote-allow-origins=*");
			d=new ChromeDriver(c);
		}
		else if(bro.equalsIgnoreCase("firefox"))
		{
			d=new FirefoxDriver();
		}
		if(bro.equalsIgnoreCase("edge"))
		{
			EdgeOptions c=new EdgeOptions();
			c.addArguments("--remote-allow-origins=*");
			d=new EdgeDriver(c);
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get(url);
		return d;
	}
	
	@BeforeMethod
	public LoginPage loginIn() throws IOException
	{
		l= new LoginPage(initialize());
		return l;
	}
}
