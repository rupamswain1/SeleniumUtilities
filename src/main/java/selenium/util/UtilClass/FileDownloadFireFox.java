package selenium.util.UtilClass;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadFireFox {
	
	static WebDriver driver;
	static String link;
	static File folder;
	static String website="https://the-internet.herokuapp.com/download";
	static String fileext=".txt";
	


@FindBy(xpath="//a")
static List<WebElement> files;

public FileDownloadFireFox() {
	PageFactory.initElements(driver, this);
}

public static void initialize()
{
	System.setProperty("webdriver.gecko.driver","F:\\Selenium\\geckodriver.exe");
	
	FirefoxProfile profile=new FirefoxProfile();
	profile.setPreference("browser.download.dir",folder.getAbsolutePath());
	profile.setPreference("browser.download.folderList", 2);
	
	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
	profile.setPreference("pdfjs.disabled", true);
	FirefoxOptions options=new FirefoxOptions();
	options.setProfile(profile);
	driver=new FirefoxDriver(options);
	driver.manage().window().maximize();
	driver.get(website);
	
	
}

public static void MakeFolder()
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
