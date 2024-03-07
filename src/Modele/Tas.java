package Modele;

public class Tas implements Comparable<Tas> {
    private int numTas;
    private int allumette;

    public Tas(int numTas){
        this.numTas=numTas;
        allumette=numTas*2-1;
    }

    public boolean estVide(){
        return numTas<=0;
    }

    public boolean supprimerAllumettes(int nbAllumette) throws Exception {
        if (nbAllumette>allumette){
            throw new Exception("le nbre d'allumette restante est inferieur au coup demandé");
        } else {
            allumette=allumette-nbAllumette;
            return true;
        }
    }

    public int getNumTas() {
        return numTas;
    }
    public int getAllumette (){
        return allumette ;
    }

    @Override
    public int compareTo(Tas o) {
        return this.numTas-o.getNumTas();
    }
}
