package be.massimo.project;

public class Game {
	
	//	ATTRIBUTES
	private int Id;
	private String Name;
	private String Developers;
	private String Editor;
	private int Unit;
	
	//	GET/SET
	public int getId() {
		return this.Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getDevelopers() {
		return this.Developers;
	}
	
	public void setDevelopers(String developers) {
		this.Developers = developers;
	}
	
	public String getEditor() {
		return this.Editor;
	}
	
	public void setEditor(String editor) {
		this.Editor = editor;
	}
	
	public int getUnit() {
		return this.Unit;
	}
	
	public void setUnit(int unit) {
		this.Unit = unit;
	}
	
	//	CONSTRUCTOR(S)
	public Game(int id,String name, String developers, String editor, int unit) {
		this.Id = id;
		this.Name = name;
		this.Developers = developers;
		this.Editor = editor;
		this.Unit = unit;
	}
}
