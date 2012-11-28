package database;

import java.util.*;

public class Table {

	private String name;
	private List<Column> columns;
	
	public Table(String name) {
		this.name = name;
		columns = new ArrayList<Column>();
	}
	
	public void addColumn(Column theColumn) {
		columns.add(theColumn);
	}

	public List<Column> getColumns() {
		return columns;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer("");
		
		sb.append("TableName: ");
		sb.append(name);
		sb.append("\n");
		for (Column column : columns) 
		{
			sb.append(column.toString());
			sb.append("\n");
		}
		
		return sb.toString(); 
	}
}

