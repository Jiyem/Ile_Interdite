/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import java.awt.BorderLayout;
import static java.awt.SystemColor.window;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anandanj
 */
public class VueErreur extends Observable {
    private JFrame window;
    private JPanel mainPanel;
    public VueErreur(String texte){
        window = new JFrame();
        window.setSize(600, 200);
        window.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        window.add(mainPanel);
        JLabel textAffiche = new JLabel(texte);
        mainPanel.add(textAffiche);
        
    }
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

}
