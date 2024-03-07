package Modele;

public class Joueur {
    private int numJoueur ;
    private String nomJoueur;
    private static int denierJoueur = 0 ;

    public static int getDenierJoueur() {
        return denierJoueur;
    }

    public Joueur(String nomJouer) {
        this.nomJoueur = nomJoueur;
        this.numJoueur = ++denierJoueur;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }
}
