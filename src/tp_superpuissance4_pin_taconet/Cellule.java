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
public class Cellule {
    Jeton jetonCourant;
    Boolean trouNoir;
    Boolean desintegrateur;
public Cellule(){
    jetonCourant=null;
    trouNoir=false;
    desintegrateur=false;
}
public boolean affecterJeton(Jeton unJeton){
    if(jetonCourant==null){
        jetonCourant=unJeton;
        return true;
        
    }
    else{
        return false;
    }
}
public Jeton recupererJeton(){
    Jeton unjeton=jetonCourant;
    jetonCourant=null;
    return jetonCourant;
}
public boolean supprimerJeton(){
    if(jetonCourant!=null){
        jetonCourant=null;
        return true;
    }
    else{
        return false;
    }
}
public boolean placerTrouNoir(){
    if(trouNoir==true){
        return false;
    }
    else{
        trouNoir=true;
        return true;
    }
}
public boolean placerDesintegrateur(){
    if(desintegrateur==true){
        return false;
    }
    else{
        desintegrateur=true;
        return true;
    }
}
public boolean presenceTrouNoir(){
   return trouNoir;
   
}
public boolean presencedesintegrateur(){
    return desintegrateur;
}

public String lireCouleurDuJeton(){
    return jetonCourant.lireCouleur();
}
public boolean recupererDesintegrateur(){
    if(presencedesintegrateur()==true){
        desintegrateur=false;
        return true;
    }
    else{
        return false;
    }
}
public boolean activerTrouNoir(){
    if(trouNoir){
        jetonCourant=null;
        trouNoir=false;
        return true;
    }
    else{
        return false;
    }
}
}
