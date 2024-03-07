package Modele;
import java.util.Set;
import java.util.TreeSet;

public class Partie {
    //suggestion d'amelioration : faire une liste de tas plutot qu'un set, pour y acceder plus simplement avec lesTas[numTas]
    private Set<Tas> lesTas;

    //a l'initialisation la partie cree tout les tas
    public Partie(int nbTas){
        lesTas = new TreeSet<>();
        for(int i=1;i<=nbTas;i++){
            lesTas.add(creerTas(i));
        }
    }

    //crée un seul tas
    public Tas creerTas(int n){
        return new Tas(n);
    }

    //enleve n allumettes au tas m
    public boolean enleverAllumettes (int numTas , int nbAllumettes) throws WrongInputException {
            for (Tas tas: lesTas) {
                if (tas.getNumTas() == numTas) {
                    tas.supprimerAllumettes(nbAllumettes);
                    return true;
                }
            }
            throw new WrongInputException("Le tas demandé n'existe pas");

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
