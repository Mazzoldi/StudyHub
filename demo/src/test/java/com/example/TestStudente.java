package com.example;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

public class TestStudente {

    @Test
    public void testUsaDatiPagamento() {
        // Arrange
        Studente studente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "02/01/2025", "Laurea Magistrale");

        // Simulazione di dati di pagamento esistenti
        String metodo = "Carta di Credito";
        String numeroCarta = "1234567890123456";
        String nome = "Nicolò";
        String cognome = "Mazzola";
        studente.creaDatiPagamento(metodo, numeroCarta, nome, cognome);

        // Simulazione input scanner
        InputStream inputStream = new ByteArrayInputStream(numeroCarta.getBytes());
        System.setIn(inputStream);

        // Act
        DatiPagamento datiPagamento = studente.usaDatiPagamento();

        // Assert
        assertNotNull(datiPagamento);
        assertEquals(numeroCarta, datiPagamento.getNumeroCarta());
        assertEquals(nome, datiPagamento.getNome());
        assertEquals(cognome, datiPagamento.getCognome());
    }
}