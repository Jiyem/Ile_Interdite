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
public class Navigateur extends Aventurier{
    private Tuile position;
    private final Couleur couleur;
    private final String pseudo;
    
    public Navigateur(Tuile position,String pseudo){
        this.setPosition(position);
        this.couleur = Couleur.ROUGE;
        this.pseudo = pseudo;
    }
    


    @Override
    public int[][] déplacementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
