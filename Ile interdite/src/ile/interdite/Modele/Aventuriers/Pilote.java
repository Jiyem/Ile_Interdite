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
public class Pilote extends Aventurier{
    private boolean helico;
    
    public Pilote(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.BLEU);
        this.helico=true;
    }
    public Pilote(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.BLEU);
        this.helico=true;
    }


    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        if(this.helico==true){
            helico=false;
            return grille.déplacementPossiblePilote(grille);
        }else{
            return grille.getTuilehorizontaleEtVerticale(position);
        }
    }

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
       return grille.assèchementPossible(position);
    }

    @Override
    public String getRôle() {
        return "Pilote";
    }

    /**
     * @param helico the helico to set
     */
    @Override
    public void setHelico(boolean helico) {
        this.helico = helico;
    }
}
