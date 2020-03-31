package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> boxCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCompleta;
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRisultato;
    
    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    
    	Integer matricola = Integer.parseInt(txtMatricola.getText());
    	List<Corso> c = this.model.getCorsoByStudente(matricola);
    	for(Corso a : c) {
    		txtRisultato.appendText(a.getCodins()+" "+a.getNome()+"\n");
    	}
    	
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	txtRisultato.clear();
        //recupero il valore dalla comboBox
    	Corso corso = boxCorso.getValue();
    	
    	if (corso==null) {
    		txtRisultato.setText("ERRORE CORSO INDICATO");
    		return;
    	}
    	//lavoro sulla lista studenti joinnata
    	List<Studente> s = this.model.getStudentiIscrittiAlCorso(corso);
    	for(Studente a : s) {
    		txtRisultato.appendText(a.toString()+"\n");
    	}
    	
    }

    @FXML
    void doCompleta(ActionEvent event) {
    	// INIZIALIZZO UN BOOLEAN PER LA RICERCA
    	 boolean flag = false;
    	 // TRASFORMO IN INTERO IL CAMPO DI TESTO
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	
    	//LAVORO CON LA LISTA STUDENTI IMPORTATA DAL DB
    	List<Studente> s = this.model.getTuttiGliStudenti();
    	for (Studente a : s) {
    		if (a.getMatricola()==matricola) {
    			flag = true;
    			txtNome.setText(a.getNome());
    			txtCognome.setText(a.getCognome());
    		}
    		
    	}
    	//SE NON TROVATA DESCRIVE L'ERRORE
    	if (!flag) {
    		txtNome.setText("ERRORE");
    		txtCognome.setText("INSERIMENTO");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtRisultato.clear();

    }
    
    @FXML
    void doIscrizione(ActionEvent event) {

    }
    
    void insertCorsi() {
    	boxCorso.getItems().addAll(this.model.getTuttiICorsi());
    	boxCorso.getItems().add(null);
    	boxCorso.setValue(null);
    	
    }

    @FXML
    void initialize() {
        assert boxCorso != null : "fx:id=\"boxCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'Scene.fxml'.";
        btnCompleta.setStyle("-fx-background-color: green");
        btnCompleta.setText("V");
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        model = new Model();
        insertCorsi();
    }
    public void setModel(Model model) {
    	this.model=model;
    	}
}
