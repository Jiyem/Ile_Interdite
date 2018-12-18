/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Controleur;

import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.Aventuriers.Explorateur;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Aventuriers.Ingenieur;
import ile.interdite.Modele.Aventuriers.Messager;
import ile.interdite.Modele.Aventuriers.Navigateur;
import ile.interdite.Modele.Aventuriers.Pilote;
import ile.interdite.Modele.Aventuriers.Plongeur;
import ile.interdite.Modele.Tuile;
import ile.interdite.Modele.EtatCase;
import ile.interdite.Vue.ActionsType;
import ile.interdite.Vue.MessageAventurier;
import ile.interdite.Vue.MessageInscription;
import ile.interdite.Vue.VueAventurier;
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
    private VueAventurier vueAventurier;
    HashMap<Couleur, String> depart = new HashMap<>();
    //Création d'une tuile par défaut pour placer les aventuriers lors de leurs instanciation un peu plus bas.
    //Lucas lpb 
//    private Tuile defaut = new Tuile(0,"défaut");
    private Grille grille;
    private int nombreAction = 3;
    private int y=0;
    
    public Controleur(){
        joueurs=new ArrayList<>();
        inscri.addObserver(this);
        inscri.afficher();
        
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
                        ArrayList<String> l = new ArrayList<>();
                        l.add("Explorateur");l.add("Ingenieur");l.add("Messager");l.add("Navigateur");l.add("Pilote");l.add("Plongeur");
                        
                        
                        int nb = 0;
                        int aléa1 = 10;
                                                

                        //Initialisation de la grille.
                        grille = new Grille();
                        //mise de la grille dans la liste tuiles
                        Tuile[][] tuiles = grille.getTuile();
                        
                        //*******************************************************//
                        //***********Attribution des rôles pour la démo**********//
                        //*******************************************************//
                        Aventurier joueur1 = new Ingenieur(message.getPseudo2());
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Bronze")){
                                            joueur1.setPosition(tuiles[y][x]);
                                            System.out.println("La position du ingénieur est initialisé");
                                        }
                                    }      
                                }
                        joueurs.add(joueur1);
                        Aventurier joueur2 = new Pilote(message.getPseudo4());
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("Heliport")){
                                            joueur2.setPosition(tuiles[y][x]);
                                            System.out.println("La position du pilote est initialisé");
                                        }
                                    }
                                } 
                        joueurs.add(joueur2);
                        if(message.getNbJoueurs() == 3 || message.getNbJoueurs() == 4){
                            Aventurier joueur3 = new Plongeur(message.getPseudo3());
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Fer")){
                                            joueur3.setPosition(tuiles[y][x]);
                                            System.out.println("La position du plongeur est initialisé");
                                        }
                                    }
                                }
                        joueurs.add(joueur3);
                        }

                        if(message.getNbJoueurs() == 4){
                                Aventurier joueur4 = new Explorateur(message.getPseudo1());
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Cuivre")){
                                            joueur4.setPosition(tuiles[y][x]);
                                            System.out.println("La position de l'explorateur est initialisée");
                                        }
                                    }
                                }
                        joueurs.add(joueur4);
                        }
                        
                        
                        
                        //*******************************************************//
                        //************Mise en place des rôles aléatoire**********//
                        //****Supprimé pour la démo mais à remettre plus tard****//
                        //*******************************************************//

                        //0 = Explorateur, 1= Ingénieur, 2= Messager, 3=Navigateur, 4= Pilote, 5=Plongeur
//                        while(nb<message.getNbJoueurs()){
//                            //Tirage d'un nombre aléatoire entre 0 et 5 (inclu)
//                            aléa1 = r.nextInt(l.size()-0);
//                            //Vérifié que la valeur est toujours présente dans la liste des rôles dispo, sinon refaire un tirage.
//                            while(aléa1 > l.size()){
//                                aléa1 = r.nextInt(l.size()-0);
//                            }
//                            //Attribution du rôle au nom de joueur -> Instanciation des aventuriers
//                            //intialisation des explorateurs
//                            if(l.get(aléa1) == "Explorateur"){
//                                Aventurier joueur = new Explorateur(s.get(nb));
//                                for (int y = 0; y < 6; y++) {
//                                    for (int x = 0; x < 6; x++) {
//                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Cuivre")){
//                                            joueur.setPosition(tuiles[y][x]);
//                                            System.out.println("La position de l'explorateur est initialisée");
//                                        }
//                                    }
//                                }
//                                joueurs.add(joueur);
//                                l.remove("Explorateur");
//                            //intialisation des inénieurs
//                            } else if(l.get(aléa1) == "Ingenieur"){
//                                Aventurier joueur = new Ingenieur(s.get(nb));
//                                for (int y = 0; y < 6; y++) {
//                                    for (int x = 0; x < 6; x++) {
//                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Bronze")){
//                                            joueur.setPosition(tuiles[y][x]);
//                                            System.out.println("La position du ingénieur est initialisé");
//                                        }
//                                    }      
//                                }
//                                joueurs.add(joueur);
//                                l.remove("Ingenieur");
//                            //initalisation des messagers    
//                            } else if(l.get(aléa1) == "Messager"){
//                                Aventurier joueur = new Messager(s.get(nb));
//                                for (int y = 0; y < 6; y++) {
//                                    for (int x = 0; x < 6; x++) {
//                                        if(tuiles[y][x] != null &&  tuiles[y][x].getNomTuile().equals("La Porte d’Argent")){
//                                            joueur.setPosition(tuiles[y][x]);
//                                            System.out.println("La position du messager est initialisé");
//                                        }
//                                    }
//                                }
//                                joueurs.add(joueur);
//                                l.remove("Messager");
//                            //initialisation des navigateurs
//                            } else if(l.get(aléa1) == "Navigateur"){
//                                Aventurier joueur = new Navigateur(s.get(nb));
//                                for (int y = 0; y < 6; y++) {
//                                    for (int x = 0; x < 6; x++) {
//                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte d’Or")){
//                                            joueur.setPosition(tuiles[y][x]);
//                                            System.out.println("La position du navigateur est initialisé");
//                                        }
//                                    }
//                                }
//                                joueurs.add(joueur);
//                                l.remove("Navigateur");
//                                
//                            //initialisation des pilotes
//                            } else if(l.get(aléa1) == "Pilote"){
//                                Aventurier joueur = new Pilote(s.get(nb));
//                                for (int y = 0; y < 6; y++) {
//                                    for (int x = 0; x < 6; x++) {
//                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("Heliport")){
//                                            joueur.setPosition(tuiles[y][x]);
//                                            System.out.println("La position du pilote est initialisé");
//                                        }
//                                    }
//                                }
//                                l.remove("Pilote");
//                                joueurs.add(joueur);
//                                
//                            //initialisation des plongeurs
//                            } else if( l.get(aléa1) == "Plongeur"){
//                                Aventurier joueur = new Plongeur(s.get(nb));
//                                for (int y = 0; y < 6; y++) {
//                                    for (int x = 0; x < 6; x++) {
//                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Fer")){
//                                            joueur.setPosition(tuiles[y][x]);
//                                            System.out.println("La position du plongeur est initialisé");
//                                        }
//                                    }
//                                }
//                                l.remove("Plongeur");
//                                joueurs.add(joueur);
//                                
//                            }
//                            //Suppression de l'aventurier dans la liste des rôles dispo.
//                            
//                            
//                            nb = nb +1;
//                            
//                        }

                        //*******************************************************//
                        //************Fin de la mise en place des rôles**********//
                        //*******************aléatoire***************************//
                        //*******************************************************//

                        // à supprimer plus tard pour intégrer à l'IHM.
                        for(int i = 0; i < joueurs.size();i++){
                            System.out.println("Le joueur "+joueurs.get(i).getPseudo()+" est un "+joueurs.get(i).getRôle());
                        }
                        
                        // à supprimer
                        System.out.println("La grille est initialisée");
                        int y=0;
                        Aventurier joueurCourant = joueurs.get(y);
                
                    //Tour n°1 : 
                    vueAventurier = new VueAventurier(joueurCourant.getPseudo(), joueurCourant.getRôle(),joueurCourant.getCouleur().getCouleur() );
                    vueAventurier.addObserver(this);
                    vueAventurier.afficher();
                    vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile()); // possibilité de le changer en while
                    inscri.close();

                        
                    };
                    // Si l'utilisateur à demander plus de 4 joueurs ou moins de 2 joueurs.
                    if (message.getNbJoueurs() == 0){
                        inscri.erreurNbJoueurs0();
                    }
                    //Si l'utilisateur entre le joueur 3 sans le joueur 4
                    else{
                        inscri.erreurNbJoueurs();
                    }
         
                }
            //Tour de jeu:
//            int numTour = 1;
            }
         //   for(int x=0;x<joueurs.size();x++){ //ne devrais pas être dans le update je pense...
                Aventurier joueurCourant = joueurs.get(y);
                
//                //Tour n°1 : 

                
                if(arg1 instanceof MessageAventurier){
                    MessageAventurier messageAventurier = (MessageAventurier) arg1 ;
                    if(messageAventurier.getAction()==ActionsType.DEPLACER){
                        //faire le déplacement
                        if(joueurCourant.ouAller(grille)==true){
                            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile());
                            nombreAction=nombreAction-1;
                        };
                        
                    }
                    else if(messageAventurier.getAction()==ActionsType.ASSECHER){
                        //faire l'assecheemnt
                        if(joueurCourant.ouAssecher(grille)==true){
                            nombreAction=nombreAction-1;
                        };
                        if(joueurCourant.getRôle()=="Ingenieur" && joueurCourant.assèchementPossible(grille).size()!=0){
                            Scanner sc=new Scanner(System.in);
                            System.out.println("Voulez-vous effectuer un deuxième assèchement ? (o/n)");
                            if(sc.nextLine().equals("o")){
                                joueurCourant.ouAssecher(grille);
                                
                            }
                        }
                        
                    }
                    else if(messageAventurier.getAction()==ActionsType.AUTREACTION){ // Ne fait rien du tout pour l'instant
                        //faire autre action
                        if(joueurCourant.getCouleur().equals(Couleur.BLEU)){ // modifier pour pouvoir utiliser son pouvoir qu'une fois
                            if(joueurCourant.ouAllerSpe(grille)==true){
                            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile());
                            nombreAction=nombreAction-1;

                            
                        }
                        }
                        else {    
                        System.out.println("Vous n'avez pas encore accès aux actions speciales.");}
                        //nombreAction=nombreAction-1; à ajouter plus tard
                    
                    }
                    else if(messageAventurier.getAction()==ActionsType.PASSERTOUR){
                        //faire la fin du tour.
                        nombreAction=0;
                    }
                    //Verification de fin de tour et changement tour
                    if(nombreAction == 0){
                        if(y<joueurs.size()-1){
                            y=y+1;                            
                        }else {
                            y = 0;
                        }
                            System.out.print(y);
                            vueAventurier.fermer();
                            joueurCourant = joueurs.get(y);
                            vueAventurier = new VueAventurier(joueurCourant.getPseudo(), joueurCourant.getRôle(),joueurCourant.getCouleur().getCouleur() );
                            vueAventurier.addObserver(this);
                            vueAventurier.afficher();
                            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile()); // possibilité de le changer en while
                            nombreAction=3;
                            System.out.println("Changement de joueur");
                        }
                    
                }
                
            
            
    }
            
            

}

