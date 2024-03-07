package Controleur;
import Vue.*;
import Modele.*;

import javax.naming.ldap.Control;
import java.util.Set;

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

        jeu.creerJoueur(nomJ1);
        jeu.creerJoueur(nomJ2);

        //joueurs créés
        //code

        while(ihm.ihmRejouer().equals("y")){

        }
        //ici tout le déroulement de la partie, a chaque étape de la partie on a un appel a la fonction ihm et un retour de données
    }
    public void jouerPartie(Jeu jeu){
            while(!jeu.testerGagnant()){
                //implementer toString()
                ihm.affichage(jeu.toString());
                //trouver le moyen de parcourir les joueurs dans Jeu
                ihm.affichage("\n A "+jeu.joueurSuivant()+" de jouer. Vous pouvez jouer un coup de la forme \"m n\" :\n");
                String coup = ihm.ihmDemanderCoup();
                //traitement du string pour avoir un coup
                try {
                    jeu.jouerCoup(m,n);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
    }

}
