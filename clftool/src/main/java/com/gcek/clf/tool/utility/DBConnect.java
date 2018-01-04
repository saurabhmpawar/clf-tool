package com.gcek.clf.tool.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

/**
 * 
 * @author
 *
 *
 * 		This class is used for creating connection to database
 */
public class DBConnect {

	private DBConnect() {
	}

	static final Logger logger = Logger.getLogger(DBConnect.class);

	/**
	 * This is static method used for getting connection from mysql database
	 * 
	 * 
	 * This is my class
	 * 
	 * @return Connection
	 * 
	 */
	public static Connection getConnecttion() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfltool", "root", "root");
		} catch (Exception e) {
			logger.error("Error at creating connection to database ", e);
		}
		return cons;
	}

	public static void main(String[] args) {
		logger.info(getConnecttion());
	}

}
