/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion;

/**
 *
 * @author chapellr
 */
public class Message {
   private int numCase;
   private Commande commande;
   
   public Message(int numCase, Commande commande){
    this.numCase = numCase;
    this.commande = commande;
}
   
}
