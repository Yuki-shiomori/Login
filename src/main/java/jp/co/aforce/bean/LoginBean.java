package jp.co.aforce.bean;

public class LoginBean implements java.io.Serializable {
	
	private int id;
	private int pas;
	
	public int getId() {
		return id;
	}
	
	public int getPas() {
		return pas;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setPas(int pas) {
		this.pas=pas;
		
	}
}
