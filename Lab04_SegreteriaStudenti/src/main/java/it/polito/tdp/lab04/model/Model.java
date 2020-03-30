package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO daoC;
	private StudenteDAO daoS;
	
	public Model() {
		daoC = new CorsoDAO();
		daoS = new StudenteDAO();
	}

}
