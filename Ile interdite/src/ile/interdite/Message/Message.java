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
public class Message {
    private ActionsType action;
    
    public Message(ActionsType action){
        setAction(action);
    }

    /**
     * @return the action
     */
    public ActionsType getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(ActionsType action) {
        this.action = action;
    }
    
}
