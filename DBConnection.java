package chap06;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String CONNECT_URL = "jdbc:mysql://localhost:3306/sample_db";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	private Connection con;

	public Connection getConnect() throws Exception {
		if (con == null) {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(CONNECT_URL, USER_NAME, PASSWORD);
		}

		return con;
	}

	public void closeConnect() throws Exception {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
