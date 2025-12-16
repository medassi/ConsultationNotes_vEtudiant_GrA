package com.medassi.consultationnotes.entities;

public class Matiere {
    public String idMatiere ;
    public String libelleMatiere ;
    public float coeffMatiere ;

    @Override
    public String toString() {
        return libelleMatiere+"("+coeffMatiere+")";
    }
    
}
