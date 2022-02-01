package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibaray.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.HomePage;

public class SampleRetry  extends BaseAnnotationClass{
	
	@Test(retryAnalyzer=com.crm.GenericLibaray.RetryImpclass.class)
	
	public void contactTest() 
	{
		HomePage hp=new HomePage(driver);
		hp.getContactLnk().click();
		Assert.assertEquals("A", "B");
	}

}
