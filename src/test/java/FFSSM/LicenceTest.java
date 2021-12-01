/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
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
public class LicenceTest {

    LocalDate datedeNaissance;
    Plongeur p1;
    LocalDate dateDeNaissance2;
    Moniteur p2;
    Club club;
    LocalDate delivrance;
    Licence licence;

    public LicenceTest() {
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
        licence = new Licence(p1, "1", delivrance, club);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of estValide method, of class Licence.
     */
    @Test
    public void testEstValide() {
        assertFalse(licence.estValide(LocalDate.of(2021, Month.MARCH, 13)));

    }

    /**
     * Test of estValide method, of class Licence.
     */
    @Test
    public void testEstValide2() {
        assertTrue(licence.estValide(LocalDate.of(2022, Month.JANUARY, 13)));

    }

    /**
     * Test of estValide method, of class Licence.
     */
    @Test
    public void testEstValide3() {
        assertFalse(licence.estValide(LocalDate.of(2023, Month.MARCH, 13)));

    }
}
