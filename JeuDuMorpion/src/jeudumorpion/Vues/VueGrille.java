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

/**
 *
 * @author chapellr
 */
public class VueGrille extends Observable{
    private HashMap<Integer,ICase> iCases = new HashMap();
    private JFrame window;
    private final int borderWidth = 1;
    private final int rows = 3;
    private final int cols = 3;
    
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
        
        
        GridLayout morp = new GridLayout(rows,cols);
        JPanel labelMorp = new JPanel(morp);
        
        mainPanel.add(labelMorp, BorderLayout.WEST);
        
        
        
        //Bordure du morpion
        labelMorp.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                final JLabel label = new JLabel("");
                label.setPreferredSize(new Dimension(200,150));
                if (row == 0) {
                    if (col == 0) {
                        // Top left corner, draw all sides
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    }
                    else {
                        // Top edge, draw all sides except left edge
                        label.setBorder(BorderFactory.createMatteBorder(borderWidth, 0, borderWidth, borderWidth, Color.BLACK));
                    }
                }
                else {
                    if (col == 0) {
                        // Left-hand edge, draw all sides except top
                        label.setBorder(BorderFactory.createMatteBorder(0,borderWidth, borderWidth, borderWidth,Color.BLACK));
                    }
                    else {
                        // Neither top edge nor left edge, skip both top and left lines
                        label.setBorder(BorderFactory.createMatteBorder(0, 0, borderWidth, borderWidth, Color.BLACK));
                    }
                }
                labelMorp.add(label);
    }
}


        // Remplir les cases
        
        //Puis faire l'est
        
        
    }

    public void afficher() {
        this.window.setVisible(true);
    }
    
}
