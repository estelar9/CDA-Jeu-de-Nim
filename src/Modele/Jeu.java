package Modele;

import java.util.*;

public class Jeu {
    private Map<Joueur,Integer> lesJoueurs;
    private Joueur joueurCourant;
    private Partie partieEnCours;

    public Jeu(int nbTas){
        partieEnCours=creerPartie(nbTas);
        lesJoueurs = new TreeMap<>();
    }
    public Partie creerPartie(int nbTas){
        return new Partie(nbTas);
    }

    public void creerJoueur(String nom){
        Joueur nouveauJoueur = new Joueur(nom);
        lesJoueurs.put(nouveauJoueur,0);
        joueurCourant=nouveauJoueur;
    }

    public String vainqueurJeu(){
        //retourner un string qui dit qui a le plus gros score, sinon retourner qu'il y a ex aequo
        //appeler cette fonction dans ControlleurJeu.jouer()
    }
    public String joueurSuivant() {
        int suivant=(joueurCourant.getNumJoueur() == (Joueur.getDernierJoueur()-1))?1:joueurCourant.getNumJoueur()+1;
        for (Joueur j : lesJoueurs.keySet()) {
            if (j.getNumJoueur() == suivant) {
                joueurCourant = j;
            }
        }
        return joueurCourant.getNomJoueur();
    }

    public boolean testerGagnant(){
        return partieEnCours.finDePartie();
    }
    public void jouerCoup(int m, int n) throws WrongInputException {
        partieEnCours.enleverAllumettes(m,n);
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public void nouvellePartie(int nbTas){
        partieEnCours=creerPartie(nbTas);
    }
}
