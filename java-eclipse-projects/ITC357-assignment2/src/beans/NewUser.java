package beans;

public class NewUser {

	private String fName;
	private String lName;
	private String uName;
	private String pWord;
	
	public NewUser() {
		fName = "";
		lName = "";
		uName = "";
		pWord = "";
	}
	
	public String getFName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getUName() {
		return uName;
	}
	
	public void setUName(String uName) {
		this.uName = uName;
	}
	
	public String getPWord() {
		return pWord;
	}
	
	public void setPWord(String pWord) {
		this.pWord = pWord;
	}
	
	
}
