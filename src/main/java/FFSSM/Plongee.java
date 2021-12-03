/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public LocalDate date;

    public int profondeur;

    public int duree;

    public List<Plongeur> lesParticipants = new ArrayList<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        // TODO: Implémenter cette méthode
        lesParticipants.add(participant);
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        // TODO: Implémenter cette méthode
        boolean res = true;
        for (Plongeur p : lesParticipants) {
            if (p.derniereLicence().estValide(date) == false) {
                res = false;
            }
        }
        if (chefDePalanquee.derniereLicence().estValide(date) == false) {
            res = false;
        }
        return res;
    }

    public List<Plongeur> getLesParticipants() {
        return lesParticipants;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.lieu);
        hash = 37 * hash + Objects.hashCode(this.chefDePalanquee);
        hash = 37 * hash + Objects.hashCode(this.date);
        hash = 37 * hash + this.profondeur;
        hash = 37 * hash + this.duree;
        hash = 37 * hash + Objects.hashCode(this.lesParticipants);
        return hash;
    }
}
