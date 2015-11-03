package com.rinjin.util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DbUtil {

	public static Connection getConnection() throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/businessApplication";
			String user = "root";
			String password = "abc123";
			Connection objConn = (Connection) DriverManager.getConnection(
					connectionUrl, user, password);
			return objConn;
		} catch (Exception objE) {
			throw new Exception("Error in getConnection() " + objE.toString());
		}

	}

}
