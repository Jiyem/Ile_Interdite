/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.MessageCarte;
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
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Théophane
 */
public class VueCarteADonner extends Observable{
    private  JPanel panelBoutons ;
    private  JPanel panelCentre ;
    private  JFrame window;
    private  JPanel panelAventurier;
    private  JPanel mainPanel;
    private ArrayList<JButton> listeBouton;
    private JButton BoutonValide;
    private Aventurier jCourant;
    private JPanel contentPanel;
    
    public VueCarteADonner(Aventurier av,Aventurier jCourant){
        this.jCourant = jCourant;
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("La main du joueur " + jCourant.getPseudo());
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
        
        
        for(CarteTirage carte : jCourant.getCartes()){
            if(carte!= null){
                JButton jb = new JButton();
                jb.setText(carte.getType().name());
                listeBouton.add(jb);
                jb.setBackground(Color.white);
                jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageCarte(av,ActionsType.DONNERCARTE,jb.getText()));
                    clearChanged();
                }
                });
                contentPanel.add(jb);
            }
        }
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        JPanel downPanel = new JPanel (new GridLayout(3, 1));
        mainPanel.add(downPanel,BorderLayout.SOUTH);
        downPanel.add(new JLabel("",SwingConstants.CENTER));
        downPanel.add(new JLabel(""));
        
   
        BoutonValide = new JButton();
       
    }
    


    public void afficher() {
        this.window.setVisible(true);
    }
    
    public void fermer(){
        this.window.dispose();
    }
    

}
