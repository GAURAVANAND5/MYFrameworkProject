package practice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibaray.BaseAnnotationClass;

public class SimpleScreenShotTest extends BaseAnnotationClass {
	
	@Test
	public void verfiyHomepage(Method mtd) throws IOException
	{
		System.out.println(mtd.getName());
		
		String currentTestName = mtd.getName();
		System.out.println("==============Teststart==========");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshot/"+currentTestName+".png");
		FileUtils.copyFile(srcFile, destfile);
		
		System.out.println("==========test==========");
		
	}
	
	
	

}
