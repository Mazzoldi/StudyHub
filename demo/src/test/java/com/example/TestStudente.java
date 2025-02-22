package com.example;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

public class TestStudente {

    @Test
    public void testCreaDatiPagamento()
    {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        String metodo = "Carta di Credito";
        String numeroCarta = "1234-5678-1234-5678";
        String nome = "Nicolò";
        String cognome = "Mazzola";
        DatiPagamento mockDatiPagamento = mockStudente.creaDatiPagamento(metodo, numeroCarta, nome, cognome);
        assertNotNull(mockDatiPagamento);
        assertEquals(metodo, mockDatiPagamento.getMetodo());
        assertEquals(numeroCarta, mockDatiPagamento.getNumeroCarta());
        assertEquals(nome, mockDatiPagamento.getNome());
        assertEquals(cognome, mockDatiPagamento.getCognome());
        assertTrue(mockStudente.getMappaDatiPagamento().containsKey(numeroCarta));
        assertEquals(mockDatiPagamento, mockStudente.getMappaDatiPagamento().get(numeroCarta));
    }

    @Test
    public void testUsaDatiPagamento() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        String metodo = "Carta di Credito";
        String numeroCarta = "1234-5678-1234-5678";
        String nome = "Nicolò";
        String cognome = "Mazzola";
        mockStudente.creaDatiPagamento(metodo, numeroCarta, nome, cognome);
        InputStream inputStream = new ByteArrayInputStream(numeroCarta.getBytes());
        System.setIn(inputStream);
        DatiPagamento mockDatiPagamento = mockStudente.usaDatiPagamento();
        assertNotNull(mockDatiPagamento);
        assertEquals(metodo, mockDatiPagamento.getMetodo());
        assertEquals(numeroCarta, mockDatiPagamento.getNumeroCarta());
        assertEquals(nome, mockDatiPagamento.getNome());
        assertEquals(cognome, mockDatiPagamento.getCognome());
    }

    @Test
    public void testAggiungiAppunto() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Appunto mockAppunto = new Appunto(mockStudente.getId(), "Appunto", "PDF", "Appunto.pdf", 10);
        mockStudente.aggiungiAppunto(mockAppunto);
        assertEquals(1, mockStudente.getMappaAppunti().size());
        assertTrue(mockStudente.getMappaAppunti().containsKey(mockAppunto.getId()));
        assertTrue(mockStudente.getMappaAppunti().containsValue(mockAppunto));
    }

    @Test
    public void testRimuoviAppunto() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Appunto mockAppunto = new Appunto(mockStudente.getId(), "Appunto", "PDF", "Appunto.pdf", 10);
        mockStudente.aggiungiAppunto(mockAppunto);
        assertEquals(1, mockStudente.getMappaAppunti().size());
        mockStudente.rimuoviAppunto(mockAppunto);
        assertEquals(0, mockStudente.getMappaAppunti().size());
        assertFalse(mockStudente.getMappaAppunti().containsKey(mockAppunto.getId()));
        assertFalse(mockStudente.getMappaAppunti().containsValue(mockAppunto));
    }

    @Test
    public void testAggiungiAppuntoScaricato(){
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Appunto mockAppunto = new Appunto(mockStudente.getId(), "Appunto Scaricato", "PDF", "AppuntoScaricato.pdf", 15);
        mockStudente.aggiungiAppuntoScaricato(mockAppunto);
        assertEquals(1, mockStudente.getMappaAppuntiScaricati().size());
        assertTrue(mockStudente.getMappaAppuntiScaricati().containsKey(mockAppunto.getId()));
        assertTrue(mockStudente.getMappaAppuntiScaricati().containsValue(mockAppunto));
    }

    @Test
    public void testRimuoviAppuntoScaricato(){
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Appunto mockAppunto = new Appunto(mockStudente.getId(), "Appunto Scaricato", "PDF", "AppuntoScaricato.pdf", 15);
        mockStudente.aggiungiAppuntoScaricato(mockAppunto);
        assertEquals(1, mockStudente.getMappaAppuntiScaricati().size());
        mockStudente.rimuoviAppuntoScaricato(mockAppunto);
        assertEquals(0, mockStudente.getMappaAppuntiScaricati().size());
        assertFalse(mockStudente.getMappaAppuntiScaricati().containsKey(mockAppunto.getId()));
        assertFalse(mockStudente.getMappaAppuntiScaricati().containsValue(mockAppunto));
    }

    @Test
    public void testVerificaPassword() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        assertTrue(mockStudente.verificaPassword("1111"));
        assertFalse(mockStudente.verificaPassword("0000"));
    }

    @Test
    public void testAggiungiContenuto() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Contenuto mockContenuto = new Contenuto("Contenuto", "PDF", "Contenuto.pdf", 20);
        mockStudente.aggiungiContenuto(mockContenuto);
        assertEquals(1, mockStudente.getMappaContenuti().size());
        assertTrue(mockStudente.getMappaContenuti().containsKey(mockContenuto.getId()));
        assertTrue(mockStudente.getMappaContenuti().containsValue(mockContenuto));
    }

    @Test
    public void testRimuoviContenuto() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Contenuto mockContenuto = new Contenuto("Contenuto", "PDF", "Contenuto.pdf", 20);
        mockStudente.aggiungiContenuto(mockContenuto);
        assertEquals(1, mockStudente.getMappaContenuti().size());
        mockStudente.rimuoviContenuto(mockContenuto);
        assertEquals(0, mockStudente.getMappaContenuti().size());
        assertFalse(mockStudente.getMappaContenuti().containsKey(mockContenuto.getId()));
        assertFalse(mockStudente.getMappaContenuti().containsValue(mockContenuto));
    }

    @Test
    public void testSetNome() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        String nuovoNome = "Mario";
        mockStudente.creaDatiPagamento("Carta di credito", "1234-5678-1234-5678", mockStudente.getNome(), mockStudente.getCognome());
        mockStudente.setNome(nuovoNome);
        assertEquals(nuovoNome, mockStudente.getNome());
        for (DatiPagamento datiPagamento : mockStudente.getMappaDatiPagamento().values()) {
            assertEquals(nuovoNome, datiPagamento.getNome());
        }
    }

    @Test
    public void testSetCognome() {
        Studente mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        String nuovoCognome = "Rossi";
        mockStudente.setCognome(nuovoCognome);
        assertEquals(nuovoCognome, mockStudente.getCognome());
        for (DatiPagamento datiPagamento : mockStudente.getMappaDatiPagamento().values()) {
            assertEquals(nuovoCognome, datiPagamento.getCognome());
        }
    }
}