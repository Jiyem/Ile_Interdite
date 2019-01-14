/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;

/**
 *
 * @author lacranto
 */
public class CarteInnondation {
    //attributs
    private String nomcarte;
    
    //constructeurs
    public CarteInnondation(String n){
        this.nomcarte=n;
    }
    //méthodes
    
    /**
     * @return the nomcarte
     */
    public String getNomcarte() {
        return nomcarte;
    }

    /**
     * @param nomcarte the nomcarte to set
     */
    public void setNomcarte(String nomcarte) {
        this.nomcarte = nomcarte;
    }
}
