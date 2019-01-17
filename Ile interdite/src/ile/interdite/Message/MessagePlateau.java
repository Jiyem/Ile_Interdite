/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Message;

import ile.interdite.Message.Message;
import ile.interdite.Modele.Aventuriers.Aventurier;

/**
 *
 * @author mirasl
 */
public class MessagePlateau extends Message{

    /**
     * @return the joueur
     */
    public Aventurier getJoueur() {
        return joueur;
    }
    private int x;
    private int y;
    private int numBouton;
    
    
    private Aventurier joueur;
    
    public MessagePlateau(ActionsType action, int y, int x, int num){
        super(action);
        setX(x);
        setY(y);
        setNumBouton(num);
        
        
        joueur =null;
    }
    public MessagePlateau(ActionsType action, Aventurier joueur){
        super(action);
        setX(100);
        setY(100);
        setNumBouton(100);
        
        
        this.joueur =joueur;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the numBouton
     */
    public int getNumBouton() {
        return numBouton;
    }

    /**
     * @param numBouton the numBouton to set
     */
    public void setNumBouton(int numBouton) {
        this.numBouton = numBouton;
    }
    
}
