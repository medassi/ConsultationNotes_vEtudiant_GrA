package com.medassi.consultationnotes.tools;

import com.medassi.consultationnotes.entities.Etudiant;
import com.medassi.consultationnotes.entities.Matiere;
import com.medassi.consultationnotes.entities.Resultat;
import com.medassi.consultationnotes.entities.Devoir;
import javafx.collections.ObservableList;

public class OutilsCalculs {
    //retourne la moyenne des notes obtenues au devoir "unDevoir" passé en paramètre
    public static float moyenneDevoir(ObservableList<Resultat> lesResultats, Devoir unDevoir) {
        float totalNote = 0;
        int nbNotes = 0;
        for (Resultat r : lesResultats) {
            if (r.devoir == unDevoir) {
                totalNote += r.note;
                nbNotes++;
            }
        }
        return totalNote / nbNotes;
    }
    
    //retourne la moyenne des notes de la matière "uneMatiere" passée en paramètre
    public static float moyenneMatiere(ObservableList<Resultat> lesResultats, Matiere uneMatiere) {
        float sommeCoeffs = 0 ;
        float totalNote = 0 ;
        for( Resultat r : lesResultats ){
            if( r.devoir.matiere == uneMatiere){
                totalNote = totalNote + ( r.note * r.devoir.coeffDevoir ) ;
                sommeCoeffs = sommeCoeffs + r.devoir.coeffDevoir ;
            }
        }
        return totalNote / sommeCoeffs ;
    }
    
    //retourne la moyenne des notes obtenues par l'étudiant "unEtudiant" passé en paramètre dans la matière "uneMatiere" passée en paramètre
    public static float moyenneEtudiantMatiere(ObservableList<Resultat> lesResultats, Matiere uneMatiere, Etudiant unEtudiant) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne la moyenne générale de l'étudiant "unEtudiant" passé en paramètre
    public static float moyenneEtudiant(ObservableList<Resultat> lesResultats, ObservableList<Matiere> lesMatieres, Etudiant unEtudiant) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne la moyenne générale de toutes les moyennes des étudiants 
    public static float moyenne(ObservableList<Resultat> lesResultats, ObservableList<Matiere> lesMatieres, ObservableList<Etudiant> lesEtudiants) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne l'étudiant qui a obtenu la moyenne générale la plus faible 
    public static Etudiant moyenneEtudiantMini(ObservableList<Resultat> ns, ObservableList<Etudiant> es, ObservableList<Matiere> ms) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne l'étudiant qui a obtenu la moyenne générale la plus forte 
    public static Etudiant moyenneEtudiantMaxi(ObservableList<Resultat> lesResultats, ObservableList<Etudiant> lesEtudiants, ObservableList<Matiere> lesMatieres) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne l'étudiant qui a obtenu la moyenne générale la plus faible dans la matière "uneMatiere" passée en paramètre 
    public static Etudiant moyenneEtudiantMatiereMini(ObservableList<Resultat> lesResultats, ObservableList<Etudiant> lesEtudiants, Matiere uneMatiere) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne l'étudiant qui a obtenu la moyenne générale la plus forte dans la matière "uneMatiere" passée en paramètre
    public static Etudiant moyenneEtudiantMatiereMaxi(ObservableList<Resultat> lesResultats, ObservableList<Etudiant> lesEtudiants, Matiere uneMatiere) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne l'étudiant qui a obtenu la note la plus haute pour le devoir "unDevoir" passé en paramètre
    public static Etudiant noteEtudiantDevoirMaxi(ObservableList<Resultat> lesResultats, Devoir unDevoir) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne l'étudiant qui a obtenu la note la plus basse pour le devoir "unDevoir" passé en paramètre
    public static Etudiant noteEtudiantDevoirMini(ObservableList<Resultat> lesResultats, Devoir unDevoir) {
        throw new UnsupportedOperationException("A faire !!!");
    }
    
    //retourne la note de l'étudiant "unEtudiant" passé en paramètre dans le devoir "unDevoir" passé en paramètre
    public static float rechercherNoteDevoirEtudiant(ObservableList<Resultat> lesResultats, Devoir unDevoir, Etudiant unEtudiant) {
        throw new UnsupportedOperationException("A faire !!!");
    }

}
