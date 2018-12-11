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

    
    public Messager(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.ORANGE);
    }

    public Messager(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.ORANGE);    }
    
    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille) {
        return grille.getTuilehorizontaleEtVerticale(position);
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
