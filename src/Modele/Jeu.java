package Modele;

import java.util.*;

public class Jeu {
    private final Map<Joueur,Integer> lesJoueurs;
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
    public void mettreAJourScore(String joueur){
        for(Joueur j : lesJoueurs.keySet()){
            if(j.getNomJoueur().equals(joueur)){
                lesJoueurs.replace(j,lesJoueurs.get(j)+1);
            }
        }
    }
    public String vainqueurJeu(){

        String j1=joueurCourant.getNomJoueur();
        int resJ1=lesJoueurs.get(joueurCourant);

        joueurSuivant();

        String j2=joueurCourant.getNomJoueur();
        int resJ2=lesJoueurs.get(joueurCourant);

        if (resJ1==resJ2){
            return "Félicitations, il y a ex aequo ";
        } else if (resJ1>resJ2){
            return "Félicitations "+"\u001B[32m"+j1+"\u001B[0m"+"! Vous gagnez avec "+"\u001B[33m"+resJ1+"\u001B[0m"+" victoire(s).";
        } else {
            return "Félicitations "+"\u001B[32m"+j2+"\u001B[0m"+"! Vous gagnez avec "+"\u001B[33m"+resJ2+"\u001B[0m"+" victoire(s).";
        }
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

    public String getJoueurCourant() {
        return joueurCourant.getNomJoueur();
    }

    public void nouvellePartie(int nbTas){
        partieEnCours=creerPartie(nbTas);
    }

    @Override
    public String toString() {
        return partieEnCours.toString();
    }
}
