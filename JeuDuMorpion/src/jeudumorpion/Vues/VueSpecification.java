/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion.Vues;

import java.awt.*;
import java.util.Observable;
import java.util.HashMap;
import javax.swing.*;
import java.awt.color.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
/**
 *
 * @author rose
 */
public class VueSpecification {
        private JFrame window;
        private JButton sombre;
        private JButton colore;
        private ButtonGroup joueurs;
        private JRadioButton two;
        private JRadioButton three;
        private JRadioButton four;
        private JRadioButton five;
        private JRadioButton six;
        private JRadioButton seven;
        private JRadioButton eight;
        
        public VueSpecification(){
        //Création de la fenêtre + séparation en différent layout
        window = new JFrame("Morpion");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        //Première partie de la fenêtre
        JPanel panelHaut = new JPanel(new GridLayout(5,10)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        sombre = new JButton("Sombre");
        colore = new JButton("Colore");

        for(int x =0; x<50;x++){
            if (x==33){
                panelHaut.add(new JLabel("Style ", JLabel.RIGHT));
            }
            else if(x==34){
                panelHaut.add(new JLabel("graphique", JLabel.LEFT));             
            }
            else if(x==35){
                panelHaut.add(sombre);                
            }
            else if(x==36){
                panelHaut.add(colore);                
            }
            else {
                panelHaut.add(new JLabel(""));
            }
        }
       

        //Seconde partie de la fenêtre
        JPanel panelBas = new JPanel(new BorderLayout());
        mainPanel.add(panelBas, BorderLayout.CENTER);
        JLabel labelTitre = new JLabel("Nombre de joueurs", JLabel.CENTER) ;
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setFont(new Font("Princetown LET", Font.PLAIN, (int) (labelTitre.getFont().getSize() * 2.5)));
        panelBas.add(labelTitre, BorderLayout.NORTH);
        
        
        two = new JRadioButton("2 joueurs");
        three = new JRadioButton("3 joueurs");
        four = new JRadioButton("4 joueurs");
        five = new JRadioButton("5 joueurs");
        six = new JRadioButton("6 joueurs");
        seven = new JRadioButton("7 joueurs");
        eight = new JRadioButton("8 joueurs");
        
        joueurs = new ButtonGroup();
        joueurs.add(two);
        joueurs.add(three);
        joueurs.add(four);
        joueurs.add(five);
        joueurs.add(six);
        joueurs.add(seven);
        joueurs.add(eight);
        
        panelBas.add(two);
        panelBas.add(three);
        panelBas.add(four);
        panelBas.add(five);
        panelBas.add(six);
        panelBas.add(seven);
        panelBas.add(eight);
        
        // n'arrive a a ajouter l'image
        JPanel selectNbJoueurs = new JPanel(new GridLayout(4,4));
        panelBas.add(selectNbJoueurs, BorderLayout.CENTER);
 
        

        
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(two);
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(five);
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(three);
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(six);
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(four);
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(seven);
        selectNbJoueurs.add(new JLabel(""));
        selectNbJoueurs.add(new JLabel(""));        
        selectNbJoueurs.add(eight);
        selectNbJoueurs.add(new JLabel(""));

}
        

    public void afficher() {
        this.window.setVisible(true);
    }
}
