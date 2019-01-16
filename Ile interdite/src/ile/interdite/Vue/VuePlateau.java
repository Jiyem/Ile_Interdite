/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.Message;
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
import java.util.Observable;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rose
 */
public class VuePlateau extends Observable{
    
    private JFrame window;
    private Color etat_normal = new Color(179, 229, 255);
    private Color etat_innondé = new Color(255, 255, 100);
    private Color etat_immergé = new Color(100,100,100);
    private ArrayList<JButton> btnTuile = new ArrayList<>();
    private JPanel plateau;
    private JPanel menu;
    private VueAventurier aventurier;
    private VuePersonnages personnages;
    private VueCartesSpé cartesSpe;
    private JPanel mainPanel;
    private Aventurier joueur;
    private VueNiveau niveau;
    
    public VuePlateau(Grille g, ArrayList<Aventurier> joueurs,ArrayList<CarteTirage> cartes,VueAventurier vueAventurier, VueNiveau vueNiveau) throws IOException{
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(2000, 1200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        plateau = new JPanel();
        this.initPlateau(g);

        
        menu = new JPanel(new GridLayout(3,1));
        
        
        personnages = new VuePersonnages(joueurs);
        for(int i = 0; i<personnages.getButton().size();i++){
            joueur = joueurs.get(i);
            personnages.getButton().get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    setChanged();
                    notifyObservers(new MessagePlateau(ActionsType.VALIDE,joueur));
                    clearChanged();
                }
            });
            
        }
        menu.add(personnages);

        
        aventurier = vueAventurier;
        menu.add(aventurier.getMainPanel());
        
        cartesSpe = new VueCartesSpé(cartes);
        menu.add(cartesSpe.getMainPanel());
        
        
        
        mainPanel.add(menu,BorderLayout.EAST);
        
        niveau = vueNiveau;
        mainPanel.add(niveau.getMainPanel(), BorderLayout.WEST);
        
        
        
        

    }
    
    public void initPlateau(Grille g){
        JPanel tuiles = new JPanel(new GridLayout(6, 6));
        int nb=0;
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {

                if ((y == 0 && x == 0) || (y == 0 && x == 1) || (y == 0 && x == 4) || (y == 0 && x == 5) || (y == 1 && x == 0) || (y == 1 && x == 5) || (y == 4 && x == 0) || (y == 4 && x == 5) || (y == 5 && x == 0) || (y == 5 && x == 1) || (y == 5 && x == 4) || (y == 5 && x == 5)) {
                    JButton tuileVide = new JButton();
                    tuileVide.setContentAreaFilled(false);
                    tuileVide.setBorderPainted(false);
                    tuileVide.setFocusPainted(false);
                    tuiles.add(tuileVide);
                } else {
                    int col = y;
                    int row = x;
                    nb = nb + 1;
                    JButton tuile = new JButton(g.getTuile()[y][x].getImage().getImageAAfficher());
                    this.majCouleur(tuile,g.getTuile()[y][x] );
//                    tuile.setBackground(this.etat_normal); //BleuCYAN
                    tuile.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
//                    tuile.setForeground(Color.GREEN);
//                    tuile.setContentAreaFilled(false);
//                    tuile.setBorderPainted(false);
//                    tuile.setFocusPainted(false);
                    btnTuile.add(tuile);
                    tuiles.add(tuile);
                        tuile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            setChanged();
                            notifyObservers(new MessagePlateau(ActionsType.SELECTION_CASE,col,row,btnTuile.indexOf(tuile)));
                            clearChanged();
                        }
                    });
                }

            }

        }
        
        //A changer pour tout autre jpanel ou borderlayout ou autre !
        mainPanel.add(tuiles,BorderLayout.CENTER);
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
        this.window.setVisible(false);
    }
    
    public void majCouleur(JButton bouton,Tuile tuile){
        if(tuile.getEtatCase() == EtatCase.NORMAL){
            bouton.setBackground(etat_normal);
        }else if(tuile.getEtatCase()==EtatCase.INNONDEE){
            bouton.setBackground(etat_innondé);
        }else{
            bouton.setBackground(etat_immergé);
        }
        
    }
    /*autre couleur 
    innondé     tuile.setBackground(new Color(255, 255, 100));//Orange
    coulé       tuile.setBackground(new Color(100,100,100));//gris
    */
 
}
