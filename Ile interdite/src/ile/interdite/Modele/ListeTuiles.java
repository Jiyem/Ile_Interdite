/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import java.util.ArrayList;

/**
 *
 * @author mirasl
 */
public class ListeTuiles {
    private ArrayList nom = new ArrayList<String>();
    
    public ListeTuiles(){
    this.nom.add("Le Pont des Abimes");
    this.nom.add("La Porte de Bronze");
    this.nom.add("La Caverne des Ombres");
    this.nom.add("La Porte de Fer");
    this.nom.add("La Porte d’Or");
    this.nom.add("Les Falaises de l’Oubli");
    this.nom.add("Le Palais de Corail");
    this.nom.add("La Porte d’Argent");
    this.nom.add("Les Dunes de l’Illusion");
    this.nom.add("Heliport");
    this.nom.add("La Porte de Cuivre");
    this.nom.add("Le Jardin des Hurlements");
    this.nom.add("La Foret Pourpre");
    this.nom.add("Le Lagon Perdu");
    this.nom.add("Le Marais Brumeux");
    this.nom.add("Observatoire");
    this.nom.add("Le Rocher Fantome");
    this.nom.add("La Caverne du Brasier");
    this.nom.add("Le Temple du Soleil");
    this.nom.add("Le Temple de La Lune");
    this.nom.add("Le Palais des Marees");
    this.nom.add("Le Val du Crepuscule");
    this.nom.add("La Tour du Guet");
    this.nom.add("Le Jardin des Murmures");
        
     
    }
    public String get(int i){
        return (String) this.nom.get(i);
    }
    
}
