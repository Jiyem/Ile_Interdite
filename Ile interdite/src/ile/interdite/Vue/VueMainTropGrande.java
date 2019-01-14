/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.MessageAventurier;
import ile.interdite.Message.MessageMuligan;
import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.Modele.Cartes.CarteTirage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Théophane
 */
public class VueMainTropGrande extends Observable{
    private  JPanel panelBoutons ;
    private  JPanel panelCentre ;
    private  JFrame window;
    private  JPanel panelAventurier;
    private  JPanel mainPanel;
    private  JButton carte1;
    private  JButton carte2;
    private  JButton carte3;
    private  JButton carte4;
    private  JButton carte5;
    private  JButton carte6;
    private  JButton carte7;
    private  JButton carte8;
    private  JButton carte9;
    private Boolean c1 = false;
    private Boolean c2 = false;
    private Boolean c3 = false;
    private Boolean c4 = false;
    private Boolean c5 = false;
    private Boolean c6 = false;
    private Boolean c7 = false;
    private Boolean c8 = false;
    private Boolean c9 = false;
    private  JButton btnValidation;
    private JTextField position;
    private ArrayList<JButton> listeBouton;
    private ArrayList<Boolean> listeBoutonValide;
    
    public VueMainTropGrande(Aventurier jCourant,int nbCartesAPiocher){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("Muligan de la main du joueur " + jCourant.getPseudo());
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel topPanel = new JPanel(new GridLayout(3,1));
        mainPanel.add(topPanel,BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel (new GridLayout(3, 3));
        listeBouton = new ArrayList<>(Arrays.asList(carte1,carte2,carte3,carte4,carte5,carte6,carte7,carte8,carte9));
        listeBoutonValide = new ArrayList<>(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9));
        
        for(int i = 0;i < jCourant.getCartes().size();i++){
            if(jCourant.getCartes().get(i) != null){
                listeBouton.get(i).add(new JLabel(jCourant.getCartes().get(i).getType().name()));
                contentPanel.add(listeBouton.get(i));
            }
        }
        contentPanel.setSize(contentPanel.getPreferredSize());
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        JPanel downPanel = new JPanel (new GridLayout(3, 1));
        mainPanel.add(downPanel,BorderLayout.SOUTH);
        downPanel.add(new JLabel(""));
        downPanel.add(btnValidation);
        downPanel.add(new JLabel(""));
        
        btnValidation.setEnabled(false);
        btnValidation.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<CarteTirage> listeCartesASupprimer = new ArrayList<>();
            for(int i =0;i < listeBoutonValide.size();i++){
                if(listeBoutonValide.get(i) == true){
                    listeCartesASupprimer.add(jCourant.getCartes().get(i));
                }
            }
            setChanged();
            notifyObservers(new MessageMuligan(listeCartesASupprimer));
            clearChanged();
            }
        });
        
        carte1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c1 == false){
                    carte1.setBackground(Color.gray);
                    activerBtnValider();
                    c1 = true;
                }
                if(c1 == true){
                    carte1.setBackground(Color.gray);
                    activerBtnValider();
                    c1 = false;
                } 
            }
        });
        
        carte2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c2 == false){
                    carte2.setBackground(Color.gray);
                    activerBtnValider();
                    c2 = true;
                }
                if(c2 == true){
                    carte2.setBackground(Color.gray);
                    activerBtnValider();
                    c2 = false;
                
            }
            }
        });
                
                
        carte3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c3 == false){
                    carte3.setBackground(Color.gray);
                    activerBtnValider();
                    c3 = true;
                }
                if(c3 == true){
                    carte3.setBackground(Color.gray);
                    activerBtnValider();
                    c3 = false;
                } 
            }
        });
               
        carte4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c4 == false){
                    carte4.setBackground(Color.gray);
                    activerBtnValider();
                    c4 = true;
                }
                if(c4 == true){
                    carte4.setBackground(Color.gray);
                    activerBtnValider();
                    c4 = false;
                
            }
            }
        });
        
        carte5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c5 == false){
                    carte5.setBackground(Color.gray);
                    activerBtnValider();
                    c5 = true;
                }
                if(c5 == true){
                    carte5.setBackground(Color.gray);
                    activerBtnValider();
                    c5 = false;
                } 
            }
        });
        
        carte6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c6 == false){
                    carte6.setBackground(Color.gray);
                    activerBtnValider();
                    c6 = true;
                }
                if(c6 == true){
                    carte6.setBackground(Color.gray);
                    activerBtnValider();
                    c6 = false;
                } 
            }
            
        });
        
        carte7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c7 == false){
                    carte7.setBackground(Color.gray);
                    activerBtnValider();
                    c7 = true;
                }
                if(c7 == true){
                    carte7.setBackground(Color.gray);
                    activerBtnValider();
                    c7 = false;
                } 
            }
            
        });
        
        carte8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(c8 == false){
                    carte8.setBackground(Color.gray);
                    activerBtnValider();
                    c8 = true;
                }
                if(c8 == true){
                    carte8.setBackground(Color.gray);
                    activerBtnValider();
                    c8 = false;
                } 
            }
        });
        
        carte9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c9 == false){
                    carte9.setBackground(Color.gray);
                    activerBtnValider();
                    c9 = true;
                }
                if(c9 == true){
                    carte9.setBackground(Color.gray);
                    activerBtnValider();
                    c9 = false;
                } 
            }
        });
    }
    
    public void activerBtnValider(){
        int cartevalide =0;
        for(int i = 0;i < listeBoutonValide.size();i++){
            if(listeBoutonValide.get(i) == true){
                cartevalide = cartevalide +1;
            }
        }
        if(cartevalide >= 2){
            btnValidation.setEnabled(true);
        }
        else if(cartevalide < 2){
            btnValidation.setEnabled(false);
        }
    }
}
