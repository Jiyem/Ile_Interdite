/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.image;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author mirasl
 */
public class Calque extends JLayeredPane{
        private ImageContainer fond;
        
        // Instanciation d'une image 
        // Remarque : les positions et les tailles sont en dur !
        // Dans l'idéal, il faudrait recevoir la taille de la fenêtre et 
        // faire quelque chose de proportionnel.
        
        
        
        
        public Calque(String nomImage){
            
            fond = new ImageContainer(this.getPath(nomImage), 0, 0, 100, 100);
            this.add(fond, -10);
            
            // Repaint : déclenche la méthode paintComponent
            this.repaint();
        }
        
        //nomRepertoire doit être écrit comme ça : "nomRepertoire"
        public Calque(String nomRepertoire, String nomImage){
            fond = new ImageContainer(this.getPath(nomRepertoire,nomImage), 0, 0, 0, 0);
            this.add(fond, -10);
            
            // Repaint : déclenche la méthode paintComponent
            this.repaint();
        }
        
        
    @Override
    /**
        * paintComponent permet de gérer l'affichage / la mise à jour des
         * images, à condition que le paintComponent de chaque objet soit appelé
        * avec le même contexte graphique (Graphics)
        */
    public void paintComponent(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        if (this.fond != null) {
            this.fond.paintComponent(g);
        }
    }

        
   
        

        
        
        /* Procedure pour avoir l'image dans le repertoire choisi */
        public String getPath(String repertoire, String nomImage){
        String imgFolder = System.getProperty("user.dir") + "/src/ile/interdite/image/images/" + repertoire +"/"+ nomImage +".png";
        return imgFolder;
        }
        
        
        /* Procedure a override pour avoir juste le nom d'image a entrer */
        public String getPath(String nomImage){
        String imgFolder = System.getProperty("user.dir") + "/src/ile/interdite/image/images/" + nomImage +".png";
        return imgFolder;
        }
    
}
