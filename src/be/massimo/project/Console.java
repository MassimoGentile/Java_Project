package be.massimo.project;

public class Console {
	
	// 	ATTRIBUTES
	private String Name;
	private String Version;
	
	// 	GET/SET
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
	public Console(String name, String version) {
		this.Name = name;
		this.Version = version;
	}
}
