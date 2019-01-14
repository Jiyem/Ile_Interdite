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
        this.melanger();
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
    
    public void melanger(){
        Collections.shuffle(paquet);
    }
    
    public void retirer(String nom){
        int i=0;
        while(i<paquet.size()){
            if(paquet.get(i).getNomcarte()==nom){
                paquet.remove(i);
            }
        }
    }
    
    public ArrayList<CarteInnondation> melangeMonteeEaux(int i){
        ArrayList<CarteInnondation> paquet2 = new ArrayList<>();
        ArrayList<CarteInnondation> paquet3 = new ArrayList<>();
        for(int j=0;j<=i;j++){
            paquet2.add(paquet.get(j));
            paquet.remove(j);
        }
        Collections.shuffle(paquet2);
        for(int j=0;j<=i;j++){
            paquet3.add(paquet2.get(j));
        }
        for(int j=0;j<paquet.size();j++){
            paquet3.add(paquet.get(j));
        }
        return paquet3;
        
    }
    
}
