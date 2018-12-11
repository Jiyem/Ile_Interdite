/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;
import Aides.Utils;
import Aides.Utils.EtatTuile;
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
    
    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille) {
        return grille.getTuilehorizontaleEtVerticale(position);
    }

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        return grille.assèchementPossible(position);
    }

    @Override
    public String getRôle() {
        return "Messager";
    }

}
