package Modele;
import java.util.Set;
import java.util.TreeSet;

public class Partie {
    //suggestion d'amelioration : faire une liste de tas plutot qu'un set, pour y acceder plus simplement avec lesTas[numTas]

    //peut etre optionnel, reverifier a la fin
    private int numPartie;
    private Set<Tas> lesTas;

    //a l'initialisation la partie cree tout les tas
    public Partie(int nbTas){
        lesTas = new TreeSet<>();
        for(int i=1;i<=nbTas;i++){
            lesTas.add(new Tas(i));
        }
    }

    //crée un seul tas
    public Tas creerTas(int n){
        return new Tas(n);
    }

    //enleve n allumettes au tas m
    public boolean enleverAllumettes (int num , int nbAllumettes){
        try {
            for (Tas tas: lesTas) {
                if (tas.getNumTas() == num) {
                    return tas.supprimerAllumettes(nbAllumettes);
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        return false ;
    }
    public boolean finDePartie() {
        for (Tas tas : lesTas) {
            if (!tas.estVide()) {
                return false;
            }
        }
        return true;
    }
}
