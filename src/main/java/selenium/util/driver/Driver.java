package selenium.util.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Driver 
{
	public static WebDriver driver=null;
	
	//This class will open google chrome, maximise it and open website
	private Driver()
	{
		
		try
		{
			
			System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialize()
	{
		new Driver();
	}
	

	public static void openUrl(String url)
	{
		driver.get(url);
	}
	
	public static void quit()
	{
		driver.quit();
	}
	
}
