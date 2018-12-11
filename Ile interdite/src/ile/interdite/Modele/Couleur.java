/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import java.awt.Color;

/**
 *
 * @author rose
 */
public enum Couleur {     
        ROUGE("Rouge", new Color(255, 0, 0)),
        VERT("Vert", new Color(0, 195, 0)),
        BLEU("Bleu", new Color(55,194,198)),
        ORANGE("Orange", new Color(255, 148, 0)),
        VIOLET("Violet", new Color(204, 94, 255)),
        JAUNE("Jaune", new Color(255, 255, 0)) ;    

        private final String libelle ;
        private final Color couleur ;


        Couleur (String libelle, Color couleur) {
            this.libelle = libelle ;
            this.couleur = couleur ;
}
        public Color getCouleur(){
            return this.couleur;
        }
}
