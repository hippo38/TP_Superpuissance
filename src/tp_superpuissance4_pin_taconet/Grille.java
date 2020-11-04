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
public class Grille {
     Cellule Cellules[][]=new Cellule[6][7];
     
     Grille(){
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                Cellules[i][j]=new Cellule();
            }
            
        }
     }
public boolean ajouterJetonDansColonnes(Jeton unJeton, int Colonne){
    int i=5;
    while(Cellules[i][Colonne]!=null){
        while(i>-1){
            i=i-1;
        }
    }
    if(i!=-1){
        Cellules[i][Colonne].affecterJeton(unJeton);
        return true;
    }
    else{
        return false;
    }
    
}
public boolean etreRemplie(){
    int a=0;
    for(int i=0;i<6;i++){
        for(int j=0;j<7;j++){
            if(Cellules[i][j]!=null){
                a=a+1;
        }
        }
    }
    if(a==42){
        return true;
       
    } 
    else{
        return false;
    }
        
    

}
public void viderGrille(){
    for(int i=0;i<6;i++){
        for(int j=0;j<6;j++){
           Cellules[i][j]=null; 
        }
}
}
public boolean celluleOccupee(int i, int j){
    if(Cellules[i][j]!=null){
        return true;
        }
    else{
        return false;
    }
}
public String lireCouleurDuJeton(int i, int j){
    Jeton a;
    a=Cellules[i][j].recupererJeton();
    return a.lireCouleur();
}
public boolean etreGagnantePourJoueur(Joueur unJoueur){
   return true;
}    
public void tasserGrille(int j){
    for(int i=0;i<6;i++){
        if(Cellules[i][j]==null){
            if(i!=0){
                if(Cellules[i-1][j]!=null){
                    
                }
                }
        }
    }
}
}
