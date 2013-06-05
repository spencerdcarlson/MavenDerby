package com.sc.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	private String path; 
	
	public Database(){
		path = new File("").getAbsolutePath();
		path += "/db";
		testConn();
	}
	private void testConn(){
		try {
			// Test Connection
			Connection conn = DriverManager.getConnection("jdbc:derby:"+path);
			System.out.println("jdbc:derby:" + path);
			System.out.println("Database Connected");
		} catch (SQLException e) {
			System.out.println("ERROR:::Database didn't connect");
			e.printStackTrace();
		}
	}
	public void query(String cmd){
		ResultSet r = null;
		try {
			// Connect
			Connection conn = DriverManager.getConnection("jdbc:derby:"+path);
//			Statement s = conn.createStatement();
//			r = s.executeQuery("SELECT * FROM ");
//			while(r.next()){
//				//result.add(new Runner(r.getInt("AGE"),r.getString("SEX") , r.getFloat("HOURS"), r.getInt("AGECAT8"), r.getInt("AGECAT6"), r.getInt("SEX2"), r.getInt("TIME5")));
//			}
		}catch(SQLException e){
			
		}
		
	}

}
