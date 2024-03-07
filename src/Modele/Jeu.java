package Modele;

import java.util.Set;
import java.util.TreeSet;
import java.util.Map ;

public class Jeu {
    private Partie partiesEnCours ;
    private Map<Joueur,Integer> lesJoueurs ;
    public Jeu(int nbTas){
        partiesEnCours = new Partie(nbTas);
    }
    public Partie creerPartie(int nbTas){
        return new Partie(nbTas);
    }
    public boolean jouerCoup (int m , int n ){
        return partiesEnCours.enleverAllumettes(m,n);
    }
    public boolean testerGagnant(){
       return partiesEnCours.finDePartie() ;
    }
}
