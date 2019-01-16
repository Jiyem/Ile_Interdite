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
public class CarteTresor extends CarteTirage {
    private Tresor tresor;
    public CarteTresor(Tresor tresor){
        super(TypeCarte.Tresor);
        this.tresor = tresor;
        if(tresor == Tresor.ZEPHYR){
            super.setImage("Zephyr");
        }
        else if(tresor == Tresor.PIERRE){
            super.setImage("Pierre");
        }
        else if(tresor == Tresor.CALICE){
            super.setImage("Calice");
        }
        else if(tresor == Tresor.CRISTAL){
            super.setImage("Cristal");
        }
    }
    
    @Override
    public Tresor getTresor(){
        return tresor;
    }
    
    public String toString(){
        return tresor.toString();
    }
}
