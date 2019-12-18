package entity;

public class Studente {
	private int PIN;
	private String matricola;
	
	
	public Studente (int PIN, String matricola) {
		this.PIN=PIN;
		this.matricola=new String(matricola);
	}
	
	
	public void setPIN(int PIN) {
		this.PIN=PIN;
	}
	
	public int getPIN() {
		return PIN;
	}
	public void setMatricola(String matricola) {
		this.matricola=matricola;
	}
	public String getMatricola() {
		return matricola;
	}

	public String toString() {
		
		StringBuffer buf = new StringBuffer();
		
		buf.append("Studente matricola: "+matricola+"\n");
		
		return buf.toString();
	}
	
}
