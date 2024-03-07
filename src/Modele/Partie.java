package Modele;
import java.util.Set;
import java.util.TreeSet;

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
    // fonction qui teste si tous les tas passés en paramètre sont vides
    private boolean sontVidesTas(Set<Tas> lesTas){
        for (Tas tas : lesTas) {
            if (!tas.estVide()){
                return false ;
            }
        }
        return true ;
    }
    // J'utilise la fonction sontVidesTas dans finDePartie
    //algo :je clone l'ensemble lesTas définit en haut dans un ensemble tasPourLeTest
    // ensuite je prend un tas de l'ensemble et je teste si le nbre d'allumettes dans ce tas = 1
    // Si c'est le cas; je l'enlève de l'ensemble et je teste si les autres tas restantes de l'ensembles sont vides
    // Si c'est vrai je retourne vrai sinon je remet le tas que j'ai enlevé dans l'ensemble et je continue la boucle
    public boolean finDePartie(){
        Set<Tas> tasPourLeTest = new TreeSet<>();
        for (Tas tas : lesTas){
            tasPourLeTest.add(tas);
            }
        for (Tas tas : tasPourLeTest){
            tasPourLeTest.remove(tas);
            if(tas.getAllumette() == 1 && sontVidesTas(tasPourLeTest) ) {
                return true ;
            }
            tasPourLeTest.add(tas);
        }
        return false ;
    }
}
