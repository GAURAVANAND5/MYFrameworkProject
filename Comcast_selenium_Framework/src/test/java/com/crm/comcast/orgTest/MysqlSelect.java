package com.crm.comcast.orgTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MysqlSelect {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement stmt = con.createStatement();
			String query="select * from project";
			ResultSet resultset = stmt.executeQuery(query);
			while(resultset.next())
			{
				System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
			}
		}
		catch(Throwable e)
		{
			
		}
		finally
		{
		 con.close();	
		 System.out.println("====================close db connection=============");
		}
	}

}
