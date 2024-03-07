package Controleur;
import Vue.*;
import Modele.*;

import javax.naming.ldap.Control;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ControleurJeuNim {
    private Ihm ihm;

    public ControleurJeuNim(Ihm ihm){
        this.ihm=ihm;
    }

    public void jouer(){
        //creation de la partie
        int nbTas=ihm.ihmDemanderNbTas();
        Jeu jeu=new Jeu(nbTas);
        //partie créés

        //creation des joueurs
        ihm.affichage("\nEntrez le nom du joueur 1:\n");
        String nomJ1=ihm.ihmDemanderNomJoueur();

        ihm.affichage("\nEntrez le nom du joueur 2:\n");
        String nomJ2=ihm.ihmDemanderNomJoueur();
        if (nomJ1.equals(nomJ2)){
            nomJ1=nomJ1+1;
            nomJ2=nomJ2+2;
        }
        jeu.creerJoueur(nomJ1);
        jeu.creerJoueur(nomJ2);
        //joueurs créés

        jouerPartie(jeu);

        while(ihm.ihmRejouer().equals("y")){

        }
        //ici tout le déroulement de la partie, a chaque étape de la partie on a un appel a la fonction ihm et un retour de données
    }
    public String jouerPartie(Jeu jeu) throws InterruptedException {
        //tant qu'il n'y a pas de gagnant
            while(!jeu.testerGagnant()){
                //implementer toString()
                //afficher le jeu
                ihm.affichage(jeu.toString());
                //inviter le joueur a joeur
                //trouver le moyen de parcourir les joueurs dans Jeu
                ihm.affichage("\n A "+jeu.joueurSuivant()+" de jouer. Vous pouvez jouer un coup de la forme \"m n\" :\n");

                String coup = ihm.ihmDemanderCoup();
                //traitement du string pour avoir un coup

                try {
                    jeu.jouerCoup(m,n);
                } catch (Exception e) {
                    //ici il faut generer des exceptions selon le coup entré(est ce que le tas existe, est ce qu'il y a assez d'allumettes dans le tas)
                    ihm.affichage(e.getMessage());
                    TimeUnit.SECONDS.sleep(3);
                    return jouerPartie(jeu);
                }
            }

    }

}
