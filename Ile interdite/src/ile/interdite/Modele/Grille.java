/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import ile.interdite.Modele.Aventuriers.Pilote;
import ile.interdite.image.ImageContainer;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rose
 */
public class Grille {

    //chercher quel type de colection pour les 36 tuiles de la grille
    private final Tuile tuile[][] = new Tuile[6][6];
    private ArrayList<String> tuilesDispoNom = new ArrayList();
    private ArrayList<ImageContainer> tuilesDispoImage = new ArrayList();
    private ListeTuiles liste = new ListeTuiles();
    


    public void initialiseArray() {
        for (int i = 0; i < 24; i++) {
            this.tuilesDispoNom.add(i, liste.getNom(i));
            this.tuilesDispoImage.add(i, liste.getImage(i));
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
                    this.tuile[y][x] = new Tuile(nb, tuilesDispoNom.get(nb-1),y,x,tuilesDispoImage.get(nb-1));
                    this.setTresor(y, x);
                }
            }

        }
        //this.melange();
        this.setInnondationGrille();

    }
    
    public Tuile[][] getTuiles(){
        return tuile;
    }
    
    public void setTresor(int y, int x){
        if(tuile[y][x].getNomTuile() == "Le Temple du Soleil" || tuile[y][x].getNomTuile() == "Le Temple de La Lune"){
            this.tuile[y][x].setTresor(Tresor.PIERRE);
        } else if(tuile[y][x].getNomTuile() == "Le Jardin des Murmures" || tuile[y][x].getNomTuile() == "Le Jardin des Hurlements"){
            tuile[y][x].setTresor(Tresor.ZEPHYR);        
        } else if(tuile[y][x].getNomTuile() == "La Caverne des Ombres" || tuile[y][x].getNomTuile() == "La Caverne du Brasier"){
            tuile[y][x].setTresor(Tresor.CRISTAL);
        } else if(tuile[y][x].getNomTuile() == "Le Palais des Marees" || tuile[y][x].getNomTuile() == "Le Palais de Corail"){
            tuile[y][x].setTresor(Tresor.CALICE);
        }
    }
    
    public void retirerTresor(Tresor tresor){
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if((tuile[y][x].getNomTuile() == "Le Temple du Soleil" || tuile[y][x].getNomTuile() == "Le Temple de La Lune") && tresor == Tresor.PIERRE){
                    this.tuile[y][x].setTresor(null);
                } else if((tuile[y][x].getNomTuile() == "Le Jardin des Murmures" || tuile[y][x].getNomTuile() == "Le Jardin des Hurlements")&& tresor == Tresor.ZEPHYR){
                    this.tuile[y][x].setTresor(null);        
                } else if((tuile[y][x].getNomTuile() == "La Caverne des Ombres" || tuile[y][x].getNomTuile() == "La Caverne du Brasier") && tresor == Tresor.CRISTAL){
                    this.tuile[y][x].setTresor(null);
                } else if((tuile[y][x].getNomTuile() == "Le Palais des Marees" || tuile[y][x].getNomTuile() == "Le Palais de Corail")&& tresor == Tresor.CALICE){
                    this.tuile[y][x].setTresor(null);
                }  
                
            }
        }    
        
        if(tresor == Tresor.PIERRE){
            
        }else if(tresor == Tresor.ZEPHYR){
            
        }else if(tresor == Tresor.CRISTAL){
            
        }else if(tresor == Tresor.CALICE){
            
        }
    }

    public void melange() {
        Collections.shuffle(tuilesDispoNom);
        
    }
    
    public Tuile[][] getTuile(){
        return this.tuile;
    }
    
    public ArrayList<Tuile> getTuilehorizontaleEtVerticale(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
        //Si la tuile existe ( != null) et que son état n'est pas IMMERGEE on l'ajoute aux possibilitées
        if(position.getX() !=5){
            if(tuile[position.getX()+1][position.getY()] != null && tuile[position.getX()+1][position.getY()].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()+1][position.getY()]); //Donne la position de la case à droite
            }
        }
        if(position.getX() !=0){
            if(tuile[position.getX()-1][position.getY()] != null && tuile[position.getX()-1][position.getY()].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()-1][position.getY()]); //Donne la position de la case à gauche
            } 
        }
        if(position.getY()!=5){
            if(tuile[position.getX()][position.getY()+1] != null && tuile[position.getX()][position.getY()+1].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()][position.getY()+1]);//Donne la position de la case au dessus
            }
        }
        if(position.getY()!=0){
            if(tuile[position.getX()][position.getY()-1] != null && tuile[position.getX()][position.getY()-1].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()][position.getY()-1]); //Donne la position de la case en bas
            } 
        }    
        return lDeplacementDispo;
    }
    
     public ArrayList<Tuile> getTuileDeplacementDiagonale(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
 
       // lDeplacementDispo = this.getTuilehorizontaleEtVerticale(position);

        if(position.getX() !=5 && position.getY() !=5){ 
            if(tuile[position.getX()+1][position.getY()+1] != null && tuile[position.getX()+1][position.getY()+1].getEtatCase() != EtatCase.IMMERGEE ){
                lDeplacementDispo.add(tuile[position.getX()+1][position.getY()+1]); //Donne la position une case plus basse a droite
            }
        }
        if(position.getX() !=5 && position.getY() !=0){
            if(tuile[position.getX()+1][position.getY()-1] != null && tuile[position.getX()+1][position.getY()-1].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()+1][position.getY()-1]); //Donne la position une case plus basse a gauche
            }
        }
        if(position.getX() !=0 && position.getY() !=5){
            if(tuile[position.getX()-1][position.getY()+1] != null && tuile[position.getX()-1][position.getY()+1].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()-1][position.getY()+1]); //Donne la position une case plus haute a droite
            }
        }
        if(position.getX() !=0 && position.getY() !=0){
            if(tuile[position.getX()-1][position.getY()-1] != null && tuile[position.getX()-1][position.getY()-1].getEtatCase() != EtatCase.IMMERGEE){
                lDeplacementDispo.add(tuile[position.getX()-1][position.getY()-1]); //Donne la position une case plus haute a gauche
            }
        }    
        return lDeplacementDispo;
    }
    public ArrayList<Tuile> getTuileAdjacenteImmergéesOuInnondee(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();

        if(position.getX() !=5){ // possible résolution
            if(tuile[position.getX()+1][position.getY()] != null && ((tuile[position.getX()+1][position.getY()].getEtatCase().equals(EtatCase.INNONDEE)) || tuile[position.getX()+1][position.getY()].getEtatCase().equals(EtatCase.IMMERGEE))){
                   lDeplacementDispo.add(tuile[position.getX()+1][position.getY()]); //Donne la position de la case à droite IMMERGEE ou INNONDEE  
            }
        } 
        if(position.getX() !=0){
            if(tuile[position.getX()-1][position.getY()] != null && ((tuile[position.getX()-1][position.getY()].getEtatCase().equals(EtatCase.INNONDEE)) || tuile[position.getX()-1][position.getY()].getEtatCase().equals(EtatCase.IMMERGEE))){
                lDeplacementDispo.add(tuile[position.getX()-1][position.getY()]); //Donne la position de la case à IMMERGEE
            }
        } 
        if(position.getY() !=5){    
            if(tuile[position.getX()][position.getY()+1] != null && ((tuile[position.getX()][position.getY()+1].getEtatCase().equals(EtatCase.INNONDEE)) || tuile[position.getX()][position.getY()+1].getEtatCase().equals(EtatCase.IMMERGEE))){
                lDeplacementDispo.add(tuile[position.getX()][position.getY()+1]);//Donne la position de la case au IMMERGEE
            } 
        } 
        if(position.getY() !=0){    
            if(tuile[position.getX()][position.getY()-1] != null && ((tuile[position.getX()][position.getY()-1].getEtatCase().equals(EtatCase.INNONDEE)) || tuile[position.getX()][position.getY()-1].getEtatCase().equals(EtatCase.IMMERGEE))){
                lDeplacementDispo.add(tuile[position.getX()][position.getY()-1]); //Donne la position de la case en IMMERGEE
            }
        }    
        return lDeplacementDispo;
    }
    
    public ArrayList<Tuile> getTuileDeplacementPlongeur(Tuile position){
        ArrayList<Tuile> lDeplacementDispo = new ArrayList<>();
        ArrayList<Tuile> lCaseImmergeeDispoDeplacement = new ArrayList<>();
        ArrayList<Tuile> lDeplacementCaseAdjacenteInnondeeImmergee = new ArrayList<>();
        
        lDeplacementDispo = this.getTuilehorizontaleEtVerticale(position); //On prend tout d'abord les cases non immergées autour du hero
        lCaseImmergeeDispoDeplacement =  this.getTuileAdjacenteImmergéesOuInnondee(position);//On prend ensuite les cases immergées/innondées autour du hero
        
        for(int i=0;i < lCaseImmergeeDispoDeplacement.size();i++){ //Tant qu'il existe des cases immergées 
            
            lDeplacementCaseAdjacenteInnondeeImmergee = this.getTuilehorizontaleEtVerticale(lCaseImmergeeDispoDeplacement.get(i)); //On regarde la case immergées de la 
            for(int y = 0; y < lDeplacementCaseAdjacenteInnondeeImmergee.size();y++){
                if(lDeplacementDispo.contains(lDeplacementCaseAdjacenteInnondeeImmergee.get(y)) == false && lDeplacementCaseAdjacenteInnondeeImmergee.get(y) != position){ //Permet d'eviter les boucles infinies
                   lDeplacementDispo.add(lDeplacementCaseAdjacenteInnondeeImmergee.get(y));
                }
            }
            
            lDeplacementCaseAdjacenteInnondeeImmergee = this.getTuileAdjacenteImmergéesOuInnondee(lCaseImmergeeDispoDeplacement.get(i));
            for(int x = 0; x < lDeplacementCaseAdjacenteInnondeeImmergee.size();x++){
                if(lCaseImmergeeDispoDeplacement.contains(lDeplacementCaseAdjacenteInnondeeImmergee.get(x)) == false){ //Permet d'eviter les boucles infinies
                   lCaseImmergeeDispoDeplacement.add(lDeplacementCaseAdjacenteInnondeeImmergee.get(x));
                }
            }
        
        }
        return lDeplacementDispo;  
    }
    
    public ArrayList<Tuile> déplacementPossiblePilote(Pilote pilote){
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = this.getTuile();
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if(tuiles[x][y]!=null && tuiles[x][y].getEtatCase()!= EtatCase.IMMERGEE){
                    tuilepossibles.add(tuiles[x][y]);
                }
            }
            
        }
        pilote.setActionSpe(0);
        return tuilepossibles;
    }
    public ArrayList<Tuile> assèchementPossible(Tuile position){
    ArrayList<Tuile> assechPossible = new ArrayList<>();
        if(tuile[position.getX()][position.getY()].getEtatCase()==EtatCase.INNONDEE){
            assechPossible.add(tuile[position.getX()][position.getY()]);}
        if(position.getX()!=5){
            if(tuile[position.getX()+1][position.getY()] != null && tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()]); //case à droite de l'aventurier
        }}
        if(position.getX()!=0){
             if(tuile[position.getX()-1][position.getY()] != null && tuile[position.getX()-1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()]); //case à gauche de l'aventurier
        }}
        if(position.getY()!=5){
             if(tuile[position.getX()][position.getY()+1] != null && tuile[position.getX()][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()][position.getY()+1]); //case en bas de l'aventurier
        }}
        if(position.getY()!=0){
             if(tuile[position.getX()][position.getY()-1] != null && tuile[position.getX()][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()-1]); //case en haut de l'aventurier
        }}
        return assechPossible;
    }
    
    public ArrayList<Tuile> assèchementPossibleDiagonale(Tuile position){
        ArrayList<Tuile> assechPossible = new ArrayList<>();
        
        if(position.getX()!=5 && position.getY()!=5){
            if(tuile[position.getX()+1][position.getY()+1] != null && tuile[position.getX()+1][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()+1]);  //case en diagonale bas-droite
        }}
        if(position.getX()!=5 && position.getY()!=0){
            if(tuile[position.getX()+1][position.getY()-1] != null && tuile[position.getX()+1][position.getY()-1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()+1][position.getY()-1]);  //case en diagonale haut-droite
        }}
        if(position.getX()!=0 && position.getY()!=5){
            if(tuile[position.getX()-1][position.getY()+1] != null && tuile[position.getX()-1][position.getY()+1].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()+1]);  //case en diagonale bas-gauche
        }}
        if(position.getX()!=0 && position.getY()!=0){
            if(tuile[position.getX()-1][position.getY()-1] != null && tuile[position.getX()+1][position.getY()].getEtatCase() == EtatCase.INNONDEE){
                assechPossible.add(tuile[position.getX()-1][position.getY()-1]);  //case en diagonale bas-droite
        }}
        return assechPossible;
    
}
    public void setInnondationGrille(){
        tuile[0][3].setEtatCase(EtatCase.INNONDEE);
        tuile[2][2].setEtatCase(EtatCase.IMMERGEE);
        tuile[3][1].setEtatCase(EtatCase.INNONDEE);
        tuile[3][2].setEtatCase(EtatCase.IMMERGEE);
        tuile[3][3].setEtatCase(EtatCase.INNONDEE);
        tuile[3][4].setEtatCase(EtatCase.IMMERGEE);
        tuile[3][5].setEtatCase(EtatCase.INNONDEE);
        tuile[4][2].setEtatCase(EtatCase.IMMERGEE);
        tuile[5][3].setEtatCase(EtatCase.INNONDEE);
    }
    
        
    public boolean verifHelioportEstIlCoulé(){
        boolean c = false;
        for(int i =0;i<6;i++ ){
            for(int y =0;i<6;y++ ){
                if(tuile[i][y] != null){
                    if(tuile[i][y].getNomTuile() == "Heliport" && tuile[i][y].getEtatCase() == EtatCase.IMMERGEE){
                        System.out.println(i + y);
                        c = true;
                    }
                }
            }
        }
        return c;
    }
}
