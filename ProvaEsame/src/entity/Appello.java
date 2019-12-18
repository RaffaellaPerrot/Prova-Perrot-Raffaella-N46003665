package entity;

import java.time.LocalDate;
import java.util.ArrayList;

import control.gestioneAppelli;
import entity.Luogo;
import entity.TipoProva;
import entity.Corso;
public class Appello {
	private String id;
	private ArrayList<Studente> listaStudentiPrenotati;
	private Corso corsoRiferimento;
	private LocalDate dataAppello;
	private Luogo luogo;
	private TipoProva tipoProva;
	
	public Appello(String id, Corso corsoRiferimento) {
		this.id=id;
		this.corsoRiferimento=corsoRiferimento;
	}
	
	public Appello(String id,LocalDate dataAppello, Luogo luogo,TipoProva tipoProva, Corso CorsoRiferimento) {
		this.id=id;
		this.luogo=luogo;
		this.tipoProva=tipoProva;
		this.dataAppello=dataAppello;
		this.corsoRiferimento= CorsoRiferimento;
		listaStudentiPrenotati = new ArrayList<Studente>();
	}
	public String getId() {
		return id;
	}
	public void setId (String id) {
		this.id=id;
	}
		
	public void setDatatAppello(LocalDate dataAppello) {
		this.dataAppello=dataAppello;
	}
	
	public LocalDate getDataAppello() {
		return dataAppello;
	}
	
	public void setLuogo(Luogo luogo) {
		this.luogo=luogo;
	}
	
	public Luogo getLuogo() {
		return luogo;
	}
	
	public void setTipoProva(TipoProva tipoProva) {
		this.tipoProva=tipoProva;
	}
	
	public TipoProva getTipoProva() {
		return tipoProva;
	}
	public ArrayList<Studente> getLista(){
		return listaStudentiPrenotati;
	}
	public void addStudente(Studente s) {  
		listaStudentiPrenotati.add(s);
	}
	
	public String toString () {
		StringBuffer buf = new StringBuffer();
		
		buf.append("APPELLO: "+dataAppello+" LUOGO: "+luogo+" TIPO PROVA: "+tipoProva+" "+corsoRiferimento.toString() +"\n");
		
		return buf.toString();
	}
	
	public ArrayList<Studente> getStudente() {
		return null;
	}

	
}
