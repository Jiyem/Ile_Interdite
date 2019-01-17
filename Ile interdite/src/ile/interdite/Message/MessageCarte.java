/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Message;

import ile.interdite.Modele.Aventuriers.Aventurier;
import ile.interdite.Modele.Cartes.CarteTirage;

/**
 *
 * @author rose
 */
public class MessageCarte extends Message{
    
    private CarteTirage carte;
    private String joueurGagnant;
    
    public MessageCarte(String joueurGagnant,ActionsType action,CarteTirage carte) {
        super(action);
        this.carte=carte;
        this.joueurGagnant=joueurGagnant;
               
    }

    /**
     * @return the carte
     */
    public CarteTirage getCarte() {
        return carte;
    }

    /**
     * @return the av
     */
    public String getAv() {
        return joueurGagnant;
    }
    
}
