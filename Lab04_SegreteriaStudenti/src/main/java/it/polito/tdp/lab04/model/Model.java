package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO daoC;
	private StudenteDAO daoS;
	
	
	public Model() {
		daoC = new CorsoDAO();
		daoS = new StudenteDAO();
		
	}

	//qui inserirò i metodi sulla db
	public List<Corso> getTuttiICorsi() {
		return daoC.getTuttiICorsi();
	}
	
	public List<Studente> getTuttiGliStudenti(){
		return daoS.getTuttiGliStudenti();
	}
	
	public List<Corso> getCorso(Corso corso) {
		return daoC.getCorso(corso);
	}
	public List<Studente> getStudente(Integer cod){
		return daoS.getStudente(cod);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso){
		return daoC.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsoByStudente(Integer matricola) {
		return daoC.getCorsoByStudente(matricola);
	}
}
