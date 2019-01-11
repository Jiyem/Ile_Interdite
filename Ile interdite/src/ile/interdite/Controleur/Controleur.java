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
import ile.interdite.Vue.ActionsType;
import ile.interdite.Vue.MessageAventurier;
import ile.interdite.Vue.MessageInscription;
import ile.interdite.Vue.VueAventurier;
import ile.interdite.Vue.VueInscription;
import ile.interdite.Vue.VuePlateau;
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
    private HashMap<Couleur, String> depart = new HashMap<>();
    private Grille grille;
    private int nombreAction;
    private int y=0; //une variable drapeau.
    private Tuile[][] tuiles;
    private MessageInscription message;
    private MessageAventurier messageAventurier;
    private Aventurier joueurCourant;
    
    private VuePlateau plateau;
    
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
                message = (MessageInscription) arg1 ;
                //Si l'utilisateur clic sur validé
                if (message.getAction() == ActionsType.VALIDE) {
                    System.out.println("L'utilisateur a validé");                 
                    //Si le nombre de joueur est bien compris entre 2 et 4 (inclu)
                    if (message.getNbJoueurs() > 1 && message.getNbJoueurs() < 5) {
                        //Initialisation de la grille.
                        this.initialisationGrille();
                        
                        
                        /**************************très moche*****************************/          
                        plateau = new VuePlateau(grille);
                        plateau.afficher();
                        
                        
                        //mise de la grille dans la liste tuiles
                        tuiles = grille.getTuile(); 
                        //Initialisation des joueurs
                        this.initialisationJoueurs();
                        // à supprimer plus tard pour intégrer à l'IHM.
                        this.afficheJoueursListe();  
                        // à supprimer
                        System.out.println("La grille est initialisée");
                        // mise en place du joueur courant.
                        joueurCourant = joueurs.get(y);                      
                        //mise ne place du nombre d'action pour le 1er joueur
                        if(joueurCourant.getClass() == Navigateur.class){
                            nombreAction = 4;
                        }else{
                            nombreAction=3;                                
                        }
                        //Tour n°1 : 
                        this.tour1();
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
            }
                joueurCourant = joueurs.get(y);
                //Tour n°1 : 
                if(arg1 instanceof MessageAventurier){
                    messageAventurier = (MessageAventurier) arg1 ;
                    if(messageAventurier.getAction()==ActionsType.DEPLACER){
                        //faire le déplacement
                        if(joueurCourant.ouAller(grille)==true){
                            this.déplacer();
                        };  
                    }
                    else if(messageAventurier.getAction()==ActionsType.ASSECHER){
                        //faire l'assecheemnt
                        this.assécher();  
                    }
                    else if(messageAventurier.getAction()==ActionsType.AUTREACTION){ // Ne fait rien du tout pour l'instant
                        //faire autre action
                        this.autreAction(); 
                    }
                    else if(messageAventurier.getAction()==ActionsType.PASSERTOUR){
                        //faire la fin du tour.
                        this.passerTour();
                    }
                    //Verification de fin de tour et changement tour
                    this.changementTour();          
                }
                
            
            
    }
    
    //Les méthodes utilisés pour le contrôleur :
    private void initialisationGrille(){
        grille = new Grille();
    }
    private void initialisationJoueurs(){
                        Random r = new Random();
                        ArrayList<String> s = new ArrayList<>();
                        s.add(message.getPseudo1());s.add(message.getPseudo2());s.add(message.getPseudo3());s.add(message.getPseudo4());
                        ArrayList<String> l = new ArrayList<>();
                        l.add("Explorateur");l.add("Ingenieur");l.add("Messager");l.add("Navigateur");l.add("Pilote");l.add("Plongeur");
                        int nb = 0;
                        int aléa1 = 10;
        //                        0 = Explorateur, 1= Ingénieur, 2= Messager, 3=Navigateur, 4= Pilote, 5=Plongeur
                        while(nb<message.getNbJoueurs()){
                            //Tirage d'un nombre aléatoire entre 0 et 5 (inclu)
                            aléa1 = r.nextInt(l.size());
                            //Vérifié que la valeur est toujours présente dans la liste des rôles dispo, sinon refaire un tirage.
                            while(aléa1 > l.size()){
                                aléa1 = r.nextInt(l.size());
                            }
                            //Attribution du rôle au nom de joueur -> Instanciation des aventuriers
                            //intialisation des explorateurs
                            if(l.get(aléa1) == "Explorateur"){
                                Aventurier joueur = new Explorateur(s.get(nb));
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Cuivre")){
                                            joueur.setPosition(tuiles[y][x]);
                                            System.out.println("La position de l'explorateur est initialisée");
                                        }
                                    }
                                }
                                joueurs.add(joueur);
                                l.remove("Explorateur");
                            //intialisation des inénieurs
                            } else if(l.get(aléa1) == "Ingenieur"){
                                Aventurier joueur = new Ingenieur(s.get(nb));
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Bronze")){
                                            joueur.setPosition(tuiles[y][x]);
                                            System.out.println("La position du ingénieur est initialisé");
                                        }
                                    }      
                                }
                                joueurs.add(joueur);
                                l.remove("Ingenieur");
                            //initalisation des messagers    
                            } else if(l.get(aléa1) == "Messager"){
                                Aventurier joueur = new Messager(s.get(nb));
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null &&  tuiles[y][x].getNomTuile().equals("La Porte d’Argent")){
                                            joueur.setPosition(tuiles[y][x]);
                                            System.out.println("La position du messager est initialisé");
                                        }
                                    }
                                }
                                joueurs.add(joueur);
                                l.remove("Messager");
                            //initialisation des navigateurs
                            } else if(l.get(aléa1) == "Navigateur"){
                                Aventurier joueur = new Navigateur(s.get(nb));
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte d’Or")){
                                            joueur.setPosition(tuiles[y][x]);
                                            System.out.println("La position du navigateur est initialisé");
                                        }
                                    }
                                }
                                joueurs.add(joueur);
                                l.remove("Navigateur");
                                
                            //initialisation des pilotes
                            } else if(l.get(aléa1) == "Pilote"){
                                Aventurier joueur = new Pilote(s.get(nb));
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("Heliport")){
                                            joueur.setPosition(tuiles[y][x]);
                                            System.out.println("La position du pilote est initialisé");
                                        }
                                    }
                                }
                                l.remove("Pilote");
                                joueurs.add(joueur);
                                
                            //initialisation des plongeurs
                            } else if( l.get(aléa1) == "Plongeur"){
                                Aventurier joueur = new Plongeur(s.get(nb));
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Fer")){
                                            joueur.setPosition(tuiles[y][x]);
                                            System.out.println("La position du plongeur est initialisé");
                                        }
                                    }
                                }
                                l.remove("Plongeur");
                                joueurs.add(joueur);
                                
                            }
                            //Suppression de l'aventurier dans la liste des rôles dispo.
                            
                            
                            nb = nb +1;
                            
                        }
    }
    //à supprimer, c'est pour la visibilité pdt les tests.
    private void afficheJoueursListe(){
            for(int i = 0; i < joueurs.size();i++){
                            System.out.println("Le joueur "+joueurs.get(i).getPseudo()+" est un "+joueurs.get(i).getRôle());
                        }
    }
    private void tour1(){
            vueAventurier = new VueAventurier(joueurCourant.getPseudo(), joueurCourant.getRôle(),joueurCourant.getCouleur().getCouleur() );
            vueAventurier.addObserver(this);
            vueAventurier.afficher();
            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile()); // possibilité de le changer en while
            inscri.close();
    }
    private void déplacer(){
            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile());
            nombreAction=nombreAction-1;
    }
    private void assécher(){
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
    private void autreAction(){
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
    private void passerTour(){
        nombreAction=0;
    }
    private void changementTour(){
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
            if(joueurCourant.getClass() == Navigateur.class){
                nombreAction = 4;
            }else{
                nombreAction=3;                                
            }
            System.out.println("Changement de joueur");
            }
    }
            
}

