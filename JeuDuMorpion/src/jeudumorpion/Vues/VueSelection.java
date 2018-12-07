/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion.Vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mirasl
 */
public class VueSelection {

    private final JFrame window;
    private final JButton btnNewPartie;
    private final JButton btnTableauS;
    private final JButton btnTuto;
    private final JButton btnCréation;

    public VueSelection(){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(550, 350);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        JPanel panelHaut = new JPanel();
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        //Positionnement titre   
//        Rajouter un espace en haut faire un grid layout 2lignes
        JLabel labelTitre = new JLabel("Jeu du morpion") ;
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setFont(new Font(labelTitre.getFont().getName(), labelTitre.getFont().getStyle(), (int) (labelTitre.getFont().getSize() * 2.0)));
        panelHaut.add(labelTitre);
        
        
        //création zone menu
        JPanel menu= new JPanel(new BorderLayout());
        mainPanel.add(menu,BorderLayout.CENTER);
        //menuHaut parti Laisser au milieu
        JPanel menuHaut = new JPanel(new GridLayout(5,3));
        menu.add(menuHaut,BorderLayout.NORTH);
        btnNewPartie = new JButton("Nouvelle Partie");
        btnTableauS = new JButton("Tableau des Scores");
        for(int x =0; x<15;x++){
            if (x==4){
                menuHaut.add(btnNewPartie);
            }
            else if(x==10){
                menuHaut.add(btnTableauS);                
            }
            else {
                menuHaut.add(new JLabel(""));
            }
        }
        //menuBas tuto création Mettre au Sud
        JPanel menuBas = new JPanel(new GridLayout(6,5));
        menu.add(menuBas,BorderLayout.CENTER);
        btnCréation = new JButton("Création"); 
        btnTuto = new JButton("Tutoriel");
        for(int i=0;i<30;i++){
            if(i==6){
                menuBas.add(btnTuto);
            }
            else if(i==8){
                menuBas.add(btnCréation);
            }
            else {
                menuBas.add(new JLabel(""));   
            }
        }

    }
    public void afficher() {
        this.window.setVisible(true);
    }
}
