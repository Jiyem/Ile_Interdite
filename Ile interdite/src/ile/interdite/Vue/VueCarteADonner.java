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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JComboBox listeAv;
    
    public VueCarteADonner(ArrayList<Aventurier> joueurs,Aventurier jCourant){
        this.jCourant = jCourant;
        String[] aventuriers = this.listJoueursSurCase(jCourant, joueurs);
        
        
        window = new JFrame();
        // Définit la taille de la fenêtre en pixels
        window.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("La main du joueur " + jCourant.getPseudo());
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel topPanel = new JPanel(new GridLayout(2,3));
        mainPanel.add(topPanel,BorderLayout.NORTH);
        for(int i = 1; i<7;i++){
            if(i == 2){
                JLabel pseudojoueur = new JLabel(jCourant.getPseudo());
                topPanel.add(pseudojoueur);
                pseudojoueur.setFont(new Font(pseudojoueur.getName(), Font.PLAIN, (pseudojoueur.getFont().getSize())*2));
            }else if(i==5){
                JLabel donnerA = new JLabel("Donner à : ");
                topPanel.add(donnerA);
                donnerA.setFont(new Font(donnerA.getName(), Font.PLAIN, (donnerA.getFont().getSize())));
            }else if(i ==6){
                listeAv = new JComboBox(aventuriers);
                topPanel.add(listeAv);
                
            }else{
                topPanel.add(new JLabel(""));
            }
        }
        
        int nbligne = jCourant.getCartes().size();
        if(nbligne % 3 != 0){
            nbligne = 1+((int)nbligne/3);
        }
        contentPanel = new JPanel(new GridLayout(nbligne,3));  
        listeBouton = new ArrayList<>();
        
        
        for(CarteTirage carte : jCourant.getCartes()){
            if(carte!= null){
                JButton jb = new JButton();
                jb.setIcon(carte.getImage().getImageAAfficher());
                listeBouton.add(jb);
                jb.setBackground(Color.white);
                jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageCarte((String) listeAv.getSelectedItem(),ActionsType.DONNERCARTE,carte));
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
    
    private int nbJoueursSurMemeCase(Aventurier joueurCourant, ArrayList<Aventurier> joueurs){
        int nbJoueurs = 0;
        for(int i = 0; i<joueurs.size();i++){
            if(joueurs.get(i) != joueurCourant && joueurs.get(i).getPosition() == joueurCourant.getPosition()){
                nbJoueurs += 1;
            }
        }
        return nbJoueurs;
    }
    
    private String[] listJoueursSurCase(Aventurier joueurCourant, ArrayList<Aventurier> joueurs){
        String[] liste = new String[this.nbJoueursSurMemeCase(joueurCourant, joueurs)];
        int nbJoueurs = 0;
        for(int i = 0; i<joueurs.size();i++){
            if(joueurs.get(i) != joueurCourant && joueurs.get(i).getPosition() == joueurCourant.getPosition()){
                liste[nbJoueurs] = joueurs.get(i).getPseudo();
                nbJoueurs += 1;
            }
        }
        return liste;
    }

}
