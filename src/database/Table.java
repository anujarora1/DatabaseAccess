package database;

import java.util.*;

public class Table {

	List<Column> columns;
	
	public Table() {
		columns = new ArrayList<Column>();
	}
	
	public void addColumn(Column theColumn) {
		columns.add(theColumn);
	}
	
}
