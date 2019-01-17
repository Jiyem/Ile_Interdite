/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Message;

/**
 *
 * @author anandanj
 */
public class MessageAction {
    private int numTuile;
    private ActionsType action;
    public MessageAction(ActionsType type,int numTuile){
        this.numTuile = numTuile;
        this.action = type;
    }

    /**
     * @return the numTuile
     */
    public int getNumTuile() {
        return numTuile;
    }

    /**
     * @param numTuile the numTuile to set
     */
    public void setNumTuile(int numTuile) {
        this.numTuile = numTuile;
    }

    /**
     * @return the type
     */
    public ActionsType getAction() {
        return action;
    }

    /**
     * @param type the type to set
     */
    public void setAction(ActionsType action) {
        this.action = action;
    }
    
}
