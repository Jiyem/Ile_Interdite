/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;

import static ile.interdite.Modele.EtatCase.INNONDEE;
import static ile.interdite.Modele.EtatCase.NORMAL;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;

/**
 *
 * @author anandanj
 */
public class CarteSacDeSable extends CarteTirage {
    public CarteSacDeSable(){
        super(TypeCarte.SacDeSable);
    }
    
    //Méthode qui renvoie la liste des tuiles qui sont assèchable avec un sac de sable avec pour paramètre d'entrée une grille..
    public ArrayList<Tuile> assechable(Grille grille){
        ArrayList<Tuile> tuilesAssechable = new ArrayList<>();
        Tuile[][] tuiles = grille.getTuile();
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if(tuiles[y][x].getEtatCase()==INNONDEE){
                    tuilesAssechable.add(tuiles[y][x]);
                }
            }
        }
        return tuilesAssechable;
    }
    
    
    //Méthode qui effectue l'assèchement de la carte sac de sable.
    public void assecher(Tuile tuile){
        tuile.setEtatCase(NORMAL);
    }
    
    public String toString(){
        return "Sac de sable";
    }
    
    
}
