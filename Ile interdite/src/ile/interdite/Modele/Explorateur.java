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
public class Explorateur extends Aventurier{
    
    private final Couleur couleur;
    private Tuile position = new Tuile(1,"La Porte de Cuivre",1,1);
    private String pseudo;
    
    public Explorateur(Tuile position,String pseudo){
        super(position,pseudo);
        this.couleur = Couleur.VERT;

    }
    
    public Explorateur(String pseudo){
        super(pseudo);
        this.couleur = Couleur.VERT;

    }

    @Override
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        ArrayList<Tuile> tuilepossibles = new ArrayList();
        Tuile[][] tuiles = grille.getTuile();
        
        if(tuiles[position.getX()][position.getY()+1] != null){tuilepossibles.add(tuiles[position.getX()][position.getY()+1]);}
        if(tuiles[position.getX()+1][position.getY()+1] != null){tuilepossibles.add(tuiles[position.getX()+1][position.getY()+1]);}
        if(tuiles[position.getX()+1][position.getY()+1] != null){tuilepossibles.add(tuiles[position.getX()+1][position.getY()+1]);} //Donne la position une case plus haute et à droite
        if(tuiles[position.getX()-1][position.getY()+1] != null){tuilepossibles.add(tuiles[position.getX()-1][position.getY()+1]);}//Donne la position une case plus haute et à gauche
        
        if(tuiles[position.getX()][position.getY()-1] != null){tuilepossibles.add(tuiles[position.getX()][position.getY()-1]);} //Donne la position une case plus basse
        if(tuiles[position.getX()+1][position.getY()-1] != null){tuilepossibles.add(tuiles[position.getX()+1][position.getY()-1]);} //Donne la position une case plus basse et à droite
        if(tuiles[position.getX()-1][position.getY()-1] !=null){tuilepossibles.add(tuiles[position.getX()-1][position.getY()-1]);} //Donne la position une case plus basse et à gauche
        
        if(tuiles[position.getX()+1][position.getY()] !=null){tuilepossibles.add(tuiles[position.getX()+1][position.getY()]);} //Donne la position d'une case à droite
        if(tuiles[position.getX()-1][position.getY()] != null){tuilepossibles.add(tuiles[position.getX()-1][position.getY()]);}; //Donne la position d'une case à gauche
        
        return tuilepossibles;
        }    
    

    @Override
    public ArrayList<Tuile> assèchementPossible(Grille grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRôle() {
        return "Explorateur";
    }
    
    
}
