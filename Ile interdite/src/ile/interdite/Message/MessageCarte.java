/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Message;

import ile.interdite.Modele.Aventuriers.Aventurier;

/**
 *
 * @author rose
 */
public class MessageCarte extends Message{
    
    private String carte;
    private Aventurier av;
    
    public MessageCarte(Aventurier av,ActionsType action,String carte) {
        super(action);
        this.carte=carte;
        this.av=av;
               
    }

    /**
     * @return the carte
     */
    public String getCarte() {
        return carte;
    }

    /**
     * @return the av
     */
    public Aventurier getAv() {
        return av;
    }
    
}
