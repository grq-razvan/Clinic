package persistance.layer.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/hospital", "grq", "qwerty789");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return connection;
	}
}
