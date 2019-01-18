/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import aide.util.Parameters;
import ile.interdite.image.ImageContainer;
import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author anandanj
 */

public enum Tresor {
        PIERRE("La Pierre Sacrée", new Color(141,79,9), new Color(255,242,0), "pierre.png"),
        ZEPHYR("La statue du Zéphyr", new Color(255,215,0), new Color(208,26,136),  "zephyr.png"),
        CRISTAL("Le Cristal Ardent", new Color(219,56,154), new Color(99,187,242),  "cristal.png"),
        CALICE("Le Calice de l'Onde", new Color(27,188,245), new Color(141,79,9),  "calice.png") ;

        String libelle;
        Color bgColor ;
        Color textColor ;
        String pathPicture ;
        ImageContainer image;
        
        Tresor(String libelle, Color bgColor, Color textColor, String pathPicture) {
            this.libelle = libelle;
            this.bgColor = bgColor ;
            this.textColor = textColor ;
            this.setImage(pathPicture);
        }

        @Override
        public String toString() {
            return this.libelle ;
        }

        public Color getBgColor() {
            return this.bgColor ;
        }

        public Color getTextColor() {
            return this.textColor ;
        }
        
        public String getPathPicture() {
            return this.pathPicture ;
        }

        public static Tresor getFromName(String name) {
            if (name.equals(PIERRE.name())) return PIERRE ;
            if (name.equals(ZEPHYR.name())) return ZEPHYR ;
            if (name.equals(CRISTAL.name())) return CRISTAL ;
            if (name.equals(CALICE.name())) return CALICE ;
            return null ;
        }

    private void setImage(String chemin) {
        this.image = new ImageContainer(System.getProperty("user.dir")+"/src/ile/interdite/image/images/tresors/"+chemin,0,0,0,0);
    }

    /**
     * @return the image
     */
    public ImageContainer getImage() {
        return image;
    }
    
}
