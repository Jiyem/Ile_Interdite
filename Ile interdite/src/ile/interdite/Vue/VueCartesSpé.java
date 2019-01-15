/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.Message;
import ile.interdite.Modele.Cartes.CarteHelicoptere;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Cartes.TypeCarte;
import static ile.interdite.Modele.Cartes.TypeCarte.Helicoptere;
import ile.interdite.image.Calque;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chapellr
 */
public class VueCartesSpé extends Observable{
private JFrame window;
    private JPanel mainPanel;
    private JLabel cartesspe;
    private JPanel marges;
    private JLabel nbHelico;
    private JLabel nbSable;
    private JButton carteSable;
    private JButton carteHelico;
    private JPanel contientCartes;
    
    
    
    
    public VueCartesSpé(ArrayList<CarteTirage> cartesSpe){
this.window = new JFrame();
window.setSize(600, 200);
window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
window.setLocationRelativeTo(null);

        //titre
        mainPanel = new JPanel(new BorderLayout());
window.add(mainPanel);
        cartesspe = new JLabel("Cartes Spéciales", JLabel.CENTER);
        cartesspe.setFont(new Font("TimesRoman", Font.PLAIN, (cartesspe.getFont().getSize()*2)));
        mainPanel.add(cartesspe, BorderLayout.NORTH);
        marges = new JPanel(new BorderLayout());
        mainPanel.add(marges, BorderLayout.CENTER);
        
        //Cartes Speciales - Sac de Sable
        contientCartes = new JPanel(new GridLayout(1,4));
        marges.add(contientCartes, BorderLayout.CENTER);
        carteSable = new JButton();
        Calque c = new Calque("SacsDeSable");
        carteSable.setIcon(new ImageIcon(c.getPath("/cartes/"+"SacsDeSable")));
        contientCartes.add(carteSable);
        nbSable = new JLabel(" X " + nbCartesSable(cartesSpe));
        nbSable.setFont(new Font("TimesRoman", Font.PLAIN, cartesspe.getFont().getSize()*2));
        contientCartes.add(nbSable);
        carteSable.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        setChanged();
        notifyObservers(new Message(ActionsType.UTILISATION_CARTE_SABLE));
        clearChanged();
    }
        });
        
        //Cartes speciales - Helico
        carteHelico = new JButton();
        Calque ca = new Calque("Helicoptere");
        carteHelico.setIcon(new ImageIcon(c.getPath("/cartes/"+"Helicoptere")));
        contientCartes.add(carteHelico);
        nbHelico = new JLabel(" X " + nbCartesHelico(cartesSpe));
        nbHelico.setFont(new Font("TimesRoman", Font.PLAIN, cartesspe.getFont().getSize()*2));
        contientCartes.add(nbHelico);
        carteHelico.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        setChanged();
        notifyObservers(new Message(ActionsType.UTILISATION_CARTE_HELICO));
        clearChanged();
    }
        });

        
        
        
        
        
    }
    
    
    public int nbCartesHelico(ArrayList<CarteTirage> cartesSpe){
        int i =0;
        for(CarteTirage ct : cartesSpe){
            if(ct.getType() == TypeCarte.Helicoptere){
                i = i+1;
            }
        }
        return i;
    }
    
    public int nbCartesSable(ArrayList<CarteTirage> cartesSpe){
         int i =0;
        for(CarteTirage ct : cartesSpe){
            if(ct.getType() == TypeCarte.SacDeSable){
                i = i+1;
            }
        }
        return i;
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    public void fermer(){
        this.window.setVisible(false);
    }
    
}
