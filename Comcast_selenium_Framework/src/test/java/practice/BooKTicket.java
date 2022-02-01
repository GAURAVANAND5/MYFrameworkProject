package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BooKTicket {
	
	@Test(dataProvider="dataProvider_bookTicketTest")
	
	public void bookTicketTest(String src,String dst) {
		System.out.println("book tickeet from "+src+ "to "+dst);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicketTest()
	{
		Object[][] objArr=new Object[5][2];
		
		objArr[0][0]="Banagalore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Banagalore";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Banagalore";
		objArr[2][1]="Mnagalore";
		
		objArr[3][0]="Banagalore";
		objArr[3][1]="Hyd";
		
		objArr[4][0]="Banagalore";
		objArr[4][1]="Mp";
		return objArr;
		
		
	}

}
