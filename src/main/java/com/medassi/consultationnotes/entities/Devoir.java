package com.medassi.consultationnotes.entities;

public class Devoir {
    public String idDevoir ;
    public String libelleDevoir ;
    public float coeffDevoir ;
    public Matiere matiere ;

    @Override
    public String toString() {
        return libelleDevoir+ "("+coeffDevoir+")";
    }
    
}
