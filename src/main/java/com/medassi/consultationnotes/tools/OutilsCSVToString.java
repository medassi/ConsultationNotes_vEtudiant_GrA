package com.medassi.consultationnotes.tools;

import com.medassi.consultationnotes.App;
import java.util.Scanner;

public class OutilsCSVToString {

    public static String chargerDepuisFichier(String nomFichier) {
        String retour = "";
        Scanner sc = new Scanner(App.class.getResourceAsStream(nomFichier), "UTF-8");
        if (sc.nextLine() != "") {
            while (sc.hasNext()) {
                retour += sc.nextLine() + "\n";
            }
        }
        return retour;
    }

    public static String extraireLigne(String lesDonnees, int numero) {
        return lesDonnees.split("\n")[numero];
    }

    public static String extraireValeur(String uneLigne, int colonne) {
        return uneLigne.split("\t")[colonne];
    }

    public static int nbLignes(String lesDonnees) {
        return lesDonnees.split("\n").length;
    }
}
