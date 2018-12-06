/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import java.util.ArrayList;

/**
 *
 * @author rose
 */
public class Grille {
    //chercher quel type de colection pour les 36 tuiles de la grille
    private final Tuile tuile[][] = new Tuile[6][6];
    private ArrayList tuiles = new ArrayList();
    
    public Grille(){
        
    }
    
    public void initialiseArray(){
        this.tuiles.addAll(tuiles);
    }
    
}
