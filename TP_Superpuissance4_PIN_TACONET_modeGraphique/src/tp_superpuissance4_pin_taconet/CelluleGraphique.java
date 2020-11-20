/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_superpuissance4_pin_taconet;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Donatien
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleGraphique (Cellule uneCellule){
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir()==true){
            setIcon(img_trouNoir);
        }
        else if (celluleAssociee.presencedesintegrateur()==true){
            setIcon(img_desint);
        }
        else{
            String couleur_jeton=celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton){
                case "vide":
                    setIcon(img_vide); 
                    break;
                case "R":
                    setIcon(img_jetonRouge);
                    break;
                case "J":
                    setIcon(img_jetonJaune);
                    break;
            }
        }
         
    }
}
