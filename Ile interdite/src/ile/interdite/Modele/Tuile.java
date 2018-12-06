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
public class Tuile {
    private int numTuile;
    private String nomTuile;
    
    
    public Tuile(int numTuile,String nomTuile){
        this.setNumTuile(numTuile);
        this.setNomTuile(nomTuile);
    }

    /**
     * @return the numTuile
     */
    public int getNumTuile() {
        return numTuile;
    }

    /**
     * @param numTuile the numTuile to set
     */
    public void setNumTuile(int numTuile) {
        this.numTuile = numTuile;
    }

    /**
     * @return the nomTuile
     */
    public String getNomTuile() {
        return nomTuile;
    }

    /**
     * @param nomTuile the nomTuile to set
     */
    public void setNomTuile(String nomTuile) {
        this.nomTuile = nomTuile;
    }
    
}
