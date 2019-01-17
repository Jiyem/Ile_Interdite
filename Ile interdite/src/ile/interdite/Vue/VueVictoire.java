/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Modele.Aventuriers.Aventurier;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chapellr
 */
public class VueVictoire {
    private JFrame window;
    private JPanel mainPanel;
    private JLabel labelTitre;
    private JPanel ontgagnés;
    private JButton retourPageAccueil;
    
    public VueVictoire(ArrayList<Aventurier> aventuriers){
        this.window = new JFrame("Carte de l'aventurier");
        window.setSize(600, 200);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

                //titre
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        labelTitre = new JLabel("Victoire !");
        mainPanel.add(labelTitre, BorderLayout.NORTH);
        
            //Corps de la vue
        ontgagnés = new JPanel();
        ontgagnés.add(new JLabel("Bravo "));
        for(int i = 0; i < aventuriers.size(); i++){
            JLabel perso = new JLabel(aventuriers.get(i).getPseudo()+ " ");
            ontgagnés.add(perso);
        }
        JLabel fin = new JLabel(" vous avez réussi à vous échapper de l'île avec tous les trésors !");
        ontgagnés.add(fin);
        
        mainPanel.add(ontgagnés, BorderLayout.CENTER);
            //Bas de la vue
        retourPageAccueil = new JButton("Retour page d'accueil");
        
        mainPanel.add(retourPageAccueil, BorderLayout.SOUTH);
        
        
        
        
    }
}
