package Modele;

public class Tas {
    private int numTas;
    private int allumette;

    public Tas(int numTas){
        this.numTas=numTas;
        allumette=numTas*2-1;
    }

    public boolean estVide(){
        return numTas<=0;
    }

    public boolean supprimerAllumettes(int nbAllumette){
        if (nbAllumette>allumette){
            return false;
        } else {
            allumette=allumette-nbAllumette;
            return true;
        }
    }

}
