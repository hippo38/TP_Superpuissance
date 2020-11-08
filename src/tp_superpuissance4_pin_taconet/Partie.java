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
    for(int k=0;k<5;k++){
        int i=random.nextInt(6);
        int j=random.nextInt(7);
        Cellules.placerTrouNoir(i,j);
        int m=random.nextInt(6);
        int n=random.nextInt(7);
        while(m==i&&n==j){
            m=random.nextInt(6);
            n=random.nextInt(7);  
        }
        if(k<3){
            Cellules.placerDesintegrateur(m, n);
        }
        else{
            Cellules.placerDesintegrateur(i,j);
        
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
        System.out.println("le joueur courant est1 " +JoueurCourant.Nom);
        Scanner sc = new Scanner(System.in);
        initialiserPartie();
        System.out.println("la partie va commencer");
        boolean i = true;
        while (Grillefinal.etreGagnantePourJoueur(ListeJoueurs[0]) == false && Grillefinal.etreGagnantePourJoueur(ListeJoueurs[1]) == false && Grillefinal.etreRemplie() == false) {
            System.out.println("\n");
            
            Grillefinal.afficherGrilleSurConsole();
            while (JoueurCourant.NombreJetonsRestants != 0 && i == true) {
                System.out.println("c'est au tour de : " + JoueurCourant.Nom
                        + "\n"
                        + "Souhaitez vous : "
                        + "\n"
                        + "1) jouer un de vos jetons "
                        + "\n"
                        + "2) recuperer un jeton "
                        + "\n"
                        + "3) desintegrer un jeton"
                        + "\n"
                        + "Saisissez 1, 2, 3 : ");
                int rep = sc.nextInt();
                if (rep == 1) {
                    Grillefinal.afficherGrilleSurConsole();
                    System.out.println("Saisissez la colonne où mettre le jeton (entre 1 et 7) : ");

                    int saisie = sc.nextInt(); // la saisie se fait entre 1 et 7
                    int col = saisie - 1; // pour Java, les numéros de colonne commencent à 0.
                    System.out.println(Grillefinal.colonneRemplie(col));
                    if (col >= 0 && col < 7 && Grillefinal.colonneRemplie(col) == false) { 
                        int li = 5; // l correspond a la ligne 
                        while (Grillefinal.Cellules[li][col].jetonCourant != null && li >= 0) { // permet de sortir de la boucle des qu'on trouve une cellule où le jetonCourant==null
                            li--; // l correspond donc a la ligne où le jeton sera placé 
                        }

                        if (Grillefinal.ajouterJetonDansColonnes(JoueurCourant.ListeJetons[0], col) == true) { // si on ajoute un jeton sur un trou noir, le trou noir disparait et on perd un jeton
                            JoueurCourant.NombreJetonsRestants -= 1;
                        }
                        if (Grillefinal.Cellules[li][col].presencedesintegrateur() == true) {
                            Grillefinal.Cellules[li][col].recupererDesintegrateur();
                            JoueurCourant.NombreDesintegrateurs++;

                        }

                        System.out.println("nombre jetons restants pour " + JoueurCourant.Nom + ": " + JoueurCourant.NombreJetonsRestants);
                    } else if (col < 0 || col > 6) {
                        System.out.println("erreur saisie : au joueur suivant !");
                    } else if (Grillefinal.colonneRemplie(col) == true) {
                        System.out.println("colonne " + (saisie) + " remplie");
                    }

                i = false;
                } else if (rep == 2) {
                    System.out.println("Saisissez la ligne i puis la colonne j du jeton a récupérer "
                            + "\n"
                            + "Rq : en bas à gauche cela correspond à la ligne 6 colonne 1. "
                            + "\n"
                            + "Saisissez votre choix : ");
                    int ligne = sc.nextInt();
                    int li = ligne - 1;
                    int colonne = sc.nextInt();
                    int j = colonne - 1;
                    if (Grillefinal.celluleOccupee(li, j) == false) {
                        System.out.println("Oups, il n'y a pas de jeton dans cette cellule");
                    } else if (Grillefinal.lireCouleurDuJeton(li, j) == JoueurCourant.Couleur) {
                        Grillefinal.recupererJeton(li, j);
                        JoueurCourant.NombreJetonsRestants += 1;
                        Grillefinal.tasserGrille(j); // on tasse la grille apres avoir retiré un jeton de la colonne j.
                    } else {
                        System.out.println("Vous ne pouvez récuperer qu'un de vos jetons!");
                    }
                i = false;

                } else if (rep == 3) {
                    Grillefinal.afficherGrilleSurConsole();
                    System.out.println("Saisissez la ligne i puis la colonne j du jeton que vous souhaitez désintegrer"
                            + "\n"
                            + "n'oubliez pas que en bas à gauche cela correspond à la ligne 6 colonne 1"
                            + "\n"
                            + "Saisissez votre choix : ");

                    int ligne = sc.nextInt();
                    int l = ligne - 1;
                    int colonne = sc.nextInt();
                    int j = colonne - 1;
                    if (JoueurCourant.NombreDesintegrateurs != 0) {
                        if (Grillefinal.celluleOccupee(l, j) == true && Grillefinal.Cellules[l][j].lireCouleurDuJeton() != JoueurCourant.Couleur) {

                            JoueurCourant.utiliserDesintegrateur();
                            Grillefinal.supprimerJeton(l, j);
                            Grillefinal.tasserGrille(j);

                        } else if (Grillefinal.celluleOccupee(l, j) == false) {
                            System.out.println("Il n'y a pas de jetons dans cette cellule");
                        } else if (Grillefinal.Cellules[l][j].lireCouleurDuJeton() == JoueurCourant.Couleur) {
                            System.out.println("Vous ne pouvez pas désintégrer un de vos jetons! ");
                        }

                    } else {
                        System.out.println("Vous n'avez pas de désintégrateurs, gagnez en un sur la Grille de jeu");
                    }
                
                }
                i=false;
                
            }
            if (JoueurCourant == ListeJoueurs[1]) { // a chaque tour de jeu, joueurCourant change et permet de jouer chacun son tour
                
                JoueurCourant = ListeJoueurs[0];
                
            } 
            else {
                JoueurCourant = ListeJoueurs[1];
            }
            i=true;
            

        }
        if (Grillefinal.etreGagnantePourJoueur(ListeJoueurs[0]) == true) {
            Grillefinal.afficherGrilleSurConsole();
            System.out.println("Joueur gagnant :" + ListeJoueurs[0].Nom);
        } else if (Grillefinal.etreGagnantePourJoueur(ListeJoueurs[1]) == true) {
            Grillefinal.afficherGrilleSurConsole();
            System.out.println("Joueur gagnant :" + ListeJoueurs[1].Nom);
        } else {
            System.out.println("error");
        }
    }
}
