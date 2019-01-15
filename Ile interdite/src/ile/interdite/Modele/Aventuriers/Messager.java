/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Aventuriers;
import aide.Utils;
import aide.Utils.EtatTuile;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Cartes.TypeCarte;
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
        return "messager";
    }
    
    @Override
     public void donnerCarte(Aventurier a, CarteTirage carte){
        if(carte.getType() == TypeCarte.Tresor){
         if(a.getCartes().size() < 10) {
                a.ajouterCartes(carte);
                this.enleverCarte(carte);
            }
            else{
                System.out.print("Le joueur à qui vous voulez donner cette carte en possède trop");
            }
     }
        else{
            System.out.println("La carte que vous souhaitez donner n'est pas une carte trésor");
        }
    }


}
