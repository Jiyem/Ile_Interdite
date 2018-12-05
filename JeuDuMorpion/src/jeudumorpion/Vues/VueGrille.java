/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion.Vues;


import java.awt.*;
import java.util.Observable;
import java.util.HashMap;
import javax.swing.*;
import jeudumorpion.ICase;

/**
 *
 * @author chapellr
 */
public class VueGrille extends Observable{
    private HashMap<Integer,ICase> iCases = new HashMap();
    private JFrame window;
    
    public VueGrille(){
        
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        window.setSize(1000, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
                
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel() ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        
        JLabel labelTitre = new JLabel("Jeu du morpion") ;
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setFont(new Font(labelTitre.getFont().getName(), labelTitre.getFont().getStyle(), (int) (labelTitre.getFont().getSize() * 1.5)));
        panelHaut.add(labelTitre) ;
        panelHaut.add(labelTitre, BorderLayout.NORTH);
        
        JPanel labelMorp = new JPanel(new GridLayout(3,3));
        mainPanel.add(labelMorp, BorderLayout.WEST);
        // Remplir les cases
        
        //Puis faire l'est
        
        
    }

    public void afficher() {
        this.window.setVisible(true);
    }
    
}
