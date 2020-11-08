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
    if(trouNoir==false){
        trouNoir=true;
        return true;
    }
    else{
        return false;
    }
}
public boolean placerDesintegrateur(){
    if(desintegrateur==false){
        desintegrateur=true;
        return true;
    }
    else{
        return false;
    }
}
public boolean presenceTrouNoir(){
    if(trouNoir==true){
        return true;
    }
    else{
        return false;
    }
}
public boolean presencedesintegrateur(){
    if(desintegrateur==true){
        return true;
    }
    else{
        return false;
    }
}
public String lireCouleurDuJeton(){
    return jetonCourant.lireCouleur();
}
public boolean recupererDesintegrateur(){
    if(desintegrateur==true){
        desintegrateur=false;
        return true;
    }
    else{
        return false;
    }
}
public boolean activerTrouNoir(){
    if(trouNoir==true){
        jetonCourant=null;
        trouNoir=false;
        return true;
    }
    else{
        return false;
    }
}
}
