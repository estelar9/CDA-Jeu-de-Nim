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
            throw new WrongInputException("Oups ! Pas assez d'allumettes dans le tas "+"\u001B[33m"+numTas+"\u001B[0m");
        } else if (nbAllumettes<=0) {
            throw new WrongInputException("Zut ! le nombre d'allumettes doit être supérieur à 0 ");
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

    public int getAllumette() {
        return allumette;
    }
    @Override
    public String toString() {
        return "numTas" + numTas + " -> allumette " + allumette + "\n";
    }
}
