package com.mkyong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
	public static void createDB() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch ( ClassNotFoundException e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}


	public static void prepareTable() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = ""
					+ "CREATE TABLE DBUSER ( \n" +
					"  USER_ID       NUMBER (5)    NOT NULL, \n" +
					"  USERNAME      VARCHAR2 (20)  NOT NULL, \n" +
					"  CREATED_BY    VARCHAR2 (20)  NOT NULL, \n" +
					"  CREATED_DATE  DATE          NOT NULL, \n" +
					"  PRIMARY KEY ( USER_ID ) \n" +
					")";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		  } catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	  System.out.println("Table created successfully");
	}

	public static void main(String[] args) {
		System.out.println("Loaded");
		createDB();
		prepareTable();
	}
}
