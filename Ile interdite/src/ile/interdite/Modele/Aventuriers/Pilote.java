/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Aventuriers;

import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rose
 */
public class Pilote extends Aventurier{
    private int actionSpe =1;
    
    public Pilote(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.BLEU);
        
    }
    public Pilote(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.BLEU);
        
    }


    private ArrayList<Tuile> déplacementSpecial(Grille grille) {
        //Redefinition totale de la fonction pour le deplcaement possible du plongeur
        return grille.déplacementPossiblePilote(this);
    }
    
    //Comme les assechements du pilote sont basiques pas besoin de redefinir les fonctions
    @Override
    public String getRôle() {
        return "Pilote";
    }
    
    @Override
    public boolean ouAllerSpe(Grille grille) {
        
         //To change body of generated methods, choose Tools | Templates.
        if(getActionSpe() ==0){
            this.ouAller(grille);
        } 
        else{
        ArrayList<Tuile> deplacementPossible = new ArrayList();
        deplacementPossible = this.déplacementSpecial(grille);// faire en sorte que l'on calcule ses mouvement possible puis qu'on l'affiche sur la grille/consonle
        if(deplacementPossible.size()==0){
            System.out.println("Il n'y a aucune tuile sur laquelle se déplacer");
            return false;
        }else{
            
            for (int i =0; i < deplacementPossible.size();i++){
                System.out.println(i + " : " + deplacementPossible.get(i).getNomTuile());
            }
            System.out.println("Entrez le numéro de la tuile où vous souhaitez aller");
            Scanner scanner = new Scanner(System.in);
            String numeroTuile = scanner.nextLine();


            for(int j =0; j < deplacementPossible.size();j++){
                if (numeroTuile.equals(Integer.toString(j))) {
                    this.deplacement(deplacementPossible.get(j));
                    System.out.println("Vous venez d'être déplacé sur la tuile : " + deplacementPossible.get(j).getNomTuile());
                }



            }
        return true;} 
        }
        return false;
       
        }

    /**
     * @return the actionSpe
     */
    public int getActionSpe() {
        return actionSpe;
    }

    /**
     * @param actionSpe the actionSpe to set
     */
    public void setActionSpe(int actionSpe) {
        this.actionSpe = actionSpe;
    }

    


   
}
