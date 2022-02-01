package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibaray.BaseAnnotationClass;

public class SimScreenShot  extends BaseAnnotationClass{
	
	@Test
	public void verifyHome()
	{
		System.out.println("============test start=========");
		
		Assert.assertEquals("A", "B");
	}
	
	

}
