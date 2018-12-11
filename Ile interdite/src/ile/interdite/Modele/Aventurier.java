/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;
import java.util.ArrayList;

/**
 *
 * @author domestit
 */
public abstract class Aventurier {

    /**
     * @return the couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    //attributs
    protected Tuile position; // Il faudra faire un equal entre String pour la trouver sur le plateau || Faire les setter
    protected Couleur couleur; // Faire setter
    protected String pseudo;
    //constructeurs
    public Aventurier(Tuile position,String pseudo){
        this.setPosition(position);
        this.setPseudo(pseudo);
        this.setCouleur(null);
    }
    public Aventurier(String pseudo){
        this.setPseudo(pseudo);
        this.setCouleur(null);
    }
    //méthodes
    public abstract ArrayList<Tuile> déplacementPossible(Grille grille);
    
    public abstract ArrayList<Tuile> assèchementPossible(Grille grille);
    
    public abstract String getRôle();
    
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
    
    
}
