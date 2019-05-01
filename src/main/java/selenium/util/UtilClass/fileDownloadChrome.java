package selenium.util.UtilClass;



import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class fileDownloadChrome {
	
static String website="https://the-internet.herokuapp.com/download";
static String fileext=".txt";
static File folder;
static WebDriver driver;

@FindBy(xpath="//a")
static List<WebElement> files;

public fileDownloadChrome()
{
	PageFactory.initElements(driver, this);
}

public static void initialize()
{
	System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	Map<String, Object> prefs=new HashMap<String,Object>();
	prefs.put("profile.default_content_settings.popups", 0);
	System.out.println(folder.getAbsolutePath());
	prefs.put("download.default_directory", folder.getAbsolutePath());
	
	options.setExperimentalOption("prefs", prefs);
	DesiredCapabilities capabilities= DesiredCapabilities.chrome();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	driver=new ChromeDriver(capabilities);
	driver.manage().window().maximize();
	driver.get(website);
	
	
}

public static void makeFolder()
{
	folder=new File(UUID.randomUUID().toString());
	folder.mkdir();
}


public static void deleteFileFolder()
{
	FileLoop:
	for(File fil:folder.listFiles())
	{
		fil.delete();
	}
	folder.delete();
}

public static void download() throws InterruptedException
{
	for(WebElement name:files)
	{
		String link=name.getAttribute("href");
		//System.out.println(link.substring(link.length()-4, link.length()));
		if(link.substring(link.length()-4, link.length()).contains(fileext))
		{
			name.click();
			Thread.sleep(5000);
		}
		
	}
	File listofFiles[]=folder.listFiles();
	System.out.println("Files downloaded: "+listofFiles.length);
	for(File file:listofFiles)
	{
		System.out.println(file.getName()+" length is "+file.length());
	}
}

public static void quit()
{
	driver.quit();
}

}
