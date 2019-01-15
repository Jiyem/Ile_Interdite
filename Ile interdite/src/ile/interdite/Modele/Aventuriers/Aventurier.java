/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile.interdite.Modele.Aventuriers;
import ile.interdite.Modele.Cartes.CarteTirage;
import ile.interdite.Modele.Cartes.TypeCarte;
import static ile.interdite.Modele.Cartes.TypeCarte.Tresor;
import ile.interdite.Modele.Couleur;
import ile.interdite.Modele.EtatCase;
import ile.interdite.Modele.Grille;
import ile.interdite.Modele.Tresor;
import ile.interdite.Modele.Tuile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author domestit
 */
public abstract class Aventurier {
    
    /**
     * @return the couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
        /**
     * @return the cartes
     */
    public ArrayList<CarteTirage> getCartes() {
        return cartes;
    }
    
    
    //attributs
    protected Tuile position; // Il faudra faire un equal entre String pour la trouver sur le plateau || Faire les setter
    private Couleur couleur; // Faire setter
    protected String pseudo;
    private ArrayList<CarteTirage> cartes = new ArrayList<>();
    private ArrayList<Tresor> tresors = new ArrayList<>();
    //constructeurs
    public Aventurier(Tuile position,String pseudo){
        this.setPosition(position);
        this.setPseudo(pseudo);
        this.setCouleur(null);
    }
    public Aventurier(String pseudo){
        this.setPseudo(pseudo);
        this.setCouleur(null);
    }
    //méthode
    
    public void ajouterCartes(CarteTirage carte){
        if(getCartes().size() < 9){
            getCartes().add(carte);   
        }else{
            System.out.println("Erreur joueur a 9 cartes");
        }
    }
    
        public void enleverCarte(CarteTirage carte){
            for(int i =0; i < this.getCartes().size(); i++){
                if (this.getCartes().get(i) == carte){
                    this.getCartes().remove(this.getCartes().get(i));
                    System.out.println("La carte à bien été supprimée");
                }
            }
    }
    
    public ArrayList<Tuile> déplacementPossible(Grille grille){
        return grille.getTuilehorizontaleEtVerticale(position); 
    }
    
    public ArrayList<Tuile> assèchementPossible(Grille grille){
         return grille.assèchementPossible(position);
    }
    
    public abstract String getRôle();

    
    public Tuile getPosition(){
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Tuile position) {
        this.position = position;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }
      public void deplacement(Tuile t){
        this.setPosition(t);
    }
    public void assechement(Tuile t){
        t.setEtatCase(EtatCase.NORMAL);
    }
    
    public void donnerCarte(Aventurier a, CarteTirage carte){
        if(carte.getType() == TypeCarte.Tresor){
            if (this.getPosition() == a.getPosition()){
                if(a.getCartes().size() < 10) {
                    a.ajouterCartes(carte);
                    this.enleverCarte(carte);
                }
                else{
                    System.out.print("Le joueur à qui vous voulez donner cette carte en possède trop");
                }
            }
            else{
                System.out.print("Vous n'êtes pas sur la même case vous ne pouvez donc pas échanger de carte avec cet Aventurier");
            }   
        }
        else{
            System.out.println("La carte que vous souhaitez donner n'est pas une carte trésor");
        }
        

    }
    
    public boolean ouAller(Grille grille){
    ArrayList<Tuile> deplacementPossible = new ArrayList();
    deplacementPossible = this.déplacementPossible(grille);// faire en sorte que l'on calcule ses mouvement possible puis qu'on l'affiche sur la grille/consonle
    if(deplacementPossible.size()==0){
        System.out.println("Il n'y a aucune tuile sur laquelle se déplacer");
        return false;
    }else{
    for (int i =0; i < deplacementPossible.size();i++){
        System.out.println(i + " : " + deplacementPossible.get(i).getNomTuile());
    }
    System.out.println("Entrez le numéro de la tuile où vous souhaitez aller");
    Scanner scanner = new Scanner(System.in);
    String numeroTuile = scanner.nextLine();


        for(int j =0; j < deplacementPossible.size();j++){
                    if (numeroTuile.equals(Integer.toString(j))) {
                    this.deplacement(deplacementPossible.get(j));
                    System.out.println("Vous venez d'être déplacé sur la tuile : " + deplacementPossible.get(j).getNomTuile());
                    }



        }
    return true;}

}
    public boolean ouAssecher(Grille grille){
    ArrayList<Tuile> asschmntPossible = new ArrayList();
    asschmntPossible = this.assèchementPossible(grille);// faire en sorte que l'on calcule ses assechement possible puis qu'on l'affiche sur la grille/consonle
    if(asschmntPossible.size()==0){
        System.out.println("Il n'y a aucune tuile que vous puissiez assècher");
        return false;
    }else{
    for (int k =0; k < asschmntPossible.size(); k++){
        System.out.println(k + " : " + asschmntPossible.get(k).getNomTuile());
    }
    System.out.println("Entrez le numéro de la tuile que vous souhaitez assècher");
    Scanner scanner = new Scanner(System.in);
    String numeroTuile = scanner.nextLine();


        for(int j =0; j < asschmntPossible.size();j++){
                    if (numeroTuile.equals(Integer.toString(j))) {
                    this.assechement(asschmntPossible.get(j));
                    System.out.println("Vous avez asséché la tuile : " + asschmntPossible.get(j).getNomTuile());
                    }



        }return true;}

}
    public boolean ouAllerSpe(Grille grille){
        return false;
    }
    
    public void ajouterTresor(Tresor tresor){
        getTresors().add(tresor);
    }

    /**
     * @return the tresors
     */
    public ArrayList<Tresor> getTresors() {
        return tresors;
    }


    

}
