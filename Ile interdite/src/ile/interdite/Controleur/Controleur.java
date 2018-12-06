/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Controleur;

import ile.interdite.Modele.Aventurier;
import ile.interdite.Modele.Grille;
import ile.interdite.Vue.ActionsType;
import ile.interdite.Vue.MessageInscription;
import ile.interdite.Vue.VueInscription;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rose
 */
public class Controleur implements Observer {
    private ArrayList<Aventurier>joueurs;
    private VueInscription inscri = new VueInscription();
    Controleur(){
        joueurs=new ArrayList<>();
        inscri.addObserver(this);
        inscri.afficher();
        
    }

    @Override
    public void update(Observable arg0, Object arg1) {
            if (arg1 instanceof ActionsType) {
                if (((ActionsType) arg1) == ActionsType.ANNULE) {
                    System.out.println("L'utilisateur a abandonné");
                }
            } else if (arg1 instanceof MessageInscription) {
                MessageInscription message = (MessageInscription) arg1 ;
                if (message.getAction() == ActionsType.VALIDE) {
                    System.out.println("L'utilisateur a validé");
                    if (message.getNbJoueurs() > 1 && message.getNbJoueurs() < 5) {
                        Random r = new Random();
                        int nb = 0;
                        //0 = Explorateur, 1= Ingénieur, 2= Messager, 3=Navigateur, 4= Pilote, 5=Plongeur
                        while(nb<message.getNbJoueurs()){
                            int aléa1 = 0 + r.nextInt(5-0);
 
                            if(aléa1 == 0){
                                Aventurier joueur = new Explorateur();
                            } else if(aléa1 == 1){
                                Aventurier joueur = new Ingenieur();
                            } else if(aléa1 == 2){
                                Aventurier joueur = new Messager();
                            } else if(aléa1 == 3){
                                Aventurier joueur = new Navigateur();
                                
                            } else if(aléa1 == 4){
                                Aventurier joueur = new Pilote();
                                
                            } else if(aléa1 == 5){
                                Aventurier joueur = new Plongeur();
                                
                            }
                            nb = nb +1;
                            
                        }


                    }
                    else{
                        System.out.println("L'utilisateur à saisi une mauvaise valeur pour le nombre de joueurs");
                    }
                }
            }
        }
}
    

