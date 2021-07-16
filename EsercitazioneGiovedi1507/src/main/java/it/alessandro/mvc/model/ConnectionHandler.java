package it.alessandro.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionHandler {
	private final String db_url;
	private final String schema;
	private final String db_name;
	private final String username;
	private final String password;
	private final String JDBC_URL;
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public ConnectionHandler(String db_url, String db_name, String schema,  String username, String password) {
		this.db_url = db_url;
		this.db_name = db_name;
		this.schema = schema;
		this.username = username;
		this.password = password;
		JDBC_URL = String.format("jdbc:postgresql://%s:5432/%s?currentSchema=%s&user=%s&password=%s", db_url, db_name, schema, username, password);
	}

	public static Connection getConnection() throws SQLException {
		if( connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/esercitazione4?currentSchema=negozio&user=postgres&password=epicode");
		}
		return connection;
	}
	
	public void closeConnection() throws SQLException {
		if( connection != null || !connection.isClosed()) {
			connection.close();
		}
	}
	
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		if(connection == null) {
			throw new IllegalStateException("non si puo' creare un prepared statement senza aver prima creato la connessione");
		}
		return connection.prepareStatement(query);
	}
	
	
}
