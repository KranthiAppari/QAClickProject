package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	
	Connection connection;
	public Connection SQLConnection() throws SQLException {
		
	String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QAClickAcademyDB;user=sa123;password=sa123";
	connection = DriverManager.getConnection(connectionUrl);
	
	return connection;
	}
}
