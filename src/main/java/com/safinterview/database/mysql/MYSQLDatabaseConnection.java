package com.safinterview.database.mysql;

import java.net.ConnectException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.CommunicationsException;

/**
* MYSQLDatabaseConnection
*
* Created database connection
*
* This source code is auto-generated
* Victor Mwenda
* @author vmwenda.vm@gmail.com
 */
public class MYSQLDatabaseConnection {

	private Connection connection;
	private String host;
	private String database;
	private String user;
	private String password;

	public MYSQLDatabaseConnection(String host, String database, String user, String password) {
		
		this.host = host;
		this.database = database;
		this.user = user;
		this.password = password;
		

		try {
			connection = createConnection(host, database, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		catch (ConnectException e) {
			e.printStackTrace();

		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

	private Connection createConnection(String host, String database, String user, String password)
			throws ClassNotFoundException, SQLException, CommunicationsException, ConnectException, SocketException {
		Class.forName("com.mysql.jdbc.Driver");
		if (host == null) {
			throw new IllegalArgumentException("Missing database host");
		}
		if (user == null) {
			throw new IllegalArgumentException("Missing database user");
		}
		if (password == null) {
			throw new IllegalArgumentException("Missing user passowrd");
		}
		if (database == null) {
			return DriverManager.getConnection("jdbc:mysql://" + host + "/", user, password);
		} else {
			return DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, password);
		}
	}

	/**
	 * MYSQL DATABASE CONNECTION
	 * 
	 * @return CONNECTION
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SocketException
	 * @throws ConnectException
	 */
	public Connection getConnection()
			throws SQLException, ClassNotFoundException, CommunicationsException, ConnectException, SocketException {
		if (connection == null) {

			connection = createConnection(host, database, user, password);

		}
		return connection;
	}

}
