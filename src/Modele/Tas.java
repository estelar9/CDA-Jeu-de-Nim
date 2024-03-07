package Modele;

public class Tas implements Comparable<Tas> {
    private final int numTas;
    private int allumette;

    public Tas(int numTas){
        this.numTas=numTas;
        allumette=numTas*2-1;
    }

    public boolean estVide(){
        return allumette<=0;
    }

    public void supprimerAllumettes(int nbAllumettes) throws WrongInputException {
        if (nbAllumettes>allumette){
            throw new WrongInputException("le nombre d'allumettes restante est inferieur au coup demandé");
        } else {
            allumette=allumette-nbAllumettes;
        }
    }

    public int getNumTas() {
        return numTas;
    }


    @Override
    public int compareTo(Tas o) {
        return this.numTas-o.getNumTas();
    }
}
