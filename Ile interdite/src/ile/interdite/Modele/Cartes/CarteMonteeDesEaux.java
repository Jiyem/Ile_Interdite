/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;

/**
 *
 * @author anandanj
 */
public class CarteMonteeDesEaux extends CarteTirage{
    public CarteMonteeDesEaux(){
        super(TypeCarte.MonteeDesEaux);
    }
    
    public String toString(){
        return "Montée des eaux";
    }
    
}
