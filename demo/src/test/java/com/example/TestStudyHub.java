package com.example;

import org.junit.*;

import java.util.*;
import java.io.*;
import static org.junit.Assert.*;

public class TestStudyHub 
{
    static StudyHub studyHub;
    private static Studente mockStudente;
    private static Corso mockCorso;
    private static Corso mockCorso2;
    private static Corso mockCorso3;
    private Iscrizione mockIscrizione;
    private boolean isLogged;
    
    //Recupera istanza di StudyHub
    @Before
    public void init()
    {
        studyHub = StudyHub.getIstance();
        studyHub.loadData();
        for (Studente studente : studyHub.getStudenti().values())
        {
            if (studente.getUsername().equals("Mazzoldi"))
            {
                mockStudente = studente;
                break;
            }
        }
        for (Corso corso : studyHub.getMappaCorsiTotali().values())
        {
            if (corso.getNome().equals("Matematica"))
            {
                mockCorso = corso;
                break;
            }
        }
        for (Corso corso : studyHub.getMappaCorsiTotali().values())
        {
            if (corso.getNome().equals("Fisica"))
            {
                mockCorso2 = corso;
                break;
            }
        }
        for (Corso corso : studyHub.getMappaCorsiTotali().values())
        {
            if (corso.getNome().equals("Storia"))
            {
                mockCorso3 = corso;
                break;
            }
        }
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

    //Test per l'opzione 11 del menu a scelta
    @Test
    public void testMenuOption11() {
        isLogged = false;
        String simulatedInput = "11\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(11, result);
    }

    //Test per l'opzione 12 del menu a scelta
    @Test
    public void testMenuOption12() {
        isLogged = false;
        String simulatedInput = "12\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(12, result);
    }

    //Test per l'opzione 13 del menu a scelta
    @Test
    public void testMenuOption13() {
        isLogged = false;
        String simulatedInput = "13\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = studyHub.menu(isLogged);
        assertEquals(13, result);
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
    //Test creaProfilo e datiProfilo
    @Test
    public void testCreaProfilo()
    {
        String simulatedInput = "no\nRossiMario\n1111\nMario\nRossi\n01/01/1900\nRoma\nRoma\nLaurea\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int numeroStudenti = studyHub.getStudenti().size();
        studyHub.creaProfilo();
        TestStudyHub.mockStudente = studyHub.getStudente();
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

    //Test controllaUsername
    @Test
    public void testControllaUsername()
    {
        String simulatedInput = "Mazzoldi\n1111\nNicolò\nMazzola\n12/09/2002\nCatania\nCatania\nLaurea Magistrale\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        assertFalse(studyHub.creaProfilo());
    }

    //Test eliminaProfilo
    @Test
    public void testEliminaProfilo()
    {
        Map<String, Corso> mockCorsiCreati = mockStudente.getMappaCorsiCreati();
        Map<String, GruppoStudio> mockGruppiStudio = mockStudente.getMappaGruppiStudio();
        Map<String, Appunto> mockAppunti = mockStudente.getMappaAppunti();
        Map<String, Iscrizione> mockIscrizioni = mockStudente.getMappaIscrizioni();
        Map<String, DatiPagamento> mockDatiPagamento = mockStudente.getMappaDatiPagamento();
        studyHub.setStudente(mockStudente);
        studyHub.setIsLogged(true);
        studyHub.setCorsoSelezionato(mockStudente.getMappaCorsiCreati().values().iterator().next());
        int numeroStudenti = studyHub.getStudenti().size();
        studyHub.eliminaProfilo();
        assertEquals(numeroStudenti - 1, studyHub.getStudenti().size());
        assertNull(studyHub.getStudenti().get(mockStudente.getId()));
        assertNull(studyHub.getStudente());
        assertNull(studyHub.getCorsoSelezionato());
        for (Corso corso : mockCorsiCreati.values())
        {
            assertNull(studyHub.getStudente().getMappaCorsiCreati().get(corso.getId()));
            assertNull(studyHub.getMappaCorsiTotali().get(corso.getId()));
            assertNull(corso.getMappaContenuti());
        }
        for (GruppoStudio gruppoStudio : mockGruppiStudio.values())
        {
            if (gruppoStudio.getAdmin() == mockStudente.getId())
            {
                assertNull(studyHub.getGruppiStudio().get(gruppoStudio.getId()));
                for (Studente studente : gruppoStudio.getMappaStudenti().values())
                {
                    assertNull(studente.getMappaGruppiStudio().get(gruppoStudio.getId()));
                    assertNull(gruppoStudio.getMappaStudenti().get(studente.getId()));
                }
            }
            assertNull(studyHub.getStudente().getMappaGruppiStudio().get(gruppoStudio.getId()));
        }
        for (Appunto appunto : mockAppunti.values())
        {
            assertNull(studyHub.getStudente().getMappaAppunti().get(appunto.getId()));
            assertNull(studyHub.getAppunti().get(appunto.getId()));
        }
        for (Iscrizione iscrizione : mockIscrizioni.values())
        {
            assertNull(studyHub.getStudente().getMappaIscrizioni().get(iscrizione.getId()));
            assertNull(studyHub.getMappaCorsiTotali().get(iscrizione.getCorso()).getMappaIscrizioni().get(iscrizione.getId()));
        }
        for (DatiPagamento datiPagamento : mockDatiPagamento.values())
        {
            assertNull(studyHub.getStudente().getMappaDatiPagamento().get(datiPagamento.getNumeroCarta()));
        }
    }

    //UC2
    //Test modificaProfilo
    @Test
    public void testModificaProfilo()
    {
        studyHub.setStudente(mockStudente);
        Map<String, Studente> mockStudenti = new HashMap<String, Studente>();
        mockStudenti.put(mockStudente.getId(), mockStudente);
        studyHub.setStudenti(mockStudenti);
        String simulatedInput = "AndreaBianchi\n1111\nAndrea\nBianchi\n02/02/2000\nMilano\nMilano\nLaurea Magistrale\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.modificaProfilo();
        Studente mockNewStudente = studyHub.getStudente();
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
        studyHub.setStudente(mockStudente);
        String simulatedInput = "Ingegneria del Software\nDifficile\n49\nitaliano\n49\n100\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockCorso = studyHub.creaCorso();
        assertNotNull(studyHub.getStudente().getMappaCorsiCreati().get(mockCorso.getId()));
        assertNotNull(studyHub.getMappaCorsiTotali().get(mockCorso.getId()));
        assertEquals(mockCorso, studyHub.getStudente().getMappaCorsiCreati().get(mockCorso.getId()));
        assertEquals(mockCorso, studyHub.getMappaCorsiTotali().get(mockCorso.getId()));
    }

    //Test controllaNomeCorso
    @Test
    public void testControllaNomeCorso()
    {
        studyHub.setStudente(mockStudente);
        int mockNumeroCorsi = studyHub.getMappaCorsiTotali().size();
        String simulatedInput = "Matematica\nDifficile\n49\nitaliano\n49\n100\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockCorso = studyHub.creaCorso();
        assertNull(mockCorso);
        assertEquals(mockNumeroCorsi, studyHub.getMappaCorsiTotali().size());
        simulatedInput = "@##[]§\nDifficile\n49\nitaliano\n49\n100\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockCorso = studyHub.creaCorso();
        assertNull(mockCorso);
        assertEquals(mockNumeroCorsi, studyHub.getMappaCorsiTotali().size());
    }

    //Test eliminaCorso
    @Test
    public void testEliminaCorso()
    {
        studyHub.setStudente(mockStudente);
        Map<String, Corso> mockCorsiTotali = studyHub.getMappaCorsiTotali();
        studyHub.setCorsoSelezionato(mockCorso);
        int numeroCorsi = mockStudente.getMappaCorsiCreati().size();
        System.out.println(numeroCorsi);
        Map <String, Contenuto> mockContenuti = mockCorso.getMappaContenuti();
        Map<String, Iscrizione> mockIscrizioni = mockCorso.getMappaIscrizioni();
        String simulatedInput = mockCorso.getId() + "\n";
        System.out.println(mockCorso.getNome());
        System.out.println(mockCorso.getId());
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaCorso();
        assertEquals(numeroCorsi - 1, mockStudente.getMappaCorsiCreati().size());
        assertNull(mockStudente.getMappaCorsiCreati().get(mockCorso.getId()));
        assertNull(mockCorsiTotali.get(mockCorso.getId()));
        assertNull(studyHub.getCorsoSelezionato());
        for (Contenuto contenuto : mockContenuti.values())
        {
            assertNull(mockCorso.getMappaContenuti().get(contenuto.getId()));
        }
        for (Iscrizione iscrizione : mockIscrizioni.values())
        {
            assertNull(mockCorso.getMappaIscrizioni().get(iscrizione.getId()));
            assertNull(studyHub.getStudenti().get(iscrizione.getStudente()).getMappaIscrizioni().get(iscrizione.getId()));
        }
    }

    //UC4
    //Test cercaCorso
    @Test
    public void testCercaCorso()
    {
        Map<String, Corso> mockMappaCorsiTotali = new HashMap<String, Corso>();
        Corso mockCorso1 = new Corso("Matematica", "Laurea Magistrale", 0, "Nicolò Mazzola", "Italiano", 30, 15);
        Corso mockCorso2 = new Corso("Fisica", "Laurea Triennale", 10, "Danilo Verde", "Inglese", 30, 15);
        Corso mockCorso3 = new Corso("Inglese", "Liceo", 0, "Mario Rossi", "Italiano", 30, 15);
        Corso mockCorso4 = new Corso("Italiano", "Laurea Triennale", 20, "Andrea Bianchi", "Italiano", 30, 15);
        Corso mockCorso5 = new Corso("Storia", "Liceo", 10, "Mario Rossi", "Inglese", 30, 15);
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
        Corso mockCorso1 = new Corso("Ingegneria", "Difficile", 49, "Nicolò Mazzola", "italiano", 100, 15);
        Corso mockCorso2 = new Corso("Matematica", "Difficile", 49, "Nicolò Mazzola", "italiano", 100, 15);
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
        studyHub.setStudente(mockStudente);
        int numeroStudenti = mockCorso3.getNumeroStudenti();
        int numeroCorsi = mockStudente.getMappaIscrizioni().size();
        String simulatedInput = mockCorso3.getNome() + "\n" + mockCorso3.getLivello() + "\n" + mockCorso3.getCreatore() + "\n\n" + mockCorso3.getLingua() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.iscrizioneCorso();
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso3.getId()));
        assertNotNull(mockCorso3.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso3.getId()), mockCorso3.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(numeroStudenti + 1, mockCorso3.getNumeroStudenti());
        assertEquals(numeroCorsi + 1, mockStudente.getNumeroCorsi());
    }

    //Test controllaIscrizione
    @Test
    public void testControllaIscrizione()
    {
        studyHub.setStudente(mockStudente);
        studyHub.setCorsoSelezionato(mockCorso);
        int numeroCorsi = mockStudente.getMappaIscrizioni().size();
        int numeroStudenti = mockCorso.getNumeroStudenti();
        studyHub.controllaIscrizione(mockCorso);
        assertEquals(numeroCorsi, mockStudente.getMappaIscrizioni().size());
        assertEquals(numeroStudenti, mockCorso.getNumeroStudenti());
    }

    //Test pagamentoIscrizione
    @Test
    public void testPagamentoIscrizione()
    {
        studyHub.setStudente(mockStudente);
        mockStudente.creaDatiPagamento("carta", "123456789", mockStudente.getNome(), mockStudente.getCognome());
        studyHub.setCorsoSelezionato(mockCorso);
        int numeroStudenti = mockCorso.getNumeroStudenti();
        int numeroCorsi = mockStudente.getNumeroCorsi();
        assertNotNull(mockStudente.getMappaDatiPagamento().get("123456789"));
        String simulatedInput = "123456789\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockIscrizione = studyHub.pagamentoIscrizione(mockCorso.getCosto());
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNotNull(mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso.getId()), mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(numeroStudenti + 1, mockCorso.getNumeroStudenti());
        assertEquals(numeroCorsi + 1, mockStudente.getNumeroCorsi());
        assertNotNull(mockIscrizione.getMappaPagamenti().values().iterator().next());
        assertEquals(1, mockIscrizione.getMappaPagamenti().size());
    }

    //Test aggiungiIscrizione
    @Test
    public void testAggiungiIscrizione()
    {
        studyHub.setStudente(mockStudente);
        studyHub.setCorsoSelezionato(mockCorso);
        int numeroStudenti = mockCorso.getNumeroStudenti();
        int numeroCorsi = mockStudente.getNumeroCorsi();
        mockIscrizione = new Iscrizione(mockStudente.getId(), mockCorso.getId());
        studyHub.aggiungiIscrizione(mockIscrizione);
        assertNotNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNotNull(mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(mockStudente.getMappaIscrizioni().get(mockCorso.getId()), mockCorso.getMappaIscrizioni().get(mockStudente.getId()));
        assertEquals(numeroStudenti + 1, mockCorso.getNumeroStudenti());
        assertEquals(numeroCorsi + 1, mockStudente.getNumeroCorsi());
    }

    //Test selezionaCorsoIscritto
    @Test
    public void testSelezionaCorsoIscritto()
    {
        studyHub.setStudente(mockStudente);
        studyHub.setCorsoSelezionato(null);
        System.out.println(mockCorso2.getId());
        String simulatedInput = mockCorso2.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.selezionaCorsoIscritto();
        assertNotNull(studyHub.getCorsoSelezionato());
        assertEquals(mockCorso2, studyHub.getCorsoSelezionato());
    }

    //Test eliminaIscrizione
    @Test
    public void testEliminaIscrizione()
    {
        studyHub.setStudente(mockStudente);
        studyHub.setCorsoSelezionato(mockCorso2);
        int numeroCorsi = mockStudente.getMappaIscrizioni().size();
        int numeroStudenti = mockCorso2.getNumeroStudenti();
        String simulatedInput = mockCorso2.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaIscrizione();
        assertEquals(numeroCorsi - 1, mockStudente.getMappaIscrizioni().size());
        assertEquals(numeroStudenti - 1, mockCorso2.getNumeroStudenti());
        assertNull(mockStudente.getMappaIscrizioni().get(mockCorso.getId()));
        assertNull(mockCorso2.getMappaIscrizioni().get(mockStudente.getId()));
    }
    
    //UC5
    //Test creaGruppoStudio
    @Test
    public void testCreaGruppoStudio()
    {
        studyHub.setStudente(mockStudente);
        int numeroGruppiStudioTotali = studyHub.getGruppiStudio().size();
        int numeroGruppiStudioStudente = mockStudente.getMappaGruppiStudio().size();
        String simulatedInput = "Mock gruppo\n1111\nItaliano\n30\n15\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        GruppoStudio mockGruppoStudio = studyHub.creaGruppoStudio();
        assertNotNull(mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(mockGruppoStudio, mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockGruppoStudio, studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockStudente, mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(mockStudente.getId(), mockGruppoStudio.getAdmin());
        assertEquals(numeroGruppiStudioStudente + 1, mockStudente.getMappaGruppiStudio().size());
        assertEquals(numeroGruppiStudioTotali + 1, studyHub.getGruppiStudio().size());
        assertEquals(1, mockGruppoStudio.getNumeroStudenti());
    }

    //Test controllaNomeGruppo
    @Test
    public void testControllaNomeGruppo()
    {
        studyHub.setStudente(mockStudente);
        int numeroGruppiStudioTotali = studyHub.getGruppiStudio().size();
        int numeroGruppiStudioStudente = mockStudente.getMappaGruppiStudio().size();
        String simulatedInput = "Gruppo1\n1111\nItaliano\n30\n15\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        GruppoStudio mockGruppoStudio = studyHub.creaGruppoStudio();
        assertNull(mockGruppoStudio);
        assertEquals(numeroGruppiStudioTotali, studyHub.getGruppiStudio().size());
        assertEquals(numeroGruppiStudioStudente, mockStudente.getMappaGruppiStudio().size());
    }

    //Test selezionaGruppoStudioCreato
    @Test
    public void testSelezionaGruppoStudioCreato()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo1")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        System.out.println(mockGruppoStudio.getNome());
        String simulatedInput = mockGruppoStudio.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        GruppoStudio mockGruppoStudio2 = studyHub.selezionaGruppoStudioCreato();
        assertNotNull(mockGruppoStudio2);
        assertEquals(mockGruppoStudio, mockGruppoStudio2);
    }

    //Test eliminaGruppoStudio
    @Test
    public void testEliminaGruppoStudio()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo1")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        Map<String, Studente> mockStudenti = mockGruppoStudio.getMappaStudenti();
        int numeroGruppiStudioTotali = studyHub.getGruppiStudio().size();
        int numeroGruppiStudioStudente = mockStudente.getMappaGruppiStudio().size();
        String simulatedInput = mockGruppoStudio.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaGruppoStudio();
        assertNull(mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertNull(studyHub.getGruppiStudio().get(mockGruppoStudio.getId()));
        for (Studente studente : mockStudenti.values())
        {
            assertNull(studente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        }
        assertEquals(numeroGruppiStudioTotali - 1, studyHub.getGruppiStudio().size());
        assertEquals(numeroGruppiStudioStudente - 1, mockStudente.getMappaGruppiStudio().size());
    }

    //UC6
    //Test iscrizioneGruppoStudio
    @Test
    public void testIscrizioneGruppoStudio()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo2")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        System.out.println(mockGruppoStudio.getNome());
        int numeroStudenti = mockGruppoStudio.getNumeroStudenti();
        int numeroGruppiStudio = mockStudente.getMappaGruppiStudio().size();
        String simulatedInput = "Gruppo2\n1111\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.iscrizioneGruppoStudio();
        assertNotNull(mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertNotNull(mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(mockGruppoStudio, mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertEquals(mockStudente, mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
        assertEquals(numeroGruppiStudio + 1, mockStudente.getMappaGruppiStudio().size());
        assertEquals(numeroStudenti + 1, mockGruppoStudio.getNumeroStudenti());
    }

    //Test selezionaGruppoStudioIscritto
    @Test
    public void testSelezionaGruppoStudioIscritto()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo4")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        System.out.println(mockGruppoStudio.getNome());
        String simulatedInput = mockGruppoStudio.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        GruppoStudio mockGruppoStudio2 = studyHub.selezionaGruppoStudioIscritto();
        assertNotNull(mockGruppoStudio2);
        assertEquals(mockGruppoStudio, mockGruppoStudio2);
    }

    //Test selezionaGruppoStudio
    @Test
    public void testSelezionaGruppoStudio()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo4")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        System.out.println(mockGruppoStudio.getNome());
        String simulatedInput = mockGruppoStudio.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        GruppoStudio mockGruppoStudio2 = studyHub.selezionaGruppoStudio();
        assertNotNull(mockGruppoStudio2);
        assertEquals(mockGruppoStudio, mockGruppoStudio2);
        mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo3")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        System.out.println(mockGruppoStudio.getNome());
        simulatedInput = mockGruppoStudio.getId() + "\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockGruppoStudio2 = studyHub.selezionaGruppoStudio();
        assertNotNull(mockGruppoStudio2);
        assertEquals(mockGruppoStudio, mockGruppoStudio2);
    }

    //Test eliminaIscrizioneGruppoStudio
    @Test
    public void testEliminaIscrizioneGruppoStudio()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome() == "Gruppo4")
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        int numeroGruppiStudio = mockStudente.getMappaGruppiStudio().size();
        int numeroStudenti = mockGruppoStudio.getNumeroStudenti();
        String simulatedInput = mockGruppoStudio.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaIscrizioneGruppoStudio();
        assertEquals(numeroGruppiStudio - 1, mockStudente.getMappaGruppiStudio().size());
        assertEquals(numeroStudenti - 1, mockGruppoStudio.getNumeroStudenti());
        assertNull(mockStudente.getMappaGruppiStudio().get(mockGruppoStudio.getId()));
        assertNull(mockGruppoStudio.getMappaStudenti().get(mockStudente.getId()));
    }

    //UC7
    //Test selezionaCorsoCreato
    @Test
    public void testSelezionaCorsoCreato()
    {
        studyHub.setStudente(mockStudente);
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
        studyHub.setCorsoSelezionato(mockCorso);
        String simulatedInput = "Lezione 1\npdf\ncontenuto.pdf\n25\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Contenuto mockContenuto = studyHub.caricaContenuto();
        assertNotNull(studyHub.getCorsoSelezionato().getMappaContenuti().get(mockContenuto.getId()));
        assertEquals(mockContenuto, studyHub.getCorsoSelezionato().getMappaContenuti().get(mockContenuto.getId()));
    }

    //Test controllaContenuto
    @Test
    public void testControllaContenuto()
    {
        studyHub.setCorsoSelezionato(mockCorso);
        int numeroContenuti = mockCorso.getMappaContenuti().size();
        String simulatedInput = "Lezione 1\njpg\ncontenuto.pdf\n25\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Contenuto mockContenuto = studyHub.caricaContenuto();
        assertNull(mockContenuto);
        assertEquals(numeroContenuti, mockCorso.getMappaContenuti().size());
        simulatedInput = "Lezione 1\npdf\ncontenuto.pdf\n40\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        mockContenuto = studyHub.caricaContenuto();
        assertNull(mockContenuto);
        assertEquals(numeroContenuti, mockCorso.getMappaContenuti().size());
    }

    //Test eliminaContenuto
    @Test
    public void testEliminaContenuto()
    {
        studyHub.setCorsoSelezionato(mockCorso);
        studyHub.setStudente(studyHub.getStudenti().get(mockCorso.getCreatore()));
        Contenuto mockContenuto = mockCorso.getMappaContenuti().values().iterator().next();
        int numeroContenuti = mockCorso.getMappaContenuti().size();
        String simulatedInput = mockCorso.getId() + "\n" + mockContenuto.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaContenuto();
        assertEquals(numeroContenuti - 1, mockCorso.getMappaContenuti().size());
        assertNull(mockCorso.getMappaContenuti().get(mockContenuto.getId()));
    }

    //UC8
    //Test caricaAppunto
    @Test
    public void testCaricaAppunto() {
        studyHub.setStudente(mockStudente);
        String simulatedInput = "Appunto di Matematica\nPDF\nappunti_matematica.pdf\n30\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.setScanner(new Scanner(inputStream));
        Appunto mockAppunto = studyHub.caricaAppunto();
        assertNotNull(mockStudente.getMappaAppunti());
        assertEquals(mockAppunto, mockStudente.getMappaAppunti().get(mockAppunto.getId()));
    }

    //Test controllaAppunto
    @Test
    public void testControllaAppunto()
    {
        studyHub.setStudente(mockStudente);
        Appunto mockAppunto = mockStudente.getMappaAppunti().values().iterator().next();
        int numeroAppunti = mockStudente.getMappaAppunti().size();
        String simulatedInput = mockAppunto.getTitolo() + "\nJPG\nappunti_matematica.pdf\n30\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.setScanner(new Scanner(inputStream));
        assertNull(studyHub.caricaAppunto());
        assertEquals(numeroAppunti, mockStudente.getMappaAppunti().size());
    }

    //Test eliminaAppunto e selezionaAppunto
    @Test
    public void testEliminaAppunto()
    {
        studyHub.setStudente(mockStudente);
        Appunto mockAppunto = mockStudente.getMappaAppunti().values().iterator().next();
        int numeroAppunti = mockStudente.getMappaAppunti().size();
        String simulatedInput = mockAppunto.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaAppunto();
        assertEquals(numeroAppunti - 1, mockStudente.getMappaAppunti().size());
        assertNull(mockStudente.getMappaAppunti().get(mockAppunto.getId()));
    }

    //Test caricaAppuntoGruppoStudio e eliminaAppuntoGruppoStudio
    @Test
    public void testAppuntoGruppoStudio()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome().equals("Gruppo4"))
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        Appunto mockAppunto = mockStudente.getMappaAppunti().values().iterator().next();
        int numeroAppunti = mockGruppoStudio.getMappaAppunti().size();
        int numeroAppuntiStudente = mockStudente.getMappaAppunti().size();
        String simulatedInput = mockGruppoStudio.getId() + "\n2\n" + mockAppunto.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.caricaAppuntoGruppoStudio();
        assertNotNull(mockGruppoStudio.getMappaAppunti().get(mockAppunto.getId()));
        assertEquals(mockAppunto, mockGruppoStudio.getMappaAppunti().get(mockAppunto.getId()));
        assertEquals(numeroAppunti + 1, mockGruppoStudio.getMappaAppunti().size());
        assertEquals(numeroAppuntiStudente, mockStudente.getMappaAppunti().size());
        simulatedInput = mockGruppoStudio.getId() + "\n1\nmockAppunto\npdf\nappunti.pdf\n" + 30 + "\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.caricaAppuntoGruppoStudio();
        Appunto mockAppunto2 = null;
        for (Appunto appunto : mockGruppoStudio.getMappaAppunti().values())
        {
            if (appunto.getTitolo().equals("mockAppunto"))
            {
                mockAppunto2 = appunto;
            }
        }
        assertNotNull(mockGruppoStudio.getMappaAppunti().get(mockAppunto2.getId()));
        assertEquals(numeroAppunti + 2, mockGruppoStudio.getMappaAppunti().size());
        assertEquals(numeroAppuntiStudente + 1, mockStudente.getMappaAppunti().size());
        simulatedInput = mockGruppoStudio.getId() + "\n" + mockAppunto.getId() + "\n1\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaAppuntoGruppoStudio();
        assertNull(mockGruppoStudio.getMappaAppunti().get(mockAppunto.getId()));
        assertEquals(numeroAppunti + 1, mockGruppoStudio.getMappaAppunti().size());
        assertNull(mockStudente.getMappaAppunti().get(mockAppunto.getId()));
        assertEquals(numeroAppuntiStudente, mockStudente.getMappaAppunti().size());
        simulatedInput = mockGruppoStudio.getId() + "\n" + mockAppunto2.getId() + "\n2\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaAppuntoGruppoStudio();
        assertNull(mockGruppoStudio.getMappaAppunti().get(mockAppunto2.getId()));
        assertEquals(numeroAppunti, mockGruppoStudio.getMappaAppunti().size());
        assertNotNull(mockStudente.getMappaAppunti().get(mockAppunto2.getId()));
        assertEquals(numeroAppuntiStudente, mockStudente.getMappaAppunti().size());
    }

    //UC9
    //test downloadContenuto ed eliminaContenutoScaricato
    @Test
    public void testDownloadContenuto()
    {
        studyHub.setStudente(mockStudente);
        studyHub.setCorsoSelezionato(mockCorso2);
        Contenuto mockContenuto = mockCorso2.getMappaContenuti().values().iterator().next();
        int numeroContenuti = mockStudente.getMappaContenuti().size();
        String simulatedInput = mockCorso2.getId() + "\n" + mockContenuto.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.downloadContenuto();
        assertNotNull(mockStudente.getMappaContenuti().get(mockContenuto.getId()));
        assertEquals(mockContenuto, mockStudente.getMappaContenuti().get(mockContenuto.getId()));
        assertEquals(numeroContenuti + 1, mockStudente.getMappaContenuti().size());
        simulatedInput = mockContenuto.getId() + "\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaContenutoScaricato();
        assertNull(mockStudente.getMappaContenuti().get(mockContenuto.getId()));
        assertEquals(numeroContenuti, mockStudente.getMappaContenuti().size());
    }

    //Test downloadAppunto ed eliminaAppuntoScaricato
    @Test
    public void testDownloadAppunto()
    {
        studyHub.setStudente(mockStudente);
        GruppoStudio mockGruppoStudio = null;
        for (GruppoStudio gruppoStudio : studyHub.getGruppiStudio().values())
        {
            if (gruppoStudio.getNome().equals("Gruppo4"))
            {
                mockGruppoStudio = gruppoStudio;
            }
        }
        Appunto mockAppunto = mockStudente.getMappaAppunti().values().iterator().next();
        String simulatedInput = mockGruppoStudio.getId() + "\n2\n" + mockAppunto.getId() + "\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.caricaAppuntoGruppoStudio();
        assertEquals(1, mockGruppoStudio.getMappaAppunti().size());
        assertNotNull(mockGruppoStudio.getMappaAppunti().get(mockAppunto.getId()));
        Studente mockStudente2 = null;
        for (Studente studente : mockGruppoStudio.getMappaStudenti().values())
        {
            if (!studente.getId().equals(mockStudente.getId()))
            {
                System.out.println(studente.getUsername());
                mockStudente2 = studente;
            }
        }
        studyHub.setStudente(mockStudente2);
        int numeroAppunti = mockStudente2.getMappaAppuntiScaricati().size();
        simulatedInput = mockGruppoStudio.getId() + "\n" + mockAppunto.getId() + "\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.downloadAppunto();
        assertNotNull(mockStudente2.getMappaAppuntiScaricati().get(mockAppunto.getId()));
        assertEquals(mockAppunto, mockStudente2.getMappaAppuntiScaricati().get(mockAppunto.getId()));
        assertEquals(numeroAppunti + 1, mockStudente2.getMappaAppuntiScaricati().size());
        simulatedInput = mockAppunto.getId() + "\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        studyHub.eliminaAppuntoScaricato();
        assertNull(mockStudente2.getMappaAppuntiScaricati().get(mockAppunto.getId()));
        assertEquals(numeroAppunti, mockStudente2.getMappaAppuntiScaricati().size());
    }
}