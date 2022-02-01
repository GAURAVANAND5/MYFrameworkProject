package com.crm.comcast.orgTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest {
	
	@Test
	public void projectUnitT() throws SQLException
	{
		String ProjeectName="AXIS BANK";
		Connection con=null;
		try {
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement stmt = con.createStatement();
			String query="select * from project";
			ResultSet result = stmt.executeQuery(query);
			boolean flag=false;
			while(result.next())
			{
				String actProjectName = result.getString(4);
				if(actProjectName.equals(ProjeectName))
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			con.close();
			System.out.println("===================bd connection closed=========");
		}
	}

}
