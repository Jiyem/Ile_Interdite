/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

/**
 *
 * @author anandanj
 */
public class MessageAventurier {
    private ActionsType action;
    
    public MessageAventurier(ActionsType action){
        this.action = action;
    }
    
    public ActionsType getAction(){
        return this.action;
    }
    
}