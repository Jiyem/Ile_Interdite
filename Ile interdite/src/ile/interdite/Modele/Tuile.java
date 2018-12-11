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
    private EtatCase etatCase;
    private int X,Y;
    
    
    public Tuile(int numTuile,String nomTuile,int X, int Y){
        this.setNumTuile(numTuile);
        this.setNomTuile(nomTuile);
        this.etatCase = EtatCase.NORMAL;
        this.X=X;
        this.Y=Y;
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

    /**
     * @return the X
     */
    public int getX() {
        return X;
    }

    /**
     * @return the Y
     */
    public int getY() {
        return Y;
    }

    /**
     * @return the etatCase
     */
    public EtatCase getEtatCase() {
        return etatCase;
    }

    /**
     * @param etatCase the etatCase to set
     */
    public void setEtatCase(EtatCase etatCase) {
        this.etatCase = etatCase;
    }
    
}
