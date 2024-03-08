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
        //partie crée

        //creation des joueurs
        //récuperation du nom du j1
        ihm.affichage("\nEntrez le nom du joueur 1:\n");
        String nomJ1=ihm.ihmDemanderNomJoueur();

        //récuperation du nom du j2
        ihm.affichage("\nEntrez le nom du joueur 2:\n");
        String nomJ2=ihm.ihmDemanderNomJoueur();

        //Si les noms sont les memes, on ajoute 1 et 2 a la fin
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
        //à la fin lorsque l'utilisateur ne veut plus jouer, afficher la fin du jeu
        ihm.affichage("\nFin de la Session, voici le tableau des scores : \n");
        ihm.affichage("\n"+jeu.vainqueurJeu()+"\n");


    }
    public void jouerPartie(Jeu jeu){

        //tant qu'il n'y a pas de gagnant
            while(!jeu.testerGagnant()){
                //afficher le jeu
                ihm.affichage(jeu.toString());

                //inviter le joueur suivant à jouer
                String joueurCourant=jeu.joueurSuivant();
                String coup = ihm.ihmDemanderCoup(joueurCourant);
                //si le coup est mauvais alors reessayer à l'infini
                while(true){
                    //le try catch récupère l'erreur dans le coup qui est joué
                    try {
                        String[] coupListe = coup.split(" ");
                        int m = Integer.parseInt(coupListe[0]);
                        int n = Integer.parseInt(coupListe[1]);
                        jeu.jouerCoup(m, n);
                        break;
                    } catch (Exception e1) {
                        //afficher l'erreur concernant le coup joué
                        ihm.affichage(e1.getMessage());
                        //ce try catch est la pour l'objet TimeUnit
                        try {
                            //pause d'une seconde pour voir l'erreur
                            TimeUnit.SECONDS.sleep(1);
                        } catch (Exception e2) {
                            continue;
                        }
                        //redemander un coup
                        coup = ihm.ihmDemanderCoup(joueurCourant);
                    }
                }
            }
            //afficher le gagnant de la partie en cours
        ihm.affichage("\nFélicitations "+jeu.getJoueurCourant().getNomJoueur()+", vous avez remporté la partie!\n");
    }
}
