package com.example;

import java.util.*;

public class StudyHub 
{
    //Creazione di un singleton per la classe StudyHub
    private static StudyHub instance;
    //Studente che utilizza l'applicazione
    private Studente studenteCorrente;
    //Mappe per la memorizzazione dei dati
    private Map<String, Corso> mappaCorsiTotali;
    private Map<String, Studente> studenti;
    private Map<String, Appunto> appunti;
    private Map<String, GruppoStudio> gruppiStudio;
    //Corso selezionato durante una ricerca o un'iscrizione
    private Corso corsoSelezionato;
    //Scanner per l'input da tastiera
    private static Scanner scanner = new Scanner(System.in);
    //Booleano per la verifica del login
    boolean isLogged = false;

    //Costruttore privato per la classe StudyHub
    private StudyHub()
    {
        //Inizializzazione delle mappe
        this.appunti = new HashMap<String, Appunto>();
        this.studenti = new HashMap<String, Studente>();
        this.mappaCorsiTotali = new HashMap<String, Corso>();
        this.gruppiStudio = new HashMap<String, GruppoStudio>();
        //Inizializzazione dello studente, del corso selezionato e del login
        this.studenteCorrente = null;
        this.corsoSelezionato = null;
        this.isLogged = false;
        //Caricamento dei dati di prova
        loadData();
    }

    //Funzione per caricare dei dati di prova
    public void loadData()
    {
        //Ripulisco prima tutti i dati
        for (Corso corso : mappaCorsiTotali.values())
        {
            corso.getMappaIscrizioni().clear();
            corso.getMappaContenuti().clear();
        }
        for (Studente stud : studenti.values())
        {
            stud.getMappaIscrizioni().clear();
            stud.getMappaDatiPagamento().clear();
            stud.getMappaAppunti().clear();
            stud.getMappaCorsiCreati().clear();
            stud.getMappaGruppiStudio().clear();
        }
        for (GruppoStudio gruppo : gruppiStudio.values())
        {
            gruppo.getMappaStudenti().clear();
        }
        studenti.clear();
        mappaCorsiTotali.clear();
        appunti.clear();
        gruppiStudio.clear();
        //Dati sugli studenti
        Studente studente1 = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Studente studente2 = new Studente("MarioRossi", "1111", "Mario", "Rossi", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studenti.put(studente1.getId(), studente1);
        studenti.put(studente2.getId(), studente2);
        //Dati sui pagamenti
        studente1.creaDatiPagamento("Carta di credito", "1234-5678-1234-5678", "Nicolò", "Mazzola");
        studente2.creaDatiPagamento("Carta di credito", "1234-5678-1234-5678", "Mario", "Rossi");
        //Dati sui corsi
        Corso corso1 = new Corso("Matematica", "Laurea Magistrale", 0, studente1.getId(), "Italiano", 30, 30);
        studente1.aggiungiCorsoCreato(corso1);
        Corso corso2 = new Corso("Fisica", "Laurea Triennale", 10, studente2.getId(), "Inglese", 30, 30);
        studente2.aggiungiCorsoCreato(corso2);
        Corso corso3 = new Corso("Inglese", "Liceo", 0, studente1.getId(), "Italiano", 30, 30);
        studente1.aggiungiCorsoCreato(corso3);
        Corso corso4 = new Corso("Italiano", "Laurea Triennale", 20, studente1.getId(), "Italiano", 30, 30);
        studente1.aggiungiCorsoCreato(corso4);
        Corso corso5 = new Corso("Storia", "Liceo", 0, studente2.getId(), "Inglese", 30, 30);
        studente2.aggiungiCorsoCreato(corso5);
        //Mappe per i corsi
        mappaCorsiTotali.put(corso1.getId(), corso1);
        mappaCorsiTotali.put(corso2.getId(), corso2);
        mappaCorsiTotali.put(corso3.getId(), corso3);
        mappaCorsiTotali.put(corso4.getId(), corso4);
        mappaCorsiTotali.put(corso5.getId(), corso5);
        //Dati sulle iscrizioni
        Iscrizione iscrizione1 = new Iscrizione(studente2.getId(), corso1.getId());
        studente2.aggiungiIscrizione(corso1, iscrizione1);
        corso1.aggiungiIscrizione(studente2, iscrizione1);
        DatiPagamento datiPagamento1 = studente1.getMappaDatiPagamento().get("1234-5678-1234-5678");
        Iscrizione iscrizione2 = new Iscrizione(studente1.getId(), corso2.getId());
        studente1.aggiungiIscrizione(corso2, iscrizione2);
        corso2.aggiungiIscrizione(studente1, iscrizione2);
        Pagamento pagamentoIscrizione1 = new Pagamento(corso2.getCosto(), datiPagamento1);
        iscrizione2.aggiungiPagamento(pagamentoIscrizione1);
        Iscrizione iscrizione3 = new Iscrizione(studente2.getId(), corso3.getId());
        studente2.aggiungiIscrizione(corso3, iscrizione3);
        corso3.aggiungiIscrizione(studente2, iscrizione3);
        DatiPagamento datiPagamento2 = studente2.getMappaDatiPagamento().get("1234-5678-1234-5678");
        Iscrizione iscrizione4 = new Iscrizione(studente2.getId(), corso4.getId());
        studente2.aggiungiIscrizione(corso4, iscrizione4);
        corso4.aggiungiIscrizione(studente2, iscrizione4);
        Pagamento pagamentoIscrizione2 = new Pagamento(corso4.getCosto(), datiPagamento2);
        iscrizione4.aggiungiPagamento(pagamentoIscrizione2);
        //Dati sugli appunti
        Appunto appunto1 = new Appunto(studente1.getId() ,"Appunto1", "pdf", "appunto1.pdf", 10);
        Appunto appunto2 = new Appunto(studente2.getId(), "Appunto2", "pdf", "appunto2.pdf", 10);
        Appunto appunto3 = new Appunto(studente1.getId(), "Appunto3", "pdf", "appunto3.pdf", 10);
        //Dati sugli appunti degli studenti
        appunti.put(appunto1.getId(), appunto1);
        studente1.aggiungiAppunto(appunto1);
        appunti.put(appunto2.getId(), appunto2);
        studente2.aggiungiAppunto(appunto2);
        appunti.put(appunto3.getId(), appunto3);
        studente1.aggiungiAppunto(appunto3);
        //Dati sui contenuti
        Contenuto contenuto1 = new Contenuto("Contenuto1", "pdf", "contenuto1.pdf", 10);
        Contenuto contenuto2 = new Contenuto("Contenuto2", "pdf", "contenuto2.pdf", 10);
        Contenuto contenuto3 = new Contenuto("Contenuto3", "pdf", "contenuto3.pdf", 10);
        Contenuto contenuto4 = new Contenuto("Contenuto4", "pdf", "contenuto4.pdf", 10);
        Contenuto contenuto5 = new Contenuto("Contenuto5", "pdf", "contenuto5.pdf", 10);
        Contenuto contenuto6 = new Contenuto("Contenuto6", "pdf", "contenuto6.pdf", 10);
        //Dati sui contenuti dei corsi
        corso1.aggiungiContenuto(contenuto1);
        corso1.aggiungiContenuto(contenuto6);
        corso2.aggiungiContenuto(contenuto2);
        corso3.aggiungiContenuto(contenuto3);
        corso4.aggiungiContenuto(contenuto4);
        corso5.aggiungiContenuto(contenuto5);
        //Dati sui gruppi studio
        GruppoStudio gruppo1 = new GruppoStudio("Gruppo1", studente1.getId(), "1111", "Italiano", 30, 10);
        GruppoStudio gruppo2 = new GruppoStudio("Gruppo2", studente2.getId(), "1111", "Italiano", 30, 10);
        GruppoStudio gruppo3 = new GruppoStudio("Gruppo3", studente1.getId(), "1111", "Italiano", 30, 10);
        GruppoStudio gruppo4 = new GruppoStudio("Gruppo4", studente2.getId(), "1111", "Italiano", 30, 10);
        gruppo1.aggiungiStudente(studente1);
        gruppo1.aggiungiStudente(studente2);
        studente1.aggiungiGruppoStudio(gruppo1);
        studente2.aggiungiGruppoStudio(gruppo1);
        gruppo2.aggiungiStudente(studente2);
        studente2.aggiungiGruppoStudio(gruppo2);
        gruppo3.aggiungiStudente(studente1);
        gruppo3.aggiungiStudente(studente2);
        studente1.aggiungiGruppoStudio(gruppo3);
        studente2.aggiungiGruppoStudio(gruppo3);
        gruppo4.aggiungiStudente(studente1);
        gruppo4.aggiungiStudente(studente2);
        studente1.aggiungiGruppoStudio(gruppo4);
        studente2.aggiungiGruppoStudio(gruppo4);
        gruppiStudio.put(gruppo1.getId(), gruppo1);
        gruppiStudio.put(gruppo2.getId(), gruppo2);
        gruppiStudio.put(gruppo3.getId(), gruppo3);
        gruppiStudio.put(gruppo4.getId(), gruppo4);
    }

    //Funzione per ottenre l'istanza di StudyHub
    public static StudyHub getIstance()
    {
        if(instance == null)
        {
            instance = new StudyHub();
        }

        return instance;
    }

    //Funzione per la generazione di un ID univoco
    public static String generaId()
    {
        return UUID.randomUUID().toString();
    }

    // Visualizzazione di un menu di scelta
    public int menu(boolean isLogged)
    {
        int scelta;
        scanner = new Scanner(System.in);
        if (isLogged == false)
        {
            System.out.println("Menu:");
            System.out.println("1. Registrazione");
            System.out.println("2. Login");
            System.out.println("3. Esci");
            System.out.print("Seleziona un'opzione: ");
        }
        else
        {
            System.out.println("Menu:");
            System.out.println("1. Elimina profilo");
            System.out.println("2. Modifica profilo");
            System.out.println("3. Crea o elimina un corso");
            System.out.println("4. Iscriviti o disiscriviti ad un corso");
            System.out.println("5. Crea o elimina un gruppo studio");
            System.out.println("6. Iscriviti o disiscriviti ad un gruppo studio");
            System.out.println("7. Carica o elimina un contenuto");
            System.out.println("3. Carica o elimina un appunto");
            System.out.println("8. Logout");
            System.out.println("9. Esci");
            System.out.print("Seleziona un'opzione: ");
        }
        scelta = scanner.nextInt();
        scanner.nextLine();
        return scelta;
    }

    //Funzione per ottenere i corsi
    public Map<String, Corso> getMappaCorsiTotali()
    {
        return mappaCorsiTotali;
    }

    //Funzione per settare i corsi
    public void setMappaCorsiTotali(Map<String, Corso> mappaCorsiTotali)
    {
        this.mappaCorsiTotali = mappaCorsiTotali;
    }

    //Funzione per ottenere gli studenti
    public Map<String, Studente> getStudenti()
    {
        return studenti;
    }

    //Funzione per settare gli studenti
    public void setStudenti(Map<String, Studente> studenti)
    {
        this.studenti = studenti;
    }

    //Funzione per ottenere gli appunti
    public Map<String, Appunto> getAppunti()
    {
        return appunti;
    }

    //Funzione per ottenere i gruppi di studio
    public Map<String, GruppoStudio> getGruppiStudio()
    {
        return gruppiStudio;
    }

    //Funzione per settare i gruppi di studio
    public void setGruppiStudio(Map<String, GruppoStudio> gruppiStudio)
    {
        this.gruppiStudio = gruppiStudio;
    }

    //Funzione per ottenere lo studente loggato
    public Studente getStudente()
    {
        return studenteCorrente;
    }

    //Funzione per settare lo studente loggato
    public void setStudente(Studente studente)
    {
        this.studenteCorrente = studente;
    }

    //Funzione per ottenere il corso selezionato
    public Corso getCorsoSelezionato()
    {
        return corsoSelezionato;
    }

    //Funzione per settare il corso selezionato
    public void setCorsoSelezionato(Corso corsoSelezionato)
    {
        this.corsoSelezionato = corsoSelezionato;
    }

    //Funzione per ottenere lo status del login
    public boolean getIsLogged()
    {
        return isLogged;
    }

    //Funzione per settare lo status del login
    public void setIsLogged(boolean isLogged)
    {
        this.isLogged = isLogged;
    }

    //Main
    public static void main(String[] args) 
    {
        StudyHub studyHub = new StudyHub();
        boolean running = true;
        int scelta;
        Runnable action;

        do 
        {
            scelta = studyHub.menu(studyHub.isLogged);
            if (studyHub.isLogged == false) 
            {
                switch (scelta) 
                {
                    case 1:
                        System.out.println("Hai selezionato Registrazione");
                        studyHub.isLogged = studyHub.creaProfilo();
                        break;
                    case 2:
                        System.out.println("Hai selezionato Login");
                        studyHub.isLogged = studyHub.login();
                        break;
                    case 3:
                        System.out.println("Uscita dal programma...");
                        running = false;
                        break;
                    case 4:
                        System.out.println("Visualizzazione di tutti i dati");
                        studyHub.visualizzaTuttiIDati();
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            }
            else 
            {
                switch (scelta) 
                {
                    case 1:
                        System.out.println("Hai selezionato Elimina profilo");
                        studyHub.eliminaProfilo();
                        break;
                    case 2:
                        System.out.println("Hai selezionato Modifica profilo");
                        studyHub.modificaProfilo();
                        break;
                    case 3:
                        System.out.println("Hai selezionato Crea o elimina un corso");
                        System.out.println("Scegli un'opzione: ");
                        System.out.println("1. Crea un corso");
                        System.out.println("2. Elimina un corso");
                        action = studyHub.sceltaOpzione() == 1 ? () -> studyHub.creaCorso() : () -> studyHub.eliminaCorso();
                        action.run();
                        break;
                    case 4:
                        System.out.println("Hai selezionato Iscrizione o disiscrizione ad un corso");
                        System.out.println("Scelta un'opzione: ");
                        System.out.println("1. Iscrizione ad un corso");
                        System.out.println("2. Disiscrizione da un corso");
                        action = studyHub.sceltaOpzione() == 1 ? () -> studyHub.iscrizioneCorso() : () -> studyHub.eliminaIscrizione();
                        action.run();
                        break;
                    case 5:
                        System.out.println("Hai selezionato Crea o elimina un gruppo studio");
                        System.out.println("Scegli un'opzione: ");
                        System.out.println("1. Crea un gruppo di studio");
                        System.out.println("2. Elimina un gruppo di studio");
                        action = studyHub.sceltaOpzione() == 1 ? () -> studyHub.creaGruppoStudio() : () -> studyHub.eliminaGruppoStudio();
                        action.run();
                        break;
                    case 6:
                        System.out.println("Hai selezionato Iscrizione o disiscrizione ad un gruppo studio");
                        System.out.println("Scelta un'opzione: ");
                        System.out.println("1. Iscrizione ad un gruppo studio");
                        System.out.println("2. Disiscrizione da un gruppo studio");
                        action = studyHub.sceltaOpzione() == 1 ? () -> studyHub.iscrizioneGruppoStudio() : () -> studyHub.eliminaIscrizioneGruppoStudio();
                        action.run();
                        break;
                    case 7:
                        System.out.println("Hai selezionato Carica o elimina contenuto");
                        System.out.println("Scegli un'opzione: ");
                        System.out.println("1. Carica un contenuto");
                        System.out.println("2. Elimina un contenuto");
                        action = studyHub.sceltaOpzione() == 1 ? () -> studyHub.caricaContenuto() : () -> studyHub.eliminaContenuto();
                        action.run();
                        break;
                    case 8:
                        System.out.println("Hai selezionato Carica o elimina appunto");
                        System.out.println("Scegli un'opzione: ");
                        System.out.println("1. Carica un appunto");
                        System.out.println("2. Elimina un appunto");
                        action = studyHub.sceltaOpzione() == 1 ? () -> studyHub.caricaAppunto() : () -> studyHub.eliminaAppunto();
                        action.run();
                        break;            
                    case 9:
                        System.out.println("Hai selezionato Logout");
                        studyHub.studenteCorrente = null;
                        studyHub.isLogged = false;
                        break;
                    case 10:
                        System.out.println("Uscita dal programma...");
                        running = false;
                        break;
                    case 11: 
                        System.out.println("Visualizzazione di tutti i dati");
                        studyHub.visualizzaTuttiIDati();
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            }
        } while (running);
        scanner.close();
    }

    //Funzione per scegliere l'opzione
    public int sceltaOpzione()
    {
        int opzione;
        do
        {
            opzione = scanner.nextInt();
        } while (opzione != 1 && opzione != 2);
        return opzione;
    }

    //Funzione per il login di uno studente
    public boolean login()
    {
        scanner = new Scanner(System.in);
        String username;
        String password;
        boolean login = false;
        System.out.println("Inserisci username: ");
        username = scanner.nextLine();
        System.out.println("Inserisci password: ");
        password = scanner.nextLine();

        for(Studente stud: studenti.values())
        {
            if(stud.getUsername().equals(username) && stud.verificaPassword(password))
            {
                login = true;
                studenteCorrente = stud;
                System.out.println("Login effettuato con successo");
                System.out.println("Benvenuto " + studenteCorrente.getNome() + " " + studenteCorrente.getCognome());
            }
        }

        if (login == false)
        {
            System.out.println("Username o password errati");
        }
        return login;
    }

    //Funzione per l'inserimento dei dati dello studente
    public Studente datiProfilo()
    {
        scanner = new Scanner(System.in);
        String username;
        String password;
        String nome;
        String cognome;
        String dataNascita;
        String luogoNascita;
        String residenza;
        String livello;

        System.out.println("Inserisci lo username: ");
        username = scanner.nextLine();
        System.out.println("Inserisci la password: ");
        password = scanner.nextLine();
        System.out.println("Inserisci il nome: ");
        nome = scanner.nextLine();
        System.out.println("Inserisci il cognome: ");
        cognome = scanner.nextLine();
        System.out.println("Inserisci la data di nascita: ");
        dataNascita = scanner.nextLine();
        System.out.println("Inserisci il luogo di nascita: ");
        luogoNascita = scanner.nextLine();
        System.out.println("Inserisci la residenza: ");
        residenza = scanner.nextLine();
        System.out.println("Inserisci il livello: ");
        livello = scanner.nextLine();
        Studente stud = new Studente(username, password, nome, cognome, dataNascita, luogoNascita, residenza, livello);
        return stud;
    }

    //UC1: Iscrizione/eliminazione profilo
    
    //Funzione per la creazione di un profilo
    public boolean creaProfilo()
    {
        Studente stud = datiProfilo();
        if (stud == null)
        {
            return false;
        }
        if (!controllaDatiProfilo(stud))
        {
            System.out.println("Dati mancanti");
            return false;
        }
        if (!controllaUsername(stud.getUsername()))
        {
            System.out.println("Username già esistente");
            return false;
        }
        studenti.put(stud.getId(), stud);
        studenteCorrente = stud;
        System.out.println("Profilo creato con successo");
        return true;
    }

    //Funzione per il controllo dei dati del profilo
    public boolean controllaDatiProfilo(Studente stud)
    {
        if(stud.getUsername().isEmpty() || stud.getPassword().isEmpty() || stud.getNome().isEmpty() || stud.getCognome().isEmpty() || stud.getDataNascita().isEmpty() || stud.getLuogoNascita().isEmpty() || stud.getResidenza().isEmpty() || stud.getLivello().isEmpty())
        {
            return false;
        }
        return true;
    }

    //Funzione per il controllo dell'unicità dello username
    public boolean controllaUsername(String username)
    {
        for(Studente stud: studenti.values())
        {
            if(stud.getUsername().equals(username))
            {
                return false;
            }
        }
        return true;
    }

    //Funzione per l'eliminazione del profilo
    public void eliminaProfilo()
    {
        Iterator<Map.Entry<String, Corso>> corsoIterator = mappaCorsiTotali.entrySet().iterator();
        while (corsoIterator.hasNext())
        {
            Map.Entry<String, Corso> entry = corsoIterator.next();
            Corso corso = entry.getValue();
            if (corso.getCreatore().equals(studenteCorrente.getId()))
            {
                corsoIterator.remove();
                for (Studente stud : studenti.values())
                {
                    if (stud.getMappaIscrizioni().containsKey(corso.getId()))
                    {
                        corso.rimuoviIscrizione(stud);
                        stud.rimuoviIscrizione(corso);
                    }
                }
                corso.getMappaIscrizioni().clear();
                corso.getMappaContenuti().clear();
            }
            else if (corso.getMappaIscrizioni().containsKey(studenteCorrente.getId()))
            {
                corso.rimuoviIscrizione(studenteCorrente);
            }
        }
        Iterator<Map.Entry<String, GruppoStudio>> gruppoIterator = gruppiStudio.entrySet().iterator();
        while (gruppoIterator.hasNext())
        {
            Map.Entry<String, GruppoStudio> entry = gruppoIterator.next();
            GruppoStudio gruppoStudio = entry.getValue();
            if (gruppoStudio.getAdmin().equals(studenteCorrente.getId()))
            {
                for (Studente stud : new ArrayList<>(gruppoStudio.getMappaStudenti().values()))
                {
                    stud.rimuoviGruppoStudio(gruppoStudio);
                    gruppoStudio.rimuoviStudente(stud);
                }
                gruppoIterator.remove();
            }
            else if (gruppoStudio.getMappaStudenti().containsKey(studenteCorrente.getId()))
            {
                gruppoStudio.rimuoviStudente(studenteCorrente);
            }
        }
        Iterator<Map.Entry<String, Appunto>> appuntiIterator = appunti.entrySet().iterator();
        while (appuntiIterator.hasNext())
        {
            Map.Entry<String, Appunto> entry = appuntiIterator.next();
            if (entry.getValue().getCreatore().equals(studenteCorrente.getId()))
            {
                appuntiIterator.remove();
            }
        }
        studenteCorrente.getMappaIscrizioni().clear();
        studenteCorrente.getMappaDatiPagamento().clear();
        studenteCorrente.getMappaAppunti().clear();
        studenteCorrente.getMappaCorsiCreati().clear();
        studenteCorrente.getMappaGruppiStudio().clear();
        studenti.remove(studenteCorrente.getId());
        studenteCorrente = null;
        corsoSelezionato = null;
        isLogged = false;
        System.out.println("Profilo eliminato con successo");
    }

    //UC2: Modifica profilo

    //Funzione per la modifica del profilo
    public void modificaProfilo()
    {
        Studente stud = datiProfilo();
        if (!stud.getUsername().isEmpty())
        {
            studenteCorrente.setUsername(stud.getUsername());
        }
        if (!stud.getPassword().isEmpty())
        {
            studenteCorrente.setPassword(stud.getPassword());
        }
        if (stud.getNome() != "")
        {
            studenteCorrente.setNome(stud.getNome());
        }
        if (stud.getCognome() != "")
        {
            studenteCorrente.setCognome(stud.getCognome());
        }
        if (stud.getDataNascita() != "")
        {
            studenteCorrente.setDataNascita(stud.getDataNascita());
        }
        if (stud.getLuogoNascita() != "")
        {
            studenteCorrente.setLuogoNascita(stud.getLuogoNascita());
        }
        if (stud.getResidenza() != "")
        {
            studenteCorrente.setResidenza(stud.getResidenza());
        }
        if (stud.getLivello() != "")
        {
            studenteCorrente.setLivello(stud.getLivello());
        }
    }

    //UC3: Creazione di un corso

    //Funzione per la creazione di un corso
    public Corso creaCorso()
    {
        scanner = new Scanner(System.in);
        String nome;
        String livello;
        float costo;
        String lingua;
        int durata;

        System.out.println("Inserisci il nome del corso: ");
        nome = scanner.nextLine();
        System.out.println("Inserisci il livello del corso: ");
        livello = scanner.nextLine();
        System.out.println("Inserisci il costo del corso: ");
        costo = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Inserisci la lingua del corso: ");
        lingua = scanner.nextLine();
        System.out.println("Inserisci la durata del corso: ");
        durata = scanner.nextInt();
        System.out.println("Inserisci la dimensione massima dei contenuti: ");
        int dimensioneMassima = scanner.nextInt();

        if (!controllaNomeCorso(nome))
        {
            System.out.println("Nome corso non valido");
            return null;
        }

        Corso corso = new Corso(nome, livello, costo, studenteCorrente.getId(), lingua, durata, dimensioneMassima);
        studenteCorrente.aggiungiCorsoCreato(corso);
        mappaCorsiTotali.put(corso.getId(), corso);
        System.out.println("Corso creato con successo");
        return corso;
    }

    //Funzione per il controllo del nome del corso
    public boolean controllaNomeCorso(String nome)
    {
        for(Corso corso: mappaCorsiTotali.values())
        {
            if(corso.getNome().equals(nome))
            {
                return false;
            }
            else if(!nome.matches("[a-zA-Z0-9 ]+"))
            {
                return false;
            }
        }
        return true;
    }

    //Funzione per l'eliminazione di un corso
    public void eliminaCorso()
    {
        selezionaCorsoCreato();
        if (corsoSelezionato.getCreatore().equals(studenteCorrente.getId()))
        {
            mappaCorsiTotali.remove(corsoSelezionato.getId());
            studenteCorrente.rimuoviCorsoCreato(corsoSelezionato);
            for(Iscrizione iscrizione : corsoSelezionato.getMappaIscrizioni().values())
            {
                Studente stud = studenti.get(iscrizione.getStudente());
                stud.rimuoviIscrizione(corsoSelezionato);
            }
            corsoSelezionato.getMappaIscrizioni().clear();
            corsoSelezionato.getMappaContenuti().clear();
            corsoSelezionato = null;
        }
        else
        {
            System.out.println("Non sei il creatore del corso");
        }
    }

    //UC4: Iscrizione ad un corso

    // Funzione per la ricerca di un corso a cui iscriversi
    public Map<String, Corso> cercaCorso() 
    {
        scanner = new Scanner(System.in);
        System.out.println("Inserisci i dati relativi al corso: ");
        System.out.println("Inserisci il nome del corso (lascia vuoto se non lo conosci): ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il livello del corso (lascia vuoto se non lo conosci): ");
        String livello = scanner.nextLine();
        System.out.println("Inserisci il creatore del corso (lascia vuoto se non lo conosci): ");
        String creatore = scanner.nextLine();
        System.out.println("Inserisci l'ID del corso (lascia vuoto se non lo conosci): ");
        String id = scanner.nextLine();
        System.out.println("Inserisci la lingua del corso (lascia vuoto se non la conosci): ");
        String lingua = scanner.nextLine();

        Map<String, Corso> mappaCorsiCercati = new HashMap<>();

        if (!id.isEmpty()) 
        {
            Corso corso = mappaCorsiTotali.get(id);
            if (corso != null) 
            {
                mappaCorsiCercati.put(id, corso);
                return mappaCorsiCercati;
            } 
        }
        else 
        {
            for (Corso corso : mappaCorsiTotali.values()) 
            {
                boolean nomeCorrisponde = nome.isEmpty() || corso.getNome().equalsIgnoreCase(nome);
                boolean livelloCorrisponde = livello.isEmpty() || corso.getLivello().equalsIgnoreCase(livello);
                boolean linguaCorrisponde = lingua.isEmpty() || corso.getLingua().equalsIgnoreCase(lingua);
                boolean creatoreCorrisponde = creatore.isEmpty() || corso.getCreatore().equalsIgnoreCase(creatore);

                if (nomeCorrisponde && livelloCorrisponde && linguaCorrisponde && creatoreCorrisponde) 
                {
                    mappaCorsiCercati.put(corso.getId(), corso);
                }
            }
        }

        if (mappaCorsiCercati.isEmpty()) 
        {
            System.out.println("Nessun corso trovato con i criteri forniti.");
        }
        return mappaCorsiCercati;
    }

    //Funzione per selezionare un corso da quelli cercati
    public void selezionaCorso(Map<String, Corso> mappaCorsiCercati)
    {
        scanner = new Scanner(System.in);
        if (mappaCorsiCercati.isEmpty())
        {
            System.out.println("Nessun corso trovato");
            return;
        }
        if (mappaCorsiCercati.size() == 1)
        {
            corsoSelezionato = mappaCorsiCercati.values().iterator().next();
            return;
        }
        System.out.println("I corsi trovati sono: ");
        for(Corso corso: mappaCorsiCercati.values())
        {
            System.out.println(corso.getNome());
            System.out.println(corso.getId());
        }

        System.out.println("Inserisci l'id di un corso: ");
        String id = scanner.nextLine();
        corsoSelezionato = mappaCorsiCercati.get(id);
    }

    //Funzione per l'iscrizione ad un corso
    public void iscrizioneCorso()
    {
        selezionaCorso(cercaCorso());
        if (!controllaIscrizione(corsoSelezionato))
        {
            System.out.println("Sei già iscritto a questo corso");
            return;
        }
        float costo = corsoSelezionato.getCosto();
        if (costo == 0)
        {
            Iscrizione iscrizione = new Iscrizione(studenteCorrente.getId(), corsoSelezionato.getId());
            aggiungiIscrizione(iscrizione);
        }
        else
        {
            Iscrizione iscrizione = pagamentoIscrizione(costo);
            if (iscrizione == null)
            {
                System.out.println("Pagamento non andato a buon fine");
            }
        }
    }

    //Funzione per il controllo dell'iscrizione ad un corso
    public boolean controllaIscrizione(Corso corso)
    {
        for(Iscrizione iscrizione: studenteCorrente.getMappaIscrizioni().values())
        {
            if(iscrizione.getCorso().equals(corso.getId()) || corso.getCreatore().equals(studenteCorrente.getId()))
            {
                return false;
            }
        }
        return true;
    }

    //Funzione per il pagamento dell'iscrizione
    public Iscrizione pagamentoIscrizione(float costo)
    {
        boolean confermaPagamento = false;

        DatiPagamento datiPagamento = studenteCorrente.usaDatiPagamento();

        if(datiPagamento == null)
        {
            System.out.println("Non hai inserito i dati di pagamento");
            return null;
        }

        // Presumiamo che sia sempre vero anche se serve un sistema di pagamento esterno
        confermaPagamento = true;

        if(confermaPagamento)
        {
            Iscrizione iscrizione = new Iscrizione(studenteCorrente.getId(), corsoSelezionato.getId());
            aggiungiIscrizione(iscrizione);

            Pagamento pagamento = new Pagamento(costo, datiPagamento);

            iscrizione.aggiungiPagamento(pagamento);

            System.out.println("Pagamento effettuato con successo");
            System.out.println("Iscrizione avvenuta con successo");
            return iscrizione;
        }
        else
        {
            return null;
        }
    }

    //Funzione per il collegamento di un iscrizione tra studente e corso
    public void aggiungiIscrizione(Iscrizione iscrizione)
    {
        corsoSelezionato.aggiungiIscrizione(studenteCorrente, iscrizione);
        studenteCorrente.aggiungiIscrizione(corsoSelezionato, iscrizione);
        System.out.println("Iscrizione avvenuta con successo");
    }

    //Funzione per la selezione di un corso a cui si è iscritti
    public void selezionaCorsoIscritto()
    {
        scanner = new Scanner(System.in);
        Map<String, Iscrizione> mappaCorsiIscritti = studenteCorrente.getMappaIscrizioni();
        if (mappaCorsiIscritti.isEmpty())
        {
            System.out.println("Non sei iscritto a nessun corso");
            return;
        }

        System.out.println("I tuoi corsi sono: ");
        for(Iscrizione iscrizione: mappaCorsiIscritti.values())
        {
            System.out.print(iscrizione.getCorso() + " ");
            System.out.println(iscrizione.getId());
        }

        do
        {
            System.out.print("Inserisci l'id di un corso: ");
            String id = scanner.nextLine();

            corsoSelezionato = mappaCorsiTotali.get(id);
            if(corsoSelezionato == null)
            {
                System.out.println("Corso non trovato");
            }
        } while(corsoSelezionato == null);
    }

    //Funzione per l'eliminazione di un'iscrizione
    public void eliminaIscrizione()
    {
        selezionaCorsoIscritto();
        if (corsoSelezionato.getMappaIscrizioni().containsKey(studenteCorrente.getId()))
        {
            corsoSelezionato.rimuoviIscrizione(studenteCorrente);
            studenteCorrente.rimuoviIscrizione(corsoSelezionato);
            System.out.println("Iscrizione rimossa con successo");
        }
        else
        {
            System.out.println("Non sei iscritto a questo corso");
        }
    }

    //UC5: Creazione di un gruppo studio

    //Funzione per la creazione di un gruppo studio
    public GruppoStudio creaGruppoStudio()
    {
        scanner = new Scanner(System.in);
        String nome;
        String password;
        String lingua;
        int durata;

        System.out.println("Inserisci il nome del gruppo studio: ");
        nome = scanner.nextLine();
        System.out.println("Inserisci la password del gruppo studio: ");
        password = scanner.nextLine();
        System.out.println("Inserisci la lingua del gruppo studio: ");
        lingua = scanner.nextLine();
        System.out.println("Inserisci la durata del gruppo studio: ");
        durata = scanner.nextInt();
        System.out.println("Inserisci il numero massimo di studenti: ");
        int numeroMaxStudenti = scanner.nextInt();

        if (!controllaNomeGruppo(nome))
        {
            System.out.println("Nome del gruppo studio già esistente");
            return null;
        }
        GruppoStudio gruppoStudio = new GruppoStudio(nome, studenteCorrente.getId(), password, lingua, durata, numeroMaxStudenti);
        gruppoStudio.aggiungiStudente(studenteCorrente);
        studenteCorrente.aggiungiGruppoStudio(gruppoStudio);
        gruppiStudio.put(gruppoStudio.getId(), gruppoStudio);
        System.out.println("Gruppo studio creato con successo");
        return gruppoStudio;
    }

    //Funzione per il controllo del nome del gruppo studio
    public boolean controllaNomeGruppo(String nome)
    {
        for(GruppoStudio gruppoStudio: gruppiStudio.values())
        {
            if(gruppoStudio.getNome().equals(nome))
            {
                return false;
            }
        }
        return true;
    }

    //Funzione per la selezione di un gruppo studio creato
    public GruppoStudio selezionaGruppoStudioCreato()
    {
        scanner = new Scanner(System.in);
        Map<String, GruppoStudio> mappaGruppiStudioCreati = studenteCorrente.getMappaGruppiStudio();
        GruppoStudio gruppoStudioSelezionato = null;
        if (mappaGruppiStudioCreati.isEmpty())
        {
            System.out.println("Non hai creato nessun gruppo studio");
            return null;
        }

        System.out.println("I tuoi gruppi studio sono: ");
        for(GruppoStudio gruppoStudio: mappaGruppiStudioCreati.values())
        {
            System.out.print(gruppoStudio.getNome() + " ");
            System.out.println(gruppoStudio.getId());
        }

        do
        {
            System.out.print("Inserisci l'id di un gruppo studio: ");
            String id = scanner.nextLine();

            gruppoStudioSelezionato = mappaGruppiStudioCreati.get(id);
            if(gruppoStudioSelezionato == null)
            {
                System.out.println("Gruppo studio non trovato");
            }
            else
            {
                return gruppoStudioSelezionato;
            }
        } while(true);
    }

    //Funzione per l'eliminazione di un gruppo studio
    public void eliminaGruppoStudio() {
        GruppoStudio gruppoStudio = selezionaGruppoStudioCreato();
        if (gruppoStudio == null)
        {
            return;
        }
        if (gruppoStudio.getAdmin().equals(studenteCorrente.getUsername()))
        {
            gruppiStudio.remove(gruppoStudio.getId());
            studenteCorrente.rimuoviGruppoStudio(gruppoStudio);
            List<Studente> studentiCopia = new ArrayList<>(gruppoStudio.getMappaStudenti().values());
            for (Studente stud : studentiCopia)
            {
                if (stud.getMappaGruppiStudio().containsKey(gruppoStudio.getId()))
                {
                    gruppoStudio.rimuoviStudente(stud);
                    stud.rimuoviGruppoStudio(gruppoStudio);
                }
            }
            gruppoStudio.getMappaStudenti().clear();
        }
        else
        {
            System.out.println("Non sei l'admin del gruppo studio");
        }
    }

    //UC6: Iscrizione ad un gruppo studio

    //Funzione per l'iscrizione ad un gruppo studio
    public void iscrizioneGruppoStudio()
    {
        scanner = new Scanner(System.in);
        String nome;
        String password;
        boolean trovato = false;

        System.out.println("Inserisci il nome del gruppo studio: ");
        nome = scanner.nextLine();
        System.out.println("Inserisci la password del gruppo studio: ");
        password = scanner.nextLine();

        for(GruppoStudio gruppoStudio: this.gruppiStudio.values())
        {
            if(gruppoStudio.getNome().equals(nome))
            {
                trovato = true;
                if(gruppoStudio.passwordCorretta(password))
                {
                    if (gruppoStudio.verificaIscrizione(studenteCorrente) == false)
                    {
                        if (gruppoStudio.getNumeroStudenti() < gruppoStudio.getNumeroMaxStudenti())
                        {
                            gruppoStudio.aggiungiStudente(studenteCorrente);
                            studenteCorrente.aggiungiGruppoStudio(gruppoStudio);
                            System.out.println("Password corretta, iscrizione avvenuta con successo");
                            System.out.println("Benvenuto nel gruppo studio " + gruppoStudio.getNome());
                            System.out.println("Admin: " + gruppoStudio.getAdmin());
                            System.out.println("Lingua: " + gruppoStudio.getLingua());
                            System.out.println("Numero studenti: " + gruppoStudio.getNumeroStudenti());
                            break;
                        }
                        else
                        {
                            System.out.println("Il gruppo studio è pieno");
                        }
                    }
                    else
                    {
                        System.out.println("Sei già iscritto a questo gruppo studio");
                    }
                }
                else
                {
                    System.out.println("Password errata, iscrizione non avvenuta");
                }
            }
        }
        if(trovato == false)
        {
            System.out.println("Gruppo studio non trovato");
        }
    }

    //Funzione per la selezione di un gruppo studio a cui si è iscritti
    public GruppoStudio selezionaGruppoStudioIscritto()
    {
        scanner = new Scanner(System.in);
        Map<String, GruppoStudio> mappaGruppiStudioIscritti = studenteCorrente.getMappaGruppiStudio();
        GruppoStudio gruppoStudioSelezionato = null;
        if (mappaGruppiStudioIscritti.isEmpty())
        {
            System.out.println("Non sei iscritto a nessun gruppo studio");
            return null;
        }

        System.out.println("I tuoi gruppi studio sono: ");
        for(GruppoStudio gruppoStudio: mappaGruppiStudioIscritti.values())
        {
            System.out.print(gruppoStudio.getNome() + " ");
            System.out.println(gruppoStudio.getId());
        }

        do
        {
            System.out.print("Inserisci l'id di un gruppo studio: ");
            String id = scanner.nextLine();

            gruppoStudioSelezionato = mappaGruppiStudioIscritti.get(id);
            if(gruppoStudioSelezionato == null)
            {
                System.out.println("Gruppo studio non trovato");
            }
            else
            {
                return gruppoStudioSelezionato;
            }
        } while(true);
    }

    //Funzione per l'eliminazione di un'iscrizione ad un gruppo studio
    public void eliminaIscrizioneGruppoStudio()
    {
        GruppoStudio gruppoStudio = selezionaGruppoStudioIscritto();
        if (gruppoStudio == null)
        {
            return;
        }
        if (gruppoStudio.getMappaStudenti().containsKey(studenteCorrente.getId()))
        {
            if (gruppoStudio.getAdmin().equals(studenteCorrente.getUsername()))
            {
                eliminaGruppoStudio();
                return;
            }
            gruppoStudio.rimuoviStudente(studenteCorrente);
            studenteCorrente.rimuoviGruppoStudio(gruppoStudio);
            System.out.println("Iscrizione rimossa con successo");
        }
        else
        {
            System.out.println("Non sei iscritto a questo gruppo studio");
        }
    }

    //UC7: Caricamento di un contenuto

    //Funzione per selezionare un corso
    public void selezionaCorsoCreato()
    {
        scanner = new Scanner(System.in);
        Map<String, Corso> mappaCorsiCreati = studenteCorrente.getMappaCorsiCreati();
       
        if (mappaCorsiCreati.isEmpty())
        {
            System.out.println("Non hai creato nessun corso");
            return;
        }

        System.out.println("I tuoi corsi sono: ");
        for(Corso corso: mappaCorsiCreati.values())
        {
            System.out.print(corso.getNome() + " ");
            System.out.println(corso.getId());
        }

        do
        {
            System.out.print("Inserisci l'id di un corso: ");
            String id = scanner.nextLine();

            System.out.println(id);
            corsoSelezionato = mappaCorsiCreati.get(id);
            System.out.println(corsoSelezionato.getNome());
            System.out.println(corsoSelezionato.getId());
            if(corsoSelezionato == null)
            {
                System.out.println("Corso non trovato");
            }
        } while(corsoSelezionato == null);
    }

    //Funzione per il caricamento di un contenuto
    public Contenuto caricaContenuto()
    {
        selezionaCorsoCreato();
        if (corsoSelezionato == null)
        {
            return null;
        }
        scanner = new Scanner(System.in);
        String titolo;
        String formato;
        String file;

        System.out.println("Inserisci i dati relativi al contenuto: ");
        System.out.println("Inserisci il titolo: ");
        titolo = scanner.nextLine();
        System.out.println("Inserisci il formato: ");
        formato = scanner.nextLine();
        System.out.println("Inserisci il file: ");
        file = scanner.nextLine();
        System.out.println("Inserisci la dimensione: ");
        int dimensione = scanner.nextInt();
        scanner.nextLine();

        if(!controllaContenuto(dimensione, formato))
        {
            return null;
        }

        Contenuto contenuto = new Contenuto(titolo, formato, file, dimensione);
        corsoSelezionato.aggiungiContenuto(contenuto);
        System.out.println("Contenuto caricato con successo");
        return contenuto;
    }

    //Funzione per il controllo del contenuto
    public boolean controllaContenuto(int dimensione, String formato)
    {
        if(dimensione > corsoSelezionato.getDimensioneMassima())
        {
            System.out.println("Dimensione massima superata");
            return false;
        }
        if(!formato.equals("pdf") && !formato.equals("doc") && !formato.equals("txt"))
        {
            System.out.println("Formato non valido");
            return false;
        }
        return true;
    }

    //Funzione per selezionare un contenuto tra quelli del corso
    public Contenuto selezionaContenutoCreato()
    {
        Map<String, Contenuto> mappaContenuti = corsoSelezionato.getMappaContenuti();
        Contenuto contenutoSelezionato = null;
        if (mappaContenuti.isEmpty())
        {
            System.out.println("Non hai creato nessun contenuto per questo corso");
            return null;
        }

        System.out.println("I tuoi contenuti sono: ");
        for(Contenuto contenuto: mappaContenuti.values())
        {
            System.out.print(contenuto.getTitolo() + " ");
            System.out.println(contenuto.getId());
        }

        do
        {
            System.out.print("Inserisci l'id di un contenuto: ");
            String id = scanner.nextLine();

            contenutoSelezionato = mappaContenuti.get(id);
            if(contenutoSelezionato == null)
            {
                System.out.println("Contenuto non trovato");
            }
            else
            {
                return contenutoSelezionato;
            }
        } while(true);
    }

    //Funzione per l'eliminazione di un contenuto
    public void eliminaContenuto()
    {
        selezionaCorsoCreato();
        if (corsoSelezionato == null)
        {
            return;
        }
        Contenuto contenuto = selezionaContenutoCreato();
        if (corsoSelezionato.getMappaContenuti().containsKey(contenuto.getId()))
        {
            corsoSelezionato.rimuoviContenuto(contenuto);
            System.out.println("Contenuto rimosso con successo");
        }
        else
        {
            System.out.println("Contenuto non trovato");
        }
    }

    //UC8: Caricamento di un appunto

    //Funzione per caricare un appunto tra quelli dello studente
    public Appunto caricaAppunto()
    {
        scanner = new Scanner(System.in);
        String titolo;
        String formato;
        String file;

        System.out.println("Inserisci i dati relativi all'appunto: ");
        System.out.println("Inserisci il titolo: ");
        titolo = scanner.nextLine();
        System.out.println("Inserisci il formato: ");
        formato = scanner.nextLine();
        System.out.println("Inserisci il file: ");
        file = scanner.nextLine();
        System.out.println("Inserisci la dimensione: ");
        int dimensione = scanner.nextInt();
        
        Appunto appunto = new Appunto(studenteCorrente.getId(), titolo, formato, file, dimensione);
        if(!controllaAppunto(appunto))
        {
            System.out.println("Appunto non valido");
            return null;
        }

        studenteCorrente.aggiungiAppunto(appunto);
        appunti.put(appunto.getId(), appunto);
        System.out.println("Appunto caricato con successo");
        return appunto;
    }

    //Funzione per il controllo dell'appunto
    public boolean controllaAppunto(Appunto appunto)
    {
        if(appunto.getTitolo().isEmpty() || appunto.getFormato().isEmpty() || appunto.getFile().isEmpty())
        {
            return false;
        }
        //Controlla che non sia già stato caricato
        for(Appunto app: appunti.values())
        {
            if(appunto.getTitolo().equals(app.getTitolo()))
            {
                return false;
            }
        }
        return true;
    }

    //Funzione per selezionare un appunto tra quelli dello studente
    public Appunto selezionaAppunto()
    {
        scanner = new Scanner(System.in);
        Appunto appuntoSelezionato = null;
        if (studenteCorrente.getMappaAppunti().isEmpty())
        {
            System.out.println("Non hai creato nessun appunto");
            return null;
        }

        System.out.println("I tuoi appunti sono: ");
        for(Appunto appunto: studenteCorrente.getMappaAppunti().values())
        {
            System.out.print(appunto.getTitolo() + " ");
            System.out.println(appunto.getId());
        }

        do
        {
            System.out.print("Inserisci l'id di un appunto: ");
            String id = scanner.nextLine();

            appuntoSelezionato = studenteCorrente.getMappaAppunti().get(id);
            if(appuntoSelezionato == null)
            {
                System.out.println("Appunto non trovato");
            }
            else
            {
                return appuntoSelezionato;
            }
        } while(true);
    }

    //Funzione per l'eliminazione di un appunto
    public void eliminaAppunto()
    {
        Appunto appunto = selezionaAppunto();
        if (appunto == null)
        {
            return;
        }
        if (appunto.getCreatore().equals(studenteCorrente.getId()))
        {
            appunti.remove(appunto.getId());
            studenteCorrente.rimuoviAppunto(appunto);
            System.out.println("Appunto rimosso con successo");
        }
        else
        {
            System.out.println("Non sei il creatore dell'appunto");
        }
    }

    //UC GENERALE

    //Funzione per visualizzare tutti i dati
    public void visualizzaTuttiIDati()
    {
        if(studenteCorrente == null)
        {
            System.out.println("Non sei loggato");
        }
        else
        {
            System.out.println("Dati studente loggato: ");
            System.out.println("Id: " + studenteCorrente.getId().toString());
            System.out.println("Username: " + studenteCorrente.getUsername().toString());
            System.out.println("Password: " + studenteCorrente.getPassword().toString());
            System.out.println("Nome: " + studenteCorrente.getNome().toString());
            System.out.println("Cognome: " + studenteCorrente.getCognome().toString());
            System.out.println("Data di nascita: " + studenteCorrente.getDataNascita().toString());
            System.out.println("Luogo di nascita: " + studenteCorrente.getLuogoNascita().toString());
            System.out.println("Residenza: " + studenteCorrente.getResidenza().toString());
            System.out.println("Livello: " + studenteCorrente.getLivello().toString());
            System.out.println("Data iscrizione: " + studenteCorrente.getDataIscrizioneSito().toString());
        }
        System.out.println("Studenti: ");
        for(Studente stud: studenti.values())
        {
            System.out.println("Dati studente: ");
            System.out.println("Id: " + stud.getId().toString());
            System.out.println("Username: " + stud.getUsername().toString());
            System.out.println("Password: " + stud.getPassword().toString());
            System.out.println("Nome: " + stud.getNome().toString());
            System.out.println("Cognome: " + stud.getCognome().toString());
            System.out.println("Data di nascita: " + stud.getDataNascita().toString());
            System.out.println("Luogo di nascita: " + stud.getLuogoNascita().toString());
            System.out.println("Residenza: " + stud.getResidenza().toString());
            System.out.println("Livello: " + stud.getLivello().toString());
            System.out.println("Data iscrizione: " + stud.getDataIscrizioneSito().toString());
            Map<String, Corso> mappaCorsiCreati = stud.getMappaCorsiCreati();
            if(mappaCorsiCreati.isEmpty())
            {
                System.out.println("Non hai creato nessun corso");
            }
            else
            {
                System.out.println("Corsi creati: ");
                for (Corso corso: mappaCorsiCreati.values())
                {
                    System.out.println("Nome: " + corso.getNome().toString());
                    System.out.println("Livello: " + corso.getLivello().toString());
                    System.out.println("Costo: " + corso.getCosto());
                    System.out.println("Creatore: " + studenti.get(corso.getCreatore()).getUsername());
                    System.out.println("Lingua: " + corso.getLingua().toString());
                    System.out.println("Durata: " + corso.getDurata());
                    Map<String, Contenuto> mappaContenuti = corso.getMappaContenuti();
                    if(mappaContenuti.isEmpty())
                    {
                        System.out.println("Non ci sono contenuti caricati per questo corso");
                    }
                    else
                    {
                        System.out.println("Contenuti: ");
                        for (Contenuto contenuto: mappaContenuti.values())
                        {
                            System.out.println("Id: " + contenuto.getId().toString());
                            System.out.println("Titolo: " + contenuto.getTitolo().toString());
                            System.out.println("Formato: " + contenuto.getFormato().toString());
                            System.out.println("File: " + contenuto.getFile().toString());
                            System.out.println("Dimensione: " + contenuto.getDimensione());
                            System.out.println("Data creazione: " + contenuto.getDataCreazione().toString());
                            System.out.println("Data ultima modifica: " + contenuto.getDataUltimaModifica().toString());
                        }
                    }
                }
            }
            Map<String, Iscrizione> mappaIscrizioni = stud.getMappaIscrizioni();
            if(mappaIscrizioni.isEmpty())
            {
                System.out.println("Non sei iscritto a nessun corso");
            }
            else
            {
                System.out.println("Iscrizioni: ");
                for (Iscrizione iscrizione: mappaIscrizioni.values())
                {
                    System.out.println("Studente: " + studenti.get(iscrizione.getStudente().toString()).getUsername());
                    System.out.println("Corso: " + mappaCorsiTotali.get(iscrizione.getCorso().toString()).getNome());
                    System.out.println("Data iscrizione: " + iscrizione.getDataIscrizione().toString());
                    System.out.println("Data scadenza: " + iscrizione.getDataScadenza().toString());
                    Map<String, Pagamento> mappaPagamenti = iscrizione.getMappaPagamenti();
                    if(mappaPagamenti.isEmpty())
                    {
                        System.out.println("Non hai effettuato nessun pagamento");
                    }
                    else
                    {
                        for (Pagamento pagamento: mappaPagamenti.values())
                        {
                            System.out.println("Id: " + pagamento.getId().toString());
                            System.out.println("Data pagamento: " + pagamento.getDataPagamento().toString());
                            System.out.println("Costo: " + pagamento.getCosto());
                            System.out.println("Numero carta: " + pagamento.getDatiPagamento().getNumeroCarta().toString());
                            System.out.println("Metodo: " + pagamento.getDatiPagamento().getMetodo().toString());
                            System.out.println("Nome: " + pagamento.getDatiPagamento().getNome().toString());
                            System.out.println("Cognome: " + pagamento.getDatiPagamento().getCognome().toString());
                        }
                    }
                }
            }
            Map<String, Appunto> mappaAppunti = stud.getMappaAppunti();
            if(mappaAppunti.isEmpty())
            {
                System.out.println("Non hai caricato nessun appunto");
            }
            else
            {
                System.out.println("Appunti: ");
                for (Appunto appunto: mappaAppunti.values())
                {
                    System.out.println("Id: " + appunto.getId().toString());
                    System.out.println("Titolo: " + appunto.getTitolo().toString());
                    System.out.println("Formato: " + appunto.getFormato().toString());
                    System.out.println("File: " + appunto.getFile().toString());
                    System.out.println("Dimensione: " + appunto.getDimensione());
                    System.out.println("Data creazione: " + appunto.getDataCreazione().toString());
                    System.out.println("Data ultima modifica: " + appunto.getDataUltimaModifica().toString());
                }
            }
            Map<String, DatiPagamento> mappaDatiPagamento = stud.getMappaDatiPagamento();
            if(mappaDatiPagamento.isEmpty())
            {
                System.out.println("Non hai inserito nessun dato di pagamento");
            }
            else
            {
                System.out.println("Dati di pagamento: ");
                for (DatiPagamento datiPagamento: mappaDatiPagamento.values())
                {
                    System.out.println("Metodo: " + datiPagamento.getMetodo().toString());
                    System.out.println("Numero carta: " + datiPagamento.getNumeroCarta().toString());
                    System.out.println("Nome: " + datiPagamento.getNome().toString());
                    System.out.println("Cognome: " + datiPagamento.getCognome().toString());
                }
            }
            Map<String, GruppoStudio> mappaGruppiStudio = stud.getMappaGruppiStudio();
            if(mappaGruppiStudio.isEmpty())
            {
                System.out.println("Non sei iscritto a nessun gruppo studio");
            }
            else
            {
                System.out.println("Gruppi studio: ");
                for (GruppoStudio gruppo: mappaGruppiStudio.values())
                {
                    System.out.println("Nome: " + gruppo.getNome().toString());
                    System.out.println("Id: " + gruppo.getId().toString());
                    System.out.println("Password: " + gruppo.getPassword().toString());
                    System.out.println("Admin: " + gruppo.getAdmin().toString());
                    System.out.println("Lingua: " + gruppo.getLingua().toString());
                    System.out.println("Data creazione: " + gruppo.getDataCreazione().toString());
                    System.out.println("Durata: " + gruppo.getDurata());
                    System.out.println("Numero studenti: " + gruppo.getNumeroStudenti());
                    System.out.println("Numero massimo studenti: " + gruppo.getNumeroMaxStudenti());
                    Map<String, Studente> mappaStudenti = gruppo.getMappaStudenti();
                    if(mappaStudenti.isEmpty())
                    {
                        System.out.println("Non ci sono studenti iscritti al gruppo");
                    }
                    else
                    {
                        for (Studente studente: mappaStudenti.values())
                        {
                            System.out.println("Id: " + studente.getId().toString());
                            System.out.println("Username: " + studente.getUsername().toString());
                            System.out.println("Password: " + studente.getPassword().toString());
                            System.out.println("Nome: " + studente.getNome().toString());
                            System.out.println("Cognome: " + studente.getCognome().toString());
                            System.out.println("Data nascita: " + studente.getDataNascita().toString());
                            System.out.println("Luogo nascita: " + studente.getLuogoNascita().toString());
                            System.out.println("Residenza: " + studente.getResidenza().toString());
                            System.out.println("Livello: " + studente.getLivello().toString());
                            System.out.println("Data iscrizione: " + studente.getDataIscrizioneSito().toString());
                        }
                    }
                }
            }
            System.out.println("-------------------------------------------------");
        }
        System.out.println("Corsi: ");
        for(Corso corso: mappaCorsiTotali.values())
        {
            System.out.println("Nome: " + corso.getNome().toString());
            System.out.println("Livello: " + corso.getLivello().toString());
            System.out.println("Costo: " + corso.getCosto());
            System.out.println("Creatore: " + studenti.get(corso.getCreatore()).getUsername());
            System.out.println("Lingua: " + corso.getLingua().toString());
            System.out.println("Durata: " + corso.getDurata());
            Map<String, Contenuto> mappaContenuti = corso.getMappaContenuti();
            if(mappaContenuti.isEmpty())
            {
                System.out.println("Non ci sono contenuti caricati per questo corso");
            }
            else
            {
                System.out.println("Contenuti: ");
                for (Contenuto contenuto: mappaContenuti.values())
                {
                    System.out.println("Id: " + contenuto.getId().toString());
                    System.out.println("Titolo: " + contenuto.getTitolo().toString());
                    System.out.println("Formato: " + contenuto.getFormato().toString());
                    System.out.println("File: " + contenuto.getFile().toString());
                    System.out.println("Dimensione: " + contenuto.getDimensione());
                    System.out.println("Data creazione: " + contenuto.getDataCreazione().toString());
                    System.out.println("Data ultima modifica: " + contenuto.getDataUltimaModifica().toString());
                }
            }
            Map<String, Iscrizione> mappaIscrizioni = corso.getMappaIscrizioni();
            if(mappaIscrizioni.isEmpty())
            {
                System.out.println("Non ci sono studenti iscritti a questo corso");
            }
            else
            {
                System.out.println("Iscrizioni: ");
                for (Iscrizione iscrizione: mappaIscrizioni.values())
                {
                    System.out.println("Studente: " + studenti.get(iscrizione.getStudente().toString()).getUsername());
                    System.out.println("Corso: " + mappaCorsiTotali.get(iscrizione.getCorso().toString()).getNome());
                    System.out.println("Data iscrizione: " + iscrizione.getDataIscrizione().toString());
                    System.out.println("Data scadenza: " + iscrizione.getDataScadenza().toString());
                    Map<String, Pagamento> mappaPagamenti = iscrizione.getMappaPagamenti();
                    if(mappaPagamenti.isEmpty())
                    {
                        System.out.println("Non hai effettuato nessun pagamento");
                    }
                    else
                    {
                        for (Pagamento pagamento: mappaPagamenti.values())
                        {
                            System.out.println("Id: " + pagamento.getId().toString());
                            System.out.println("Data pagamento: " + pagamento.getDataPagamento().toString());
                            System.out.println("Costo: " + pagamento.getCosto());
                            System.out.println("Numero carta: " + pagamento.getDatiPagamento().getNumeroCarta().toString());
                            System.out.println("Metodo: " + pagamento.getDatiPagamento().getMetodo().toString());
                            System.out.println("Nome: " + pagamento.getDatiPagamento().getNome().toString());
                            System.out.println("Cognome: " + pagamento.getDatiPagamento().getCognome().toString());
                        }
                    }
                }
            }
            System.out.println("-------------------------------------------------");
        }
        System.out.println("Appunti: ");
        for(Appunto appunto: appunti.values())
        {
            System.out.println("Id: " + appunto.getId().toString());
            System.out.println("Titolo: " + appunto.getTitolo().toString());
            System.out.println("Formato: " + appunto.getFormato().toString());
            System.out.println("File: " + appunto.getFile().toString());
            System.out.println("Dimensione: " + appunto.getDimensione());
            System.out.println("Data creazione: " + appunto.getDataCreazione().toString());
            System.out.println("Data ultima modifica: " + appunto.getDataUltimaModifica().toString());
        }
        System.out.println("Gruppi studio: ");
        for(GruppoStudio gruppo: gruppiStudio.values())
        {
            System.out.println("Nome: " + gruppo.getNome().toString());
            System.out.println("Id: " + gruppo.getId().toString());
            System.out.println("Password: " + gruppo.getPassword().toString());
            System.out.println("Admin: " + gruppo.getAdmin().toString());
            System.out.println("Lingua: " + gruppo.getLingua().toString());
            System.out.println("Data creazione: " + gruppo.getDataCreazione().toString());
            System.out.println("Durata: " + gruppo.getDurata());
            System.out.println("Numero studenti: " + gruppo.getNumeroStudenti());
            System.out.println("Numero massimo studenti: " + gruppo.getNumeroMaxStudenti());
            Map<String, Studente> mappaStudenti = gruppo.getMappaStudenti();
            if(mappaStudenti.isEmpty())
            {
                System.out.println("Non ci sono studenti iscritti al gruppo");
            }
            else
            {
                for (Studente studente: mappaStudenti.values())
                {
                    System.out.println("Id: " + studente.getId().toString());
                    System.out.println("Username: " + studente.getUsername().toString());
                    System.out.println("Password: " + studente.getPassword().toString());
                    System.out.println("Nome: " + studente.getNome().toString());
                    System.out.println("Cognome: " + studente.getCognome().toString());
                    System.out.println("Data nascita: " + studente.getDataNascita().toString());
                    System.out.println("Luogo nascita: " + studente.getLuogoNascita().toString());
                    System.out.println("Residenza: " + studente.getResidenza().toString());
                    System.out.println("Livello: " + studente.getLivello().toString());
                    System.out.println("Data iscrizione: " + studente.getDataIscrizioneSito().toString());
                }
            }
            System.out.println("-------------------------------------------------");
        }
    }
}