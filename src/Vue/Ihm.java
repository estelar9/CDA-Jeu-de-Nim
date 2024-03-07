package Vue;

public class Ihm {
    public void affichage(String texte){
        System.out.println(texte);
    }
    public int ihmDemanderNbTas(){}
    public String ihmDemanderNomJoueur(){}
    public String ihmDemanderCoup(){
        //retourne le string d'un coup de forme "m n" on recuperera dans le controleur les int
    }
    public String ihmRejouer(){
        // retourne un string genre "y" "o" "yes" "oui" ou "n" "no" etc on traitera le resultat dans le controleur
    }
}
