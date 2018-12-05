/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudumorpion.Vues;

import jeudumorpion.modele.EtatCase;
import jeudumorpion.modele.EtatCase;

/**
 *
 * @author chapellr
 */
public class ICase {
    private int numero;
    private EtatCase etatCase;
    
    public ICase(int numero){
        this.numero = numero;
        this.etatCase = etatCase.NON_COCHEE;
    }
}
