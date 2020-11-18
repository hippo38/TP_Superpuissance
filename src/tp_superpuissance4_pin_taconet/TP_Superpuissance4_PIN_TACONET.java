/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_superpuissance4_pin_taconet;

/**
 *
 * @author hpin
 */
public class TP_Superpuissance4_PIN_TACONET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur joueur1=new Joueur("BOB");
        Joueur joueur2=new Joueur("JEAN");
        Joueur ListeJoueurs[]=new Joueur[2];
        Grille Celluletest=new Grille();
        Partie Partie1=new Partie(joueur1,joueur2);
        Partie1.debuterPartie();
    }
    
}
