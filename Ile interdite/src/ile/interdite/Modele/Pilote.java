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
public class Pilote extends Aventurier{
    private final Couleur couleur;
    private final Tuile position = new Tuile(1,"Heliport",1,1);
    
    public Pilote(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.BLEU;
    }
    public Pilote(String pseudo){
        super(pseudo);
        this.couleur = Couleur.BLEU;
    }


       @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = grille.getTuile();
        tuilepossibles.add(tuiles[position.getX()][position.getY()+1]); //Donne la position 1 case plus haute
        tuilepossibles.add(tuiles[position.getX()+1][position.getY()+1]); //Donne la position une case plus haute et à droite
        tuilepossibles.add(tuiles[position.getX()-1][position.getY()+1]);//Donne la position une case plus haute et à gauche
        
        tuilepossibles.add(tuiles[position.getX()][position.getY()-1]); //Donne la position une case plus basse
        tuilepossibles.add(tuiles[position.getX()+1][position.getY()-1]); //Donne la position une case plus basse et à droite
        tuilepossibles.add(tuiles[position.getX()-1][position.getY()-1]); //Donne la position une case plus basse et à gauche
        
        tuilepossibles.add(tuiles[position.getX()+1][position.getY()]); //Donne la position d'une case à droite
        tuilepossibles.add(tuiles[position.getX()-1][position.getY()]); //Donne la position d'une case à gauche
        
        return tuilepossibles;
        }    
    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRôle() {
        return "Pilote";
    }
}
