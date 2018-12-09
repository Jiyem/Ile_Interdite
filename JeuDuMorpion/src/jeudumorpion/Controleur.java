/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion;

import java.io.IOException;
import jeudumorpion.modele.Case;
import jeudumorpion.modele.Joueur;
import jeudumorpion.Vues.VueGrille;
import java.util.Observable;
import java.util.Observer;
import jeudumorpion.Vues.VueSelection;
import jeudumorpion.Vues.VueSpecification;

/**
 *
 * @author chapellr
 */
public class Controleur implements Observer{
   private Case cases;
   private Joueur joueurs;
   private VueGrille vueGrille;
   private VueSelection vueSelection;
   private VueSpecification vueSpe;
   
   public Controleur() throws IOException{
       vueGrille=new VueGrille();
       //vueGrille.afficher();
       vueSelection=new VueSelection();
       //vueSelection.afficher();
       vueSpe = new VueSpecification();
       vueSpe.afficher();
   }
    @Override
    public void update(Observable arg0, Object arg1) {
        
    }
   
    
    
}
