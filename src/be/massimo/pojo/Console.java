package be.massimo.pojo;

public class Console {
	
	// 	ATTRIBUTES
	private int Id;
	private String Name;
	private String Version;
	
	// 	GET/SET
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
	
	public String getVersion() {
		return this.Version;
	}
	
	public void setVersion(String version) {
		this.Version = version;
	}
	
	//	CONSTRUCTOR(S)
	public Console(int id, String name, String version) {
		this.Id = id;
		this.Name = name;
		this.Version = version;
	}
}
