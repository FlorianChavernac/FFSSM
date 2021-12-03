/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class PlongeeTest {

    LocalDate datedeNaissance;
    Plongeur p1;
    LocalDate dateDeNaissance2;
    Moniteur p2;
    Club club;
    LocalDate delivrance;
    Licence licence;
    Plongee plongee;
    Site site;
    Plongee plongee2;
    Plongee plongee3;
    LocalDate delivrance2;

    public PlongeeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        datedeNaissance = LocalDate.of(1990, Month.DECEMBER, 13);
        p1 = new Plongeur("1010", "Durand", "Michel", "2 rue du Vallespir", "0602030405", datedeNaissance);
        dateDeNaissance2 = LocalDate.of(1990, Month.FEBRUARY, 13);
        p2 = new Moniteur("1011", "Lambert", "Jacques", "50 rue de la Cicogne", "0603040506", dateDeNaissance2, 1);
        club = new Club(p2, "Club de Plongee", "0647437547");
        delivrance = LocalDate.of(2021, Month.DECEMBER, 1);
        delivrance2 = LocalDate.of(2021, Month.NOVEMBER, 1);
        p1.ajouterLicence("10", delivrance, club);
        p2.ajouterLicence("11", delivrance2, club);
        site = new Site("Argeles", "Pas de détails");
        plongee = new Plongee(site, p2, delivrance, 30, 2);
        plongee2 = new Plongee(site, p2, LocalDate.of(2022, Month.DECEMBER, 1), 30, 2);
        plongee3 = new Plongee(site, p2, LocalDate.of(2023, Month.MARCH, 1), 30, 2);

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ajouteParticipant method, of class Plongee.
     */
    @Test
    public void testAjouteParticipant() {
        List<Plongeur> lesPlongeurs = new ArrayList<>();
        lesPlongeurs.add(p1);
        plongee.ajouteParticipant(p1);
        assertEquals(plongee.getLesParticipants(), lesPlongeurs, "les participants ne correspondent pas");

    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme() {
        plongee.ajouteParticipant(p1);
        plongee.ajouteParticipant(p2);
        assertTrue(plongee.estConforme(), "La licence des participants sont valide");
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme2() {
        plongee2.ajouteParticipant(p1);
        plongee2.ajouteParticipant(p2);
        assertFalse(plongee2.estConforme(), "La licence d'un plongeur n'est pas valide");
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme3() {
        plongee3.ajouteParticipant(p1);
        plongee3.ajouteParticipant(p2);
        assertFalse(plongee3.estConforme(), "La licence des deux plongeurs nes sont pas valide");
    }

}
