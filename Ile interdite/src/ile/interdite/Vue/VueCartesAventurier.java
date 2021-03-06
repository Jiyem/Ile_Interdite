/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Modele.Aventuriers.Aventurier;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chapellr
 */
public class VueCartesAventurier {
    private JFrame window;
    private JPanel mainPanel;
    private JLabel labelTitre;
    private JPanel panelCartes;
    private JButton ok;
    private JPanel panelFooter;
    private JPanel panelDroite;
    private JPanel panelTresor;
    private JButton buttTresor;
    
    public VueCartesAventurier(Aventurier j){
        this.window = new JFrame("Carte de l'aventurier");
        window.setSize(600, 600);
        window.setLocationRelativeTo(null);

                //titre
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        labelTitre = new JLabel("Les cartes de " + j.getPseudo() + " - " + j.getRôle(), JLabel.CENTER);
        labelTitre.setFont(new Font("TimesRoman", Font.PLAIN, (labelTitre.getFont().getSize()*2)));
        mainPanel.add(labelTitre, BorderLayout.NORTH);
        int nbligne = j.getCartes().size();
        if(nbligne % 3 != 0){
            nbligne = 1+((int)nbligne/3);
        }
        
        panelCartes = new JPanel (new GridLayout(nbligne,3));
        panelCartes.setOpaque(false);
        for(int i=0; i < j.getCartes().size(); i++){
            JButton jb = new JButton(j.getCartes().get(i).getImage().getImageAAfficher());
            jb.setFocusPainted(false);
            jb.setContentAreaFilled(false);
            jb.setBorderPainted(false);
            panelCartes.add(jb);
        }
        mainPanel.add(panelCartes, BorderLayout.CENTER);
        
        panelDroite = new JPanel(new BorderLayout());
        mainPanel.add(panelDroite, BorderLayout.EAST);
        JButton carteAv = new JButton(j.getImage().getImageAAfficher());
        carteAv.setContentAreaFilled(false);
        carteAv.setFocusPainted(false);
        carteAv.setBorderPainted(false);
        panelDroite.add(carteAv, BorderLayout.NORTH);
        
        int nbtresor = j.getTresors().size();
        if(nbtresor % 2 != 0){
            nbtresor = 1+((int)nbligne/2);
        }
        panelTresor = new JPanel(new GridLayout(2, nbtresor));
        panelDroite.add(panelTresor, BorderLayout.CENTER);
        
        for(int i=0; i < j.getTresors().size(); i++){
            JLabel buttTresor = new JLabel();
            buttTresor.setIcon(j.getTresors().get(i).getImage().getImageAAfficher());
//            buttTresor.setFocusPainted(false);
//            buttTresor.setContentAreaFilled(false);
//            buttTresor.setBorderPainted(false);
            panelTresor.add(buttTresor);
        }
        
        
        panelFooter = new JPanel(new GridLayout(3, 1));
        panelFooter.add(new JLabel(""));
        ok = new JButton("OK");
        panelFooter.add(ok);
        panelFooter.add(new JLabel(""));
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              fermer();
            }
        });
        mainPanel.add(panelFooter, BorderLayout.SOUTH);
        
    }
    
        public void afficher() {
        this.window.setVisible(true);
    }
    
         public void fermer(){
        this.window.dispose();
    }

}
