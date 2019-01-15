/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Vue;

import ile.interdite.image.ImageContainer;

/**
 *
 * @author mirasl
 */
public class VueIPersonnages {
    ImageContainer imagePerso;

    public VueIPersonnages(String path) {
       imagePerso = new ImageContainer(path,0,0,100,100);
    }
    
    
}
