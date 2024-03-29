package Controleur;
import Vue.*;
import Modele.*;


import java.util.concurrent.TimeUnit;

public class ControleurJeuNim {
    private final Ihm ihm;

    public ControleurJeuNim(Ihm ihm){
        this.ihm=ihm;
    }

    public void jouer(){
        //creation de la partie
        int nbTas=ihm.ihmDemanderNbTas();
        Jeu jeu=new Jeu(nbTas);
        //partie créés

        //creation des joueurs
        ihm.affichage("\nEntrez le nom du "+ihm.toGreen("joueur 1")+":\n");
        String nomJ1=ihm.ihmDemanderNomJoueur();

        ihm.affichage("\nEntrez le nom du "+ihm.toGreen("joueur 2")+":\n");
        String nomJ2=ihm.ihmDemanderNomJoueur();

        if (nomJ1.equals(nomJ2)){
            nomJ1=nomJ1+1;
            nomJ2=nomJ2+2;
        }

        jeu.creerJoueur(nomJ1);
        jeu.creerJoueur(nomJ2);
        //joueurs créés

        //jouer une partie
        jouerPartie(jeu);

        //rejouer tant que l'utilisateur le veut
        while(ihm.ihmRejouer().equals("y")){
            jeu.nouvellePartie(nbTas);
            jouerPartie(jeu);
        }
        //a la fin afficher
        ihm.affichage("\nFin de la Session. \n");
        ihm.affichage("\n"+jeu.vainqueurJeu()+"\n");


    }
    public void jouerPartie(Jeu jeu){
        //tant qu'il n'y a pas de gagnant
            while(!jeu.testerGagnant()){
                //afficher le jeu
                ihm.affichage(jeu.toString());

                //inviter le joueur à jouer
                String joueurCourant=jeu.joueurSuivant();
                String coup = ihm.ihmDemanderCoup(joueurCourant);
                //si le coup est mauvais alors reessayer a l'infini
                while(true){
                    try {
                        String[] coupListe = coup.split(" ");
                        int m = Integer.parseInt(coupListe[0]);
                        int n = Integer.parseInt(coupListe[1]);
                        jeu.jouerCoup(m, n);
                        break;
                    } catch (Exception e1) {
                        ihm.affichage(ihm.toRed(e1.getMessage()));
                        //ici je met une pause de 1 seconde pour que la personne ait le temps de voir l'erreur avant de réafficher le jeu
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (Exception e2) {
                            continue;
                        }
                        coup = ihm.ihmDemanderCoup(joueurCourant);
                    }
                }
            }
            //afficher le gagnant de la partie en cours
            ihm.affichage("\nFélicitations "+jeu.getJoueurCourant()+", vous avez remporté la partie!\n");
            jeu.mettreAJourScore(jeu.getJoueurCourant());
    }
}
