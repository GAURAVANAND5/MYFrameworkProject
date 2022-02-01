package practice;

import org.testng.annotations.Test;

public class CreateCustomerDependsTest {
	
	@Test
	public void createCustomerTest() {
		System.out.println("Execute HDFC createCustomerTest");
	}
	@Test(dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest() {
		System.out.println("Execute  HDFC modifyCustomerTest");
	}
	
	@Test(dependsOnMethods="modifyCustomerTest")
	public void deleteCustomerTest() {
		System.out.println("Execute HDFC deleteCustomerTest");
	}


}
