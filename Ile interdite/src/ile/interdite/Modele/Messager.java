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
public class Messager extends Aventurier{
    private final Couleur couleur;
    private final Tuile position;
    
    public Messager(Tuile position,String pseudo{
        super(position,pseudo);
        this.couleur = Couleur.BLANC;
    }

    public Messager(String pseudo){
        super(pseudo);
        this.couleur = Couleur.BLANC;
    }
    
    @Override
    public int[][] déplacementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet.");
//        return grille.getTuilesAdjacentesHorizontalesVerticales(position);
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
        return "Messager";
    }

}
