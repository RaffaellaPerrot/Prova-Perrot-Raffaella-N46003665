package control;

import java.time.LocalDate;
import java.util.ArrayList;

import entity.Appello;
import entity.Corso;
import entity.Luogo;
import entity.Studente;
import entity.TipoProva;

public class gestioneAppelli {
	ArrayList<Studente> lista_studenti;
	ArrayList<Corso> lista_corsi;
	ArrayList<Appello> lista_appelli;
	 
	public gestioneAppelli() {
		lista_appelli = new ArrayList<Appello>();
		lista_corsi = new ArrayList<Corso>();
		lista_studenti = new ArrayList<Studente>();
	}
	public ArrayList<Corso> getCorsi(){
		return lista_corsi;
	}
	public void aggiungiStudentePrenotato(String id, Studente s) {
		for (Appello a : lista_appelli) {
			if (a.getId().equals(id)) {
				a.addStudente(s);
			}
				
		}
	}
	public void Prenotazione(Studente s , Appello a) {
		
		a.addStudente(s);
	}
	
	
	public Appello creaAppello(String id,LocalDate dataAppello, Luogo luogo,TipoProva tipoProva,Corso corsoRiferimento) {
		boolean f = false;
		for(Corso c : lista_corsi) {
			for (Appello a1 : c.getAppelli()) {
				if((a1.getDataAppello().equals(dataAppello))&& c.getNomeCorso().equals(corsoRiferimento)) {
					System.out.println("Appello già presente"); 
				}
			}
		}
		for(Corso c : lista_corsi) {
			if(c.getNomeCorso().equals(corsoRiferimento)) {
				f = true;
			}
		}
		if(f) {
			return new Appello(id, dataAppello, luogo, tipoProva, corsoRiferimento);
			}
		return null;
	}
	
	public int studentiPrenotatiAppello(String idAppello){
		boolean flag = false;
		int studenti = 0;
		for(Corso c : lista_corsi) {
			for(Appello a : c.getAppelli()) {
				if(a.getId().equals(idAppello)) {
					flag = true;
					for(Studente s : a.getLista()) {
						System.out.println(" "+s.getMatricola()+" "+s.getPIN());
						studenti++;
					}
				}
			}
		}
		if(!flag) {
			System.out.println("Appello inesistente");
			return 0;
		}
		if(studenti == 0) {
			System.out.println("0 studenti prenotati");
		}
		return studenti;
	}
	public boolean creaCorso(String nomeCorso, String nomeDocente, int CFU) { 
		for(Corso c1 : lista_corsi) {
			if(c1.getNomeCorso().equals(nomeCorso)) {
				System.out.println("Corso già presente");
				return false;
			}
		}
		Corso c = new Corso(nomeCorso, nomeDocente, CFU);
		return lista_corsi.add(c);
	}
	public void aggiungiCorso(Corso c) {
		lista_corsi.add(c);
	}
	public void  aggiungiAppello(Appello a) {
		lista_appelli.add(a);
	}
	
	public void visualizzaAppelli(Appello a) {
		
	}
	
	public void modificaAppello() {
		
	}
	
	public void eliminaAppello(Appello a) {
		lista_appelli.remove(a);
	}
	public void eliminaCorso(Corso c) {
		lista_corsi.remove(c);
	}
	public void eliminaStudente(Studente s) {
		lista_studenti.remove(s);
	}
	public void aggiungiStudente (Studente s) {
		lista_studenti.add(s);
	}
	
	
	public ArrayList<Appello> stampaListaAppelli(){
		return lista_appelli;
	}
	
}
