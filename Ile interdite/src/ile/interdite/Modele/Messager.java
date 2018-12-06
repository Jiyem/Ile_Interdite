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
    private final Couleur couleur;
    private final Tuile position = new Tuile(1, "La Porte d'Argent");
    
    public Messager(Tuile position,String pseudo){
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
    public int[][] assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRôle() {
        return "Messager";
    }

}
