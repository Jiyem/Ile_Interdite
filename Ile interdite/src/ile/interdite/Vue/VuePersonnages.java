/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.Modele.Aventuriers.Pilote;
import ile.interdite.image.Calque;
import ile.interdite.image.ImageContainer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mirasl
 */
public class VuePersonnages  extends JPanel  {
//    private JPanel mainPanel;
    private ArrayList<JButton> boutons = new ArrayList<>();
    private JButton btnPerso;
    private Calque imagePerso;
    private Image image ;
    
    
    public VuePersonnages(ArrayList<Aventurier> joueurs) {
        super(new GridLayout(2, 2));
      
        // Cas unique où il y a qu'un joueur !
       
        for (int j=0; j<joueurs.size();j++){
            btnPerso = new JButton(joueurs.get(j).getImage().getImageAAfficher());
            add(btnPerso);
            boutons.add(btnPerso);
//            String path = System.getProperty("user.dir")+"/src/ile/interdite/image/images/"+"personnages/"+joueurs.get(j).getRôle()+".png";
//            mainPanel.setOpaque(false);
//
//            repaint();
//            try {
//            System.out.println("creation de ImageIO");
//            this.image = ImageIO.read(new File(path));
//
//            repaint();
//            
//        } catch (IOException ex) {
//           System.err.println("ImageIO plante");
//        }
        }
        
        
    }
//    public JPanel getMainPanel(){
//        return mainPanel;
//    }
    
//    @Override
//    public void paintComponent(Graphics g) {
//        System.out.println("VuePersonnage.paintComponent");
//        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
//        g.drawImage(image, 0,0,100,100, null, this);
//    }
    public ArrayList<JButton> getButton(){
        return boutons;
    }
       
    public static void main(String[] args) {
        JFrame window = new JFrame() ;
        window.setSize(450, 300);
        // Centrage de la fenêtre sur l'écran
      
        Aventurier a1 = new Pilote("test") ;
        ArrayList<Aventurier> t = new ArrayList<>();
             t.add(a1);
        VuePersonnages vue = new VuePersonnages(t) ;
        window.add(vue) ;
        window.setVisible(true);
        vue.repaint();
        window.repaint();
    }

}
