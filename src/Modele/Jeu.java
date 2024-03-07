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

    public String joueurSuivant() {
        int suivant=(joueurCourant.getNumJoueur() == Joueur.getDenierJoueur())?joueurCourant.getNumJoueur()+1:1;
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

}
