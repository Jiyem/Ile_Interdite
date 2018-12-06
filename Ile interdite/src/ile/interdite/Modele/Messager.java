/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

/**
 *
 * @author rose
 */
public class Messager extends Aventurier{
    private Tuile tuile;
    private final Couleur couleur;
    
    public Messager(Tuile tuile){
        this.setPosition(tuile);
        this.couleur = Couleur.BLANC;
    }

    @Override
    public int[][] déplacementPossible(Grille grille) {
        return grille.getTuilesAdjacentesHorizontalesVerticales(tuile);
    }

    @Override
    public int[][] assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
