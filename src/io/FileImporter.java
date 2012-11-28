package io;

import java.sql.*;
import java.util.*;

import database.*;

public class FileImporter {
	
	String filename;
	
	List<Table> tables;
	
	public FileImporter(String filename) {
		this.filename = filename;
		populateTables();
	}
	
	private void populateTables() {
		
		//populate all the tables, create a database connection
		//run the query
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbFile = "jdbc:sqlite:" + filename;
			Connection connection = DriverManager.getConnection(dbFile);
			
			Statement statement = connection.createStatement();
			
			String sql = "";
			
			ResultSet rs = statement.executeQuery(sql);
			
			
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}
