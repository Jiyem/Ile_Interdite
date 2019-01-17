/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.image;

import ile.interdite.Modele.Aventuriers.Aventurier;
import java.awt.Graphics;

/**
 *
 * @author mirasl
 */
public class TuileCalque extends Calque {

    private ImageContainer joueur1;
    private ImageContainer joueur2;
    private ImageContainer joueur3;
    private ImageContainer joueur4;

    
    public TuileCalque(String nomTuile){
    // Récupération du chemin vers le dossier contenant les images
        super("tuiles",nomTuile);
                
        joueur1 = null;        
        joueur2 = null;        
        joueur3 = null;        
        joueur4 = null;        
      
                
    }
    

    @Override
    public String getPath(String nomImage) {
        String imgFolder = System.getProperty("user.dir") + "/src/ile/interdite/image/images/pions/pion" + nomImage +".png";
        return imgFolder;
        
    }
    
    public void ajouterPion(Aventurier A, int numeroJ){
        
//        if (numeroJ ==0){
//        joueur1 = new ImageContainer(this.getPath(A.getCouleur().getlibelle()), 0, 0, 100, 100);
//        this.add(joueur1,0);
//        repaint();
//        }
//        else if (numeroJ ==1){
//        joueur2 = new ImageContainer(this.getPath(A.getCouleur().getlibelle()), 100, 0, 100, 100);
//        this.add(joueur2,1);
//        repaint();
//        }
//        else if (numeroJ ==2){
//        joueur3 = new ImageContainer(this.getPath(A.getCouleur().getlibelle()), 0, 100, 100, 100); 
//        this.add(joueur3,2);
//        repaint();
//        }
//        else if (numeroJ ==3){
//        joueur4 = new ImageContainer(this.getPath(A.getCouleur().getlibelle()), 100, 100, 100, 100);
//        this.add(joueur4,3);
//        repaint();
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.joueur1 != null) {
            System.out.println("pain J1");
        this.joueur1.paintComponent(g);
        }
        if (this.joueur2 != null) {
        this.joueur1.paintComponent(g);
        }
        if (this.joueur3 != null) {
        this.joueur1.paintComponent(g);
        }
        if (this.joueur4 != null) {
        this.joueur1.paintComponent(g);
        }
    }    
        
    
    
    
}
