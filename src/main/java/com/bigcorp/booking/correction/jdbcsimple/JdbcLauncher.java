package com.bigcorp.booking.correction.jdbcsimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Exemple d'utilisation directe de JDBC
 */
public class JdbcLauncher {

	public static void main(String[] args) {
		Properties connectionProps = new Properties();
		connectionProps.put("user", "test");
		connectionProps.put("password", "test");
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:h2:file:~/h2-data/formation-spring-jpa",
					connectionProps);
			
			String dropQuery = "DROP TABLE EXAMPLE IF EXISTS";
			String createQuery = "CREATE TABLE EXAMPLE(ID INTEGER PRIMARY KEY, NOM VARCHAR(255))";
			String selectQuery = "SELECT * FROM EXAMPLE";
			try(Statement statement = connection.createStatement()){
				statement.execute(dropQuery);
				statement.execute(createQuery);
				ResultSet resultSet = statement.executeQuery(selectQuery);
				resultSet.getString("NON");
				resultSet.getString("COLONNE2");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Could not connect to database ", e);
		}

	}

}
