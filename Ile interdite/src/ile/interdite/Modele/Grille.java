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
    
    public ArrayList<Tuile> getTuilehorizontaleEtVerticale(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
        //Si la tuile existe ( != null) et que son état n'est pas IMMERGEE on l'ajoute aux possibilitées
        if(tuile[position.getX()+1][position.getY()] != null && tuile[position.getX()+1][position.getY()].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()+1][position.getY()]); //Donne la position de la case à droite
        }
        if(tuile[position.getX()-1][position.getY()] != null && tuile[position.getX()-1][position.getY()].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()-1][position.getY()]); //Donne la position de la case à gauche
        } 
        if(tuile[position.getX()][position.getY()+1] != null && tuile[position.getX()][position.getY()+1].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()][position.getY()+1]);//Donne la position de la case au dessus
        } 
        if(tuile[position.getX()][position.getY()-1] != null && tuile[position.getX()][position.getY()-1].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()][position.getY()-1]); //Donne la position de la case en bas
        } 
        return lDeplacementDispo;
    }
    
    public ArrayList<Tuile> getTuilehorizontaleEtVerticaleEtDiagonal(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
 
        lDeplacementDispo = this.getTuilehorizontaleEtVerticale(position);
        
        if(tuile[position.getX()+1][position.getY()+1] != null && tuile[position.getX()+1][position.getY()+1].getEtatCase() != EtatCase.IMMERGEE ){
            lDeplacementDispo.add(tuile[position.getX()+1][position.getY()+1]); //Donne la position une case plus basse a droite
        }
        if(tuile[position.getX()+1][position.getY()-1] != null && tuile[position.getX()+1][position.getY()-1].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()+1][position.getY()-1]); //Donne la position une case plus basse a gauche
        } 
        if(tuile[position.getX()-1][position.getY()+1] != null && tuile[position.getX()-1][position.getY()+1].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()-1][position.getY()+1]); //Donne la position une case plus haute a droite
        }
        if(tuile[position.getX()-1][position.getY()-1] != null && tuile[position.getX()-1][position.getY()-1].getEtatCase() != EtatCase.IMMERGEE){
            lDeplacementDispo.add(tuile[position.getX()-1][position.getY()-1]); //Donne la position une case plus haute a gauche
        } 
        return lDeplacementDispo;
    }
    public ArrayList<Tuile> getTuileAdjacenteImmergéesOuInnondee(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
        lDeplacementDispo = this.getTuilehorizontaleEtVerticale(position);

        if(tuile[position.getX()+1][position.getY()] != null && ((tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE) || tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.IMMERGEE)){
               lDeplacementDispo.add(tuile[position.getX()+1][position.getY()]); //Donne la position de la case à droite IMMERGEE ou INNONDEE  
        }
        if(tuile[position.getX()-1][position.getY()] != null && ((tuile[position.getX()-1][position.getY()].getEtatCase() == EtatCase.INNONDEE) || tuile[position.getX()-1][position.getY()].getEtatCase() == EtatCase.IMMERGEE)){
            lDeplacementDispo.add(tuile[position.getX()-1][position.getY()]); //Donne la position de la case à IMMERGEE
        } 
        if(tuile[position.getX()][position.getY()+1] != null && ((tuile[position.getX()][position.getY()+1].getEtatCase() == EtatCase.INNONDEE) || tuile[position.getX()][position.getY()+1].getEtatCase() == EtatCase.IMMERGEE)){
            lDeplacementDispo.add(tuile[position.getX()][position.getY()+1]);//Donne la position de la case au IMMERGEE
        } 
        if(tuile[position.getX()][position.getY()-1] != null && ((tuile[position.getX()][position.getY()-1].getEtatCase() == EtatCase.INNONDEE) || tuile[position.getX()][position.getY()-1].getEtatCase() == EtatCase.IMMERGEE)){
            lDeplacementDispo.add(tuile[position.getX()][position.getY()-1]); //Donne la position de la case en IMMERGEE
        } 
        return lDeplacementDispo;
    }
    
    public ArrayList<Tuile> getTuileDeplacementPlongeur(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
        ArrayList<Tuile> lCaseImmergeeDispoDeplacement = new ArrayList<>();
        ArrayList<Tuile> lDeplacementCaseAdjacente = new ArrayList<>();
        
        lDeplacementDispo = this.getTuilehorizontaleEtVerticale(position); //On prend tout d'abord les cases non immergées autour du hero
        lCaseImmergeeDispoDeplacement =  this.getTuileAdjacenteImmergéesOuInnondee(position);//On prend ensuite les cases immergées/innondées autour du hero
        
        for(int i=0;i < lCaseImmergeeDispoDeplacement.size();i++){ //Tant qu'il existe des cases immergées 
            lDeplacementCaseAdjacente = this.getTuileAdjacenteImmergéesOuInnondee(lCaseImmergeeDispoDeplacement.get(i)); //On regarde la case immergées de la 
            for(int y = 0; y < lDeplacementCaseAdjacente.size();y++){
                lCaseImmergeeDispoDeplacement.add(lDeplacementCaseAdjacente.get(y));
            }
        }
        for(int i= 0;i < lCaseImmergeeDispoDeplacement.size();i++){
            lDeplacementCaseAdjacente = this.getTuilehorizontaleEtVerticale( lCaseImmergeeDispoDeplacement.get(i));
            for(int y =0;y < lDeplacementDispo.size();i++){
                lDeplacementDispo.add(lDeplacementCaseAdjacente.get(y));
            }
        }
        return lDeplacementDispo;
            
        }
    public ArrayList<Tuile> déplacementPossiblePilote(Grille grille){
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = grille.getTuile();
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if(tuiles[x][y]!=null && tuiles[x][y].getEtatCase()!= EtatCase.IMMERGEE){
                    tuilepossibles.add(tuiles[x][y]);
                }
            }
            
        }
        return tuilepossibles;
    }
    public ArrayList<Tuile> assèchementPossible(Tuile position){
    ArrayList<Tuile> assechPossible = new ArrayList<>();
        if(position.getX()!=5){
            if(tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()]); //case à droite de l'aventurier
        }}
        if(position.getX()!=0){
             if(tuile[position.getX()-1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()]); //case à gauche de l'aventurier
        }}
        if(position.getY()!=5){
             if(tuile[position.getX()][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()][position.getY()+1]); //case en bas de l'aventurier
        }}
        if(position.getY()!=0){
             if(tuile[position.getX()][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()-1]); //case en haut de l'aventurier
        }}
        return assechPossible;
    }
    
    public ArrayList<Tuile> assèchementPossibleIngenieur(Tuile position){
        ArrayList<Tuile> assechPossible = new ArrayList<>();
        if(position.getX()!=5){
            if(tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()]);  //case à droite de l'aventurier
        }}
        if(position.getX()!=0){
             if(tuile[position.getX()-1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()]);  //case à gauche de l'aventurier
        }}
        if(position.getY()!=5){
             if(tuile[position.getX()][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()][position.getY()+1]);  //case en dessous de l'aventurier
        }}
        if( position.getY()!=0){
             if(tuile[position.getX()][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()][position.getY()-1]);  //case au dessus de l'aventurier
        }}
        if(position.getX()!=5 && position.getY()!=5){
            if(tuile[position.getX()+1][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()+1]);  //case en diagonale bas-droite
        }}
        if(position.getX()!=5 && position.getY()!=0){
            if(tuile[position.getX()+1][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()-1]);  //case en diagonale haut-droite
        }}
        if(position.getX()!=0 && position.getY()!=5){
            if(tuile[position.getX()-1][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()+1]);  //case en diagonale bas-gauche
        }}
        if(position.getX()!=0 && position.getY()!=0){
            if(tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()-1]);  //case en diagonale bas-droite
        }}
        return assechPossible;
    
}
}
