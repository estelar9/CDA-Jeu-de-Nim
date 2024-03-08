package Modele;

import java.util.*;

public class Jeu {
    private final Map<Joueur,Integer> lesJoueurs;
    private final int[] scores = new int[]{0,0};
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
    public void mettreAJourScore(Joueur joueur){
        scores[joueur.getNumJoueur()-1] = ++scores[joueur.getNumJoueur()-1];
    }
    public String vainqueurJeu(){
        //retourner un string qui dit qui a le plus gros score, sinon retourner qu'il y a ex aequo
        //appeler cette fonction dans ControlleurJeu.jouer()
        if (scores[0]==scores[1]){
            return "Félicitations, il y a ex aequo ";
        }


        return joueurCourant.getNomJoueur()+ " gagne avec "+scores[joueurCourant.getNumJoueur()-1]+" victoire(s)";
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

    @Override
    public String toString() {
        return partieEnCours.toString();
    }
}
