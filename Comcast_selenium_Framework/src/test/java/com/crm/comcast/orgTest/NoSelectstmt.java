package com.crm.comcast.orgTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.util.SystemOutLogger;

import com.mysql.jdbc.Driver;

public class NoSelectstmt {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		boolean flag=false;
		int  result=0;
		try
		{
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement stmt = con.createStatement();
			String quary="insert into project values('TY_PROJ_008','GAURAV','12/01/2022','AXIS BANK','On Going',6)";
			result=stmt.executeUpdate(quary);
		}
		catch(Throwable e)
		{
			
		}
		finally {
			if(result==1)
			{
				System.out.println("Project inserted successfully");
			}
			else
			{
				System.out.println("Project  is not inserted ");
			}
		}
		con.close();
		System.out.println("===========DB connection closed============");
		
	}

}
