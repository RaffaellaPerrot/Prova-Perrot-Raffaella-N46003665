package main;
import java.time.LocalDate;
import java.time.Month;


import control.gestioneAppelli;
import entity.Appello;
import entity.Corso;
import entity.Luogo;
import entity.Studente;
import entity.TipoProva;

public class main {

	public static void main(String[] args) {
		
		gestioneAppelli gestioneappelli = new gestioneAppelli();
		

		Studente s1 = new Studente(12345 , "N46003665");
		Studente s2 = new Studente(67890 ,"N46004657");
		Studente s3 = new Studente(13579, "N46006789");
		Studente s4 = new Studente (24680 ,"N46008976");

		Corso c1 = new Corso("Analisi 1","DE MAIO",9); 
		Corso c2 = new Corso("Analisi 2","DE MAIO",6);
		Corso c3 = new Corso("Programmazione 1","MARESCA",9); 
		
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);
		gestioneappelli.aggiungiCorso(c3);
	
		
		
		LocalDate dataAppello = LocalDate.of(2018,Month.JANUARY,12);
		Luogo luogo = Luogo.AULA;
		TipoProva tipoProva = TipoProva.SCRITTA;
		String id="P11";
		Appello a1 = new Appello (id, dataAppello , luogo , tipoProva,c1);
		
		dataAppello = LocalDate.of(2018,Month.FEBRUARY,12);
		luogo = Luogo.LABORATORIO;
		tipoProva = TipoProva.SCRITTA;
		id="P22";
		Appello a2 = new Appello (id,dataAppello , luogo , tipoProva,c2);
		
		dataAppello = LocalDate.of(2018,Month.JUNE,12);
		luogo = Luogo.LABORATORIO;
		tipoProva = TipoProva.ORALE;
		id="P33";
		Appello a3 = new Appello (id,dataAppello , luogo , tipoProva,c3);
		
		dataAppello = LocalDate.of(2018,Month.SEPTEMBER,12);
		luogo = Luogo.AULA;
		tipoProva = TipoProva.AL_CALCOLATORE;
		id="P44";
		Appello a4 = new Appello (id ,dataAppello , luogo , tipoProva,c3);
		
		gestioneappelli.aggiungiAppello(a1);
		gestioneappelli.aggiungiAppello(a2);
		gestioneappelli.aggiungiAppello(a3);
		gestioneappelli.aggiungiAppello(a4);
		
		
		gestioneappelli.Prenotazione(s1,a1);
		gestioneappelli.Prenotazione(s2,a1);
		gestioneappelli.Prenotazione(s3,a2);
		gestioneappelli.Prenotazione(s2,a2);
		gestioneappelli.Prenotazione(s2,a3);
		gestioneappelli.Prenotazione(s3,a4);

		
		
		for (Appello a : gestioneappelli.stampaListaAppelli()) {
			System.out.println(a.toString());
			for(Studente s : a.getLista()) {
			System.out.println(s.toString());
			}
			}
		
	}}

