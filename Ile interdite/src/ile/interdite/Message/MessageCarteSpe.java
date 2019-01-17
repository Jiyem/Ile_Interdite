/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Message;

/**
 *
 * @author mirasl
 */
public class MessageCarteSpe extends Message{
    
    private int nbCarteSpe;
    
    public MessageCarteSpe(ActionsType action, int nbCarte){
        super(action);
        
        this.nbCarteSpe = nbCarte;
    }

    /**
     * @return the nbCarteSpe
     */
    public int getNbCarteSpe() {
        return nbCarteSpe;
    }
    
}
