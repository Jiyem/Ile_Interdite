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
import java.util.HashMap;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
    private JButton btnValidation = new JButton("Valider les cartes à retirer");
    private ArrayList<JButton> listeBouton;
    private ArrayList<JButton> listeBoutonValide;
    private Aventurier jCourant;
    private JPanel contentPanel;
    private int nbCartesARetirer;
    
    public VueMainTropGrande(Aventurier jCourant,int nbCartesARetirer){
        this.jCourant = jCourant;
        this.nbCartesARetirer = nbCartesARetirer;
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
        
        int nbligne = jCourant.getCartes().size();
        if(nbligne % 3 != 0){
            nbligne = 1+((int)nbligne/3);
        }
        contentPanel = new JPanel(new GridLayout(nbligne,3));  
        listeBouton = new ArrayList<>();
        
        
        for(int i = 0;i < jCourant.getCartes().size();i++){
            if(jCourant.getCartes().get(i) != null){
                final JButton jb = new JButton(jCourant.getCartes().get(i).getType().name());
                listeBouton.add(jb);
                jb.setBackground(Color.white);
                jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!listeBoutonValide.contains(jb)){
                        jb.setBackground(Color.gray);
                        listeBoutonValide.add(jb);
                        activerBtnValider();
                    } 
                    else {
                        jb.setBackground(Color.white);
                        listeBoutonValide.remove(jb);
                        activerBtnValider();
                    }
                }
                });
                contentPanel.add(jb);
            }
        }
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        JPanel downPanel = new JPanel (new GridLayout(3, 1));
        mainPanel.add(downPanel,BorderLayout.SOUTH);
        downPanel.add(new JLabel("Vous allez devoir retirer au moins "+ nbCartesARetirer + " cartes",SwingConstants.CENTER));
        downPanel.add(btnValidation);
        downPanel.add(new JLabel(""));
        
        btnValidation.setEnabled(false);
        btnValidation.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageMuligan(donnerArrayListCarteAEnlever()));
            clearChanged();
            }
        });
        listeBoutonValide = new ArrayList<>();
       
    }
    
    public void activerBtnValider(){
        if(listeBoutonValide.size() >= nbCartesARetirer){
            btnValidation.setEnabled(true);
        }
        else{
            btnValidation.setEnabled(false);
        }
    }

    public void afficher() {
        this.window.setVisible(true);
    }
    
    public void fermer(){
        this.window.setVisible(false);
    }
    
    public ArrayList<CarteTirage> donnerArrayListCarteAEnlever(){
        ArrayList<CarteTirage> cartes = new ArrayList<CarteTirage>();
        for(int i = 0;i<jCourant.getCartes().size();i++){
            if(listeBoutonValide.contains(jCourant.getCartes().get(i).getType().name())){
                cartes.add(jCourant.getCartes().get(i));
            } 
        }
        return cartes;
    }
    
}
