package Modele;
import java.*;

public class Partie {
    private int numPartie;
    private Set<Tas> lesTas;

    public Partie(int nbTas){
        lesTas = new TreeSet<>();
        for(int i=1;i<=nbTas;i++){
            lesTas.add(new Tas(i));
        }
    }
    //changer la valeur de retour dans le diag de classe de conception
    public Tas creerTas(int n){
        return new Tas(n);
    }
    public boolean enleverAllumettes (int num , int nbAllumettes){
        for (lesTas: Tas tas ) {
            if (tas.getNumTas() == num){
                return tas.supprimerAllumettes(nbAllumettes) ;
            }
            return false ;
        }
    }
    public boolean finDePartie(){
        for (lesTas:Tas tas ) {
            if (!tas.estVide()){
                return false ;
            }
            return true ;
        }
    }
}
