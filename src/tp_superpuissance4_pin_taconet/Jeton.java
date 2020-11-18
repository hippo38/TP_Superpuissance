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
public class Jeton {
    String Couleur;

public Jeton(String uneCouleur){
    Couleur=uneCouleur;
}
public String lireCouleur(){
    return Couleur;
}
@Override
public String toString(){
    if("Rouge"==Couleur){
        return "\u0018_[31m 0";
    
    }
    else{
        return "\u001B[33m 0";
    }
}
}
