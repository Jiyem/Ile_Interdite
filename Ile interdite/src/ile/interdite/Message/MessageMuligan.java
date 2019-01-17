/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Message;

import ile.interdite.Modele.Cartes.CarteTirage;
import java.util.ArrayList;

/**
 *
 * @author Théophane
 */
public class MessageMuligan extends Message {
    private ArrayList<CarteTirage> listecartes;
    
    public MessageMuligan(ActionsType action,ArrayList<CarteTirage> listecartes){
        super(action);
        this.listecartes = listecartes;
    }

    /**
     * @return the listecartes
     */
    public ArrayList<CarteTirage> getListecartes() {
        return listecartes;
    }
    
    
}
