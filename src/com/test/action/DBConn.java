package com.test.action;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {
	private final String RESOURCE = "jdbc/CityDB";
	private final String LOOKUP = "java:/comp/env";
	private DataSource ds;
	private static DBConn _instance;

	private DBConn() {

		try {
			Context context = (Context) new InitialContext().lookup(LOOKUP);
			ds = (DataSource) context.lookup(RESOURCE);
		} catch (NamingException ex) {

		}
	}

	public synchronized static DBConn getInstance() {
		if (_instance == null)
			_instance = new DBConn();
		return _instance;
	}

	public Connection getConnection() throws SQLException {
		return ds.getConnection();

	}

}
