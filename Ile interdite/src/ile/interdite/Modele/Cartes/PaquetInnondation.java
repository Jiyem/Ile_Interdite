/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Cartes;
import ile.interdite.Modele.ListeTuiles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/**
 *
 * @author lacranto
 */
public class PaquetInnondation {
    //attributs
    private ArrayList<CarteInnondation> paquet = new ArrayList<>();
    private final ListeTuiles liste = new ListeTuiles();
    //constructeurs
    public PaquetInnondation(){
        for(int i=0;i<24;i++){
            paquet.add(new CarteInnondation(liste.get(i)));
        }
    }

    /**
     * @return the paquet
     */
    public ArrayList<CarteInnondation> getPaquet() {
        return paquet;
    }

    /**
     * @param paquet the paquet to set
     */
    public void setPaquet(ArrayList<CarteInnondation> paquet) {
        this.paquet = paquet;
    }
    
    public void mélanger(){
        Collections.shuffle(paquet);
    }
}
