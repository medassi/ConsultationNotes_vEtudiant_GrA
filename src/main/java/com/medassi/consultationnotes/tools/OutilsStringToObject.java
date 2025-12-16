package com.medassi.consultationnotes.tools;

import com.medassi.consultationnotes.entities.Etudiant;
import com.medassi.consultationnotes.entities.Matiere;
import com.medassi.consultationnotes.entities.Resultat;
import com.medassi.consultationnotes.entities.Devoir;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OutilsStringToObject {

    //Construit et retourne une liste d'étudiant à partir du fichier dont le nom est passé en paramètre
    public static ObservableList<Etudiant> recupererLesEtudiants(String nfe) {
        String CsvEtudiants = OutilsCSVToString.chargerDepuisFichier(nfe);
        ObservableList<Etudiant> lesEtudiants = FXCollections.observableArrayList();
        for (int i = 0; i < OutilsCSVToString.nbLignes(CsvEtudiants); i++) {
            String ligne = OutilsCSVToString.extraireLigne(CsvEtudiants, i);
            Etudiant e = new Etudiant();
            e.idEtudiant = OutilsCSVToString.extraireValeur(ligne, 0);
            e.nomEtudiant = OutilsCSVToString.extraireValeur(ligne, 1);
            e.prenomEtudiant = OutilsCSVToString.extraireValeur(ligne, 2);
            lesEtudiants.add(e);
        }
        return lesEtudiants;
    }

    //Construit et retourne une liste de matière à partir du fichier dont le nom est passé en paramètre
    public static ObservableList<Matiere> recupererLesMatieres(String nfm) {
        ObservableList<Matiere> lesMatieres = FXCollections.observableArrayList();
        String CsvMatieres = OutilsCSVToString.chargerDepuisFichier(nfm);
        for (int i = 0; i < OutilsCSVToString.nbLignes(CsvMatieres); i++) {
            String ligne = OutilsCSVToString.extraireLigne(CsvMatieres, i);
            Matiere m = new Matiere();
            m.idMatiere = OutilsCSVToString.extraireValeur(ligne, 0);
            m.libelleMatiere = OutilsCSVToString.extraireValeur(ligne, 1);
            m.coeffMatiere = Float.parseFloat(OutilsCSVToString.extraireValeur(ligne, 2));
            lesMatieres.add(m);
        }
        return lesMatieres;
    }

    //Construit et retourne une liste de devoir à partir du fichier dont le nom est passé en paramètre
    public static ObservableList<Devoir> recupererLesDevoirs(String nfd, ObservableList<Matiere> lesMatieres) {
        ObservableList<Devoir> lesDevoirs = FXCollections.observableArrayList();
        String CsvDevoirs = OutilsCSVToString.chargerDepuisFichier(nfd);
        for (int i = 0; i < OutilsCSVToString.nbLignes(CsvDevoirs); i++) {
            String ligne = OutilsCSVToString.extraireLigne(CsvDevoirs, i);
            Devoir d = new Devoir();
            d.idDevoir = OutilsCSVToString.extraireValeur(ligne, 0);
            d.libelleDevoir = OutilsCSVToString.extraireValeur(ligne, 1);
            d.coeffDevoir = Float.parseFloat(OutilsCSVToString.extraireValeur(ligne, 2));
            d.matiere = getMatiereById(lesMatieres, OutilsCSVToString.extraireValeur(ligne, 3));
            lesDevoirs.add(d);
        }
        return lesDevoirs;
    }
    //Construit et retourne une liste de note à partir du fichier dont le nom est passé en paramètre.
    //Cette fonction a besoin de la liste des devoirs, et de la liste d'étudiant afin de pouvoir construire des objets "Resultat".

    public static ObservableList<Resultat> recupererLesNotes(String nfn, ObservableList<Devoir> lesDevoirs, ObservableList<Etudiant> lesEtudiants) {
        ObservableList<Resultat> lesNotes = FXCollections.observableArrayList();
        String CsvNotes = OutilsCSVToString.chargerDepuisFichier(nfn);
        for (int i = 0; i < OutilsCSVToString.nbLignes(CsvNotes); i++) {
            String ligne = OutilsCSVToString.extraireLigne(CsvNotes, i);
            Resultat n = new Resultat();
            n.idNote = OutilsCSVToString.extraireValeur(ligne, 0);
            n.note = Float.parseFloat(OutilsCSVToString.extraireValeur(ligne, 1));
            n.etudiant = getEtudiantById(lesEtudiants, OutilsCSVToString.extraireValeur(ligne, 2));
            n.devoir = getDevoirById(lesDevoirs, OutilsCSVToString.extraireValeur(ligne, 3));
            lesNotes.add(n);
        }
        return lesNotes;
    }

    //Retourne L'étudiant dont l'Id est égal à celui passé en paramètre, parmis les étudiants de la liste passée en paramètre
    public static Etudiant getEtudiantById(ObservableList<Etudiant> liste, String id) {
        for (Etudiant next : liste) {
            if (next.idEtudiant.equals(id)) {
                return next;
            }
        }
        return null;
    }

    //Retourne Le devoir dont l'Id est égal à celui passé en paramètre, parmis les devoirs de la liste passée en paramètre
    public static Devoir getDevoirById(ObservableList<Devoir> liste, String id) {
        for (Devoir next : liste) {
            if (next.idDevoir.equals(id)) {
                return next;
            }
        }
        return null;
    }

    //Retourne La matière dont l'Id est égal à celui passé en paramètre, parmis les matières de la liste passée en paramètre
    public static Matiere getMatiereById(ObservableList<Matiere> liste, String id) {
        for (Matiere next : liste) {
            if (next.idMatiere.equals(id)) {
                return next;
            }
        }
        return null;
    }
}
