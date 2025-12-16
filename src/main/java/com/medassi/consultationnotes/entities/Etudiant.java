package com.medassi.consultationnotes.entities;

public class Etudiant {

    public String idEtudiant;
    public String nomEtudiant;
    public String prenomEtudiant;

    @Override
    public String toString() {
        return nomEtudiant + " " + prenomEtudiant;
    }

}
