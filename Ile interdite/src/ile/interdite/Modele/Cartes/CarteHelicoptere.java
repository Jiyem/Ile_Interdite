/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;

import ile.interdite.Modele.Aventuriers.Aventurier;
import static ile.interdite.Modele.EtatCase.INNONDEE;
import static ile.interdite.Modele.EtatCase.NORMAL;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;

/**
 *
 * @author anandanj
 */
public class CarteHelicoptere extends CarteTirage{
    public CarteHelicoptere(){
        super(TypeCarte.Helicoptere);
    }
    
    //Méthode qui renvoie toutes les tuiles (ArrayList) sur lesquels les joueurs peuvent s'héliporter.
    public ArrayList<Tuile> deplacable(Grille grille){
        ArrayList<Tuile> tuilesDeplacable = new ArrayList<>();
        Tuile[][] tuiles = grille.getTuile();
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if(tuiles[y][x].getEtatCase()== INNONDEE ||tuiles[y][x].getEtatCase() == NORMAL){
                    tuilesDeplacable.add(tuiles[y][x]);
                }
            }
        }
        return tuilesDeplacable;
    }
    
    //Méthode qui demande la tuile de départ utilisé par la carte, la tuile d'arrivé et l'ArrayList des joueurs qui veulent être déplacé.
    //  /!\ on part du principe que la méthode deplacable à été utilisé au préalable et que tuileDep et tuileArr sont bien dans les tuiles possible.
    //La méthode vérifie que tout les joueurs sont sur la tuile de départ sinon lève une exception (a supprimer plus tard en fonction de comment on code dans le contrôleur)
    //Une fois la vérification éffectuée la méthode déplace les joueurs sur la tuile d'arrivé..
    public void utiliserHelico(Tuile tuileDep,Tuile tuileArr,ArrayList<Aventurier> joueurs){
        boolean verifJoueursSurTuile = true;
        for(int i = 0;i<joueurs.size();i++){
            if(joueurs.get(i).getPosition() != tuileDep){
                verifJoueursSurTuile = false;
            }
        }
        if(!verifJoueursSurTuile){
            //faudra lever une exception
        }else{
            
        }for(int i = 0;i<joueurs.size();i++){
            joueurs.get(i).deplacement(tuileArr);
        }
    }
    
    public String toString(){
        return "Helicoptere";
    }
    
}
