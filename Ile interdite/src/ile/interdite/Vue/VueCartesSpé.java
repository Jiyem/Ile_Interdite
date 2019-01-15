/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Modele.Cartes.CarteHelicoptere;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Cartes.TypeCarte;
import static ile.interdite.Modele.Cartes.TypeCarte.Helicoptere;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chapellr
 */
public class VueCartesSpé {
private JFrame window;
    private JPanel mainPanel;
    private JLabel cartesspe;
    private JPanel marges;
    private JLabel nbHelico;
    private JPanel nbSable;
    private JButton carteSable;
    private JButton carteHelico;
    
    
    
    
    public VueCartesSpé(ArrayList<CarteTirage> cartesSpe){
this.window = new JFrame();
window.setSize(600, 200);
window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
window.setLocationRelativeTo(null);
window.add(mainPanel);
        
        mainPanel = new JPanel(new BorderLayout());
        cartesspe = new JLabel("Cartes Spéciales", JLabel.CENTER);
        cartesspe.setFont(new Font("TimesRoman", Font.PLAIN, (cartesspe.getFont().getSize()*2)));
        mainPanel.add(cartesspe, BorderLayout.NORTH);
        marges = new JPanel(new BorderLayout());
        mainPanel.add(marges, BorderLayout.CENTER);
        
        
        
        
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
}
