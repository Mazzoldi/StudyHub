package com.example;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

class StudenteTest {

    @Test
    void testUsaDatiPagamento() {
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
        assertEquals(numeroCarta, datiPagamento.getNumeroCarta(), "Il numero della carta deve corrispondere.");
        assertEquals(nome, datiPagamento.getNome(), "Il nome deve corrispondere.");
        assertEquals(cognome, datiPagamento.getCognome(), "Il cognome deve corrispondere.");
    }
}