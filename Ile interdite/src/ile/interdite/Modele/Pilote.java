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
public class Pilote extends Aventurier{
    private final Couleur couleur;
    private final Tuile position = new Tuile(1,"Heliport");
    
    public Pilote(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.BLEU;
    }
    public Pilote(String pseudo){
        super(pseudo);
        this.couleur = Couleur.BLEU;
    }


    @Override
    public int[][] déplacementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRôle() {
        return "Pilote";
    }
}
