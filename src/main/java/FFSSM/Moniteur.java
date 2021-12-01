/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> lesEmbauches = new ArrayList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        // TODO: Implémenter cette méthode
        Optional<Club> c = Optional.empty();
        if (lesEmbauches.isEmpty() == false) {
            if (lesEmbauches.get(lesEmbauches.size() - 1).estTerminee() == false) {
                c = Optional.of(lesEmbauches.get(lesEmbauches.size() - 1).getEmployeur());
            }
        }
        return c;
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        // TODO: Implémenter cette méthode
        lesEmbauches.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        // TODO: Implémenter cette méthode
        return lesEmbauches;
    }

}
