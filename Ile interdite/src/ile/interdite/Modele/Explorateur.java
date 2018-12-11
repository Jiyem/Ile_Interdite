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
        ArrayList<Tuile> assechPossible = new ArrayList<>();
        if(position.getX()!=5){
            if(grille.getTuile()[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()]);  //case à droite de l'aventurier
        }}
        if(position.getX()!=0){
             if(grille.getTuile()[position.getX()-1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()-1][position.getY()]);  //case à gauche de l'aventurier
        }}
        if(position.getY()!=5){
             if(grille.getTuile()[position.getX()][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()][position.getY()+1]);  //case en dessous de l'aventurier
        }}
        if( position.getY()!=0){
             if(grille.getTuile()[position.getX()][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()][position.getY()-1]);  //case au dessus de l'aventurier
        }}
        if(position.getX()!=5 && position.getY()!=5){
            if(grille.getTuile()[position.getX()+1][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()+1]);  //case en diagonale bas-droite
        }}
        if(position.getX()!=5 && position.getY()!=0){
            if(grille.getTuile()[position.getX()+1][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()-1]);  //case en diagonale haut-droite
        }}
        if(position.getX()!=0 && position.getY()!=5){
            if(grille.getTuile()[position.getX()-1][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()-1][position.getY()+1]);  //case en diagonale bas-gauche
        }}
        if(position.getX()!=0 && position.getY()!=0){
            if(grille.getTuile()[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()-1][position.getY()-1]);  //case en diagonale bas-droite
        }}
        return assechPossible;
    }


    @Override
    public String getRôle() {
        return "Explorateur";
    }
    
    
}
