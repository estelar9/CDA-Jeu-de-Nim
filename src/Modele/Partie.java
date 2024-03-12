package modele;
import java.util.ArrayList;
import java.util.List;

public class Partie {
    private final List<Tas> lesTas;

    //a l'initialisation la partie cree tout les tas
    public Partie(int nbTas){
        lesTas = new ArrayList<>();
        for(int i=1;i<=nbTas;i++){
            lesTas.add(creerTas(i));
        }
    }

    //crée un seul tas
    public Tas creerTas(int n){
        return new Tas(n);
    }

    //enleve n allumettes au tas m
    public void enleverAllumettes (int numTas , int nbAllumettes) throws WrongInputException {
        try {
            lesTas.get(numTas - 1).supprimerAllumettes(nbAllumettes);
        } catch (Exception e) {
            throw new WrongInputException("Mince ! le tas demandé n'existe pas");
        }

    }
    public boolean finDePartie() {
        for (Tas tas : lesTas) {
            if (!tas.estVide()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String tasString = "\n";
        tasString += "Affichage des tas : \n";
        for (Tas tas : lesTas) {
            int numEspace = lesTas.size() - tas.getNumTas();
            for (int i = 0; i < numEspace; i++) {
                tasString += " ";
            }
            int numAllumettes = tas.getAllumette();
            for (int i = 0; i < numAllumettes; i++) {
                tasString += "|";
            }
            tasString += "\n";
        }
        return tasString;
    }

}
