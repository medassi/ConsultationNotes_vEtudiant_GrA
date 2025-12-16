package com.medassi.consultationnotes;

import com.medassi.consultationnotes.tools.OutilsStringToObject;
import com.medassi.consultationnotes.entities.Etudiant;
import com.medassi.consultationnotes.entities.Matiere;
import com.medassi.consultationnotes.entities.Resultat;
import com.medassi.consultationnotes.entities.Devoir;
import com.medassi.consultationnotes.tools.OutilsCalculs;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class PrimaryController implements javafx.fxml.Initializable {

    @FXML
    private Label labelGeneMoyenne;
    @FXML
    private Label labelGeneMiniEtud;
    @FXML
    private Label labelGeneMaxiEtud;
    @FXML
    private Label labelGeneMiniNote;
    @FXML
    private Label labelGeneMaxiNote;
    @FXML
    private ComboBox<Etudiant> cbEtudiants;
    @FXML
    private ComboBox<Matiere> cbMatieres;
    @FXML
    private ComboBox<Devoir> cbDevoirs;

    private ObservableList<Etudiant> es;
    private ObservableList<Matiere> ms;
    private ObservableList<Devoir> ds;
    private ObservableList<Resultat> rs;

    private Alert alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chargementFichierCSV();
        chargementComboBoxes();
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Consultation des notes");
        aEffacer();
        //updateGeneral();
    }

    private void aEffacer() {
        alert.setHeaderText("Bienvenue dans l'application de consultation de notes");
        alert.setContentText("A vous de jouer pour que l'application réponde aux besoins.");
        alert.showAndWait();
    }

    private void chargementComboBoxes() {
        cbEtudiants.setItems(es);
        cbMatieres.setItems(ms);
        cbDevoirs.setItems(ds);
    }

    private void chargementFichierCSV() {
        es = OutilsStringToObject.recupererLesEtudiants("csv/etudiants.csv");
        ms = OutilsStringToObject.recupererLesMatieres("csv/matieres.csv");
        ds = OutilsStringToObject.recupererLesDevoirs("csv/devoirs.csv", ms);
        rs = OutilsStringToObject.recupererLesNotes("csv/notes.csv", ds, es);
    }

    private void updateGeneral() {
        throw new UnsupportedOperationException("A faire !!!");
    }

    @FXML
    private void onActionRechercherEtudiant(ActionEvent event) {
        Etudiant e = (Etudiant) cbEtudiants.getSelectionModel().getSelectedItem();
        throw new UnsupportedOperationException("A faire !!!");
    }

    @FXML
    private void onActionRechercherMatiere(ActionEvent event) {
        Matiere mSelect = (Matiere) cbMatieres.getSelectionModel().getSelectedItem();
        System.out.println("Moyenne :" +OutilsCalculs.moyenneMatiere(rs, mSelect));
    }

    @FXML
    private void onActionRechercherDevoir(ActionEvent event) {
        Devoir d = (Devoir) cbDevoirs.getSelectionModel().getSelectedItem();
        float moyenneDuDevoir = OutilsCalculs.moyenneDevoir(rs, d) ;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Consultation des notes");
        alert.setContentText("Pour le devoir "+d.libelleDevoir +", la moyenne est "+moyenneDuDevoir);
        alert.showAndWait() ;
    }

}
