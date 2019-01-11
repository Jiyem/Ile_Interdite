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
public class Navigateur extends Aventurier{
    
    public Navigateur(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.JAUNE);
    }
    public Navigateur(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.JAUNE);
        
    }
    //Comme les deplacements et les assechements du navigateur sont basiques pas besoin de redefinir les fonctions
    
    @Override
    public String getRôle() {
        return "Navigateur";
    }

}
