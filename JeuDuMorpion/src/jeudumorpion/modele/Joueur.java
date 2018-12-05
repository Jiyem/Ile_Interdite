/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion.modele;
import java.util.ArrayList;
/**
 *
 * @author chapellr
 */
public class Joueur {
    private ArrayList<Case> casesCochée = new ArrayList<>();
    private Signe signe;
    
    public Joueur(){
        this.casesCochée = null;
        this.signe = null;
    }

    
    public void addCase(Case c){
        if (this.casesCochée.size() < 6) {
           this.casesCochée.add(c); 
        }
        else {
            System.out.println("Vous ne pouvez pas cocher une case de plus.");
        }
        
    }
    
    
    /**
     * @return the signe
     */
    public Signe getSigne() {
        return signe;
    }

    /**
     * @param signe the signe to set
     */
    public void setSigne(Signe signe) {

        this.signe = signe;
    }
    
    
}
