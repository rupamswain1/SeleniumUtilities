package selenium.util.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.util.UtilClass.fileDownload;

public class FileDownLoadTest 
{
	@BeforeMethod
	public void init()
	{
		fileDownload.makeFolder();
		fileDownload.initialize();
		new fileDownload();
		
		
	}
	
	@Test
	public void downloadTest() throws InterruptedException
	{
		fileDownload.download();
	}
	
	@AfterMethod
	public void teardown()
	{
		fileDownload.deleteFileFolder();
		fileDownload.quit();
	}
}
