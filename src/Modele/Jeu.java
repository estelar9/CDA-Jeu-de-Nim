package Modele;

import java.util.*;

public class Jeu {
    private Set<Partie> lesParties;
    private Map<Joueur,Integer>lesJoueurs;
    private Joueur joueurCourant=null;

    public Jeu(int nbTas){
        lesParties=new TreeSet<>();
        lesParties.add(creerPartie(nbTas));
        lesJoueurs = new TreeMap<>();

    }
    public Partie creerPartie(int nbTas){
        return new Partie(nbTas);
    }

    public void creerJoueur(String nom){
        Joueur nouveauJoueur = new Joueur(nom);
        lesJoueurs.put(nouveauJoueur,0);
    }

    public String joueurSuivant(){
        if (joueurCourant==null){
            joueurCourant=lesJoueurs.;
        } else {
            if (joueurCourant.getNumJoueur()==Joueur.getDenierJoueur()){
                for (Joueur j : lesJoueurs){
                    if(j.getNumJoueur()==1){
                        joueurCourant=j;
                    }
                }
            };
        }
    };
}
