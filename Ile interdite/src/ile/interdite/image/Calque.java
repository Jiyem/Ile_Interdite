/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.image;

/**
 *
 * @author mirasl
 */
public class Calque {
        private ImageContainer Fond;
        
        public Calque(String nomImage){
            Fond = new ImageContainer(this.getPath(nomImage)+".png", 0, 0, 0, 0);
        }
        public Calque(String nomRepertoire, String nomImage){
            Fond = new ImageContainer(this.getPath(nomRepertoire,nomImage)+".png", 0, 0, 0, 0);
        }
        
        /* Procedure pour avoir l'image dans le repertoire choisi */
        public String getPath(String repertoire, String nomImage){
        String imgFolder = System.getProperty("user.dir") + "/src/ile/interdite/image/images/" + repertoire + nomImage +".png";
        return imgFolder;
        }
        
        
        /* Procedure a override pour avoir juste le nom d'image a entrer */
        public String getPath(String nomImage){
        String imgFolder = System.getProperty("user.dir") + "/src/ile/interdite/image/images/" + nomImage +".png";
        return imgFolder;
        }
    
}
