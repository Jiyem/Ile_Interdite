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
    private final Couleur couleur;
    private final Tuile position = new Tuile(1,"Heliport",1,1);
    
    public Pilote(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.BLEU;
    }
    public Pilote(String pseudo){
        super(pseudo);
        this.couleur = Couleur.BLEU;
    }


       @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = grille.getTuile();
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if(tuiles[x][y]!=null && tuiles[x][y].getEtatCase()!= EtatCase.IMMERGEE){
                    tuilepossibles.add(tuiles[x][y]);
                }
            }
        }
        
        return tuilepossibles;
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
