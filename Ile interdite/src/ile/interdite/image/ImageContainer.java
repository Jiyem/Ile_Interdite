/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.image;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mirasl
 */
public class ImageContainer extends JPanel{
    protected Image image = null;  // Image à afficher
    protected final int x, // Position de l'image sur l'horizontale avec 0 à gauche
                        y, // Position de l'image sur la verticale avec 0 en haut
                        width, // Largeur de l'image
                        height ; // Hauteur de l'image
    
    public ImageContainer(String path, int x, int y, int width, int height){
        super();
        this.setOpaque(false);

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
    }
}
    

