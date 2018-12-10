/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;
import Aides.Utils;
import Aides.Utils.EtatTuile;
import java.util.ArrayList;
/**
 *
 * @author rose
 */
public class Messager extends Aventurier{
    private final Couleur couleur;
    private final Tuile position=null;
    
    public Messager(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.BLANC;
    }

    public Messager(String pseudo){
        super(pseudo);
        this.couleur = Couleur.BLANC;
    }
    
    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille) {
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = grille.getTuile();
        if(tuiles[position.getX()+1][position.getY()] != null || tuiles[position.getX()+1][position.getY()].getEtatCase() == EtatCase.IMMERGEE){
            tuilepossibles.add(tuiles[position.getX()+1][position.getY()]); //Donne la position d'une case à droite
        }
        if(tuiles[position.getX()-1][position.getY()] != null || tuiles[position.getX()-1][position.getY()].getEtatCase() == EtatCase.IMMERGEE){
        tuilepossibles.add(tuiles[position.getX()-1][position.getY()]); //Donne la position d'une case à gauche
        }; 
        if(tuiles[position.getX()][position.getY()+1] != null || tuiles[position.getX()][position.getY()+1].getEtatCase() == EtatCase.IMMERGEE){
            tuilepossibles.add(tuiles[position.getX()][position.getY()+1]);//Donne la position d'une case a dessus
        } 
        if(tuiles[position.getX()][position.getY()-1] != null || tuiles[position.getX()][position.getY()-1].getEtatCase() == EtatCase.IMMERGEE){
            tuilepossibles.add(tuiles[position.getX()][position.getY()-1]); //Donne la position une case plus basse
        } 
        return tuilepossibles;
    }

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        ArrayList<Tuile> assechPossible = new ArrayList<>();
        if(position.getX()!=5){
            if(grille.getTuile()[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()]); //case à droite de l'aventurier
        }}
        if(position.getX()!=0){
             if(grille.getTuile()[position.getX()-1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()-1][position.getY()]); //case à gauche de l'aventurier
        }}
        if(position.getY()!=5){
             if(grille.getTuile()[position.getX()][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()][position.getY()+1]); //case en bas de l'aventurier
        }}
        if( position.getY()!=0){
             if(grille.getTuile()[position.getX()][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(grille.getTuile()[position.getX()+1][position.getY()-1]); //case en haut de l'aventurier
        }}
        return assechPossible;
    }

    @Override
    public String getRôle() {
        return "Messager";
    }

}
