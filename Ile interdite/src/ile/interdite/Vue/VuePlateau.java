/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.Message;
import ile.interdite.Message.MessageAction;
import ile.interdite.Message.MessagePlateau;
import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.EtatCase;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rose
 */
public class VuePlateau extends Observable{
    
    private JFrame window;
    private Color etat_normal = new Color(255, 255, 100);
    private Color etat_innondé = new Color(179, 229, 255);
    private Color etat_immergé = new Color(100,100,100);
    private ArrayList<JButton> btnTuile = new ArrayList<>();
    private HashMap<Aventurier,JLabel> labelPion = new HashMap<>();
    
    private JPanel plateau;
    private JPanel menu;
    private VueAventurier aventurier;
    private VuePersonnages_1 personnages;
//    private VuePersonnages personnages;
    private VueCartesSpé cartesSpe;
    private JPanel mainPanel;
    private Aventurier joueur;
    private VueNiveau niveau;
    private JPanel margeplateau;
    private ArrayList<CarteTirage> cartes;
    private ArrayList<JButton> btnListé = new ArrayList<>();
    private ArrayList<Aventurier> joueurs; 
    private boolean test;
    private  JPanel basTuile;
    
    public VuePlateau(Grille g, ArrayList<Aventurier> joueurs,ArrayList<CarteTirage> cartes,VueAventurier vueAventurier, VueNiveau vueNiveau) throws IOException{
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(2000, 1200);
        this.joueurs = joueurs;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        margeplateau = new JPanel(new BorderLayout());
        margeplateau.add(new JLabel("     "), BorderLayout.EAST);
        margeplateau.add(new JLabel("     "), BorderLayout.WEST);
        plateau = new JPanel();
        this.initPlateau(g);
        mainPanel.add(margeplateau);
        this.cartes = cartes;
        
        
        
        
        personnages = new VuePersonnages_1(joueurs);
//        for(int i = 0; i<personnages.getButton().size();i++){
//            joueur = joueurs.get(i);
//            personnages.getButton().get(i).addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    setChanged();
//                    notifyObservers(new MessagePlateau(ActionsType.PAGE_PERSONNAGE,joueur));
//                    clearChanged();
//                }
//            });
//            
//        }
        personnages.getButton().get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    setChanged();
                    notifyObservers(new MessagePlateau(ActionsType.PAGE_PERSONNAGE,joueurs.get(0)));
                    clearChanged();            }
        });

        personnages.getButton().get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    setChanged();
                    notifyObservers(new MessagePlateau(ActionsType.PAGE_PERSONNAGE,joueurs.get(1)));
                    clearChanged();            }
        });

        personnages.getButton().get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    setChanged();
                    notifyObservers(new MessagePlateau(ActionsType.PAGE_PERSONNAGE,joueurs.get(2)));
                    clearChanged();            }
        });

        personnages.getButton().get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    setChanged();
                    notifyObservers(new MessagePlateau(ActionsType.PAGE_PERSONNAGE,joueurs.get(3)));
                    clearChanged();            }
        });
        
        menu = new JPanel(new GridLayout(3,1));
        menu.add(personnages);

        
        aventurier = vueAventurier;
        menu.add(aventurier.getMainPanel());
        
        cartesSpe = new VueCartesSpé(cartes);
        menu.add(cartesSpe.getMainPanel());
        
        
        
        mainPanel.add(menu,BorderLayout.EAST);
        
        niveau = vueNiveau;
        mainPanel.add(niveau.getMainPanel(), BorderLayout.WEST);
        
        
        
        

    }
//    public void majVueNiveau(VueNiveau vueNiveau){
//        mainPanel.remove(menu);
//        
//        niveau = vueNiveau;
//        mainPanel.add(niveau.getMainPanel(), BorderLayout.WEST);
//    }
//    
//    public void majVueAventurier(VueAventurier vueAventurier){
//        menu.remove(aventurier.getMainPanel());
//        aventurier = vueAventurier;
//        menu.add(aventurier.getMainPanel());
//        
//    }
    
    
    public void initPlateau(Grille g){
        JPanel tuiles = new JPanel(new GridLayout(6, 6));
        int nb=0;
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                JPanel tuilespecifique = new JPanel(new BorderLayout());
                basTuile = new JPanel(new GridLayout(1,4));
                
                tuiles.add(tuilespecifique);
                tuilespecifique.add(basTuile,BorderLayout.SOUTH);   
                
//                if ((y == 0 && x == 0) || (y == 0 && x == 1) || (y == 0 && x == 4) || (y == 0 && x == 5) || (y == 1 && x == 0) || (y == 1 && x == 5) || (y == 4 && x == 0) || (y == 4 && x == 5) || (y == 5 && x == 0) || (y == 5 && x == 1) || (y == 5 && x == 4) || (y == 5 && x == 5)) {
//                    JButton tuileVide = new JButton();
//                    tuileVide.setContentAreaFilled(false);
//                    tuileVide.setBorderPainted(false);
//                    tuileVide.setFocusPainted(false);
//                    tuiles.add(tuileVide);

                if ((y == 0 && x == 0) || (y == 0 && x == 5) || (y == 5 && x == 0) || (y == 5 && x == 5)) {
                    JButton tuileVide = new JButton();
                    tuileVide.setContentAreaFilled(false);
                    tuileVide.setBorderPainted(false);
                    tuileVide.setFocusPainted(false);
                    tuilespecifique.add(tuileVide,BorderLayout.CENTER);
                }
                else if((y == 0 && x == 1) || (y == 0 && x == 4) || (y == 1 && x == 0) || (y == 1 && x == 5) || (y == 4 && x == 0) || (y == 4 && x == 5) || (y == 5 && x == 1) || (y == 5 && x == 4)){
                    JButton tuileVide = new JButton();
                    tuileVide.setContentAreaFilled(false);
                    tuileVide.setBorderPainted(false);
                    tuileVide.setFocusPainted(false);
                    tuilespecifique.add(tuileVide,BorderLayout.CENTER);
                }
                
                else {
                    int col = y;
                    int row = x;
                    nb = nb + 1;
                    JButton tuile = new JButton();
                    
                    
                    this.majCouleur(tuile,g.getTuile()[y][x] );
                    
                    
                        
                        for(int u=0 ;u<joueurs.size();u++){
                          JLabel pion = new JLabel(" ");
                          
                          pion.setBorder(BorderFactory.createLineBorder(Color.black));
                            labelPion.put(joueurs.get(u),pion);
                            basTuile.add(pion);
                            
                        }
                        
                    for(int p=0 ;p<joueurs.size();p++){    
                        this.majCouleurPionPlateau(g.getTuile()[y][x]);
                        
                    }
                    
                        
                    
                    tuile.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                    
                    btnTuile.add(tuile);
                    tuilespecifique.add(tuile,BorderLayout.CENTER);
                        tuile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            setChanged();
                            notifyObservers(new MessagePlateau(ActionsType.SELECTION_CASE,col,row,btnTuile.indexOf(tuile)+1));
                            clearChanged();
                        }
                    });
                }

            }

        }
        
        //A changer pour tout autre jpanel ou borderlayout ou autre !
        margeplateau.add(tuiles,BorderLayout.CENTER);
    }
    
    public void majPlateau(Grille g){
        int cpt = 0;
            for (int y = 0; y < 6; y++) {
                for (int x = 0; x < 6; x++) {
                        if(g.getTuile()[y][x] != null){
                            JButton tuile = btnTuile.get(cpt);
                            this.majCouleur(tuile,g.getTuile()[y][x] );
                            btnTuile.get(cpt).setEnabled(true);
                            cpt +=1;
                            
                        } 
                    
                }

            }  
        }
   
    
    public void afficherAction(ArrayList<Tuile> tuiles,Grille g,Aventurier joueurCourant,ActionsType action){
        ArrayList<JButton> cliquables = new ArrayList<>();
            for (int y = 0; y < 6; y++) {
                for (int x = 0; x < 6; x++) {
                    boolean verif = true;
                    for(int i = 0;i<tuiles.size();i++){
                        if(g.getTuile()[y][x] == null || g.getTuile()[y][x].getNumTuile() == tuiles.get(i).getNumTuile()){
                            verif = false;
                        }
                    }
                    if(verif){
                        Tuile tuileAModifier = g.getTuile()[y][x];
                        if(tuileAModifier.getEtatCase() == EtatCase.NORMAL){
                            btnTuile.get(g.getTuile()[y][x].getNumTuile()-1).setDisabledIcon(tuileAModifier.getImage().getImageAAfficher());
                            btnTuile.get(g.getTuile()[y][x].getNumTuile()-1).setBackground(Color.DARK_GRAY);
                        }
                        else if(tuileAModifier.getEtatCase() == EtatCase.INNONDEE){
                            btnTuile.get(g.getTuile()[y][x].getNumTuile()-1).setDisabledIcon(tuileAModifier.getImageInnondée().getImageAAfficher());
                            btnTuile.get(g.getTuile()[y][x].getNumTuile()-1).setBackground(Color.DARK_GRAY);
                        }
                        btnTuile.get(g.getTuile()[y][x].getNumTuile()-1).setEnabled(false);
                    }
                    else if(g.getTuile()[y][x] != null){
                        cliquables.add(btnTuile.get(g.getTuile()[y][x].getNumTuile()-1)); //puisque le pilote peut aller partout l'arrayList est vide donc ça fais null pointeur exception
                    }
                    
                }
            }
            btnTuile.get(joueurCourant.getPosition().getNumTuile()-1).setBackground(joueurCourant.getCouleur().getCouleur());
            this.clicAction(cliquables,action);
            
        }
    
    public void clicAction(ArrayList<JButton> cliquables,ActionsType action){
        boolean dansliste;
        for(int i = 0;i<cliquables.size();i++){
            for(int y = 0;y<btnTuile.size();y++){
                
                if(cliquables.get(i) == btnTuile.get(y)){
                    int num = y +1 ;
                    ActionListener probTest = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        setChanged();
                        if(action == ActionsType.DEPLACER){
                            notifyObservers(new MessageAction(ActionsType.DEPLACER,num));

                        }else if(action == ActionsType.ASSECHER){
                            notifyObservers(new MessageAction(ActionsType.ASSECHER,num));
                        }

                        clearChanged();
                        }
                    };
                    dansliste = false;
                    
                    int z = 0;
                    while(z < btnListé.size() && !dansliste){
                        if(cliquables.get(i) == btnListé.get(z)){
                            dansliste = true;
                        }
                        z += 1;
                    }
                    
                    if(dansliste == false){
                        cliquables.get(i).addActionListener(probTest);
                        btnListé.add(cliquables.get(i));
                        
                    }

                    
                    
                    
                }
            }

        }
    }
        public void majCouleurPionPlateau(Tuile tuile){
            for (Map.Entry<Aventurier, JLabel> entry : labelPion.entrySet()) {
                Aventurier key = entry.getKey();
                JLabel value = entry.getValue();
                if(key.getPosition() == tuile){
                   value.setIcon(key.getPion().getImageAAfficher());
                   value.setVisible(true);
                   value.setBackground(key.getCouleur().getCouleur());
                   value.setOpaque(true);
                }
                else{
                    value.setIcon(null);
                    value.setVisible(false);
                }
        }
            basTuile.revalidate();
            basTuile.repaint();
        
        }
    

    
//    public void afficherTuilesDispo(ArrayList<Tuile> tuilesA){
//        for (int x =0;x<6;x++){
//            for (int y=0;y<6;y++){
//                for (int z =0; z<tuilesA.size();z++){
//                    if (tuilesA.get(z).getNumTuile()==)
//                }
//            }
//        }    
//    }
        
    public void afficher() {
        this.window.setVisible(true);
    }
    public void fermer(){
        this.window.dispose();
    }
    
    public void majCouleur(JButton bouton,Tuile tuile){
        if(tuile.getEtatCase() == EtatCase.NORMAL){
            bouton.setBackground(etat_normal);
            bouton.setIcon(tuile.getImage().getImageAAfficher());
        }else if(tuile.getEtatCase()==EtatCase.INNONDEE){
            bouton.setBackground(etat_innondé);
            bouton.setIcon(tuile.getImageInnondée().getImageAAfficher());
        }else{
            bouton.setBackground(Color.DARK_GRAY);
            bouton.setIcon(null);
            bouton.setEnabled(false);
        }
        
    }
    
    public VueCartesSpé getVueCartesSpé(){
        return cartesSpe;
    }
    
    
    
    /*autre couleur 
    innondé     tuile.setBackground(new Color(255, 255, 100));//Orange
    coulé       tuile.setBackground(new Color(100,100,100));//gris
    */
 
    
}
