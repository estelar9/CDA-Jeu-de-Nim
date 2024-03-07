package Controleur;
import Vue.*;
import Modele.*;

import javax.naming.ldap.Control;
import java.util.Set;

public class ControleurJeuNim {
    private Ihm ihm;

    public ControleurJeuNim(Ihm ihm){
        this.ihm=ihm;
    }

    public void jouer(){
        //ici tout le déroulement de la partie, a chaque étape de la partie on a un appel a la fonction ihm et un retour de données
    }
    public void demanderNbTas(){
        ihm.affichage("Avec combien de tas souhaitez vous jouer?\n");
    }

}
