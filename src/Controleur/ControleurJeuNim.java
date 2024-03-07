package Controleur;
import Vue.*;
import Modele.*;

public class ControleurJeuNim {
    private Ihm ihm;
    int n ;
    int m;


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


                String coup = demanderCoup();
                String[] coupListe = coup.split(" ");
                m = Integer.parseInt(coupListe[0]);
                n = Integer.parseInt(coupListe[1]);

                //traitement du string pour avoir un coup
                try {
                    jeu.jouerCoup(m,n);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
    }
    private String demanderCoup(){
         return ihm.ihmDemanderCoup();

    }


}
