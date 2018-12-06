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
    //constructeurs
    Aventurier(Tuile pos){
        this.position=pos;
    }
    //méthodes
    public abstract boolean déplacementPossible(Grille grille);
    
    public abstract boolean assèchementPossible(Tuile tuile);
    
    public Tuile getPosition(){
        return position;
    }
    
    
}
