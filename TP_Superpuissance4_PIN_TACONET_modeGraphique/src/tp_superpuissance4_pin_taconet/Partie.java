/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_superpuissance4_pin_taconet;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hpin
 */
public class Partie {
    
    Random random=new Random();
    Joueur ListeJoueurs[]=new Joueur[2];
    Joueur JoueurCourant;
    Grille Grillefinal=new Grille();
public Partie(Joueur Joueur1,Joueur Joueur2){
    ListeJoueurs[0]=Joueur1;
    ListeJoueurs[1]=Joueur2;
}
public void attribuerCouleursAuxJoueurs(){
    int CouleurJoueur=random.nextInt((1)+1)+1;
    switch(CouleurJoueur){
        case 1:
            ListeJoueurs[0].Couleur="J";
            ListeJoueurs[0].affecterCouleur("J");
            break;
        case 2:
            ListeJoueurs[0].Couleur="R";
            ListeJoueurs[0].affecterCouleur("R");
            break;
       
    }
    if(ListeJoueurs[0].Couleur=="R"){
        ListeJoueurs[1].Couleur="J";
        ListeJoueurs[1].affecterCouleur("J");
        
    }
    else{
        ListeJoueurs[1].Couleur="R";
        ListeJoueurs[1].affecterCouleur("R");
    }
    
    System.out.println(ListeJoueurs[0].Nom+" joue avec la couleur "+ListeJoueurs[0].Couleur+ " et "+ListeJoueurs[1].Nom+" joue avec la couleur "+ListeJoueurs[1].Couleur);
}
public void initialiserPartie(){
    Grille Cellules=new Grille();
    if(Cellules.etreRemplie()==true){
        Cellules.viderGrille(); 
    }
    Scanner sc=new Scanner(System.in);
    System.out.println("Pseudo joueur 1");
    Joueur Joueur1=new Joueur(sc.nextLine());
    System.out.println("Pseudo joueur2");
    Joueur Joueur2=new Joueur(sc.nextLine());
    ListeJoueurs[0] = Joueur1;
    ListeJoueurs[1] = Joueur2;
    
    for(int k=0;k<5;k++){
        int i=random.nextInt(6);
        int j=random.nextInt(7);
        Grillefinal.placerTrouNoir(i,j);
        
        int m=random.nextInt(6);
        int n=random.nextInt(7);
        while(m==i&&n==j){
            m=random.nextInt(6);
            n=random.nextInt(7);  
        }
        if(k<3){
            Grillefinal.placerDesintegrateur(m, n);
        }
        else{
            Grillefinal.placerDesintegrateur(i,j);
        
        }
    }
    for(int i=0;i<21;i++){
        ListeJoueurs[0].ListeJetons[i]=new Jeton(ListeJoueurs[0].Couleur);
        ListeJoueurs[1].ListeJetons[i]=new Jeton(ListeJoueurs[1].Couleur);
    }
    ListeJoueurs[0].NombreJetonsRestants=21;
    ListeJoueurs[1].NombreJetonsRestants=21;
}
public void debuterPartie() {

        
        attribuerCouleursAuxJoueurs();
        int aléatoire = random.nextInt(1);//la variable aléatoire prend soit la valeur 0 soit la valeure 1
        System.out.println("aléatoire");
        if (aléatoire == 0) {
            System.out.println("Couleur tirée : R "); // la couleure rouge commence 
        } else {
            System.out.println("Couleur tirée : J ");//la couleur jaune commence

        }
        switch (aléatoire) { // tirage au sort du joueur débutant la partie 
            case 0:// couleur tirée est rouge
                if (ListeJoueurs[0].Couleur == "J") {
                    JoueurCourant = ListeJoueurs[1];//le joueur qui a la couleur rouge commence
                } else {
                    JoueurCourant = ListeJoueurs[0];//sinon l'autre joueur commence
                }
                break;
            case 1://couleur tirée est jaune
                if (ListeJoueurs[0].Couleur == "R") {
                    JoueurCourant = ListeJoueurs[1];//le joueur qui a la couleur jaune commence

                } else {
                    JoueurCourant = ListeJoueurs[0];//sinon l'autre joueur commence

                }
                break;
        }
        Scanner sc = new Scanner(System.in);
        initialiserPartie();
        System.out.println("Début de la partie");
        int i = 0;
        while (Grillefinal.etreGagnantePourJoueur(ListeJoueurs[0]) == false && Grillefinal.etreGagnantePourJoueur(ListeJoueurs[1]) == false && Grillefinal.etreRemplie() == false) {
            System.out.println("\n");
            while (JoueurCourant.NombreJetonsRestants != 0 && i == 0) {
                Grillefinal.afficherGrilleSurConsole();
                System.out.println("C'est au tour de "+JoueurCourant.Nom+" de jouer ("+JoueurCourant.Couleur+")");
                System.out.println("Vous avez "+JoueurCourant.NombreJetonsRestants +" jetons "+"\n"+"Vous avez "+JoueurCourant.NombreDesintegrateurs+" désintégrateurs");
                System.out.println("Choisissez une action:\n 1) Jouer un jeton\n 2) Récupérer un jeton\n 3) Désintégrer un jeton\n");
                int choix = sc.nextInt();
                if (choix == 1) {
                    Grillefinal.afficherGrilleSurConsole();
                    System.out.println("Saisissez une colonne ou placer le jeton");
                    int colonne = sc.nextInt()-1; //choix de colonne
                    if (Grillefinal.colonneRemplie(colonne) == false && colonne >= 0 && colonne < 7 ) { 
                        int li = 5;//numéro de la ligne si il n'y a pas de jeton sur la première ligne de la colonne
                        while (Grillefinal.Cellules[li][colonne].jetonCourant != null && li >= 0) { //permet d'aller a la première cellule vide de la colonne
                            li=li-1; 
                        }
                        
                        if (Grillefinal.Cellules[li][colonne].presencedesintegrateur() == true) {//s'il y a un désintégrateur
                            Grillefinal.Cellules[li][colonne].recupererDesintegrateur();//le joueur le récupère
                            JoueurCourant.NombreDesintegrateurs=JoueurCourant.NombreDesintegrateurs+1;
                        }
                        if (Grillefinal.ajouterJetonDansColonnes(JoueurCourant.ListeJetons[0], colonne) == true) { //Si la colonne n'est pas pleine
                            JoueurCourant.NombreJetonsRestants = JoueurCourant.NombreJetonsRestants-1;//le joueur place son jeton, il en a donc 1 en oins en réserve
                        }
                        
                        System.out.println(JoueurCourant.Nom + " a " + JoueurCourant.NombreJetonsRestants+" jetons restants");
                    
                    }
                    
                    else if (Grillefinal.colonneRemplie(colonne) == true) {
                        System.out.println("la colonne " + colonne+1 + " remplie");
                    }
                    
                    else{
                        System.out.println("erreur de saisie");//si le joueur effectue une mauvaise saisie, il perd son tour
                    }

                i = 1; //on change de joueur
                } else if (choix == 2) {
                    System.out.println("Saisissez la ligne i du jeton a récupérer (la ligne du bas est la ligne 6)");
                 
                    int ligne = sc.nextInt()-1;
                    System.out.println("Saisisser la colone du jeton à récuperer (la 1ère colonne de gauche est la colonne 1)");
                    int colonne = sc.nextInt()-1;
                    if (Grillefinal.celluleOccupee(ligne,colonne) == false) {
                        System.out.println("Cette cellule est vide");
                    } 
                    else if (Grillefinal.lireCouleurDuJeton(ligne,colonne) == JoueurCourant.Couleur) {
                        Grillefinal.recupererJeton(ligne,colonne);//on récupère le jeton
                        
                        JoueurCourant.NombreJetonsRestants = JoueurCourant.NombreJetonsRestants +1;//le joueur récupère un jeton
                        
                        Grillefinal.tasserGrille(); // on tasse la grille
                    } 
                    
                    
                    else {
                        System.out.println("erreur");//le joueur perd son tour
                    }
                i = 1;//on change de joueur

                } 
                else if (choix == 3) {
                    Grillefinal.afficherGrilleSurConsole();
                    
                    System.out.println("Saisissez la ligne du jeton que vous sohaitez désintégrer");
                    int ligne = sc.nextInt()-1;
                    while(ligne>5||ligne<0){
                        System.out.println("Veuillez saisir une ligne valide");
                        ligne=sc.nextInt()-1;
                    }
                    System.out.println("Saisissez la colonne du jeton");
                    int colonne = sc.nextInt()-1;
                    while(colonne>6||colonne<0){
                        System.out.println("Veuillez saisir une colonne valide");
                        colonne=sc.nextInt()-1;
                    }
                    if (JoueurCourant.NombreDesintegrateurs != 0) {// si le joueur a des désintégrateur
                        if (Grillefinal.Cellules[ligne][colonne].jetonCourant!= null && Grillefinal.Cellules[ligne][colonne].lireCouleurDuJeton() != JoueurCourant.Couleur) {//si la cellule est occupé par un jeton adverses
                            Grillefinal.supprimerJeton(ligne,colonne);
                            Grillefinal.tasserGrille();//on supprime le jeton et on tasse la grille
                            JoueurCourant.utiliserDesintegrateur();//le joueur perd un désintégrateur

                        } 
                        else if (Grillefinal.celluleOccupee(ligne,colonne) == false) {
                            System.out.println("Il n'y a pas de jetons dans cette cellule");
                        } 
                        else if (Grillefinal.Cellules[ligne][colonne].lireCouleurDuJeton() == JoueurCourant.Couleur) {
                            System.out.println("erreur, c'est votre jeton ");
                        }

                    } 
                    else {
                        System.out.println("erreur, vous n'avez pas de désintégrateur");
                    }
                
                }
                i=1;//changement de joueurs
                
            }
            if (JoueurCourant == ListeJoueurs[1]) { // a chaque tour de jeu, joueurCourant change et permet de jouer chacun son tour
                
                JoueurCourant = ListeJoueurs[0];
                
            } 
            else {
                JoueurCourant = ListeJoueurs[1];
            }
            i=0;
            

        }
        if(Grillefinal.etreRemplie() == true){
            System.out.println("Egalité");
        }
        
        else if (Grillefinal.etreGagnantePourJoueur(ListeJoueurs[0]) == true) {
            Grillefinal.afficherGrilleSurConsole();
            System.out.println("le joueur " + ListeJoueurs[0].Nom+" a gagné");
        }  
        else{
            Grillefinal.afficherGrilleSurConsole();
            System.out.println("le joueur " + ListeJoueurs[1].Nom+ " a gagné");
        } 
        
    }
}
