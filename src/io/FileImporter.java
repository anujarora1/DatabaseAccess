package io;

import java.sql.*;
import java.util.*;

import database.*;

public class FileImporter {
	
	private String filename;
	
	private List<Table> tables;
	
	public FileImporter(String filename) {
		this.filename = filename;
		tables = new ArrayList<Table>();
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
			
			//sql to create a table list
			String sql = "select tbl_name from sqlite_master where type='table'";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String tableName = rs.getString(1);
				Table table = new Table(tableName);
				tables.add(table);
			}
			
			for (Table table : tables)
			{
				String s = table.getName();
				sql = "pragma table_info(" + s + ")";
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					String columnName = rs.getString(2);
					String columnType = rs.getString(3);
					
					Column column = new Column(columnName, columnType);
					
					table.addColumn(column);
				}
			}
			statement.close();
			connection.close();
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Table table : tables)
			System.out.println(table.toString());
	}
	
	public static void main(String args[]) {
		FileImporter importer = new FileImporter("temp.db");
	}
	

}
