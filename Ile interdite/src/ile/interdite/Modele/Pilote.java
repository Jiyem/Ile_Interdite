/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import java.util.ArrayList;

/**
 *
 * @author rose
 */
public class Pilote extends Aventurier{

    
    public Pilote(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.BLEU);
    }
    public Pilote(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.BLEU);
    }


    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        return grille.déplacementPossiblePilote(grille);
        
        }
        
            
    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRôle() {
        return "Pilote";
    }
}
