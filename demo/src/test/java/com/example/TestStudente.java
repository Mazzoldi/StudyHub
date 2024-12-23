package com.example;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

public class TestStudente {

    @Test
    public void testUsaDatiPagamento() {
        // Arrange
        Studente studente = new Studente("Mario", "Rossi", "1990-01-01", "Roma", "Via Roma, 1", "2024-01-01", "Avanzato");

        // Simulazione di dati di pagamento esistenti
        String metodo = "Carta di Credito";
        String numeroCarta = "1234567890123456";
        String nome = "Mario";
        String cognome = "Rossi";
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