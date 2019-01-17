package ile.interdite.Vue;

import ile.interdite.Message.ActionsType;
import ile.interdite.Message.Message;
import aide.Utils.Pion;
import ile.interdite.Message.MessageAventurier;
import ile.interdite.Modele.Couleur;
import ile.interdite.image.ImageContainer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
 
public class VueAventurier extends Observable  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger  ;
    private final JButton btnAssecher;
    private final JButton btnDonnerCarte;
    private final JButton btnTerminerTour;
    private JTextField position;
    private JPanel panelBouger;
    private JPanel panelAssecher;
    private JPanel panelDonner;
    private JPanel panelTerminerTour;
    private JPanel panelRecupererTresor;
    private JPanel panelAutreAction;
    private JButton btnAutreAction;
    private JButton btnRecupTresor;

   
   
    
    public VueAventurier(String nomJoueur, String nomAventurier, Color couleur){
        
        String s = System.getProperty("user.dir")+"/src/ile/interdite/image/images/icones/";


        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier+" - "+ nomJoueur,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position : ", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(3,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);
        
        panelBouger = new JPanel(new BorderLayout());
        this.btnBouger = new JButton("Bouger") ;
        btnBouger.setContentAreaFilled(false);
        btnBouger.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageAventurier(ActionsType.DEPLACER));
            clearChanged();
            }
        });
        panelBouger.add(btnBouger, BorderLayout.CENTER);
//        ImageContainer im = new ImageContainer(s +"iconMove.png",0,0,200,200);
//        panelBouger.add(im, BorderLayout.EAST);
        
        
        panelAssecher = new JPanel(new BorderLayout());
        this.btnAssecher = new JButton( "Assecher");
        btnAssecher.setContentAreaFilled(false);
        btnAssecher.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageAventurier(ActionsType.ASSECHER));
            clearChanged();
            }
        });
        panelAssecher.add(btnAssecher, BorderLayout.CENTER);
//        ImageContainer im2 = new ImageContainer(s +"iconDry.png",0,0,200,200);
//        panelAssecher.add(im2, BorderLayout.EAST);


        
        panelDonner = new JPanel(new BorderLayout());
        this.btnDonnerCarte = new JButton("Donner une carte");
        btnDonnerCarte.setContentAreaFilled(false);
        btnDonnerCarte.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageAventurier(ActionsType.DONNERCARTE));
            clearChanged();
            }
        });
        panelDonner.add(btnDonnerCarte, BorderLayout.CENTER);
//        ImageContainer im3 = new ImageContainer(s +"iconGive.png",0,0,200,200);
//        panelDonner.add(im3, BorderLayout.EAST);


        
        panelTerminerTour = new JPanel(new BorderLayout());
        this.btnTerminerTour = new JButton("Terminer Tour");
        btnTerminerTour.setContentAreaFilled(false);
        btnTerminerTour.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageAventurier(ActionsType.PASSERTOUR));
            clearChanged();
            }
        });
        
        
        panelTerminerTour.add(btnTerminerTour, BorderLayout.CENTER);
//        ImageContainer im4 = new ImageContainer(s +"iconShift.png",0,0,200,200);
//        panelTerminerTour.add(im4, BorderLayout.EAST);

        panelRecupererTresor = new JPanel(new BorderLayout());
        this.btnRecupTresor = new JButton("Récuperer Tresor");
        btnRecupTresor.setContentAreaFilled(false);
        btnRecupTresor.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageAventurier(ActionsType.GET_TRESOR));
            clearChanged();
            }
        });
        panelRecupererTresor.add(btnRecupTresor, BorderLayout.CENTER);
//        ImageContainer im4 = new ImageContainer(s +"iconShift.png",0,0,200,200);
//        panelTerminerTour.add(im4, BorderLayout.EAST);

        panelAutreAction = new JPanel(new BorderLayout());
        this.btnAutreAction = new JButton("Autre action") ;
        btnAutreAction.setContentAreaFilled(false);
        btnAutreAction.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setChanged();
            notifyObservers(new MessageAventurier(ActionsType.AUTREACTION));
            clearChanged();
            }
        });

        
        this.panelBoutons.add(panelBouger);
        this.panelBoutons.add(panelAssecher);
        this.panelBoutons.add(panelDonner);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(panelRecupererTresor);
        this.panelBoutons.add(panelTerminerTour);
        

//        this.window.setVisible(true);
    } 
    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getBtnAutreAction() {
        return btnDonnerCarte;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
    
    public JPanel getMainPanel(){
        return mainPanel;
    }
//    public void afficher() {
//        this.window.setVisible(true);
//    }
//    public void fermer(){
//        this.window.setVisible(false);
//    }
// 
}

 

