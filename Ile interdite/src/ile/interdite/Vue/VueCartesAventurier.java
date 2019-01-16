/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Modele.Aventuriers.Aventurier;
import java.awt.BorderLayout;
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
    
    public VueCartesAventurier(Aventurier j){
        this.window = new JFrame("Carte de l'aventurier");
        window.setSize(600, 200);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

                //titre
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        labelTitre = new JLabel("Les cartes de " + j.getPseudo() + " - " + j.getRôle());
        mainPanel.add(labelTitre, BorderLayout.NORTH);
        
        for(int i=0; i < j.getCartes().size(); i++){
            JPanel jp = new JPanel(j.getCartes().get(i));
        }
        
    }

}
