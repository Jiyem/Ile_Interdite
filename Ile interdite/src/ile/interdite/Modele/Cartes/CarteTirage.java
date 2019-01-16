/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;

import ile.interdite.Modele.Tresor;
import ile.interdite.image.ImageContainer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author anandanj
 */
public class CarteTirage {
    private TypeCarte type;
    private ImageContainer image;
    

    public CarteTirage(TypeCarte type){
        this.type = type;
    }
    public TypeCarte getType(){
        return this.type;
    }
    
    public void getAction(){
        if(this.type == TypeCarte.Helicoptere){
            //Ajouter une carte hélico à la main du joueur courant.
        }
        else if(this.type == TypeCarte.MonteeDesEaux){
            //Effectuer une montée des eaux
        }
        else if(this.type == TypeCarte.SacDeSable){
            //Ajouer une carte SacDeSable à la main du joueur courrant
        }
        else if(this.type == TypeCarte.Tresor){
            //Ajouter la carte du trésor correspondant a la main du joueur courant
        }
    }
    
    @Override
    public String toString(){
        return null;
    }
    
    
    public Tresor getTresor(){
        return null;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String nomFichierImage) {
            //        this.image = System.getProperty("user.dir") + "/src/ile/interdite/image/images/" + nomImage +".png";
        this.image = new ImageContainer("src/ile/interdite/image/images/cartes/"+nomFichierImage+".png",0,0,0,0);
    }

    /**
     * @return the image
     */
    public ImageContainer getImage() {
        return image;
    }


}
