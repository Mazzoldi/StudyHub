package com.example;

import org.junit.*;
import java.io.InputStream;
import java.util.*;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

public class TestStudyHub 
{
    static StudyHub studyHub;
    private Studente mockStudente;
    private Corso mockCorso;
    private Iscrizione mockIscrizione;
    
    //Recupera istanza di StudyHub
    @BeforeClass
    public static void init()
    {
        studyHub = StudyHub.getIstance();
    }

    //Test per la generazione di un ID univoco
    @Test
    public void testGeneraId()
    {
        String id = StudyHub.generaId();
        assertNotNull(id);
    }

    //Test per l'opzione 1 del menu a scelta
    @Test
    public void testMenuOption1() {
        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = studyHub.menu();

        // Verifica che l'output sia corretto
        assertEquals(1, result);
    }

    //Test per l'opzione 2 del menu a scelta
    @Test
    public void testMenuOption2() {
        String simulatedInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = studyHub.menu();

        // Verifica che l'output sia corretto
        assertEquals(2, result);
    }

    //Test per l'opzione 3 del menu a scelta
    @Test
    public void testMenuOption3() {
        String simulatedInput = "3\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = studyHub.menu();

        // Verifica che l'output sia corretto
        assertEquals(3, result);
    }

    //Test cercaCorso
    @Test
    public void testCercaCorso()
    {
        Map<String, Corso> mockMappaCorsiCercati = new HashMap<String, Corso>();
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        studyHub.getMappaCorsiTotali().put(mockCorso.getNome(), mockCorso);
        mockMappaCorsiCercati = studyHub.cercaCorso("Ingegneria del Software", "Difficile", null, "Italiano");
        assertNotNull(mockMappaCorsiCercati);
    }

    //Test selezionaCorso
    @Test
    public void testSelezionaCorso()
    {
        Map<String, Corso> mockMappaCorsiCercati = new HashMap<String, Corso>();
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        Corso mockCorso1 = new Corso("Ingegneria", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        Corso mockCorso2 = new Corso("Matematica", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        mockMappaCorsiCercati.put(mockCorso.getId(), mockCorso);
        mockMappaCorsiCercati.put(mockCorso1.getId(), mockCorso1);
        mockMappaCorsiCercati.put(mockCorso2.getId(), mockCorso2);
        String simulatedInput = mockCorso.getId();
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.selezionaCorso(mockMappaCorsiCercati);
        assertEquals(mockCorso, studyHub.getCorsoSelezionato());
    }

    //Test iscrizioneCorso
    @Test
    public void testIscrizioneCorsoGratuito()
    {
        mockStudente = new Studente("Nicolò", "Mazzola", "01/01/2000", "Roma", "Roma", "01/01/2021", "Laurea Triennale");
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 0, "Nicolò Mazzola", "italiano", 100);
        studyHub.iscrizioneCorso(mockStudente, mockCorso);
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNotNull(mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso.getId()), mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(1, mockCorso.getNumeroStudenti());
        assertEquals(1, mockStudente.getNumeroCorsi());
    }

    //Test pagamentoIscrizione
    @Test
    public void testPagamentoIscrizione()
    {
        mockStudente = new Studente("Nicolò", "Mazzola", "01/01/2000", "Roma", "Roma", "01/01/2021", "Laurea Triennale");
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        mockStudente.creaDatiPagamento("carta", "123456789", mockStudente.getNome(), mockStudente.getCognome());
        studyHub.setCorsoSelezionato(mockCorso);
        assertNotNull(mockStudente.getMappaDatiPagamento().get("123456789"));
        String simulatedInput = "123456789\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockIscrizione = studyHub.pagamentoIscrizione(mockStudente, mockCorso.getCosto());
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNotNull(mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso.getId()), mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(1, mockCorso.getNumeroStudenti());
        assertEquals(1, mockStudente.getNumeroCorsi());
        assertNotNull(mockIscrizione.getMappaPagamenti().values().iterator().next());
        assertEquals(1, mockIscrizione.getMappaPagamenti().size());
    }

    //Test per l'opzione 4 del menu a scelta
    @Test
    public void testMenuExitOption() {
        String simulatedInput = "4\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = studyHub.menu();

        // Verifica che l'output sia corretto
        assertEquals(4, result);
    }

    //Test per l'opzione 5 del menu a scelta
    @Test
    public void testInvalidMenuOption() {
        String simulatedInput = "5\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = studyHub.menu();

        // Verifica che l'output sia corretto
        assertEquals(5, result);
    }
}