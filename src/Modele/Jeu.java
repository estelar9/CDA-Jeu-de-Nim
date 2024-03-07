package Modele;

import java.util.Set;
import java.util.TreeSet;

public class Jeu {
    private Set<Partie> lesParties;
    public Jeu(int nbTas){
        lesParties=new TreeSet<>();
        lesParties.add(creerPartie(nbTas));
    }
    public Partie creerPartie(int nbTas){
        return new Partie(nbTas);
    }
}
