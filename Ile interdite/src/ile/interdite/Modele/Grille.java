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
    private ArrayList<String> tuilesUtilisé = new ArrayList(); 
    private ArrayList<String> tuilesDispo = new ArrayList();
    private ListeTuiles liste;
    public Grille(){
        
    }
    
    public void initialiseArray(){
        for (int i =0; i<24; i++){
            this.tuilesDispo.add(i, liste.toString());
        }
        
    }
    public Grille(ArrayList tuiles){
        this.initialiseArray();
        for (int x=0;  x< 5; x++  ){
            for(int y=0; y<5; y++){
                int nb = x*y;
                if ((x==0 && y==0) ||(x==0 && y==1)||(x==0 && y==4)||(x==0 && y==5)||(x==1 && y==0)||(x==1 && y==5)||(x==4 && y==0)||(x==4 && y==5)||(x==5 && y==0)||(x==5 && y==1)||(x==5 && y==4)||(x==5 && y==5) ){
                    
                } 
                else {                
                this.tuile[x][y] =new Tuile(nb,tuilesDispo.get(nb));
                this.tuilesUtilisé.add(tuilesDispo.get(nb));
                this.tuilesDispo.remove(tuilesDispo.get(nb));
                
                }
            }
        
    }
    }
}
