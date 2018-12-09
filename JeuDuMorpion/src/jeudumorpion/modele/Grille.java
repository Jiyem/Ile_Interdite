/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion.modele;

import java.util.ArrayList;

/**
 *
 * @author miras
 */
public class Grille {
    private Case cases[][] = new Case[3][3];
    private ArrayList casesCoche = new ArrayList();
    
    
    
    public Grille(){
        int nb=1;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                this.cases[x][y].setNumCase(nb);
                nb = nb+1;
            }
        }
    }
    // verification de la case si elle appartient aux case coché ou nom
    public void addCaseCoché(Case coche){
        this.casesCoche.add(coche);
        
    }
    //mettre tout les cas possible pour voir si il y a un gagnant
    public Signe Gagnant(){
        if (this.cases[1][1].getJoueurAyantCoché()!=null){
            Signe s = this.cases[1][1].getJoueurAyantCoché().getSigne();
            if(s.equals(this.cases[0][0].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[2][2].getJoueurAyantCoché().getSigne())){
                return s;  
            }
//            else if(){
                    
//                    }
            
        }
        return null;

    }
}
