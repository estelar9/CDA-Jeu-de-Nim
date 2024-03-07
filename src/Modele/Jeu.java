package Modele;

import java.util.Set;
import java.util.TreeSet;
import java.util.Map ;

public class Jeu {
    private Partie partieEnCours;
    private Partie partiesEnCours ;
    private Map<Joueur,Integer> lesJoueurs ;
    public Jeu(int nbTas){
        partieEnCours=new Partie(nbTas);
    }
    public void nouvellePartie(int nbTas){
        partieEnCours=new Partie(nbTas);
    }

    public boolean joueurSuivant(){

    }
    public boolean jouerCoup (int m , int n ){
        return partiesEnCours.enleverAllumettes(m,n);
    }
    public boolean testerGagnant(){
       return partiesEnCours.finDePartie() ;
    }
}
