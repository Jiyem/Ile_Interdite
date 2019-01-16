/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele;

import ile.interdite.image.ImageContainer;
import java.util.ArrayList;

/**
 *
 * @author mirasl
 */
public class ListeTuiles {
    private ArrayList nom = new ArrayList<String>();
    private ArrayList<ImageContainer> image=  new ArrayList<>();
    
    public ListeTuiles(){
        String s = System.getProperty("user.dir")+"/src/ile/interdite/image/images/tuiles/";
        this.nom.add("Le Pont des Abimes");
        this.image.add(new ImageContainer(s +"LePontDesAbimes.png",0,0,0,0));
        this.nom.add("La Porte de Bronze");
        this.image.add(new ImageContainer(s +"LaPorteDeBronze.png",0,0,0,0));
        this.nom.add("La Caverne des Ombres");
        this.image.add(new ImageContainer(s +"LaCarverneDesOmbres.png",0,0,0,0)); 
        this.nom.add("La Porte de Fer");
        this.image.add(new ImageContainer(s +"LaPorteDeFer.png",0,0,0,0));
        this.nom.add("La Porte d’Or");
        this.image.add(new ImageContainer(s+"LaPortedOr.png",0,0,0,0));
        this.nom.add("Les Falaises de l’Oubli");
        this.image.add(new ImageContainer(s+"LesFalaisesDeLOubli.png",0,0,0,0));
        this.nom.add("Le Palais de Corail");
        this.image.add(new ImageContainer(s+"LePalaisDeCorail.png",0,0,0,0));
        this.nom.add("La Porte d’Argent");
        this.image.add(new ImageContainer(s+"LaPortedArgent.png",0,0,0,0));
        this.nom.add("Les Dunes de l’Illusion");
        this.image.add(new ImageContainer(s+"LesDunesDeLIllusion.png",0,0,0,0));
        this.nom.add("Heliport");
        this.image.add(new ImageContainer(s+"Heliport.png",0,0,0,0));
        this.nom.add("La Porte de Cuivre");
        this.image.add(new ImageContainer(s+"LaPorteDeCuivre.png",0,0,0,0));
        this.nom.add("Le Jardin des Hurlements");
        this.image.add(new ImageContainer(s+"LeJardinDesHurlements.png",0,0,0,0));
        this.nom.add("La Foret Pourpre");
        this.image.add(new ImageContainer(s+"LaForetPourpre.png",0,0,0,0));
        this.nom.add("Le Lagon Perdu");
        this.image.add(new ImageContainer(s+"LeLagonPerdu.png",0,0,0,0));
        this.nom.add("Le Marais Brumeux");
        this.image.add(new ImageContainer(s+"LeMaraisBrumeux.png",0,0,0,0));
        this.nom.add("Observatoire");
        this.image.add(new ImageContainer(s+"Observatoire.png",0,0,0,0));
        this.nom.add("Le Rocher Fantome");
        this.image.add(new ImageContainer(s+"LeRocherFantome.png",0,0,0,0));
        this.nom.add("La Caverne du Brasier");
        this.image.add(new ImageContainer(s+"LaCarverneDuBrasier.png",0,0,0,0));
        this.nom.add("Le Temple du Soleil");
        this.image.add(new ImageContainer(s+"LeTempleDuSoleil.png",0,0,0,0));
        this.nom.add("Le Temple de La Lune");
        this.image.add(new ImageContainer(s+"LeTempleDeLaLune.png",0,0,0,0));
        this.nom.add("Le Palais des Marees");
        this.image.add(new ImageContainer(s+"LePalaisDesMarees.png",0,0,0,0));
        this.nom.add("Le Val du Crepuscule");
        this.image.add(new ImageContainer(s+"LeValDuCrepuscule.png",0,0,0,0));
        this.nom.add("La Tour du Guet");
        this.image.add(new ImageContainer(s+"LaTourDuGuet.png",0,0,0,0));
        this.nom.add("Le Jardin des Murmures");
        this.image.add(new ImageContainer(s+"LeJardinDesMurmures.png",0,0,0,0));
        
        
     
    }
    public String getNom(int i){
        return (String) this.nom.get(i);
    }

    /**
     * @return the image
     */
    public ImageContainer getImage(int i) {
        return (ImageContainer) this.image.get(i);
    }
    
    
}
