package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//serve solo per il test questa stampa
				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins,numeroCrediti,nome,periodoDidattico));
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public List<Corso> getCorso(Corso corso) {
		List<Corso> corsi = new LinkedList<Corso>();
		String cod = corso.getCodins();
		final String sql = "SELECT * FROM corso WHERE codins = ?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, cod);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins,numeroCrediti,nome,periodoDidattico));
				
			}
			conn.close();
			return corsi;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		
	}
		
	

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		List<Studente> studenti = new LinkedList<Studente>();
		String cod = corso.getCodins();
		final String sql = "SELECT s.* FROM studente AS s,iscrizione AS i WHERE s.matricola = i.matricola AND codins = ?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, cod);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				studenti.add(new Studente(matricola,cognome,nome,cds));
				
			}

			conn.close();
			return studenti;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		
	}
	
	public List<Corso> getCorsoByStudente(Studente s) {

		
		final String sql = "SELECT c.* FROM corso AS c,iscrizione AS i WHERE c.codins=i.codins AND i.matricola = ?";

		Integer matricola = s.getMatricola();
		List<Corso> corsi = new LinkedList<Corso>();
		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//serve solo per il test questa stampa
				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins,numeroCrediti,nome,periodoDidattico));
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
