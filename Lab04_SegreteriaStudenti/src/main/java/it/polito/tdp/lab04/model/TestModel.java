package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		Corso c = new Corso("01KSUPG",0,null,0);
		Studente s = new Studente (146101,null,null,null);
		
		
		
		/*
		 * 	Write here your test model
		 */
		
		
	
		System.out.println(model.getCorsoByStudente(s));
		
		
		//System.out.println(model.getStudentiIscrittiAlCorso(c));

	}

}
