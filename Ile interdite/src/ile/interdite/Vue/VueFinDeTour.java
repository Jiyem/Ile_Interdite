/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.MessageAventurier;
import ile.interdite.Modele.Cartes.CarteInnondation;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Tuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jiyem
 */
public class VueFinDeTour extends Observable {
    //Variables :
    private final JFrame window;
    
    //Constructeur:
    public VueFinDeTour(String nomJoueur,CarteTirage carte1, CarteTirage carte2,int nivEau,CarteInnondation[] tuilesInnondé){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 250);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        //Le panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        //partie haute du mainPanel
        JPanel hautMainPanel = new JPanel(new GridLayout(2,5));
        for(int i=1; i<10 ;i++){
            if(i==2){
               hautMainPanel.add(new JLabel("Cartes obtenues par")); 
            }else if(i==4){
               hautMainPanel.add(new JLabel("niveau d'eau : "+nivEau));
            }else if(i==7){
                hautMainPanel.add(new JLabel(nomJoueur)); 
            }else if(i ==9){
                hautMainPanel.add(new JLabel("cartes inondations piochés:"));
            }
            else{
                hautMainPanel.add(new JLabel(""));
            }
        }
        mainPanel.add(hautMainPanel,BorderLayout.NORTH);
       
        
        
        //partie basse du mainPanel
        JPanel basGauchePanel = new JPanel(new GridLayout(1,3));
        basGauchePanel.add(new JLabel(""));
        basGauchePanel.add(new JLabel(""));
        JButton btnOk = new JButton("OK");
        basGauchePanel.add(btnOk);
        mainPanel.add(basGauchePanel,BorderLayout.SOUTH);
        
        //partie central du mainPanel
        JPanel centrePanel = new JPanel(new GridLayout(tuilesInnondé.length,5));
        for(int i =1;i<(tuilesInnondé.length)*5;i++){
            if(i ==2){
                JLabel add = new JLabel(carte1.toString());
                add.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                centrePanel.add(add);
            }else if(i==7){
                JLabel add = new JLabel(carte2.toString());
                add.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                centrePanel.add(add);
            }else if(i == 4){
                centrePanel.add(new JLabel(tuilesInnondé[0].getNomcarte()));
            }else if(i == 9){
                centrePanel.add(new JLabel(tuilesInnondé[1].getNomcarte()));                
            }else if(i == 14){
                centrePanel.add(new JLabel(tuilesInnondé[2].getNomcarte()));                
            }else if(i == 19){
                centrePanel.add(new JLabel(tuilesInnondé[3].getNomcarte()));                
            }else if(i == 24){
                centrePanel.add(new JLabel(tuilesInnondé[4].getNomcarte()));                
            }else{
                centrePanel.add(new JLabel(""));
            }
        }
        mainPanel.add(centrePanel,BorderLayout.CENTER);
        
        //Traidement des boutons:
        btnOk.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers("FINDUTOUR");
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
