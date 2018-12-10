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
    private final Couleur couleur;
    private final Tuile position = new Tuile(1, "La Porte de Fer",1,1);
    
    public Plongeur(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.VIOLET;
    }

    public Plongeur(String pseudo){
        super(pseudo);
        this.couleur = Couleur.VIOLET;

    }
        @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = grille.getTuile();
        
        int i= 0;
        while(tuiles[position.getX()+i][position.getY()] != null && tuiles[position.getX()+i][position.getY()].getEtatCase() == EtatCase.IMMERGEE){
            tuilepossibles.add(tuiles[position.getX()+i][position.getY()]);
            i = i+1;
            int j= 0;
            while(tuiles[position.getX()+i][position.getY()+j] != null && tuiles[position.getX()+i][position.getY()+j].getEtatCase() == EtatCase.IMMERGEE){
                tuilepossibles.add(tuiles[position.getX()+j][position.getY()]);
                j = j+1;
            }
            int u = 1;
            while(tuiles[position.getX()+i][position.getY()-u] != null && tuiles[position.getX()+i][position.getY()-u].getEtatCase() == EtatCase.IMMERGEE){
            tuilepossibles.add(tuiles[position.getX()][position.getY()+u]); //Verification de s'il peut nager plus loin que prévu
            u = u+1;
        }
        }
        int a = 0;
        while(tuiles[position.getX()-a][position.getY()] != null && tuiles[position.getX()+a][position.getY()].getEtatCase() == EtatCase.IMMERGEE){
            tuilepossibles.add(tuiles[position.getX()-a][position.getY()]);
            i = i+1;
            int j= 0;
            while(tuiles[position.getX()-a][position.getY()+j] != null && tuiles[position.getX()+i][position.getY()+j].getEtatCase() == EtatCase.IMMERGEE){
                tuilepossibles.add(tuiles[position.getX()+j][position.getY()]);
                j = j+1;
            }
            int u = 1;
            while(tuiles[position.getX()+i][position.getY()-u] != null && tuiles[position.getX()+i][position.getY()-u].getEtatCase() == EtatCase.IMMERGEE ){
            tuilepossibles.add(tuiles[position.getX()][position.getY()+u]); //Verification de s'il peut nager plus loin que prévu
            u = u+1;
        }
        }
        
        return tuilepossibles;
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
