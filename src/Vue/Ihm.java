package Vue;

import java.util.Scanner;

public class Ihm {
    public void affichage(String texte){
        System.out.println(texte);
    }
    public int ihmDemanderNbTas(){
        Scanner sc=new Scanner(System.in);
        affichage("\nAvec combien de tas souhaitez vous jouer?\n");
        if(sc.hasNextInt()){
            int nbTas=sc.nextInt();
            if (nbTas<1){
                affichage("\nErreur de saisie, veuillez entrer un entier supérieur ou égal a 1.\n");
                return ihmDemanderNbTas();
            } else {
                return nbTas;
            }
        } else {
            affichage("\nErreur de saisie, veuillez entrer un entier\n");
            return ihmDemanderNbTas();
        }
    }
    public String ihmDemanderNomJoueur(){
    }
    public String ihmDemanderCoup(){
        //retourne le string d'un coup de forme "m n" on recuperera dans le controleur les int
    }
    public String ihmRejouer(){
        // retourne un string genre "y" "o" "yes" "oui" ou "n" "no" etc on traitera le resultat dans le controleur
    }
}
