/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.image.Calque;
import java.awt.GridLayout;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author mirasl
 */
public class VuePersonnages  {
    private JPanel mainPanel;
    private JPanel personnage;
    private Calque imagePerso;
    
    
    public VuePersonnages(ArrayList<Aventurier> joueurs){
        mainPanel = new JPanel();
        if (joueurs.size()==2){
        personnage = new JPanel(new GridLayout(2, 1));
        }
        else personnage = new JPanel(new GridLayout(2, 2));
        
        for (int j=0; j<joueurs.size();j++){
            
            personnage.add(new Calque("personnages", joueurs.get(j).getRôle()));
        }
        mainPanel.add(personnage);
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
