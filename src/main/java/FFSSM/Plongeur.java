package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {

    public int niveau;
    public List<Licence> lesLicences = new ArrayList<>();
    public GroupeSanguin groupeSanguin;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
    }

    public void ajouterLicence(String numero, LocalDate delivrance, Club club) {
        Licence licence = new Licence(this, numero, delivrance, club);
        lesLicences.add(licence);

    }

    public Licence derniereLicence() {
        return lesLicences.get(lesLicences.size() - 1);
    }

}
