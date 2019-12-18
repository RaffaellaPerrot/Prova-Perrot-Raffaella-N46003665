package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.gestioneAppelli;
import entity.Appello;
import entity.Corso;
import entity.Luogo;
import entity.Studente;
import entity.TipoProva;


public class gestioneAppelliTest {
	gestioneAppelli gestioneappelli;
	@Before
	public void setUp() throws Exception {
		gestioneappelli=new gestioneAppelli();
	}

	@After
	public void tearDown() throws Exception {
		gestioneappelli=null;
	}
	
	@Test
	public void testGestioneAppelli01()  {	//caso 1 corso, 1 appello e nessuno studente
		
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		gestioneappelli.aggiungiCorso(c1);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		gestioneappelli.aggiungiAppello(a1);
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(0,listaStudentiPrenotati.size());
	}
	
	@Test
	public void testGestioneAppelli02()  {	// caso 1 corso , 2 appelli e nessuno studente
		
		LocalDate data1 = LocalDate.of(2017,Month.APRIL,30) ;
		LocalDate data2 = LocalDate.of(2017,Month.JUNE,30) ;
		LocalDate data3 = LocalDate.of(2017,Month.OCTOBER,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		gestioneappelli.aggiungiCorso(c1);
		Appello a1 = new Appello("P12",data1,Luogo.AULA,TipoProva.ORALE,c1 );
		Appello a2 = new Appello("P13",data2,Luogo.AULA,TipoProva.SCRITTA,c1 );
		gestioneappelli.aggiungiAppello(a1);
		gestioneappelli.aggiungiAppello(a2);
		ArrayList<Studente> listaStudentiPrenotati1=a1.getLista() ;
		ArrayList<Studente> listaStudentiPrenotati2=a2.getLista() ;
		assertEquals(0,listaStudentiPrenotati1.size());
		assertEquals(0,listaStudentiPrenotati1.size());
	}
	
	@Test
	public void testGestioneAppelli03() {	//caso 1 corso, 0 appelli e 2 studenti
		LocalDate data = LocalDate.of
				(2017,Month.APRIL,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		gestioneappelli.aggiungiCorso(c1);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		Studente s1 = new Studente (35463,"N46003322");
		Studente s2 = new Studente (35433,"N46003672");
		gestioneappelli.aggiungiStudente(s1);
		gestioneappelli.aggiungiStudente(s2);
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(0,listaStudentiPrenotati.size());
	}
	
	@Test
	public void testGestioneAppelli04() {	//caso 1 corso, 1 appello e 2 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		LocalDate data2 = LocalDate.of(2017,Month.JUNE,30) ;
		LocalDate data3 = LocalDate.of(2017,Month.OCTOBER,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		gestioneappelli.aggiungiCorso(c1);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		gestioneappelli.aggiungiAppello(a1);
		Studente s1 = new Studente (35463,"N46003322");
		Studente s2 = new Studente (35433,"N46003672");
		gestioneappelli.aggiungiStudente(s1);
		gestioneappelli.aggiungiStudente(s2);
		gestioneappelli.Prenotazione(s1, a1);
		gestioneappelli.Prenotazione(s2, a1);
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(2,listaStudentiPrenotati.size());
	}
	
	@Test
	public void testGestioneAppelli05() {	//caso 1 corso ,2 appelli e 3 studenti 
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		LocalDate data2 = LocalDate.of(2017,Month.JUNE,30) ;
		LocalDate data3 = LocalDate.of(2017,Month.OCTOBER,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		gestioneappelli.aggiungiCorso(c1);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		Appello a2 = new Appello("P13",data2,Luogo.AULA,TipoProva.SCRITTA,c1 );
		gestioneappelli.aggiungiAppello(a1);
		gestioneappelli.aggiungiAppello(a2);
		Studente s1 = new Studente (35463,"N46003322");
		Studente s2 = new Studente (35433,"N46003672");
		Studente s3 = new Studente (78654,"N46007234");
		gestioneappelli.aggiungiStudente(s1);
		gestioneappelli.aggiungiStudente(s2);
		gestioneappelli.aggiungiStudente(s3);
		gestioneappelli.Prenotazione(s1, a1);
		gestioneappelli.Prenotazione(s2, a2);
		gestioneappelli.Prenotazione(s3, a1);
		ArrayList<Studente> listaStudentiPrenotati1=a1.getLista() ;
		ArrayList<Studente> listaStudentiPrenotati2=a2.getLista() ;
		assertEquals(2,listaStudentiPrenotati1.size());
		assertEquals(1,listaStudentiPrenotati2.size());
	}
	
	@Test
	public void testGestioneAppelli06() {	//caso 2 corsi, 0 appelli e 2 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		Corso c2 = new Corso ("Fisica 2","Andreone", 6);
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		Studente s1 = new Studente (35463,"N46003322");
		Studente s2 = new Studente (35433,"N46003672");
		gestioneappelli.aggiungiStudente( s1);
		gestioneappelli.aggiungiStudente(s2);
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(0,listaStudentiPrenotati.size());
	}
	
	@Test
	public void testGestioneAppelli07() {	//caso 2 corsi, 1 appello e 2 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		Corso c2 = new Corso ("Fisica 2","Andreone", 6);
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		gestioneappelli.aggiungiAppello(a1);
		Studente s1 = new Studente (35463,"N46003322");
		Studente s2 = new Studente (35433,"N46003672");
		gestioneappelli.aggiungiStudente(s1);
		gestioneappelli.aggiungiStudente(s2);
		gestioneappelli.Prenotazione(s1, a1);
		gestioneappelli.Prenotazione(s2, a1);
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(2,listaStudentiPrenotati.size());
	}
	
	@Test
	public void testGestioneAppelli08() {	//caso 2 corsi, 3 appelli e 2 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		LocalDate data2 = LocalDate.of(2017,Month.JUNE,30) ;
		LocalDate data3 = LocalDate.of(2017,Month.OCTOBER,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		Corso c2 = new Corso ("Fisica 2","Andreone", 6);
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		Appello a2 = new Appello("P13",data2,Luogo.AULA,TipoProva.SCRITTA,c2);
		Appello a3 = new Appello("P14",data3,Luogo.AULA,TipoProva.ORALE,c1 );
		gestioneappelli.aggiungiAppello(a1);
		gestioneappelli.aggiungiAppello(a2);
		gestioneappelli.aggiungiAppello(a3);
		Studente s1 = new Studente (35463,"N46003322");
		Studente s2 = new Studente (35433,"N46003672");
		gestioneappelli.aggiungiStudente(s1);
		gestioneappelli.aggiungiStudente(s2);
		gestioneappelli.Prenotazione(s1, a1);
		gestioneappelli.Prenotazione(s2, a3);
		ArrayList<Studente> listaStudentiPrenotati1=a1.getLista() ;
		ArrayList<Studente> listaStudentiPrenotati2=a2.getLista() ;
		ArrayList<Studente> listaStudentiPrenotati3=a3.getLista() ;
		assertEquals(1,listaStudentiPrenotati1.size());
		assertEquals(0,listaStudentiPrenotati2.size());
		assertEquals(1,listaStudentiPrenotati3.size());
	}
	
	@Test
	public void testGestioneAppelli09() {	//caso 2 corsi, 0 appelli e 0 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		Corso c2 = new Corso ("Fisica 2","Andreone", 6);
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(0,listaStudentiPrenotati.size());
		
	}

	@Test
	public void testGestioneAppelli10() {	//caso 2 corsi, 1 appello e 0 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		Corso c2 = new Corso ("Fisica 2","Andreone", 6);
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);	
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		gestioneappelli.aggiungiAppello(a1);
		ArrayList<Studente> listaStudentiPrenotati=a1.getLista() ;
		assertEquals(0,listaStudentiPrenotati.size());
		
	}
	@Test
	public void testGestioneAppelli11() {	//caso 2 corsi, 2 appelli e 0 studenti
		LocalDate data = LocalDate.of(2017,Month.APRIL,30) ;
		LocalDate data2 = LocalDate.of(2017,Month.JUNE,30) ;
		Corso c1 = new Corso ("Analisi 1","De Maio",9);
		Corso c2 = new Corso ("Fisica 2","Andreone", 6);
		gestioneappelli.aggiungiCorso(c1);
		gestioneappelli.aggiungiCorso(c2);
		Appello a1 = new Appello("P12",data,Luogo.AULA,TipoProva.ORALE,c1 );
		Appello a2 = new Appello("P13",data,Luogo.AULA,TipoProva.ORALE,c1 );
		gestioneappelli.aggiungiAppello(a1);
		gestioneappelli.aggiungiAppello(a2);
		ArrayList<Studente> listaStudentiPrenotati1=a1.getLista() ;
		ArrayList<Studente> listaStudentiPrenotati2=a2.getLista() ;
		assertEquals(0,listaStudentiPrenotati1.size());
		assertEquals(0,listaStudentiPrenotati2.size());
		
	}


}
