package selenium.util.tests;

import org.testng.annotations.Test;

import selenium.util.driver.WebDriverManagerDriver;

public class WebDriverManagerTest 
{
	@Test
	public void chrome()
	{
		WebDriverManagerDriver drive=new WebDriverManagerDriver("chrome");
		drive.openUrl("https://www.flipkart.com/");
		System.out.println(drive.driver.getTitle());
		drive.quit();
	}
	
	@Test
	public void FireFox()
	{
		WebDriverManagerDriver drive=new WebDriverManagerDriver("ff");
		drive.openUrl("https://www.flipkart.com/");
		System.out.println(drive.driver.getTitle());
		drive.quit();
	}
	
	@Test
	public void edge()
	{
		WebDriverManagerDriver drive=new WebDriverManagerDriver("edge");
		drive.openUrl("https://www.flipkart.com/");
		System.out.println(drive.driver.getTitle());
		drive.quit();
	}
	@Test
	public void ie()
	{
		WebDriverManagerDriver drive=new WebDriverManagerDriver("ie");
		drive.openUrl("https://www.flipkart.com/");
		System.out.println(drive.driver.getTitle());
		drive.quit();
	}
	
}
