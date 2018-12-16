/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Aventuriers;
import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.EtatCase;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;
import java.util.Scanner;

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
      public void deplacement(Tuile t){
        this.setPosition(t);
    }
    public void assechement(Tuile t){
        t.setEtatCase(EtatCase.NORMAL);
    }
    
    public void ouAller(Grille grille){
    ArrayList<Tuile> deplacementPossible = new ArrayList();
    deplacementPossible = this.déplacementPossible(grille);// faire en sorte que l'on calcule ses mouvement possible puis qu'on l'affiche sur la grille/consonle
    for (int i =0; i < deplacementPossible.size();i++){
        System.out.println(i + " : " + deplacementPossible.get(i).getNomTuile());
    }
    System.out.println("Entrez le numéro de la tuile où vous souhaitez aller");
    Scanner scanner = new Scanner(System.in);
    String numeroTuile = scanner.nextLine();


        for(int j =0; j < deplacementPossible.size();j++){
                    if (numeroTuile.equals(Integer.toString(j))) {
                    this.deplacement(deplacementPossible.get(j));
                    System.out.println("Vous serez déplacé sur la tuile : " + deplacementPossible.get(j).getNomTuile());
                    }



        }

}
    
}
