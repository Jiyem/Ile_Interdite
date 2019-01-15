/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
    private JLabel cause;
    private JPanel contientCause;
    
    
    
    public PartiPerdue(){
        this.window = new JFrame("Game Over");
        window.setSize(600, 200);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        finPartie = new JLabel("Fin de la parti", JLabel.CENTER);
        finPartie.setFont(new Font("TimesRoman", Font.PLAIN, (finPartie.getFont().getSize()*2)));
        mainPanel.add(finPartie, BorderLayout.NORTH);
        marges = new JPanel(new BorderLayout());
        mainPanel.add(marges, BorderLayout.CENTER);
        
        
    }
    
    
    public void nonRecupTresor(String nomTresor){
        cause = new JLabel("Deux tuiles contenant le trésor " +nomTresor +" on étés détruites, vous ne pouvez plus récupérer le trésor.", JLabel.CENTER);
        cause.setFont(new Font(cause.getName(), cause.getFont().getStyle(), cause.getFont().getSize()*2));
        contientCause = new JPanel(new GridLayout(3,1));
        marges.add(contientCause, BorderLayout.CENTER);
        JLabel a = new JLabel("");
        contientCause.add(a);
        contientCause.add(cause);
        JLabel b = new JLabel("");
        contientCause.add(b);
    }
    
    public void marqueurMort(){
        cause = new JLabel("Le niveau d'eau à trop montée, vous vous êtes retrouvés noyés.", JLabel.CENTER);
        contientCause = new JPanel(new GridLayout(3,1));
        marges.add(contientCause, BorderLayout.CENTER);
        JLabel a = new JLabel("");
        contientCause.add(a);
        contientCause.add(cause);
        JLabel b = new JLabel("");
        contientCause.add(b);
    }
    
    public void heliportCoule(){
        cause = new JLabel("L'héliport à coulé, vous ne pouvez donc plus vous échapper de l'île.", JLabel.CENTER);
        contientCause = new JPanel(new GridLayout(3,1));
        marges.add(contientCause, BorderLayout.CENTER);
        JLabel a = new JLabel("");
        contientCause.add(a);
        contientCause.add(cause);
        JLabel b = new JLabel("");
        contientCause.add(b);
    }
    
    public void joueurNoye(String nomJoueur){
        cause = new JLabel(nomJoueur + " s'est noyé, vous ne pouvez partir sans tout vos compagnons.", JLabel.CENTER);
        contientCause = new JPanel(new GridLayout(3,1));
        marges.add(contientCause, BorderLayout.CENTER);
        JLabel a = new JLabel("");
        contientCause.add(a);
        contientCause.add(cause);
        JLabel b = new JLabel("");
        contientCause.add(b);
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    public void fermer(){
        this.window.setVisible(false);
    }
    
} 
