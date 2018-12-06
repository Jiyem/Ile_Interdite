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
public class MessageInscription {
    private String pseudo1;
    private String pseudo2;
    private String pseudo3;
    private String pseudo4;
    private String nbJoueurs;
    private ActionsType action;
    
    MessageInscription(ActionsType action,String nbJoueurs,String pseudo1,String pseudo2,String pseudo3,String pseudo4){
        this.action = action;
        this.nbJoueurs = nbJoueurs;
        this.pseudo1 = pseudo1;
        this.pseudo2 = pseudo2;
        this.pseudo3 = pseudo3;
        this.pseudo4 = pseudo4;
    }

    /**
     * @return the pseudo1
     */
    public String getPseudo1() {
        return pseudo1;
    }

    /**
     * @param pseudo1 the pseudo1 to set
     */
    public void setPseudo1(String pseudo1) {
        this.pseudo1 = pseudo1;
    }

    /**
     * @return the pseudo2
     */
    public String getPseudo2() {
        return pseudo2;
    }

    /**
     * @param pseudo2 the pseudo2 to set
     */
    public void setPseudo2(String pseudo2) {
        this.pseudo2 = pseudo2;
    }

    /**
     * @return the pseudo3
     */
    public String getPseudo3() {
        return pseudo3;
    }

    /**
     * @param pseudo3 the pseudo3 to set
     */
    public void setPseudo3(String pseudo3) {
        this.pseudo3 = pseudo3;
    }

    /**
     * @return the pseudo4
     */
    public String getPseudo4() {
        return pseudo4;
    }

    /**
     * @param pseudo4 the pseudo4 to set
     */
    public void setPseudo4(String pseudo4) {
        this.pseudo4 = pseudo4;
    }

    /**
     * @return the nbJoueurs
     */
    public int getNbJoueurs() {
        int i = Integer.parseInt(nbJoueurs);
        return i;
    }

    /**
     * @param nbJoueurs the nbJoueurs to set
     */
    public void setNbJoueurs(String nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
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
