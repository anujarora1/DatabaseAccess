package database;

public class Column {
	
	private String name;
	private String type;
	
	public Column(String name) {
		this.name = name;
		type = "";
	}
	
	public Column(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "[Name: " + name + ", Type: " + type + "]";  
	}
}
