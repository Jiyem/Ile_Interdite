/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Aventuriers;

import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;

/**
 *
 * @author rose
 */
public class Explorateur extends Aventurier{   
 
    
    public Explorateur(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.VERT);

    }
    
    public Explorateur(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.VERT);

    }

    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        return grille.getTuilehorizontaleEtVerticaleEtDiagonal(position);
        }    
    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        return grille.assèchementPossibleExplorateur(position);
    }


    @Override
    public String getRôle() {
        return "Explorateur";
    }

    
}
