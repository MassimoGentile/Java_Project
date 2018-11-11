package be.massimo.project;

public class Game {
	
	private int Id;
	private String Name;
	private String Developers;
	private String Editor;
	private int Unit;
	
	public Game(int id,String name, String developers, String editor, int unit) {
		this.Id = id;
		this.Name = name;
		this.Developers = developers;
		this.Editor = editor;
		this.Unit = unit;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String getDevelopers() {
		return this.Developers;
	}
	
	public String getEditor() {
		return this.Editor;
	}
	
	public int getUnit() {
		return this.Unit;
	}
}
