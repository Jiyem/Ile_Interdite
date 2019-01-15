/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;

import ile.interdite.Modele.Tresor;

/**
 *
 * @author anandanj
 */
public class CarteTirage {
    TypeCarte type;
    public CarteTirage(TypeCarte type){
        this.type = type;
    }
    public TypeCarte getType(){
        return this.type;
    }
    
    public void getAction(){
        if(this.type == TypeCarte.Helicoptere){
            //Ajouter une carte hélico à la main du joueur courant.
        }
        else if(this.type == TypeCarte.MonteeDesEaux){
            //Effectuer une montée des eaux
        }
        else if(this.type == TypeCarte.SacDeSable){
            //Ajouer une carte SacDeSable à la main du joueur courrant
        }
        else if(this.type == TypeCarte.Tresor){
            //Ajouter la carte du trésor correspondant a la main du joueur courant
        }
    }
    
    @Override
    public String toString(){
        return null;
    }
    
    
    public Tresor getTresor(){
        return null;
    }
}
