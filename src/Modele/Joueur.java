package Modele;

public class Joueur {
    private static int denierJoueur = 0 ;

    private int numJoueur ;
    private String nomJoueur;

    public Joueur(String nomJouer) {
        this.nomJoueur = nomJoueur;
        this.numJoueur = ++denierJoueur;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }

    public String getNomJouer() {
        return nomJoueur;
    }

    public void setNomJouer(String nomJouer) {
        this.nomJoueur = nomJouer;
    }
}
