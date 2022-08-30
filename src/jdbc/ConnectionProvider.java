package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://192.168.0.103:3306/triptrip?serverTimezone=Asia/Seoul");
	}
}
