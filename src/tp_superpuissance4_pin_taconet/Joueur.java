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
public class Joueur {
    String Nom;
    String Couleur;
    Jeton[] ListeJetons;
    int NombreDesintegrateurs=0;
    int NombreJetonsRestants;
public Joueur(String NomJoueur){
    Nom=NomJoueur;
}
public void affecterCouleur(String uneCouleur){
    Couleur=uneCouleur;
}
public boolean ajouterJeton(Jeton unJeton){
    int i=0;
    while(ListeJetons[i]!=null){
            while(i<20){
                i=i+1;
            }
       }
    if(i!=20){
        ListeJetons[i]=unJeton;
        return true;
    }
    else{
        return false;
    }
    
}
public void obtenirDesintegrateur(){
    NombreDesintegrateurs=NombreDesintegrateurs+1;
}
public boolean utiliserDesintegrateur(){
    if (NombreDesintegrateurs!=0){
        NombreDesintegrateurs=NombreDesintegrateurs-1;
        return true;
    }
    else{
        return false;
    }
}
}
