/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion;

/**
 *
 * @author chapellr
 */
public class Case {
    private int numCase;
    private Joueur joueurAyantCoché;
    
    public Case(int c){
        this.numCase= c;
        this.joueurAyantCoché = null;
    }
    
        public Case(int c, Joueur j){
        this.numCase= c;
        this.joueurAyantCoché = j;
    }

    /**
     * @return the numCase
     */
    public int getNumCase() {
        return numCase;
    }

    /**
     * @return the joueurAyantCoché
     */
    public Joueur getJoueurAyantCoché() {
        return joueurAyantCoché;
    }

    /**
     * @param joueurAyantCoché the joueurAyantCoché to set
     */
    public void setJoueurAyantCoché(Joueur joueurAyantCoché) {
        this.joueurAyantCoché = joueurAyantCoché;
    }
}
