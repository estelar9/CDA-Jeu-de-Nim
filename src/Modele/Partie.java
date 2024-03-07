package Modele;
import java.util.TreeMap;

public class Partie {
    private int numPartie;
    private TreeMap lesTas = new TreeMap<>;

    public Partie(int nbTas){
        for(int i=1;i<=nbTas;i++){
            lesTas.put(i,creerTas(i));
        }
    }
    //changer la valeur de retour dans le diag de classe de conception
    public Tas creerTas(int n){
        return new Tas(n);
    }
}
