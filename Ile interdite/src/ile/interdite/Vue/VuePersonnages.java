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
//    private ArrayList<JButton> boutons = new ArrayList<>();
    private JButton btnPerso1;
    private JButton btnPerso2;
    private JButton btnPerso3;
    private JButton btnPerso4;
    private Calque imagePerso;
    private Image image ;
    
    
    public VuePersonnages(ArrayList<Aventurier> joueurs) {
        super(new GridLayout(2, 2));
      
        // Cas unique où il y a qu'un joueur !
       
        
            btnPerso1 = new JButton(joueurs.get(0).getImage().getImageAAfficher());
            add(btnPerso1);
//            boutons.add(btnPerso1);
            btnPerso1.setContentAreaFilled(false);
            
            btnPerso2 = new JButton(joueurs.get(1).getImage().getImageAAfficher());
            add(btnPerso2);
//            boutons.add(btnPerso2);
            btnPerso2.setContentAreaFilled(false);
            
            btnPerso3 = new JButton(joueurs.get(2).getImage().getImageAAfficher());
            add(btnPerso3);
//            boutons.add(btnPerso3);
            btnPerso3.setContentAreaFilled(false);
            
            btnPerso4 = new JButton(joueurs.get(3).getImage().getImageAAfficher());
            add(btnPerso4);
//            boutons.add(btnPerso4);
            btnPerso4.setContentAreaFilled(false);
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
//    public JPanel getMainPanel(){
//        return mainPanel;
//    }
    
//    @Override
//    public void paintComponent(Graphics g) {
//        System.out.println("VuePersonnage.paintComponent");
//        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
//        g.drawImage(image, 0,0,100,100, null, this);
//    }
//    public ArrayList<JButton> getButton(){
//        return boutons;
//    }
       
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

    /**
     * @return the btnPerso1
     */
    public JButton getBtnPerso(int numeroBouton) {
        if (numeroBouton==0){
        return btnPerso1;
        }
        else if (numeroBouton==1){
        return btnPerso2;
        }
        else if (numeroBouton==2){
        return btnPerso3;
        }
        else if (numeroBouton==3){
        return btnPerso4;
        }
        return null;
    }


}
