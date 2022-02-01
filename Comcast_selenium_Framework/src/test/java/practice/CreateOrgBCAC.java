package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrgBCAC {
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("=============lunch the Browser");
	}
	
	@BeforeMethod
	public void configBM()
	{
		
		System.out.println("==login==");
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
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("==logout==");
		
		
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("=============Close the Browser");
	}


}
