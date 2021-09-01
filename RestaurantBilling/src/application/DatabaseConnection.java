package application;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection databaseLink;
	
	public Connection getConnection()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			@SuppressWarnings("unused")
			final String JdbcDriver="com.mysql.cj.jdbc.Driver";
			
			
			String databaseUser="root";
			String databasePassword = "mahesh123";
			String url="jdbc:mysql://127.0.0.1:3306/pocbase";
			
			databaseLink= DriverManager.getConnection(url,databaseUser, databasePassword);
			System.out.println("Connection Estabilished\n");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return databaseLink;
	}
}
