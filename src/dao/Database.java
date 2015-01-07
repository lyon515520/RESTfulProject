package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public Connection Get_Connection() throws Exception
	{
		try
		{
			String DBURL="jdbc:mysql://localhost:3306/tweetsdb";
			String DBLOGIN="root";
			String DBPASSWORD="";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(DBURL, DBLOGIN,DBPASSWORD);
			return connection;
		}
		catch (ClassNotFoundException e)
		{
			throw e;
		} 
		catch (SQLException e)
		{
			throw e;	
		}
		catch (Exception e)
		{
			throw e;	
		}
	}

}