/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.MessageAventurier;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Tuile;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jiyem
 */
public class VueFinDeTour extends Observable {
    //Variables :
    private final JFrame window;
    
    //Constructeur:
    public VueFinDeTour(String nomJoueur,CarteTirage carte1, CarteTirage carte2,int nivEau,ArrayList<Tuile> tuilesInnondé){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        //Le panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        //Le panel de gauche
        JPanel gauchePanel = new JPanel(new BorderLayout());
        mainPanel.add(gauchePanel,BorderLayout.WEST);
        
        //partie haute du panel gauche
        JPanel hautGauchePanel = new JPanel(new GridLayout(1,2));
        hautGauchePanel.add(new JLabel("Cartes obtenues par :"));
        hautGauchePanel.add(new JLabel(nomJoueur));
        gauchePanel.add(hautGauchePanel,BorderLayout.NORTH);
        
        //partie centrale du panel de gauche
        JPanel centreGauchePanel = new JPanel();
        centreGauchePanel.add(new JLabel(carte1.toString())); //A mettre ici l'affichage de la carte 1
        centreGauchePanel.add(new JLabel(carte2.toString())); //A mettre ici l'affichage de la carte 2
        gauchePanel.add(centreGauchePanel,BorderLayout.CENTER);
        
        //partie basse du panel de gauche
        JPanel basGauchePanel = new JPanel(new GridLayout(3,1));
        basGauchePanel.add(new JLabel(""));
        basGauchePanel.add(new JLabel(""));
        JButton btnOk = new JButton("OK");
        basGauchePanel.add(btnOk);
        gauchePanel.add(basGauchePanel,BorderLayout.SOUTH);
        
        //Le panel de droite
        JPanel droitePanel = new JPanel(new BorderLayout());
        mainPanel.add(droitePanel,BorderLayout.EAST);
        
        //Partie haute du panel de droite
        JPanel hautDroitePanel = new JPanel(new GridLayout(1,2));
        hautDroitePanel.add(new JLabel("Niveau d'eau :"+nivEau));
        hautDroitePanel.add(new JLabel("Inondation de :"));
        droitePanel.add(hautDroitePanel,BorderLayout.NORTH);
        
        //Partie central du panel de droite
        JPanel centreDroitePanel = new JPanel(new GridLayout(1,tuilesInnondé.size()));
        for(int i =0;i<tuilesInnondé.size();i++){
            centreDroitePanel.add(new JLabel(tuilesInnondé.get(i).getNomTuile()));
        }
        droitePanel.add(centreDroitePanel,BorderLayout.CENTER);
        
        //Traidement des boutons:
        btnOk.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers();
            clearChanged();
            }
        });
    }
    
    //Les méthodes: 
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
}
