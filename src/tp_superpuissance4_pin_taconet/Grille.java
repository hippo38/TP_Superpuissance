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
public void afficherGrilleSurConsole(){
    System.out.println(Cellules[3][2]);
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
    String couleur=unJoueur.Couleur;
    int cpt=0;
    int a=0;
    int b=0;
    int c=0;
    for(int i=0;i<6;i++){
        cpt=0;
        for(int j=0;j<7;j++){
            if(Cellules[i][j].jetonCourant.Couleur==couleur){
                cpt=cpt+1;
                if(cpt==4){
                    a=1;
                }
                
        }
            else{
                cpt=0;
        }
        }   
    }
    cpt=0;
    for(int j=0;j<7;j++){
        cpt=0;
        for(int i=0;i<6;i++){
            if(Cellules[i][j].jetonCourant.Couleur==couleur){
                cpt=cpt+1;
                if(cpt==4){
                    b=1;
                }
            }
            else{
                cpt=0;
            }
        }
    }
    cpt=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            if(Cellules[i][j].jetonCourant.Couleur==couleur){
                if(Cellules[i+1][j+1].jetonCourant.Couleur==couleur){
                    if(Cellules[i+2][j+2].jetonCourant.Couleur==couleur){
                        if(Cellules[i+3][j+3].jetonCourant.Couleur==couleur){
                            c=1;
                        }
                    }
                }
            }
        }
    }
    for(int i=5;i>2;i--){
        for(int j=0;j<4;j++){
            if(Cellules[i][j].jetonCourant.Couleur==couleur){
                if(Cellules[i-1][j+1].jetonCourant.Couleur==couleur){
                    if(Cellules[i-2][j+2].jetonCourant.Couleur==couleur){
                        if(Cellules[i-3][j+3].jetonCourant.Couleur==couleur){
                            c=1;
                        }
                    }
                }
            }
        }
    }
    if((a==1)||(b==1)||(c==1)){
        return true;
}
    else{
        return false;
    }
}    
public void tasserGrille(int j){
    for(int i=6;i>-1;i--){
        if(Cellules[i][j]==null){
            if(i!=0){
                if(Cellules[i-1][j]!=null){
                    Cellules[i][j]=Cellules[i-1][j];
                }
                }
        }
    }
}
public boolean colonneRemplie(int j){
    if(Cellules[0][j]!=null){
        return true;
    }
    else{
        return false;
    }
}
public boolean placerTrouNoir(int i, int j){
    if(Cellules[i][j]==null){
        Cellules[i][j].placerTrouNoir();
        return true;
    }
    else{
        return false;
    }
}
public boolean placerDesintegrateur(int i, int j){
    if(Cellules[i][j].desintegrateur==false){
        Cellules[i][j].placerDesintegrateur();
        return true;
    }
    else{
        return false;
    }
}
public boolean supprimerJeton(int i,int j){
    if(Cellules[i][j].jetonCourant!=null){
        Cellules[i][j]=null;
        return true;
    }
    else{
        return false;
    }
        
}
public Jeton recupererJeton(int i, int j){
    Jeton a=Cellules[i][j].jetonCourant;
    Cellules[i][j].jetonCourant=null;
    return a;
            }
}
