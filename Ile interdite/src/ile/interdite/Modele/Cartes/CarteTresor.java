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
    }
    
    @Override
    public Tresor getTresor(){
        return tresor;
    }
    
    public String toString(){
        return tresor.toString();
    }
}
