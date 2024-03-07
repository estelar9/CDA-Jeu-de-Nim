package Modele;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Jeu {
    private Set<Partie> lesParties;
    private Map<Joueur,Integer>lesJoueurs;
    public Jeu(int nbTas){
        lesParties=new TreeSet<>();
        lesParties.add(creerPartie(nbTas));

    }
    public Partie creerPartie(int nbTas){
        return new Partie(nbTas);
    }

    public boolean CreeJoueur(String nom){
        Joueur nouveauJoueur = new Joueur(nom);
        lesJoueurs.put(nouveauJoueur,0);
        return true;
    }
}
