package selenium.util.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDriver
{
	public WebDriver driver=null;
	
	public WebDriverManagerDriver(String browser)
	{
		if(browser.toLowerCase().contains("chrome")||browser.toLowerCase().contains("google"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.toLowerCase().contains("fire")||browser.toLowerCase().contains("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.toLowerCase().contains("edge")||browser.toLowerCase().contains("microsoft"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.toLowerCase().contains("ie")||browser.toLowerCase().contains("explore"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	public void openUrl(String url)
	{
		driver.get(url);
	}
	public void quit()
	{
		driver.quit();
	}
	
}
