/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.image;

import ile.interdite.Modele.Aventuriers.Aventurier;

/**
 *
 * @author mirasl
 */
public class TuileCalque {
    private ImageContainer tuileFond;
    private ImageContainer j1;
    private ImageContainer j2;
    private ImageContainer j3;
    private ImageContainer j4;
    
    public TuileCalque(String nomTuile){
    // Récupération du chemin vers le dossier contenant les images
        String imgFolder = System.getProperty("user.dir") + "/src/ile/interdite/image/images/" ;
        
        tuileFond = new ImageContainer(imgFolder+"tuiles/"+nomTuile+".png", 0, 0, 0, 0);
        
        j1 = null;        
        j2 = null;     
        j3 = null;       
        j4 = null;      
                
    }
    
    public void ajouterPion(Aventurier A){
        
    }
}
