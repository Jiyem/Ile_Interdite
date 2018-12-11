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
public class Plongeur extends Aventurier{
    
    public Plongeur(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.VIOLET);
    }

    public Plongeur(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.VIOLET);

    }
        @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        return grille.getTuileDeplacementPlongeur(position);
        }    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        ArrayList<Tuile> assechPossible = new ArrayList<>();
        if(position.getX()!=5){
            if(grille.getTuile()[position.getX()+1][position.getY()].getEtatCase() == EtatCase.IMMERGEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()]);
        }}
        if(position.getX()!=0){
             if(grille.getTuile()[position.getX()-1][position.getY()].getEtatCase() == EtatCase.IMMERGEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()]);
        }}
        if(position.getY()!=5){
             if(grille.getTuile()[position.getX()][position.getY()+1].getEtatCase() == EtatCase.IMMERGEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()]);
        }}
        if(position.getY()!=0){
             if(grille.getTuile()[position.getX()][position.getY()-1].getEtatCase() == EtatCase.IMMERGEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()]);
        }}
        return assechPossible;
    }


    @Override
    public String getRôle() {
        return "Plongeur";
    }
}
