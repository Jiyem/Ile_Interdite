/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Controleur;

import ile.interdite.Modele.Aventurier;
import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.Explorateur;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Ingenieur;
import ile.interdite.Modele.Messager;
import ile.interdite.Modele.Navigateur;
import ile.interdite.Modele.Pilote;
import ile.interdite.Modele.Plongeur;
import ile.interdite.Modele.Tuile;
import ile.interdite.Vue.ActionsType;
import ile.interdite.Vue.MessageInscription;
import ile.interdite.Vue.VueInscription;
import java.util.ArrayList;
import java.util.HashMap;
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
    HashMap<Couleur, String> depart = new HashMap<>();
    //Création d'une tuile par défaut pour placer les aventuriers lors de leurs instanciation un peu plus bas.
    //Lucas lpb 
//    private Tuile defaut = new Tuile(0,"défaut");
    private Grille grille;
    public Controleur(){
        joueurs=new ArrayList<>();
        inscri.addObserver(this);
        inscri.afficher();
        
    }
    private void PositionDépart(){
        this.depart.put(Couleur.BLEU,"Heliport");
        this.depart.put(Couleur.JAUNE,"La Porte d'Or");
        this.depart.put(Couleur.ORANGE,"La Porte d’Argent");
        this.depart.put(Couleur.ROUGE,"La Porte De Bronze");
        this.depart.put(Couleur.VERT,"La Porte de Cuivre");
        this.depart.put(Couleur.VIOLET,"La Porte de Fer");
    }

    @Override
    public void update(Observable arg0, Object arg1) {
            if (arg1 instanceof ActionsType) {
                //Si l'utilisateur clic sur annulé
                if (((ActionsType) arg1) == ActionsType.ANNULE) {
                    System.out.println("L'utilisateur a abandonné");
                }
            } else if (arg1 instanceof MessageInscription) {
                MessageInscription message = (MessageInscription) arg1 ;
                //Si l'utilisateur clic sur validé
                if (message.getAction() == ActionsType.VALIDE) {
                    System.out.println("L'utilisateur a validé");                 
                    //Si le nombre de joueur est bien compris entre 2 et 4 (inclu)
                    if (message.getNbJoueurs() > 1 && message.getNbJoueurs() < 5) {
                        Random r = new Random();
                        ArrayList<String> s = new ArrayList<>();
                        s.add(message.getPseudo1());s.add(message.getPseudo2());s.add(message.getPseudo3());s.add(message.getPseudo4());
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(0);l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);
                        int nb = 0;
                        int aléa1;
                        //0 = Explorateur, 1= Ingénieur, 2= Messager, 3=Navigateur, 4= Pilote, 5=Plongeur
                        while(nb<message.getNbJoueurs()){
                            //Tirage d'un nombre aléatoire entre 0 et 5 (inclu)
                            aléa1 = 0 + r.nextInt(5-0);
                            //Vérifié que la valeur est toujours présente dans la liste des rôles dispo, sinon refaire un tirage.
                            while(aléa1 > l.size()){
                                aléa1 = 0 + r.nextInt(5-0);
                            }
                            //Attribution du rôle au nom de joueur -> Instanciation des aventuriers
                            if(l.get(aléa1) == 0){
                                Aventurier joueur = new Explorateur(s.get(nb));
                                //Ajout de l'aventurier dans la liste des aventuriers.
                                joueurs.add(joueur);
                            } else if(l.get(aléa1) == 1){
                                Aventurier joueur = new Ingenieur(s.get(nb));
                                joueurs.add(joueur);
                            } else if(l.get(aléa1) == 2){
                                Aventurier joueur = new Messager(s.get(nb));
                                joueurs.add(joueur);
                            } else if(l.get(aléa1) == 3){
                                Aventurier joueur = new Navigateur(s.get(nb));
                                joueurs.add(joueur);
                                
                            } else if(l.get(aléa1) == 4){
                                Aventurier joueur = new Pilote(s.get(nb));
                                joueurs.add(joueur);
                                
                            } else if(l.get(aléa1) == 5){
                                Aventurier joueur = new Plongeur(s.get(nb));
                                joueurs.add(joueur);
                                
                            }
                            //Suppression de l'aventurier dans la liste des rôles dispo.
                            l.remove(aléa1);
                            
                            nb = nb +1;
                            
                        }
                        // à supprimer plus tard pour intégrer à l'IHM.
                        for(int i = 0; i < joueurs.size();i++){
                            System.out.println("Le joueur "+joueurs.get(i).getPseudo()+" est un "+joueurs.get(i).getRôle());
                        }
                        
                        //Initialisation de la grille.
                        grille = new Grille();
                        // à supprimer
                        System.out.println("La grille est initialisée");
                        
                        
                        
                    }
                    // Si l'utilisateur à demander plus de 4 joueurs ou moins de 2 joueurs.
                    else if (message.getNbJoueurs() == 0){
                        inscri.erreurNbJoueurs0();
                    }
                    //Si l'utilisateur entre le joueur 3 sans le joueur 4
                    else{
                        inscri.erreurNbJoueurs();
                    }
         
                }
            }
        }
}
    

