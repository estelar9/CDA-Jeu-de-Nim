package Modele;
/*🟡🔴*/

public class Joueur implements Comparable<Joueur>{
    private final int numJoueur ;
    private final String nomJoueur;
    private static int denierJoueur = 1 ;

    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        this.numJoueur = denierJoueur++;
    }

    public static int getDernierJoueur() {
        return denierJoueur;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    @Override
    public int compareTo(Joueur o) {
        return numJoueur-o.getNumJoueur();
    }
}
