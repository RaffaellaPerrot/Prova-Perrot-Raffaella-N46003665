package entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Corso {
	private String nomeCorso;
	private String nomeDocente;
	private int CFU;
	private Appello id;
	private ArrayList<Appello> appelli;
	
	public Corso(String nomeCorso, String nomeDocente, int CFU) {
		this.nomeCorso=nomeCorso;
		this.nomeDocente=nomeDocente;
		this.CFU=CFU;
		this.appelli= new ArrayList<Appello>();
	}
	
	public Corso(String nomeCorso, String nomeDocente, int CFU, Appello dataAppello) {
		this.nomeCorso=nomeCorso;
		this.nomeDocente=nomeDocente;
		this.CFU=CFU;
		this.id=id;
	}
	public ArrayList<Appello> getAppelli() {
		return appelli;
	}
	
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso=nomeCorso;
	}
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente=nomeDocente;
	}
	public String getNomeDocente() {
		return nomeDocente;
	}
	public void setCFU(int CFU) {
		this.CFU=CFU;
	}
	public int getCFU() {
		return CFU;
	}
	public void addAppello(Appello a) { 
		appelli.add(a);
	}

	public String toString() {
		
		StringBuffer buf = new StringBuffer();
		
		buf.append("CORSO: "+nomeCorso+" NOME DOCENTE: "+nomeDocente+" CFU : "+CFU+"\n");
		
		
		return buf.toString();
	}
	
}
