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
        //Redefinition du deplacement 
        ArrayList<Tuile> horizontalEtVetical =  super.déplacementPossible(grille);
        ArrayList<Tuile> diagonal =  grille.getTuileDeplacementDiagonale(position);
        ArrayList<Tuile> deplacementTotal = new ArrayList<Tuile> ();
        
        for(int i=0;i<diagonal.size();i++ ){
            deplacementTotal.add(diagonal.get(i));
        }
        for(int i=0;i<horizontalEtVetical.size();i++ ){
            deplacementTotal.add(horizontalEtVetical.get(i));
        }
        
        return deplacementTotal;
        
        }    
    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        //Redefinition de l'assechement
        ArrayList<Tuile> horizontalEtVetical =  super.assèchementPossible(grille);
        ArrayList<Tuile> diagonal =  grille.assèchementPossibleDiagonale(position);
        ArrayList<Tuile> assechementTotale = new ArrayList<Tuile> ();
        
        for(int i=0;i<diagonal.size();i++ ){
            assechementTotale.add(diagonal.get(i));
        }
        for(int i=0;i<horizontalEtVetical.size();i++ ){
            assechementTotale.add(horizontalEtVetical.get(i));
        }
        
        return assechementTotale;

    }


    @Override
    public String getRôle() {
        return "Explorateur";
    }

    
}
