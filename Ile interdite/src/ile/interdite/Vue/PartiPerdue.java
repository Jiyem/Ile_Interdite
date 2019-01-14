/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chapellr
 */
public class PartiPerdue extends Observable{
    private JFrame window;
    private JPanel mainPanel;
    private JLabel finPartie;
    private JPanel marges;
    private JPanel cause;
    
    
    
    public PartiPerdue(){
        this.window = new JFrame();
        window.setSize(350, 200);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        
        finPartie = new JLabel("Fin de la parti", JLabel.CENTER);
        finPartie.getFont(new Font(nom, 0, 0));
        mainPanel.add(finPartie, BorderLayout.NORTH);
        marges = new JPanel(new BorderLayout());
        mainPanel.add(marges, BorderLayout.CENTER);
        
        
    }
    
    
    public void nonRecupTresor(String nomTresor){
        cause = new JPanel("Deux tuiles contenant le trésor " +nomTresor +" on étés détruites");
    }
    
    public void marqueurMort(){
        
    }
    
    public void heliportCoule(){
        
    }
    
    public void joueurNoye(){
        
    }
    
    
}
