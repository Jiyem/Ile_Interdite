/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion;

import jeudumorpion.modele.Case;
import jeudumorpion.modele.Joueur;
import jeudumorpion.Vues.VueGrille;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author chapellr
 */
public class Controleur implements Observer{
   private Case cases;
   private Joueur joueurs;
   private VueGrille vueGrille;

   public Controleur(){
       vueGrille=new VueGrille();
       vueGrille.afficher();
   }
    @Override
    public void update(Observable arg0, Object arg1) {
        
    }
   
    
    
}
