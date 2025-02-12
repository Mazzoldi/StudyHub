package com.example;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGruppoStudio {
    
    @Test
    public void testVerificaIscrizione() {
        GruppoStudio gruppoStudio = new GruppoStudio("Gruppo di Studio", "admin", "password", "Italiano", 2, 5);
        Studente studente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        assertTrue(gruppoStudio.aggiungiStudente(studente));
        assertTrue(gruppoStudio.verificaIscrizione(studente));
        assertEquals(1, gruppoStudio.getNumeroStudenti());
    }

    @Test
    public void testPasswordCorretta() {
        GruppoStudio gruppoStudio = new GruppoStudio("Gruppo di Studio", "admin", "password", "Italiano", 2, 5);
        assertTrue(gruppoStudio.passwordCorretta("password"));
    }

    @Test
    public void testAggiungiStudente() {
        GruppoStudio gruppoStudio = new GruppoStudio("Gruppo di Studio", "admin", "password", "Italiano", 2, 5);
        Studente studente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        assertTrue(gruppoStudio.aggiungiStudente(studente));
        assertEquals(1, gruppoStudio.getNumeroStudenti());
        assertTrue(gruppoStudio.verificaIscrizione(studente));
    }

    @Test
    public void testRimuoviStudente() {
        GruppoStudio gruppoStudio = new GruppoStudio("Gruppo di Studio", "admin", "password", "Italiano", 2, 5);
        Studente studente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        assertTrue(gruppoStudio.aggiungiStudente(studente));
        assertTrue(gruppoStudio.verificaIscrizione(studente));
        assertEquals(1, gruppoStudio.getNumeroStudenti());
        assertFalse(gruppoStudio.rimuoviStudente(studente));
        assertFalse(gruppoStudio.verificaIscrizione(studente));
        assertEquals(0, gruppoStudio.getNumeroStudenti());
    }
}
