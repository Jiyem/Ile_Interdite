/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author anandanj
 */
public class VueInscription extends Observable {
    private final JFrame window ;
//    private final JTextField nombreJoueurs;
    private final JTextField pseudo1;
    private final JTextField pseudo2;
    private final JTextField pseudo3;
    private final JTextField pseudo4;
//    private final JRadioButton radioHomme;
//    private final JRadioButton radioFemme;
    private final JButton btnValider ;
    private final JButton btnAnnuler ;
    private JLabel erreur = new JLabel("");
//    private String erreurNbJoueurs = "";
//    private String nom;
//    private String prenom;
//    private Genres genre;
//    private Integer age;

    @SuppressWarnings("Convert2Lambda")
    public VueInscription() {
//        this.nom = nom;
//        this.prenom = prenom;
//        this.genre = genre;
//        this.age = age;
        
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel topPanel = new JPanel();
        mainPanel.add(topPanel,BorderLayout.NORTH);
        topPanel.add(erreur);
        
        JPanel contentPanel = new JPanel (new GridLayout(4, 2));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
//        contentPanel.add(new JLabel("Combien de joueurs? (2 à 4)"));
//        nombreJoueurs = new JTextField();
//        contentPanel.add(nombreJoueurs);
////        contentPanel.add(new JLabel(erreurNbJoueurs));
        
        contentPanel.add(new JLabel("Pseudo du joueur 1 :"));
        pseudo1 = new JTextField("joueur 1");
        contentPanel.add(pseudo1);

        contentPanel.add(new JLabel("Pseudo du joueur 2 :"));
        pseudo2 = new JTextField("joueur 2");
        contentPanel.add(pseudo2);
    
        contentPanel.add(new JLabel("Pseudo du joueur 3 :"));
        pseudo3 = new JTextField("joueur 3");
        contentPanel.add(pseudo3);
        
        contentPanel.add(new JLabel("Pseudo du joueur 4 :"));
        pseudo4 = new JTextField("joueur 4");
        contentPanel.add(pseudo4);
//        
//        contentPanel.add(new JLabel("Age : "));
//        champAge = new JTextField();
//        contentPanel.add(champAge);
//        
//        contentPanel.add(new JLabel("Genre :"));
//        ButtonGroup radioGroupGenre = new ButtonGroup();
//
//        radioHomme = new JRadioButton("Homme");
//        contentPanel.add(radioHomme);
//        radioGroupGenre.add(radioHomme) ;
//        
//        contentPanel.add(new JLabel(""));
//
//        radioFemme = new JRadioButton("Femme");
//        contentPanel.add(radioFemme);
//        radioGroupGenre.add(radioFemme) ;
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        btnValider = new JButton("Valider");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageInscription(ActionsType.VALIDE,pseudo1.getText(),pseudo2.getText(),pseudo3.getText(),pseudo4.getText()));
                clearChanged();
            }
        });
        bottomPanel.add(btnValider);

        bottomPanel.add(new JLabel(""));

        btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(ActionsType.ANNULE);
                clearChanged();
            }
        });
        bottomPanel.add(btnAnnuler);
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
    public void erreurNbJoueurs0(){
        this.erreur.setText("Il faut au minimum le joueur 1 et le joueur 2");
        this.erreur.setForeground(Color.red);
    }
    public void erreurNbJoueurs(){
        this.erreur.setText("Vous ne pouvez pas séléctionner de joueur 4 sans joueur 3.");
        this.erreur.setForeground(Color.red);
    }

}
