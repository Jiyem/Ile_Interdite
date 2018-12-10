/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import java.util.ArrayList;

/**
 *
 * @author rose
 */
public class Ingenieur extends Aventurier{
    private final Couleur couleur;
    private final Tuile position = new Tuile(1, "La Porte De Bronze",1,1);
    
    public Ingenieur(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.ROUGE;

    }
    
    public Ingenieur(String pseudo){
        super(pseudo);
        this.couleur = Couleur.ROUGE;
    }


       @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        return grille.getTuilehorizontaleEtVerticale(position);
        }    
    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRôle() {
        return "Ingenieur";
    }
}