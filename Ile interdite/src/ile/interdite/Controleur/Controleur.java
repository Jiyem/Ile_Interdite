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
import ile.interdite.Modele.Cartes.CarteHelicoptere;
import ile.interdite.Modele.Cartes.CarteMonteeDesEaux;
import ile.interdite.Modele.Cartes.CarteSacDeSable;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Cartes.CarteTresor;
import ile.interdite.Modele.EtatCase;
import ile.interdite.Modele.Tuile;
import ile.interdite.Message.ActionsType;
import ile.interdite.Message.MessageAventurier;
import ile.interdite.Message.MessageInscription;
import ile.interdite.Vue.VueAventurier;
import ile.interdite.Vue.VueInscription;
import ile.interdite.Vue.VuePlateau;
import ile.interdite.Modele.Cartes.PaquetInnondation;
import ile.interdite.Modele.Cartes.CarteInnondation;
import ile.interdite.Modele.Cartes.TypeCarte;
import static ile.interdite.Modele.Cartes.TypeCarte.Helicoptere;
import static ile.interdite.Modele.Cartes.TypeCarte.SacDeSable;
import ile.interdite.Modele.Tresor;
import ile.interdite.Vue.VueMainTropGrande;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;
import ile.interdite.Modele.Cartes.TypeCarte;
import ile.interdite.Vue.VueFinDeTour;


/**
 *
 * @author rose
 */
public class Controleur implements Observer {
    private ArrayList<Aventurier>joueurs;
    private VueInscription inscri = new VueInscription();
    private VueAventurier vueAventurier;
    private VueFinDeTour vuefintour;
    private HashMap<Couleur, String> depart = new HashMap<>();
    private Grille grille;
    private int nombreAction;
    private int compteurCartesTirage=0;
    private int compteurInnondation=0;
    private int y=0; //une variable drapeau.
    private int niveau=0;
    private Tuile[][] tuiles;
    private MessageInscription message;
    private MessageAventurier messageAventurier;
    private Aventurier joueurCourant; 
    private VuePlateau plateau;
    private PaquetInnondation paquetInnondation = new PaquetInnondation();
    private ArrayList<CarteTirage> pileCartesTirage = new ArrayList<>();
    private ArrayList<CarteTirage> listeCartesDesAventuriers = new ArrayList<>(); //Liste des cartes spéciales qu'on les aventuriers pour pouvoir les utiliser n'importe quand...
    private VueMainTropGrande vueMuligan;
    
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
            } 
            else if (arg1 instanceof MessageInscription) {
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
            //Initialisation du paquet de carte tirage.
            this.initialisationPileCarteTirage();
            
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
                    //faire la fin du tour.;
                this.passerTour();
                }
                //Verification de fin de tour et changement tour
                this.changementTour();  
                    
//              if(joueurCourant.getCartes().size() == 9){
//              vueMuligan = new VueMainTropGrand(joueurCourant,nbCartesApriocher);
//              }
                }
                
                //Fin du tour de jeu : 
                if(arg1 instanceof String){    //Créer une action plutôt éventuellement..
                    if(arg1.equals("FINDUTOUR")){
                        this.changementJoueur();
                    }
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
    private void initialisationPileCarteTirage(){
        for(int i = 1;i<29;i++){
            //5 cartes de chaque tresor
            if(i>=1 && i<=5){
                CarteTresor tresor = new CarteTresor(Tresor.PIERRE);
                pileCartesTirage.add(tresor);
            }else if(i>=6 && i<=10){
                CarteTresor tresor = new CarteTresor(Tresor.ZEPHYR);
                pileCartesTirage.add(tresor);
            }else if(i>=11 && i<= 15){
                CarteTresor tresor = new CarteTresor(Tresor.CRISTAL);
                pileCartesTirage.add(tresor);
            }else if(i>=16 && i<= 20){
                CarteTresor tresor = new CarteTresor(Tresor.CALICE);
                pileCartesTirage.add(tresor);
            //3 cartes montée des eaux
            }else if(i>=21 && i<=23){
                CarteMonteeDesEaux carte = new CarteMonteeDesEaux();
                pileCartesTirage.add(carte);
            //3 cartes hélico
            }else if(i>=24 && i <=26){
                CarteHelicoptere carte= new CarteHelicoptere();
                pileCartesTirage.add(carte);
            //2 cartes sac de sable
            }else{
                CarteSacDeSable carte = new CarteSacDeSable();
                pileCartesTirage.add(carte);
            }
        }
        Collections.shuffle(pileCartesTirage);
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
            //prendre un trésor :
            if(joueurCourant.getPosition().possèdeTresor()){ //Si le joueur est sur une case de rendu de trésor
                int nbCartesDuTresor = 0;
                for(int i = 0; i<joueurCourant.getCartes().size();i++){
                    if(joueurCourant.getCartes().get(i).getType() == TypeCarte.Tresor){
                        if(joueurCourant.getCartes().get(i).getTresor() == joueurCourant.getPosition().getTresor()){
                            nbCartesDuTresor = nbCartesDuTresor +1;
                        }
                    }
                }
                if(nbCartesDuTresor >= 4){
                    System.out.println("Voulez vous récupérer le trésor"+joueurCourant.getPosition().getTresor().toString()+" ? (o/n)");
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Voulez-vous effectuer un deuxième assèchement ? (o/n)");
                    if(sc.nextLine().equals("o")){
                        Tresor tresor = joueurCourant.getPosition().getTresor();
                        joueurCourant.ajouterTresor(tresor); //don du trésor au joueur
                        grille.retirerTresor(tresor); //retirer le trésor de la grille
                        this.supprimerTresor(tresor); //Supprime la carte du trésor de la main des aventuriers + de la pioche.
                        nombreAction = nombreAction -1;
                    }    
                }
            }
            else{
                System.out.println("Vous n'avez pas encore accès aux actions speciales.");}
                //nombreAction=nombreAction-1; à ajouter plus tard   
            }
    }
    //supprime le trésor de la pile et de la main de tout les aventuriers
    private void supprimerTresor(Tresor tresor){
        for(int i = 0;i<pileCartesTirage.size();i++){
            if(pileCartesTirage.get(i).getTresor() == tresor){
                pileCartesTirage.remove(i);
            }
        }
        for(int i = 0;i<joueurs.size();i++){
            ArrayList<CarteTirage> cartes = joueurs.get(i).getCartes();
            for(y = 0;y<cartes.size();y++){
                if(cartes.get(y).getTresor() == tresor){
                    joueurs.get(i).enleverCarte(cartes.get(y));
                }
            }
        }
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
            
            //DEEGUEU A CHANGER EN FONCTION !
            //don des 2 cartes tirages
            joueurCourant.ajouterCartes(pileCartesTirage.get(0));
            joueurCourant.ajouterCartes(pileCartesTirage.get(1));
            //Ajout des 2 cartes dans la liste générale si carte hélico ou sac de sable
            if(pileCartesTirage.get(0).getType() == SacDeSable || pileCartesTirage.get(0).getType() == Helicoptere){
                listeCartesDesAventuriers.add(pileCartesTirage.get(0));
            }
            if(pileCartesTirage.get(1).getType() == SacDeSable || pileCartesTirage.get(1).getType() == Helicoptere){
                listeCartesDesAventuriers.add(pileCartesTirage.get(1));
            }
            // Ici à faire le tirage des innondation et mettre dans l'arraylist les tuiles innondés :
            ArrayList<Tuile> innondé = new ArrayList<>();
            
            
            //Afficher la vueFinDeTour :
            vuefintour = new VueFinDeTour(joueurCourant.getPseudo(),pileCartesTirage.get(0),pileCartesTirage.get(1),niveau,innondé);
            vuefintour.afficher();
          
            //changement de joueur
            joueurCourant = joueurs.get(y);
        }
    }
    
    private void changementJoueur(){
        vuefintour.close();
        
        
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
 

    public void verifPartiePerdu(){
        if(grille.verifHelioportEstIlCoulé() == true){
            //Faudra fermer les vues de jeu ici et peut etre ouvrir une vue de partie perdue
        }
        for(int i =0; i < joueurs.size();i++){ //On regarde sur tous les joueurs s'il peuvent se deplacer
            if(joueurs.get(i).getPosition().getEtatCase() == EtatCase.IMMERGEE){
                if(joueurs.get(i).déplacementPossible(grille).isEmpty()){
                    //Faudra fermer les vues de jeu ici et peut etre ouvrir une vue de partie perdue
                }
            }
        }
        
    }
    
    private void tirerCartesTrésor(){
        int nbMontéeEaux;
        CarteTirage[] cartesTirées = new CarteTirage[2];
        cartesTirées[0] = pileCartesTirage.get(compteurCartesTirage);
        cartesTirées[1] = pileCartesTirage.get(compteurCartesTirage+1);
        compteurCartesTirage += 2;
        //partie vue à faire
        
        //fin partie vue
        nbMontéeEaux = NbCartesMontéeEaux(cartesTirées);
        retirerMonteeDesEaux(cartesTirées, nbMontéeEaux);
        //envoyer cartesTirées à la vue aventurier -> les ajouter au tas de cartes des aventuriers
        
        //
        for(int i=0;i<2-nbMontéeEaux;i++){
            joueurCourant.ajouterCartes(cartesTirées[i]);
        }
        monteesDesEauxPiochees(nbMontéeEaux);
    }
    
    private int NbCartesMontéeEaux(CarteTirage[] cartes){
        int compteur=0;
        if(cartes[0].getType()==TypeCarte.MonteeDesEaux){
            compteur+=1;
        }
        if(cartes[1].getType()==TypeCarte.MonteeDesEaux){
            compteur+=1;
        }
        return compteur;
    }
    
    private void retirerMonteeDesEaux(CarteTirage[] cartes, int n){
        CarteTirage[] nouvellesCartes = new CarteTirage[2-n];
        int compteur=0;
        if(cartes[0].getType()!=TypeCarte.MonteeDesEaux){
            nouvellesCartes[compteur]=cartes[0];
            compteur+=1;     
        }
        if(cartes[1].getType()!=TypeCarte.MonteeDesEaux){
            nouvellesCartes[compteur]=cartes[1];
        }
        cartes = nouvellesCartes;
    }
    
    private void monteesDesEauxPiochees(int n){
        niveau+=n;
        //partie vue, juste monter le curseur de VueNiveau
        
        //
        paquetInnondation.melangeMonteeEaux(compteurInnondation);
        compteurInnondation=0;
    }
    
    private void tirerCartesInnondation(){
        if(niveau == 1 ||niveau == 2){
            tirageCartesInnondation(2);
        }
        if(niveau == 3 ||niveau == 4||niveau==5){
            tirageCartesInnondation(3);
        }
        if(niveau == 6 ||niveau == 7){
            tirageCartesInnondation(4);
        }
        if(niveau == 8 ||niveau == 9){
            tirageCartesInnondation(5);
        }
    }
    
    private void tirageCartesInnondation(int n){
        CarteInnondation[] cartesTirées = new CarteInnondation[n];
        for(int i=0;i<n;i++){
            cartesTirées[i] = paquetInnondation.getPaquet().get(compteurInnondation+n);
        }
        compteurInnondation+=n;
        for(int i=0;i<n;i++){
            for(int x=0;x<6;x++){
                for(int y=0;y<6;y++){
                    if(tuiles[x][y]!=null){
                        if(cartesTirées[i].getNomcarte() == tuiles[x][y].getNomTuile()){
                            if(tuiles[x][y].getEtatCase()==EtatCase.NORMAL){
                                tuiles[x][y].setEtatCase(EtatCase.INNONDEE);
                            }else if(tuiles[x][y].getEtatCase()==EtatCase.INNONDEE){
                                tuiles[x][y].setEtatCase(EtatCase.IMMERGEE);
                                paquetInnondation.retirer(cartesTirées[i].getNomcarte());
                            }
                        }
                    }
                }
            }
        }
    }
    
}

