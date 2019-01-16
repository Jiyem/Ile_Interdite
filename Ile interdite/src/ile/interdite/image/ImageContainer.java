/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.image;

import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.Modele.Aventuriers.Pilote;
import ile.interdite.Vue.VuePersonnages;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mirasl
 */
public class ImageContainer extends JPanel{
    private Image image = null;  // Image à afficher
    private StretchIcon imageAAfficher;
    protected final int x, // Position de l'image sur l'horizontale avec 0 à gauche
                        y; // Hauteur de l'image
    private int width;
    private int height;
    
    public ImageContainer(String path, int x, int y, int width, int height){
        super();
        this.setOpaque(false);
        System.out.println("Image container");
        this.setBackground(Color.red);
        
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;

        try {
            // Transformation du fichier contenant l'image en image
            this.image = ImageIO.read( new File(path));
        } catch (IOException ex) {
            System.err.println("Erreur en lecture de l'image " + path);
        }
        imageAAfficher = new StretchIcon(image);
        repaint();
    }
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image, x, y, width, height, null, this);
        g.drawImage(getImage(), x, y, width, height, null, this);
    }
      public static void main(String[] args) {
        JFrame window = new JFrame() ;
        window.setSize(450, 300);
        // Centrage de la fenêtre sur l'écran
      

        ImageContainer image = new ImageContainer(System.getProperty("user.dir")+"/src/ile/interdite/image/images/"+"personnages/"+"pilote"+".png",0, 0, 100, 100);
        window.add(image) ;
        window.setVisible(true);
//        image.repaint();
//        window.repaint();
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
}
    

