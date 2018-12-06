/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

/**
 *
 * @author domestit
 */
public abstract class Aventurier {
    //attributs
    private Tuile position;
    private final Couleur couleur;
    private String pseudo;
    //constructeurs
    Aventurier(Tuile position,String pseudo){
        this.setPosition(position);
        this.setPseudo(pseudo);
        this.couleur = null;
    }
    //méthodes
    public abstract int[][] déplacementPossible(Grille grille);
    
    public abstract int[][] assèchementPossible(Grille grille);
    
    public Tuile getPosition(){
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Tuile position) {
        this.position = position;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    
}
