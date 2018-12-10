/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rose
 */
public class Grille {

    //chercher quel type de colection pour les 36 tuiles de la grille
    private final Tuile tuile[][] = new Tuile[6][6];
    private ArrayList<String> tuilesUtilisé = new ArrayList();
    private ArrayList<String> tuilesDispo = new ArrayList();
    private ListeTuiles liste = new ListeTuiles();



    public void initialiseArray() {
        for (int i = 0; i < 24; i++) {
            this.tuilesDispo.add(i, liste.get(i));
        }

    }

    public Grille() {
        this.initialiseArray();
        int nb = 0;
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {

                if ((y == 0 && x == 0) || (y == 0 && x == 1) || (y == 0 && x == 4) || (y == 0 && x == 5) || (y == 1 && x == 0) || (y == 1 && x == 5) || (y == 4 && x == 0) || (y == 4 && x == 5) || (y == 5 && x == 0) || (y == 5 && x == 1) || (y == 5 && x == 4) || (y == 5 && x == 5)) {

                } else {
                    nb = nb + 1;
                    this.tuile[y][x] = new Tuile(nb, tuilesDispo.get(0),y,x);
                    this.tuilesUtilisé.add(tuilesDispo.get(0));
                    this.tuilesDispo.remove(tuilesDispo.get(0));

                }
            }

        }

    }

    
    

    public void remetTuileDispo(){
    for (int i=0;i<24;i++){
        this.tuilesDispo.add(tuilesUtilisé.get(0));
        this.tuilesUtilisé.remove(tuilesUtilisé.get(0));
        
    }
    
    }
    public void melange() {
        Collections.shuffle(tuilesDispo);
    }
    
    public Tuile[][] getTuile(){
        return this.tuile;
    }
}
