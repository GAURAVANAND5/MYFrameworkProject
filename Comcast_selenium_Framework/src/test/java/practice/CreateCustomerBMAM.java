package practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCustomerBMAM {
	
	@BeforeMethod
	public void ConfigBM()
	{
		System.out.println("=============lunch the Browser");
		System.out.println("==login==");
	}
	
	@AfterMethod
	public void ConfigAM()
	{
		System.out.println("==logout==");
		System.out.println("=============Close the Browser");
		
	}
	
	@Test
	public void createOrgTest()
	{
		System.out.println("navigate to org Module");
		System.out.println("create org ");
		System.out.println("verify");
	}
	
	@Test
	public void createOrgwithindustriesTest()
	{
		System.out.println("navigate to org Module");
		System.out.println("create org with industries");
		System.out.println("verify");
	}
	
	@Test
	public void createOrgwithRatingTest()
	{
		System.out.println("navigate to org Module");
		System.out.println("create org with Rating");
		System.out.println("verify");
	}

}
