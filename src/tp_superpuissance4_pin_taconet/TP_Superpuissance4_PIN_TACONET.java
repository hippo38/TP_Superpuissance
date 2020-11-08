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
        Jeton jetontest=new Jeton("rouge");
        Joueur joueurtest=new Joueur("BOB");
        System.out.println(jetontest.lireCouleur());
        Grille Celluletest=new Grille();
        Celluletest.afficherGrilleSurConsole();
    }
    
}
