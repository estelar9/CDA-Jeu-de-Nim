package Modele;

import java.util.Set;

public class Jeu {
    private Set<Partie> lesParties;
    public Partie creerPartie(int nbTas){
        return new Partie(nbTas);
    }
}
