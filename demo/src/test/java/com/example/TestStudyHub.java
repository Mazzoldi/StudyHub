package com.example;

import org.junit.*;

import java.util.*;
import java.io.*;
import static org.junit.Assert.*;

public class TestStudyHub 
{
    static StudyHub studyHub;
    private Studente mockStudente;
    private Corso mockCorso;
    private Iscrizione mockIscrizione;
    private boolean isLogged;
    
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
        isLogged = false;
        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(1, result);
    }

    //Test per l'opzione 2 del menu a scelta
    @Test
    public void testMenuOption2() {
        isLogged = false;
        String simulatedInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(2, result);
    }

    //Test per l'opzione 3 del menu a scelta
    @Test
    public void testMenuOption3() {
        isLogged = false;
        String simulatedInput = "3\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(3, result);
    }

    //Test per l'opzione 4 del menu a scelta
    @Test
    public void testMenuOption4() {
        isLogged = false;
        String simulatedInput = "4\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(4, result);
    }

    //Test per l'opzione 5 del menu a scelta
    @Test
    public void testMenuOption5() {
        isLogged = false;
        String simulatedInput = "5\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(5, result);
    }

    //Test per l'opzione 6 del menu a scelta
    @Test
    public void testMenuOption6() {
        isLogged = false;
        String simulatedInput = "6\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(6, result);
    }

    //Test per l'opzione 7 del menu a scelta
    @Test
    public void testMenuOption7() {
        isLogged = false;
        String simulatedInput = "7\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(7, result);
    }

    //Test per l'opzione 8 del menu a scelta
    @Test
    public void testMenuOption8() {
        isLogged = false;
        String simulatedInput = "8\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(8, result);
    }

    //Test per l'opzione 9 del menu a scelta
    @Test
    public void testMenuOption9() {
        isLogged = false;
        String simulatedInput = "9\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(9, result);
    }

    //Test per l'opzione 10 del menu a scelta
    @Test
    public void testMenuOption10() {
        isLogged = false;
        String simulatedInput = "10\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(10, result);
    }

    //Test login
    @Test
    public void testLogin()
    {
        isLogged = false;
        String simulatedInput = "Mazzoldi\n1111\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        isLogged = studyHub.login();
        assertTrue(isLogged);
    }

    //UC1
    //Test creaProfilo
    @Test
    public void testCreaProfilo()
    {
        String simulatedInput = "MarioRossi\n1111\nMario\nRossi\n01/01/1900\nRoma\nRoma\nLaurea\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int numeroStudenti = studyHub.getStudenti().size();
        mockStudente = studyHub.datiProfilo();
        studyHub.creaProfilo(mockStudente);
        assertNotNull(studyHub.getStudente());
        assertEquals(numeroStudenti + 1, studyHub.getStudenti().size());
        assertEquals(mockStudente, studyHub.getStudente());
        assertEquals(mockStudente, studyHub.getStudenti().get(mockStudente.getId()));
        assertEquals(mockStudente.getUsername(), studyHub.getStudente().getUsername());
        assertEquals(mockStudente.getPassword(), studyHub.getStudente().getPassword());
        assertEquals(mockStudente.getNome(), studyHub.getStudente().getNome());
        assertEquals(mockStudente.getCognome(), studyHub.getStudente().getCognome());
        assertEquals(mockStudente.getDataNascita(), studyHub.getStudente().getDataNascita());
        assertEquals(mockStudente.getLuogoNascita(), studyHub.getStudente().getLuogoNascita());
        assertEquals(mockStudente.getResidenza(), studyHub.getStudente().getResidenza());
        assertEquals(mockStudente.getLivello(), studyHub.getStudente().getLivello());
    }

    //UC2
    //Test modificaProfilo
    @Test
    public void testModificaProfilo()
    {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        Map<String, Studente> mockStudenti = new HashMap<String, Studente>();
        mockStudenti.put(mockStudente.getId(), mockStudente);
        studyHub.setStudenti(mockStudenti);
        String simulatedInput = "AndreaBianchi\n1111\nAndrea\nBianchi\n02/02/2000\nMilano\nMilano\nLaurea Magistrale\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Studente mockNewStudente = studyHub.datiProfilo();
        studyHub.modificaProfilo(mockNewStudente);
        assertNotNull(studyHub.getStudente());
        assertEquals(studyHub.getStudenti().get(mockStudente.getId()), studyHub.getStudente());
        assertEquals(mockNewStudente.getUsername(), studyHub.getStudente().getUsername());
        assertEquals(mockNewStudente.getPassword(), studyHub.getStudente().getPassword());
        assertEquals(mockNewStudente.getNome(), studyHub.getStudente().getNome());
        assertEquals(mockNewStudente.getCognome(), studyHub.getStudente().getCognome());
        assertEquals(mockNewStudente.getDataNascita(), studyHub.getStudente().getDataNascita());
        assertEquals(mockNewStudente.getLuogoNascita(), studyHub.getStudente().getLuogoNascita());
        assertEquals(mockNewStudente.getResidenza(), studyHub.getStudente().getResidenza());
        assertEquals(mockNewStudente.getLivello(), studyHub.getStudente().getLivello());
    }

    //UC3
    //Test creaCorso
    @Test
    public void testCreaCorso()
    {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        String simulatedInput = "Ingegneria del Software\nDifficile\n49\nitaliano\n49\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockCorso = studyHub.creaCorso();
        assertNotNull(studyHub.getStudente().getMappaCorsiCreati().get(mockCorso.getId()));
        assertNotNull(studyHub.getMappaCorsiTotali().get(mockCorso.getId()));
        assertEquals(mockCorso, studyHub.getStudente().getMappaCorsiCreati().get(mockCorso.getId()));
        assertEquals(mockCorso, studyHub.getMappaCorsiTotali().get(mockCorso.getId()));
    }

    //Test selezionaCorsoCreato
    @Test
    public void testSelezionaCorsoCreato()
    {
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, studyHub.getStudente().getId(), "italiano", 100);
        studyHub.getStudente().getMappaCorsiCreati().put(mockCorso.getId(), mockCorso);
        String simulatedInput = mockCorso.getId();
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.selezionaCorsoCreato();
        assertNotNull(studyHub.getCorsoSelezionato());
        assertEquals(mockCorso, studyHub.getCorsoSelezionato());
    }

    //Test caricaContenuto
    @Test
    public void testCaricaContenuto()
    {
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, "", "italiano", 100);
        studyHub.setCorsoSelezionato(mockCorso);
        String simulatedInput = "Lezione 1\nPDF\nappunti.pdf\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Contenuto mockContenuto = studyHub.caricaContenuto();
        assertNotNull(studyHub.getCorsoSelezionato().getMappaContenuti().get(mockContenuto.getId()));
        assertEquals(mockContenuto, studyHub.getCorsoSelezionato().getMappaContenuti().get(mockContenuto.getId()));
    }

    //UC4

    //Test cercaCorso
    @Test
    public void testCercaCorso()
    {
        Map<String, Corso> mockMappaCorsiTotali = new HashMap<String, Corso>();
        Corso mockCorso1 = new Corso("Matematica", "Laurea Magistrale", 0, "Nicolò Mazzola", "Italiano", 30);
        Corso mockCorso2 = new Corso("Fisica", "Laurea Triennale", 10, "Danilo Verde", "Inglese", 30);
        Corso mockCorso3 = new Corso("Inglese", "Liceo", 0, "Mario Rossi", "Italiano", 30);
        Corso mockCorso4 = new Corso("Italiano", "Laurea Triennale", 20, "Andrea Bianchi", "Italiano", 30);
        Corso mockCorso5 = new Corso("Storia", "Liceo", 10, "Mario Rossi", "Inglese", 30);
        mockMappaCorsiTotali.put(mockCorso1.getId(), mockCorso1);
        mockMappaCorsiTotali.put(mockCorso2.getId(), mockCorso2);
        mockMappaCorsiTotali.put(mockCorso3.getId(), mockCorso3);
        mockMappaCorsiTotali.put(mockCorso4.getId(), mockCorso4);
        mockMappaCorsiTotali.put(mockCorso5.getId(), mockCorso5);
        studyHub.setMappaCorsiTotali(mockMappaCorsiTotali);
        assertEquals(studyHub.getMappaCorsiTotali(), mockMappaCorsiTotali);
        assertEquals(5, studyHub.getMappaCorsiTotali().size());
        String simulatedInput = "\n\n\n\n\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Map<String, Corso> mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(5, mockMappaCorsiCercati.size());
        assertEquals(mockCorso1, mockMappaCorsiCercati.get(mockCorso1.getId()));
        assertEquals(mockCorso2, mockMappaCorsiCercati.get(mockCorso2.getId()));
        assertEquals(mockCorso3, mockMappaCorsiCercati.get(mockCorso3.getId()));
        assertEquals(mockCorso4, mockMappaCorsiCercati.get(mockCorso4.getId()));
        assertEquals(mockCorso5, mockMappaCorsiCercati.get(mockCorso5.getId()));
        assertEquals(5, mockMappaCorsiCercati.size());
        simulatedInput = "Inglese\n\n\n\n\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(mockCorso3, mockMappaCorsiCercati.get(mockCorso3.getId()));
        assertEquals(1, mockMappaCorsiCercati.size());
        simulatedInput = "\nLaurea Triennale\n\n\n\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(mockCorso2, mockMappaCorsiCercati.get(mockCorso2.getId()));
        assertEquals(mockCorso4, mockMappaCorsiCercati.get(mockCorso4.getId()));
        assertEquals(2, mockMappaCorsiCercati.size());
        simulatedInput = "\n\nMario Rossi\n\n\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(mockCorso3, mockMappaCorsiCercati.get(mockCorso3.getId()));
        assertEquals(mockCorso5, mockMappaCorsiCercati.get(mockCorso5.getId()));
        assertEquals(2, mockMappaCorsiCercati.size());
        simulatedInput = "\n\n\n"+ mockCorso1.getId() +"\n\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(mockCorso1, mockMappaCorsiCercati.get(mockCorso1.getId()));
        assertEquals(1, mockMappaCorsiCercati.size());
        simulatedInput = "\n\n\n\nItaliano\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(mockCorso1, mockMappaCorsiCercati.get(mockCorso1.getId()));
        assertEquals(mockCorso3, mockMappaCorsiCercati.get(mockCorso3.getId()));
        assertEquals(mockCorso4, mockMappaCorsiCercati.get(mockCorso4.getId()));
        assertEquals(3, mockMappaCorsiCercati.size());
        simulatedInput = "\n\n\n\nPortoghese\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockMappaCorsiCercati = studyHub.cercaCorso();
        assertNotNull(mockMappaCorsiCercati);
        assertEquals(0, mockMappaCorsiCercati.size());
    }

    //Test selezionaCorso
    @Test
    public void testSelezionaCorso()
    {
        Map<String, Corso> mockMappaCorsiCercati = new HashMap<String, Corso>();
        Corso mockCorso1 = new Corso("Ingegneria", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        Corso mockCorso2 = new Corso("Matematica", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        mockMappaCorsiCercati.put(mockCorso1.getId(), mockCorso1);
        mockMappaCorsiCercati.put(mockCorso2.getId(), mockCorso2);
        String simulatedInput = mockCorso1.getId();
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.selezionaCorso(mockMappaCorsiCercati);
        assertNotNull(studyHub.getCorsoSelezionato());
        assertEquals(mockCorso1, studyHub.getCorsoSelezionato());
    }

    //Test iscrizioneCorso
    @Test
    public void testIscrizioneCorsoGratuito()
    {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 0, "Nicolò Mazzola", "italiano", 100);
        studyHub.setCorsoSelezionato(mockCorso);
        studyHub.iscrizioneCorso();
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
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        studyHub.setStudente(mockStudente);
        mockStudente.creaDatiPagamento("carta", "123456789", mockStudente.getNome(), mockStudente.getCognome());
        studyHub.setCorsoSelezionato(mockCorso);
        assertNotNull(mockStudente.getMappaDatiPagamento().get("123456789"));
        String simulatedInput = "123456789\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockIscrizione = studyHub.pagamentoIscrizione(mockCorso.getCosto());
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNotNull(mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso.getId()), mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(1, mockCorso.getNumeroStudenti());
        assertEquals(1, mockStudente.getNumeroCorsi());
        assertNotNull(mockIscrizione.getMappaPagamenti().values().iterator().next());
        assertEquals(1, mockIscrizione.getMappaPagamenti().size());
    }

    //Test aggiungiIscrizione
    @Test
    public void testAggiungiIscrizione()
    {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        mockCorso = new Corso("Ingegneria del Software", "Difficile", 49, "Nicolò Mazzola", "italiano", 100);
        studyHub.setCorsoSelezionato(mockCorso);
        mockIscrizione = new Iscrizione(mockStudente.getId(), mockCorso.getId());
        studyHub.aggiungiIscrizione(mockIscrizione);
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNotNull(mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso.getId()), mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(1, mockCorso.getNumeroStudenti());
        assertEquals(1, mockStudente.getNumeroCorsi());
    }

    //UC5

    //Test caricaAppunto
    @Test
    public void testCaricaAppunto() {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        String simulatedInput = "Appunto di Matematica\nPDF\nappunti_matematica.pdf\n12/09/2021\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Appunto mockAppunto = studyHub.caricaAppunto();
        assertNotNull(mockStudente.getMappaAppunti());
        assertEquals(mockAppunto, mockStudente.getMappaAppunti().get(mockAppunto.getId()));
    }
    
    //UC6

    //Test creaGruppoStudio
    @Test
    public void testCreaGruppoStudio()
    {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        String simulatedInput = "Gruppo 1\n1111\nItaliano\n30\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        GruppoStudio mockGruppoStudio = studyHub.creaGruppoStudio();
        assertNotNull(mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(mockGruppoStudio, mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockGruppoStudio, studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockStudente, mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(mockStudente.getUsername(), mockGruppoStudio.getAdmin());
        assertEquals(1, mockStudente.getMappaGruppiStudio().size());
        assertEquals(1, mockGruppoStudio.getNumeroStudenti());
    }

    //Test creaGruppoStudio
    @Test
    public void testIscrizioneGruppoStudio()
    {
        mockStudente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = new GruppoStudio("Gruppo 1", mockStudente.getId(), "1111", "Italiano", 30);
        Map<String, GruppoStudio> mockGruppiStudio = new HashMap<String, GruppoStudio>();
        mockGruppiStudio.put(mockGruppoStudio.getId(), mockGruppoStudio);
        studyHub.setGruppiStudio(mockGruppiStudio);
        String simulatedInput = "Gruppo 1\n1111\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.iscrizioneGruppoStudio();
        assertNotNull(mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(mockGruppoStudio, mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockGruppoStudio, studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockStudente, mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(1, mockStudente.getMappaGruppiStudio().size());
        assertEquals(1, mockGruppoStudio.getNumeroStudenti());
    }
}