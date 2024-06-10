package com.fintech.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FintechDBManager {

	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("url", "user", "password");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conexao;
	}


}
