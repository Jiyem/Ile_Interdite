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
public class Plongeur extends Aventurier{
    
    public Plongeur(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.VIOLET);
        this.setImage("plongeur");
        this.setPion("pionViolet");
    }

    public Plongeur(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.VIOLET);
        this.setImage("plongeur");
        this.setPion("pionViolet");

    }
        @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        return grille.getTuileDeplacementPlongeur(position);
        }    
    
    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        return grille.assèchementPossible(position);
    }
    
    //Comme les assechements du plongeur sont basiques pas besoin de redefinir les fonctions

    @Override
    public String getRôle() {
        return "plongeur";
    }

}
