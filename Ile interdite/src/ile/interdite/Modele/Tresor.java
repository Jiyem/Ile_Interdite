/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import aide.util.Parameters;
import java.awt.Color;

/**
 *
 * @author anandanj
 */

public enum Tresor {
        PIERRE("La Pierre Sacrée", new Color(141,79,9), new Color(255,242,0), Parameters.TRESORS + "pierre.png"),
        ZEPHYR("La statue du Zéphyr", new Color(255,215,0), new Color(208,26,136), Parameters.TRESORS + "zephyr.png"),
        CRISTAL("Le Cristal Ardent", new Color(219,56,154), new Color(99,187,242), Parameters.TRESORS + "cristal.png"),
        CALICE("Le Calice de l'Onde", new Color(27,188,245), new Color(141,79,9), Parameters.TRESORS + "calice.png") ;

        String libelle;
        Color bgColor ;
        Color textColor ;
        String pathPicture ;

        Tresor(String libelle, Color bgColor, Color textColor, String pathPicture) {
            this.libelle = libelle;
            this.bgColor = bgColor ;
            this.textColor = textColor ;
            this.pathPicture = pathPicture ;
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
    
}
