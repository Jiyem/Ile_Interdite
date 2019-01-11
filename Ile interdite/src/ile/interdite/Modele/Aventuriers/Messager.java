/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Aventuriers;
import aide.Utils;
import aide.Utils.EtatTuile;
import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;
/**
 *
 * @author rose
 */
public class Messager extends Aventurier{

    
    public Messager(Tuile position,String pseudo){
        super(position,pseudo);
        this.setCouleur(Couleur.ORANGE);
    }

    public Messager(String pseudo){
        super(pseudo);
        this.setCouleur(Couleur.ORANGE);    }
    
    //Comme les deplacements et les assechements du messager sont basique pas besoin de redefinir les fonctions

    @Override
    public String getRôle() {
        return "Messager";
    }


}
