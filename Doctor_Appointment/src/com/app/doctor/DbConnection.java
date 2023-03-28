package com.app.doctor;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	static Connection con;
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver loaded");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorDb","root","root");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
