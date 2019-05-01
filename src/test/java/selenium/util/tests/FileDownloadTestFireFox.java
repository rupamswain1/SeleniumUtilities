package selenium.util.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.util.UtilClass.FileDownloadFireFox;
import selenium.util.UtilClass.fileDownloadChrome;

public class FileDownloadTestFireFox {

	@BeforeMethod
	public void init()
	{
		FileDownloadFireFox.MakeFolder();
		FileDownloadFireFox.initialize();
		new FileDownloadFireFox();
		
		
	}
	
	@Test
	public void downloadTest() throws InterruptedException
	{
		FileDownloadFireFox.download();
	}
	
	@AfterMethod
	public void teardown()
	{
		FileDownloadFireFox.deleteFileFolder();
		FileDownloadFireFox.quit();
	}

}
