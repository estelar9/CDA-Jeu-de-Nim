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

        //ici tout le déroulement de la partie, a chaque étape de la partie on a un appel a la fonction ihm et un retour de données
    }


}
