package com.example;

import org.junit.*;

import static org.junit.Assert.*;

public class TestAppunto {
    @Test
    public void testModificaAppunto() {
        Appunto mockAppunto = new Appunto("1111", "Appunto", "PDF", "Appunto.pdf", 10);
        String titolo = "Appunto Modificato";
        String file = "AppuntoModificato.pdf";
        mockAppunto.modificaAppunto(titolo, file);
        assertEquals(titolo, mockAppunto.getTitolo());
        assertEquals(file, mockAppunto.getFile());
    }
}
