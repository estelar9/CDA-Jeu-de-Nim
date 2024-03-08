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
                affichage(toRed("\nErreur de saisie, veuillez entrer un entier supérieur ou égal a 1.\n"));
                return ihmDemanderNbTas();
            } else {
                return nbTas;
            }
        } else {
            affichage(toRed("\nErreur de saisie, veuillez entrer un entier.\n"));
            return ihmDemanderNbTas();
        }
    }
    public String ihmDemanderNomJoueur(){
        Scanner sc =new Scanner(System.in);
        String nomJoueur = sc.nextLine();
        if(nomJoueur.isEmpty()){
            affichage(toRed("\nErreur de saisie, veuillez entrer un nom valide qui n'est pas une chaine vide.\n"));
            return ihmDemanderNomJoueur();
        }
        else{
            return nomJoueur;
        }
    }
    public String ihmDemanderCoup(String nomJoueur){
        Scanner sc=new Scanner(System.in);
        affichage("\n A "+toGreen(nomJoueur)+" de jouer. Vous pouvez jouer un coup de la forme \""+toRed("m n")+"\" :\n");
        return sc.next()+" "+sc.next();
    }
    public String ihmRejouer(){
        affichage("\nVoulez vous rejouer une partie?("+toGreen("y")+"/"+toRed("n")+")\n");
        Scanner sc=new Scanner(System.in);
        String rep = sc.next();
        if (rep.equals("y")||rep.equals("n")){
            return rep;
        } else {
            affichage(toRed("\nErreur de saisie, veuillez réessayer.\n"));
            return ihmRejouer();
        }
    }

    public String toRed(String s){
        return "\u001B[31m"+s+"\u001B[0m";
    }
    public String toGreen(String s){
        return "\u001B[32m"+s+"\u001B[0m";
    }
}
