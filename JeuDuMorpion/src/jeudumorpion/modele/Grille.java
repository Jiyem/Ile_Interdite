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
    private ArrayList caseslibre = new ArrayList<Case>(); // cases libre
    private ArrayList casesCoche = new ArrayList<Case>(); // cases coché
    
    
    
    public Grille(){
        int nb=1;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                this.cases[x][y].setNumCase(nb);
                nb = nb+1;
            }
        }
    }
    // verification de la case si elle appartient aux cases cochées ou non
    public void addCaseCoché(Case coche){
        this.casesCoche.add(coche);
        this.caseslibre.remove(coche);
    }
    public void reset(){
        for(int i=0; i<casesCoche.size();i++){
          //  this.casesCoche.get(i).
        }
    } 
    //mettre tout les cas possible pour voir si il y a un gagnant
    public Signe Gagnant(Signe s){
        if (this.cases[1][1].getJoueurAyantCoché().equals(s)){            
            if(s.equals(this.cases[0][0].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[2][2].getJoueurAyantCoché().getSigne())){ // diagonal haut gauche
                return s;  
            }
            else if(s.equals(this.cases[0][2].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[2][0].getJoueurAyantCoché().getSigne())){ // diagonal haut droite
                return s;    
            }
            else if(s.equals(this.cases[0][1].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[2][1].getJoueurAyantCoché().getSigne())){ //verticale milieu
                return s;
            }
            else if(s.equals(this.cases[1][0].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[1][2].getJoueurAyantCoché().getSigne())){ //horizontal milieu
                return s;
            }            
        }
        else if(this.cases[0][1].getJoueurAyantCoché().equals(s)){ //horizontal haut
            if(s.equals(this.cases[0][0].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[0][2].getJoueurAyantCoché().getSigne())){
                return s;
            }
        }
        else if(this.cases[2][1].getJoueurAyantCoché().equals(s)){ //horizontal bas
            if(s.equals(this.cases[2][0].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[2][2].getJoueurAyantCoché().getSigne())){
                return s;
            } 
            
        }
        else if(this.cases[1][0].getJoueurAyantCoché().equals(s)){ //vertical gauche
            if(s.equals(this.cases[0][0].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[0][2].getJoueurAyantCoché().getSigne())){
                return s;    
            } 
            
        }
        else if(this.cases[1][2].getJoueurAyantCoché().equals(s)){ // vertical droite
            if(s.equals(this.cases[0][2].getJoueurAyantCoché().getSigne()) && s.equals(this.cases[2][2].getJoueurAyantCoché().getSigne())){
                return s;
            } 
            
        }
        return null;

    }
}
