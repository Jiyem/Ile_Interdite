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
import ile.interdite.Message.MessageAction;
import ile.interdite.Message.MessageAventurier;
import ile.interdite.Message.MessageCarte;
import ile.interdite.Message.MessageCarteSpe;
import ile.interdite.Message.MessageInscription;
import ile.interdite.Message.MessageMuligan;
import ile.interdite.Message.MessagePlateau;
import ile.interdite.Vue.VueInscription;
import ile.interdite.Vue.VuePlateau;
import ile.interdite.Modele.Cartes.PaquetInnondation;
import ile.interdite.Modele.Cartes.CarteInnondation;
import static ile.interdite.Modele.Cartes.TypeCarte.Helicoptere;
import static ile.interdite.Modele.Cartes.TypeCarte.SacDeSable;
import ile.interdite.Modele.Tresor;
import ile.interdite.Vue.VueMainTropGrande;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import ile.interdite.Modele.Cartes.TypeCarte;
import ile.interdite.Vue.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rose
 */
public class ControleurDemo implements Observer {
    private ArrayList<Aventurier>joueurs;
    private VueInscription inscri = new VueInscription();
    private VueAventurier vueAventurier;
    private VuePersonnages vuePersonnage;
    private VueCartesAventurier vueCarteAventurier;
    private VueFinDeTour vuefintour;
    private HashMap<Couleur, String> depart = new HashMap<>();
    private Grille grille;
    private double nombreAction;
    private int compteurInnondation=0;
    private int y=0; //une variable drapeau.
    private int niveau=1;
    private Tuile[][] tuiles;
    private MessageCarteSpe messageCarteSpe;
    private MessageInscription messageInscription;
    private MessageAventurier messageAventurier;
    private MessagePlateau messagePlateau;
    private Aventurier joueurCourant; 
    private VuePlateau plateau;
    private PaquetInnondation paquetInnondation = new PaquetInnondation();
    private ArrayList<CarteInnondation> defausseCartesInnondation = new ArrayList<>();
    private ArrayList<CarteTirage> pileCartesTirage = new ArrayList<>();
    private ArrayList<CarteTirage> defausseCartesTirage = new ArrayList<>();
    private ArrayList<CarteTirage> listeCartesDesAventuriers = new ArrayList<>(); //Liste des cartes spéciales qu'on les aventuriers pour pouvoir les utiliser n'importe quand...
    private VueMainTropGrande vueMuligan;
    private CarteInnondation[] cartesTirées;
    private CarteHelicoptere carteHelico =new CarteHelicoptere();
    private CarteSacDeSable carteSacDeSable = new CarteSacDeSable();
    private VueNiveau vueNiveau;
    private VueMainTropGrande vueMainTropGrande;
    private MessageMuligan messageMuligan;
    private VueCarteADonner vueDonnerCarte;
    private VueErreur erreur;
    
    
    public ControleurDemo(){
        joueurs=new ArrayList<>();
        inscri.addObserver(this);
        inscri.afficher();
    }
    @Override
    public void update(Observable arg0, Object arg1) {
                
            if (arg1 instanceof MessageCarteSpe){
                messageCarteSpe = (MessageCarteSpe) arg1;
                if (messageCarteSpe.getAction()==ActionsType.UTILISATION_CARTE_SABLE){
                    if (messageCarteSpe.getNbCarteSpe()!=0){
                        if (carteSacDeSable.assechable(grille)!=null){ // afficher les cases possible puis choisir case et changer l'état en normal
                            plateau.afficherAction(carteSacDeSable.assechable(grille), grille, joueurCourant, ActionsType.ASSECHER);
                            int x = 0;
                            while (listeCartesDesAventuriers.get(x).equals(carteHelico)){
                                x+=1;
                            }
                            listeCartesDesAventuriers.remove(x);
                        }
                    }    
                }        
                if (messageCarteSpe.getAction()==ActionsType.UTILISATION_CARTE_HELICO){
                    if (messageCarteSpe.getNbCarteSpe()!=0){    
                        if (carteHelico.deplacable(grille)!=null){
                            plateau.afficherAction(carteHelico.deplacable(grille), grille, joueurCourant, ActionsType.DEPLACER);
                            int x = 0;
                            while (listeCartesDesAventuriers.get(x).equals(carteSacDeSable)){
                                x+=1;
                            }
                            listeCartesDesAventuriers.remove(x);
                    
                        }
                    }
                }
            }    
        
        
                if (arg1 instanceof MessageInscription) {
                messageInscription = (MessageInscription) arg1 ;
                //Si l'utilisateur clic sur validé
                if (messageInscription.getAction() == ActionsType.VALIDE) {
                    System.out.println("L'utilisateur a validé");                 
                    //Si le nombre de joueur est bien compris entre 2 et 4 (inclu)
                    if (messageInscription.getNbJoueurs() > 1 && messageInscription.getNbJoueurs() < 5) {
                        //Initialisation de la grille.
                        this.initialisationGrille();
                        
                        
                        
                        
                        
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
                    if (messageInscription.getNbJoueurs() == 0){
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
                    vueAventurier.griserBoutons(true);
                    this.ouAller();
                    

                }
                else if(messageAventurier.getAction()==ActionsType.AUTREACTION){
                    if(joueurCourant.getRôle().equals("pilote")){
                        //faire le déplacement spécial du pilote:
                        vueAventurier.griserBoutons(true);
                        this.ouAllerPilote();
                        
                    }
                }
                else if(messageAventurier.getAction()==ActionsType.ASSECHER){
                    //faire l'assecheemnt
                    vueAventurier.griserBoutons(true);
                    this.ouAssecher();
                    
                }
                else if(messageAventurier.getAction()==ActionsType.RECUP_TRESOR){
                    //faire l'assecheemnt
                    vueAventurier.griserBoutons(true);
                    this.recupererTresor();
                    
                }
                else if(messageAventurier.getAction()==ActionsType.DONNERCARTE){
                    Aventurier aventurier = null;
                    for(Aventurier av : joueurs){
                        if (av.getPosition().equals(joueurCourant.getPosition()) && av != joueurCourant){
                            aventurier=av;
                        }
                    }
                    System.out.println("Av: "+aventurier);
                    if(aventurier == null){
                        erreur = new VueErreur("Il n'y a pas d'autre joueurs sur votre tuile.");
                        erreur.afficher();
                        erreur.addObserver(this);
                    }else{
                        vueAventurier.griserBoutons(true);
                        vueDonnerCarte = new VueCarteADonner(joueurs,joueurCourant);
                        vueDonnerCarte.addObserver(this);
                        vueDonnerCarte.afficher();
                        //this.muliganCartes(messageMuligan.getListecartes());                        
                    }

                    
                    
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
                
                if(arg1 instanceof MessageAction){
                    MessageAction messageAction = (MessageAction) arg1;
                    
                       if(messageAction.getAction()== ActionsType.DEPLACER){

                        for (int y = 0; y < 6; y++) {
                            for (int x = 0; x < 6; x++) {
                                if(grille.getTuile()[y][x] != null && grille.getTuile()[y][x].getNumTuile() == messageAction.getNumTuile()){
                                    this.déplacer(grille.getTuile()[y][x]);
//                                    plateau.clearAction(messageAction.getCliquables());
                                }
                            }
                        }
                    }
                    else if(messageAction.getAction()== ActionsType.ASSECHER){
                        for (int y = 0; y < 6; y++) {
                            for (int x = 0; x < 6; x++) {
                                if(grille.getTuile()[y][x] != null && grille.getTuile()[y][x].getNumTuile() == messageAction.getNumTuile()){
                                    this.assécher(grille.getTuile()[y][x]);
                                }
                            }
                        }    
                    }
                    System.out.println("Nb Actions: "+nombreAction);
                    if(!joueurCourant.getRôle().equals("ingenieur")  && nombreAction == 0){
                        this.changementTour();
                    }else if(joueurCourant.getRôle().equals("ingenieur") && nombreAction == 0.5){
                        vueAventurier.griserBoutonsIngé(true);
                    }else if(joueurCourant.getRôle().equals("ingenieur") && nombreAction < 0.5){
                        this.changementTour();
                    }
                    plateau.majPlateau(grille); 
                    }
                
                if(arg1 instanceof MessageCarte){
                    MessageCarte messageCarte = (MessageCarte) arg1;
                    if (messageCarte.getAction()==ActionsType.DONNERCARTE){
                        int i = 0;
                        while(i < joueurs.size() && !joueurs.get(i).getPseudo().equals(messageCarte.getAv())){
                            i +=1;
                        }
                        joueurCourant.donnerCarte(joueurs.get(i),messageCarte.getCarte());
                        vueAventurier.griserBoutons(false);
                        nombreAction = nombreAction -1;
                        vueDonnerCarte.fermer();
                    }
                }
                    
                    
                
            
            
            
            
                /************ Message Provenant du plateau ************/
                if(arg1 instanceof MessagePlateau){
                    messagePlateau = (MessagePlateau) arg1;
                    if (messagePlateau.getAction()==ActionsType.PAGE_PERSONNAGE){
                        vueCarteAventurier= new VueCartesAventurier(messagePlateau.getJoueur());
                        vueCarteAventurier.afficher();
                    }
                }
                //Fin du tour de jeu : 
                if(arg1 instanceof String){    //Créer une action plutôt éventuellement..
                    String string = (String) arg1;
                    if(string.equals("FINDUTOUR")){
                        this.changementJoueur();
                    }
                    if(string.equals("VALIDERERREUR")){
                        erreur.close();
                        vueAventurier.griserBoutons(false);
                    }
                }
                
                if(arg1 instanceof MessageMuligan){
                    messageMuligan = (MessageMuligan) arg1;
                    this.muliganCartes(messageMuligan.getListecartes());

                    vueMainTropGrande.fermer();
                }
                

                  
    }
    private boolean verifVictoire(){
        boolean victoire=false;
        if(this.tresorRecupéré(Tresor.PIERRE) && this.tresorRecupéré(Tresor.CALICE) && this.tresorRecupéré(Tresor.CRISTAL) && this.tresorRecupéré(Tresor.ZEPHYR)){
            boolean verifHeliJoueurs = true;
            for(int i = 0;i <joueurs.size();i++){
                if(!joueurs.get(i).getPosition().getNomTuile().equals("Heliport")){
                    verifHeliJoueurs = false;
                }
            }
            if(verifHeliJoueurs){
               for(int i=0;i<listeCartesDesAventuriers.size();i++){
                   if(listeCartesDesAventuriers.get(i).getType()==TypeCarte.Helicoptere){
                       victoire=true;
                   }
               }
            }
   
        }
        return victoire;
    }
    
    //Les méthodes utilisés pour le contrôleur :
    private void initialisationGrille(){
        grille = new Grille();
    }
    private void initialisationJoueurs(){
                        Aventurier joueur1 = new Ingenieur(messageInscription.getPseudo1());
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Bronze")){
                                            joueur1.setPosition(tuiles[y][x]);
                                            System.out.println("La position du ingénieur est initialisé");
                                        }
                                    }      
                                }
                        joueurs.add(joueur1);
                        Aventurier joueur2 = new Pilote(messageInscription.getPseudo2());
                                for (int y = 0; y < 6; y++) {
                                    for (int x = 0; x < 6; x++) {
                                        if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("Heliport")){
                                            joueur2.setPosition(tuiles[y][x]);
                                            System.out.println("La position du pilote est initialisé");
                                        }
                                    }
                                } 
                        joueurs.add(joueur2);
                        Aventurier joueur3 = new Plongeur(messageInscription.getPseudo3());
                            for (int y = 0; y < 6; y++) {
                                for (int x = 0; x < 6; x++) {
                                    if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Fer")){
                                        joueur3.setPosition(tuiles[y][x]);
                                        System.out.println("La position du plongeur est initialisé");
                                    }
                                }
                            }
                        joueurs.add(joueur3);
                        

                        Aventurier joueur4 = new Explorateur(messageInscription.getPseudo4());
                            for(int y = 0; y < 6; y++) {
                                for (int x = 0; x < 6; x++) {
                                    if(tuiles[y][x] != null && tuiles[y][x].getNomTuile().equals("La Porte de Cuivre")){
                                        joueur4.setPosition(tuiles[y][x]);
                                        System.out.println("La position de l'explorateur est initialisée");
                                        }
                                    }
                                }
                        joueurs.add(joueur4);
                        }
    
    private void initialisationPileCarteTirage(){
        for(int i = 1;i<8;i++){
            //5 cartes de chaque tresor
            if(i>=1 && i<2){
                CarteMonteeDesEaux carte = new CarteMonteeDesEaux();
                pileCartesTirage.add(carte);
            //3 cartes hélico
            }else if(i>=3 && i <=5){
                CarteHelicoptere carte= new CarteHelicoptere();
                pileCartesTirage.add(carte);
            //2 cartes sac de sable
            }else{
                CarteSacDeSable carte = new CarteSacDeSable();
                pileCartesTirage.add(carte);
            }
           // ======================================================================
           // Cartes données aux aventurier pour la démo
           
            
            
            
        }
        CarteTresor tresor = new CarteTresor(Tresor.CALICE);
        joueurs.get(0).ajouterCartes(tresor);
        
        CarteTresor tresor2 = new CarteTresor(Tresor.CALICE);
        CarteTresor tresor3 = new CarteTresor(Tresor.CALICE);
        CarteTresor tresor4 = new CarteTresor(Tresor.CALICE);
        joueurs.get(1).ajouterCartes(tresor2);
        joueurs.get(1).ajouterCartes(tresor3);
        joueurs.get(1).ajouterCartes(tresor4);

        Collections.shuffle(pileCartesTirage);
    }
    
    //à supprimer, c'est pour la visibilité pdt les tests.
    private void afficheJoueursListe(){
            for(int i = 0; i < joueurs.size();i++){
                            System.out.println("Le joueur "+joueurs.get(i).getPseudo()+" est un "+joueurs.get(i).getRôle());
                        }
    }
    private void tour1(){
            vueAventurier = new VueAventurier(joueurCourant.getPseudo(), joueurCourant.getRôle(),joueurCourant.getCouleur().getCouleur());
            vueAventurier.addObserver(this);
            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile());
            
            vueNiveau = new VueNiveau(niveau);
            try {
                plateau = new VuePlateau(grille, joueurs, listeCartesDesAventuriers,vueAventurier, vueNiveau);
//                
            } catch (IOException ex) {
                Logger.getLogger(ControleurDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            plateau.afficher();
            plateau.addObserver(this);
            plateau.getVueCartesSpé().addObserver(this);

            inscri.close();
    }
    private void déplacer(Tuile tuile){
            vueAventurier.setPosition(tuile.getNomTuile());
            joueurCourant.setPosition(tuile);
            vueAventurier.griserBoutons(false);
            nombreAction=nombreAction-1;
    }
    private void assécher(Tuile tuile){
        tuile.setEtatCase(EtatCase.NORMAL);
        if(joueurCourant.getRôle().equals("ingenieur")){
                vueAventurier.griserBoutons(false);
                nombreAction = nombreAction -0.5;                       
        }else{
            vueAventurier.griserBoutons(false);
            nombreAction = nombreAction -1;           
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
    
    private void recupererTresor(){
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
            System.out.println("Il n'y à pas de trésor ici !");
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
            int y=0;
            ArrayList<CarteTirage> cartes = joueurs.get(i).getCartes();
            while(y<cartes.size()){
                System.out.println(joueurs.get(i).getCartes().size());
                if(joueurs.get(i).getCartes().get(y).getTresor() == tresor){
                    joueurs.get(i).enleverCarte(joueurs.get(i).getCartes().get(y));
                    y-=1;
                }
                y+=1;
            }
        }
    }
    
    private void passerTour(){
        nombreAction=0;
    }
    private void changementTour(){
        CarteTirage[] cartes = new CarteTirage[2];
        if(nombreAction == 0){
            if(y<joueurs.size()-1){
                y=y+1;                            
            }else {
                y = 0;
            }
            System.out.print(y);
            
            this.tirerCartesInnondation();
            cartes = this.tirerCartesTrésor();
            
            //Afficher la vueFinDeTour :
            vuefintour = new VueFinDeTour(joueurCourant.getPseudo(),cartes[0],cartes[1],niveau,cartesTirées);
            vuefintour.afficher();
            vuefintour.addObserver(this);
            //on reset l'action spé du pilote a un si c'est un pilote
            if(joueurCourant.getRôle().equals("pilote")){
                Pilote pilote = (Pilote) joueurCourant;
                pilote.setActionSpe(1);
            }
            
            //verif victoire et defaite
            if(this.verifVictoire()){
                //faire le traitement en cas de victoire
            }else{
                this.verifPartiePerdu();
                //changement de joueur
                joueurCourant = joueurs.get(y);
            }
            
            //Verif si la main du joueur est trop grande
            if(joueurCourant.getnbCartes() > 9 ){
                    vueMainTropGrande = new VueMainTropGrande(joueurCourant,joueurCourant.getnbCartes()-9);
                    vueMainTropGrande.addObserver(this);
                    vueMainTropGrande.afficher();
            }
        }
    }
        
    private void changementJoueur(){
            vuefintour.close();
            vueAventurier = new VueAventurier(joueurCourant.getPseudo(), joueurCourant.getRôle(),joueurCourant.getCouleur().getCouleur());
            vueAventurier.addObserver(this);
            vueAventurier.setPosition(joueurCourant.getPosition().getNomTuile());
            
            vueNiveau = new VueNiveau(niveau);
            
            plateau.fermer();
            try {
                plateau = new VuePlateau(grille, joueurs, listeCartesDesAventuriers,vueAventurier, vueNiveau);
//                
            } catch (IOException ex) {
                Logger.getLogger(ControleurDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            plateau.afficher();
            plateau.addObserver(this);
            plateau.getVueCartesSpé().addObserver(this);
            
        if(joueurCourant.getClass() == Navigateur.class){
            nombreAction = 4;
        }else{
            nombreAction=3;                                
        }
       }
 

    public void verifPartiePerdu(){
        if(grille.verifHelioportEstIlCoulé() == true){
            PartiePerdue partiePerdue = new PartiePerdue();
            partiePerdue.heliportCoule();
            partiePerdue.afficher();
        }
        if(niveau==10){
            PartiePerdue partiePerdue = new PartiePerdue();
            partiePerdue.marqueurMort();
            partiePerdue.afficher();
        }
        for(int i =0; i < joueurs.size();i++){ //On regarde sur tous les joueurs s'il peuvent se deplacer
            if(joueurs.get(i).getPosition().getEtatCase() == EtatCase.IMMERGEE){
                if(joueurs.get(i).déplacementPossible(grille).isEmpty()){
                    PartiePerdue partiePerdue = new PartiePerdue();
                    partiePerdue.joueurNoye(joueurs.get(i).getPseudo());
                    partiePerdue.afficher();
                }
            }
        }
        if(tresorRecupéré(Tresor.ZEPHYR)==false 
        && estCoulé("Le Jardin des Hurlements") 
        && estCoulé("Le Jardin des Murmures")){
            PartiePerdue partiePerdue = new PartiePerdue();
            partiePerdue.nonRecupTresor("Statue du zéphyr");
            partiePerdue.afficher();
        }
        if(tresorRecupéré(Tresor.CRISTAL)==false 
        && estCoulé("La Caverne du Brasier") 
        && estCoulé("La Caverne des Ombres")){
            PartiePerdue partiePerdue = new PartiePerdue();
            partiePerdue.nonRecupTresor("Cristal ardent");
            partiePerdue.afficher();
        }
        if(tresorRecupéré(Tresor.PIERRE)==false 
        && estCoulé("Le Temple de La Lune") 
        && estCoulé("Le Temple du Soleil")){
            PartiePerdue partiePerdue = new PartiePerdue();
            partiePerdue.nonRecupTresor("Pierre sacrée");
            partiePerdue.afficher();
        }
        if(tresorRecupéré(Tresor.CALICE)==false 
        && estCoulé("Le Palais des Marees")
        && estCoulé("Le Palais de Corail")){
            PartiePerdue partiePerdue = new PartiePerdue();
            partiePerdue.nonRecupTresor("Calice de l'onde");
            partiePerdue.afficher();
        }
    }
    
    private boolean estCoulé(String nom){
        boolean coulé=true;
        for(int i=0;i<paquetInnondation.getPaquet().size();i++){
            if(paquetInnondation.getPaquet().get(i).getNomcarte().equals(nom)){
                coulé=false;
            }
        }
        return coulé;
    }
    
    private boolean tresorRecupéré(Tresor t){
        boolean recup=false;
        for (Aventurier joueur : joueurs) {
            if(joueur.getTresors().contains(t)){
                recup=true;
            }
        }
        return recup;
    }
    
    private void retirerCarte(Aventurier joueur, CarteTirage carte){
        joueur.enleverCarte(carte);
        int i=0;
        while(i<listeCartesDesAventuriers.size() && listeCartesDesAventuriers.get(i)!=carte){
            if(listeCartesDesAventuriers.get(i)==carte){
                listeCartesDesAventuriers.remove(carte);
                defausseCartesTirage.add(carte);
            }
            i+=1;
        }
    }
    
    private CarteTirage[] tirerCartesTrésor(){
        int nbMontéeEaux;
        CarteTirage[] cartesRetourn = new CarteTirage[2];
        CarteTirage[] cartesTirées = new CarteTirage[2];
        cartesTirées[0] = pileCartesTirage.get(0);
        pileCartesTirage.remove(0);
        if(pileCartesTirage.isEmpty()){
            melangeTirage();
        }
        cartesTirées[1] = pileCartesTirage.get(0);
        pileCartesTirage.remove(0);
        if(pileCartesTirage.isEmpty()){
            melangeTirage();
        }
        cartesRetourn = cartesTirées;
        //partie vue à faire
        
        //fin partie vue
        nbMontéeEaux = NbCartesMontéeEaux(cartesTirées);
        for(int i=0;i<2;i++){
            if(cartesTirées[i].getType()==TypeCarte.MonteeDesEaux){
                defausseCartesTirage.add(cartesTirées[i]);
            }
        }
        cartesTirées = retirerMonteeDesEaux(cartesTirées, nbMontéeEaux);
        //envoyer cartesTirées à la vue aventurier -> les ajouter au tas de cartes des aventuriers
        
        //
        for(int i=0;i<2-nbMontéeEaux;i++){
            joueurCourant.ajouterCartes(cartesTirées[i]);
            if(cartesTirées[i].getType()==SacDeSable || cartesTirées[i].getType()==Helicoptere){
                listeCartesDesAventuriers.add(cartesTirées[i]);
            }
        }
        if(nbMontéeEaux!=0){
            monteesDesEauxPiochees(nbMontéeEaux);
        }
        return cartesRetourn;

    }
    
    private void melangeTirage(){
        for(int i=0;i<defausseCartesTirage.size();i++){
                pileCartesTirage.add(defausseCartesTirage.get(i));
            }
        Collections.shuffle(pileCartesTirage);
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
    
    private CarteTirage[] retirerMonteeDesEaux(CarteTirage[] cartes, int n){
        CarteTirage[] nouvellesCartes = new CarteTirage[2-n];
        int compteur=0;
        if(cartes[0].getType()!=TypeCarte.MonteeDesEaux){
            nouvellesCartes[compteur]=cartes[0];
            compteur+=1;     
        }
        if(cartes[1].getType()!=TypeCarte.MonteeDesEaux){
            nouvellesCartes[compteur]=cartes[1];
        }
        return nouvellesCartes;
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
        int k;
        if(n>paquetInnondation.getPaquet().size()){
            k=paquetInnondation.getPaquet().size();
        }else{
            k=n;
        }
        cartesTirées = new CarteInnondation[k];
        int x,y;
        for(int i=0;i<k;i++){
            if(compteurInnondation+i>=paquetInnondation.getPaquet().size()){
                compteurInnondation=0;
                paquetInnondation.melanger();
            }
            cartesTirées[i] = paquetInnondation.getPaquet().get(compteurInnondation+i);
        }
        compteurInnondation=compteurInnondation+k;
        for(int i=0;i<k;i++){
            x=0;
            y=0;
            while(x<6 && (tuiles[x][y]==null ||(cartesTirées[i].getNomcarte() != tuiles[x][y].getNomTuile()))){
                if(y!=5){    
                    y+=1;   
                }else{
                    y=0;
                    x+=1;
                }
            }   
            
                if(x!=6){
                    
                        
                System.out.println("la carte : "+tuiles[x][y].getNomTuile()+" et "+cartesTirées[i].getNomcarte());

                        if(cartesTirées[i].getNomcarte().equals(tuiles[x][y].getNomTuile())){
                            System.out.println("tamere");
                            if(tuiles[x][y].getEtatCase()==EtatCase.NORMAL){
                                System.out.println("La tuile normal :"+tuiles[x][y].getNomTuile()+" est maintenant innondée");
                                grille.getTuile()[x][y].setEtatCase(EtatCase.INNONDEE);
                                tuiles[x][y].setEtatCase(EtatCase.INNONDEE);
                            }else if(tuiles[x][y].getEtatCase()==EtatCase.INNONDEE){
                                System.out.println("La tuile innondée :"+tuiles[x][y].getNomTuile()+" est maintenant immergée");
                                grille.getTuile()[x][y].setEtatCase(EtatCase.IMMERGEE);
                                tuiles[x][y].setEtatCase(EtatCase.IMMERGEE);
                                paquetInnondation.retirer(cartesTirées[i].getNomcarte());
                                System.out.println("carte "+cartesTirées[i].getNomcarte()+" retirée du jeu");
                            }
                        }
                        
                    
                    
                    
                }        
                
            }
        //on ajoute les deux cartes dans la defausse
        
        
        
    }
    
    private void ouAller(){
        ArrayList<Tuile> deplacementPossible = new ArrayList();
        deplacementPossible = joueurCourant.déplacementPossible(grille);// faire en sorte que l'on calcule ses mouvement possible puis qu'on l'affiche sur la grille/consonle
        if(deplacementPossible.isEmpty()){
            erreur = new VueErreur("Vous n'avez nul part ou aller !");
            vueAventurier.griserBoutons(true);
            erreur.afficher();
            erreur.addObserver(this);
        }else{
            plateau.afficherAction(deplacementPossible,grille,joueurCourant,ActionsType.DEPLACER);
        } 
    }
    private void ouAllerPilote(){
        Pilote pilote = (Pilote) joueurCourant;
        if(pilote.getActionSpe()>0){
            ArrayList<Tuile> deplacementPossible = new ArrayList();
            deplacementPossible = grille.déplacementPossiblePilote(pilote);// faire en sorte que l'on calcule ses mouvement possible puis qu'on l'affiche sur la grille/consonle
            if(deplacementPossible.isEmpty()){
                erreur = new VueErreur("Vous n'avez nul part ou aller !"); //remplacé par un message sur le plateau
                vueAventurier.griserBoutons(true);
                erreur.afficher();
                erreur.addObserver(this);
            }else{
                plateau.afficherAction(deplacementPossible,grille,joueurCourant,ActionsType.DEPLACER);
                pilote.setActionSpe(0);
            }   
        }else{
            erreur = new VueErreur("Vous avez déjà utilisé votre action spéciale");
            vueAventurier.griserBoutons(true);
            erreur.afficher();
            erreur.addObserver(this);
        }

    }
    
    public void muliganCartes(ArrayList<CarteTirage> listeBoutonValide){
            for(int y=0;y<listeBoutonValide.size();y++){
                    this.retirerCarte(joueurCourant,listeBoutonValide.get(y));
            }
        }    
    
    
//    public void CartesADonner(ArrayList<CarteTirage> listeBoutonValide, Aventurier a){
//        for(int  i=0; i <joueurCourant.getCartes().size();i++){
//            for(int y=0;y<listeBoutonValide.size();y++){
//                if(listeBoutonValide.get(y) == joueurCourant.getCartes().get(i)){
//                    CarteTirage t = joueurCourant.getCartes().get(i);
//                    joueurCourant.donnerCarte(listeBoutonValide.get(i),a);
//                }    
//            }
//        }
            
//    }
    
    private void ouAssecher(){
        ArrayList<Tuile> assechementPossible = new ArrayList();
        assechementPossible = joueurCourant.assèchementPossible(grille);
        if(assechementPossible.isEmpty()){
            erreur = new VueErreur("Vous n'avez aucune tuile à assecher.");
            vueAventurier.griserBoutons(true);
            erreur.afficher();
            erreur.addObserver(this);
            
        }else{
            plateau.afficherAction(assechementPossible,grille,joueurCourant,ActionsType.ASSECHER);
        } 
    }

    private CarteTirage stringToCarte(String carte) {
        CarteTirage carteARendre = null;
        for (CarteTirage carteT : joueurCourant.getCartes()){
         if(carteT.getType().name().equals(carte)){
            carteARendre=carteT;
         }    
        }
        return carteARendre;
    }
    
}


