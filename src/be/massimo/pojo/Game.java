package be.massimo.pojo;

public class Game {
	
	//	ATTRIBUTES
	private int Id;
	private String Name;
	private int ReleaseYear;
	private String Editor;
	private int Unit;
	private Console C;
	
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
	
	public int getReleaseYear() {
		return this.ReleaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.ReleaseYear = releaseYear;
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
	
	public Console getConsole(){
		return this.C;
	}
	
	public void setConsole(Console console) {
		this.C = console;
	}
	
	//	CONSTRUCTOR(S)
	public Game(int id,String name, int releaseYear, String editor, int unit, Console console) {
		this.Id = id;
		this.Name = name;
		this.ReleaseYear = releaseYear;
		this.Editor = editor;
		this.Unit = unit;
		this.C = console;
	}
}
