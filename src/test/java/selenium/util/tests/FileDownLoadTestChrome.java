package selenium.util.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.util.UtilClass.fileDownloadChrome;

public class FileDownLoadTestChrome 
{
	@BeforeMethod
	public void init()
	{
		fileDownloadChrome.makeFolder();
		fileDownloadChrome.initialize();
		new fileDownloadChrome();
		
		
	}
	
	@Test
	public void downloadTest() throws InterruptedException
	{
		fileDownloadChrome.download();
	}
	
	@AfterMethod
	public void teardown()
	{
		fileDownloadChrome.deleteFileFolder();
		fileDownloadChrome.quit();
	}
}
