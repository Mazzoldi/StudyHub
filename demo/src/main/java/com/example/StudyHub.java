package com.example;

import java.util.*;
import java.text.SimpleDateFormat;

public class StudyHub 
{
    //Creazione di un singleton per la classe StudyHub
    private static StudyHub instance;
    //Studente che utilizza l'applicazione
    private Studente studente;
    //Mappe per la memorizzazione dei dati
    private Map<String, Corso> mappaCorsiTotali;
    private Map<String, Studente> studenti;
    private Map<String, Appunto> appunti;
    private Map<String, GruppoStudio> gruppiStudio;
    //Corso selezionato durante una ricerca o un'iscrizione
    private Corso corsoSelezionato;
    //Scanner per l'input da tastiera
    private static Scanner scanner;

    //Costruttore privato per la classe StudyHub2
    private StudyHub()
    {
        //Inizializzazione delle mappe
        this.appunti = new HashMap<String, Appunto>();
        this.studenti = new HashMap<String, Studente>();
        this.mappaCorsiTotali = new HashMap<String, Corso>();
        this.gruppiStudio = new HashMap<String, GruppoStudio>();
        //Inizializzazione dello studente e del corso selezionato
        this.studente = null;
        this.corsoSelezionato = null;
        //Caricamento dei dati di prova
        loadData();
    }

    //Funzione per caricare dei dati di prova
    private void loadData()
    {
        //Dati sui corsi
        Corso corso1 = new Corso("Matematica", "Laurea Magistrale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso2 = new Corso("Fisica", "Laurea Triennale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso3 = new Corso("Inglese", "Laurea Triennale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso4 = new Corso("Italiano", "Laurea Triennale", 20, "Mario Rossi", "Italiano", 30);
        Corso corso5 = new Corso("Storia", "Laurea Magistrale", 10, "Mario Rossi", "Italiano", 30);
        mappaCorsiTotali.put(corso1.getId(), corso1);
        mappaCorsiTotali.put(corso2.getId(), corso2);
        mappaCorsiTotali.put(corso3.getId(), corso3);
        mappaCorsiTotali.put(corso4.getId(), corso4);
        mappaCorsiTotali.put(corso5.getId(), corso5);
        //Dati sugli studenti
        Studente studente1 = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        Studente studente2 = new Studente("Rossi", "1111", "Mario", "Rossi", "12/09/2002", "Catania", "Catania", "Laurea Magistrale");
        studenti.put(studente1.getId(), studente1);
        studenti.put(studente2.getId(), studente2);
        //Dati sugli appunti
        Appunto appunto1 = new Appunto("Appunto1", "pdf", "appunto1.pdf", "02/01/2025");
        Appunto appunto2 = new Appunto("Appunto2", "pdf", "appunto2.pdf", "02/01/2025");
        Appunto appunto3 = new Appunto("Appunto3", "pdf", "appunto3.pdf", "02/01/2025");
        //Dati sugli appunti degli studenti
        appunti.put(appunto1.getId(), appunto1);
        appunti.put(appunto2.getId(), appunto2);
        appunti.put(appunto3.getId(), appunto3);
        //Dati sui pagamenti
        studente1.creaDatiPagamento("Carta di credito", "1234-5678-1234-5678", "Nicolò", "Mazzola");
        //Dati sui gruppi studio
        GruppoStudio gruppo1 = new GruppoStudio("Gruppo1", null, "1111", "Italiano", 30);
        GruppoStudio gruppo2 = new GruppoStudio("Gruppo2", null, "1111", "Italiano", 30);
        GruppoStudio gruppo3 = new GruppoStudio("Gruppo3", null, "1111", "Italiano", 30);
        gruppo1.aggiungiStudente(studente1);
        gruppo2.aggiungiStudente(studente2);
        gruppiStudio.put(gruppo1.getId(), gruppo1);
        gruppiStudio.put(gruppo2.getId(), gruppo2);
        gruppiStudio.put(gruppo3.getId(), gruppo3);
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
            System.out.println("1. Modifica profilo");
            System.out.println("2. Carica appunto");
            System.out.println("3. Carica contenuto");
            System.out.println("4. Iscrizione ad un corso");
            System.out.println("5. Crea un gruppo di studio");
            System.out.println("6. Iscriviti ad un gruppo studio");
            System.out.println("7. Logout");
            System.out.println("8. Esci");
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

    //Funzione per ottenere gli studenti
    public Map<String, Studente> getStudenti()
    {
        return studenti;
    }

    //Funzione per ottenere gli appunti
    public Map<String, Appunto> getAppunti()
    {
        return appunti;
    }

    //Funzione per ottenere i gruppi studio 
    public Studente getStudente()
    {
        return studente;
    }

    //Funzione per ottenere i gruppi studio
    public Corso getCorsoSelezionato()
    {
        return corsoSelezionato;
    }
    
    //Funzione per ottenere i gruppi studio
    public void setCorsoSelezionato(Corso corsoSelezionato)
    {
        this.corsoSelezionato = corsoSelezionato;
    }

    public static void main(String[] args) 
    {
        StudyHub studyHub = new StudyHub();
        boolean isLogged = false;
        boolean running = true;
        int scelta;

        do 
        {
            scelta = studyHub.menu(isLogged);
            if (isLogged == false) 
            {
                switch (scelta) 
                {
                    case 1:
                        System.out.println("Hai selezionato Registrazione");
                        isLogged = studyHub.creaProfilo(isLogged);
                        break;
                    case 2:
                        System.out.println("Hai selezionato Login");
                        isLogged = studyHub.login(isLogged);
                        break;
                    case 3:
                        System.out.println("Uscita dal programma...");
                        running = false;
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
                        System.out.println("Hai selezionato Modifica profilo");
                        studyHub.modificaProfilo();
                        break;
                    case 2:
                        System.out.println("Hai selezionato Carica appunto");
                        studyHub.caricaAppunto();
                        break;
                    case 3:
                        System.out.println("Hai selezionato Carica contenuto");
                        studyHub.selezionaCorsoCreato();
                        studyHub.caricaContenuto();
                        break;
                    case 4:
                        System.out.println("Hai selezionato Iscrizione ad un corso");
                        studyHub.selezionaCorso(studyHub.cercaCorso());
                        studyHub.iscrizioneCorso();
                        break;
                    case 5:
                        System.out.println("Hai selezionato Creazione Gruppo Studio");
                        GruppoStudio gruppoStudio = studyHub.creaGruppoStudio();
                        studyHub.gruppiStudio.put(gruppoStudio.getId(), gruppoStudio);
                        break;   
                    case 6:
                        System.out.println("Hai selezionato Iscrizione ad un gruppo studio");
                        studyHub.iscrizioneGruppoStudio();
                        break;            
                    case 7:
                        System.out.println("Hai selezionato Logout");
                        isLogged = false;
                        break;
                    case 8:
                        System.out.println("Uscita dal programma...");
                        running = false;
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            }
        } while (running);
        scanner.close();
    }

    //Funzione per il login di uno studente
    public boolean login(boolean isLogged)
    {
        String username;
        String password;
        System.out.println("Inserisci username: ");
        username = scanner.nextLine();
        System.out.println("Inserisci password: ");
        password = scanner.nextLine();

        for(Studente stud: studenti.values())
        {
            if(stud.getUsername().equals(username) && stud.verificaPassword(password))
            {
                isLogged = true;
                studente = stud;
                System.out.println("Login effettuato con successo");
                System.out.println("Benvenuto " + studente.getNome() + " " + studente.getCognome());
            }
        }

        if (isLogged == false)
        {
            System.out.println("Username o password errati");
        }

        return isLogged;
    }

    //UC1

    //Funzione per la registrazione di un utente
    public boolean creaProfilo(boolean isLogged)
    {
        String nome;
        String cognome;
        String dataNascita;
        String luogoNascita;
        String residenza;
        String livello;
        String username;
        String password;

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
        System.out.println("Inserisci lo username: ");
        username = scanner.nextLine();
        System.out.println("Inserisci la password: ");
        password = scanner.nextLine();

        Studente stud = new Studente(username, password, nome, cognome, dataNascita, luogoNascita, residenza, livello);
        studente = stud;
        studenti.put(studente.getId(), studente);
        return isLogged;
    }

    //UC2

    //Funzione per la modifica del profilo
    public void modificaProfilo()
    {
        String nome;
        String cognome;
        String dataNascita;
        String luogoNascita;
        String residenza;
        String dataIscrizioneSito;
        String livello;
        String username;
        String password;

        System.out.println("Inserisci i dati che vuoi modificare, invio per lasciarli immutati: ");
        System.out.println("Inserisci il nome, attuale: " + studente.getNome());
        nome = scanner.nextLine();
        System.out.println("Inserisci il cognome, attuale: " + studente.getCognome());
        cognome = scanner.nextLine();
        System.out.println("Inserisci la data di nascita, attuale: " + studente.getDataNascita());
        dataNascita = scanner.nextLine();
        System.out.println("Inserisci il luogo di nascita, attuale: " + studente.getLuogoNascita());
        luogoNascita = scanner.nextLine();
        System.out.println("Inserisci la residenza, attuale: " + studente.getResidenza());
        residenza = scanner.nextLine();
        System.out.println("Inserisci la data di iscrizione al sito, attuale: " + studente.getDataIscrizioneSito());
        dataIscrizioneSito = scanner.nextLine();
        System.out.println("Inserisci il livello, attuale: " + studente.getLivello());
        livello = scanner.nextLine();
        System.out.println("Inserisci lo username, attuale: " + studente.getUsername());
        username = scanner.nextLine();
        System.out.println("Inserisci la password, attuale: " + studente.getPassword());
        password = scanner.nextLine();

        if (username != "")
        {
            studente.setUsername(username);
        }
        if (password != "")
        {
            studente.setPassword(password);
        }
        if (nome != "")
        {
            studente.setNome(nome);
        }
        if (cognome != "")
        {
            studente.setCognome(cognome);
        }
        if (dataNascita != "")
        {
            studente.setDataNascita(dataNascita);
        }
        if (luogoNascita != "")
        {
            studente.setLuogoNascita(luogoNascita);
        }
        if (residenza != "")
        {
            studente.setResidenza(residenza);
        }
        if (dataIscrizioneSito != "")
        {
            studente.setDataIscrizioneSito(dataIscrizioneSito);
        }
        if (livello != "")
        {
            studente.setLivello(livello);
        }
    }

    //UC3

    //Funzione per selezionare un corso
    public void selezionaCorsoCreato()
    {
        Map<String, Corso> mappaCorsiCreati = studente.getMappaCorsiCreati();

        System.out.println("I tuoi corsi sono: ");
        for(Corso corso: mappaCorsiCreati.values())
        {
            System.out.print(corso.getNome());
            System.out.println(corso.getId());
        }

        System.out.print("Inserisci l'id di un corso: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        scanner.close();

        corsoSelezionato = mappaCorsiCreati.get(id);
        
        if(corsoSelezionato == null)
        {
            System.out.println("Corso non trovato");
        }
    }

    //Funzione per il caricamento di un contenuto
    public void caricaContenuto()
    {
        String titolo;
        String formato;
        String file;
        String data;

        System.out.println("Inserisci i dati relativi al contenuto: ");
        System.out.println("Inserisci il titolo: ");
        titolo = scanner.nextLine();
        System.out.println("Inserisci il formato: ");
        formato = scanner.nextLine();
        System.out.println("Inserisci il file: ");
        file = scanner.nextLine();
        System.out.println("Inserisci la data: ");
        data = scanner.nextLine();

        Contenuto contenuto = new Contenuto(titolo, formato, file, data);
        corsoSelezionato.aggiungiContenuto(contenuto);
    }

    //UC4

    // Funzione per la ricerca di un corso a cui iscriversi
    public Map<String, Corso> cercaCorso() 
    {
        // Input dati da parte dell'utente
        System.out.println("Inserisci i dati relativi al corso: ");
        System.out.println("Inserisci il nome del corso (lascia vuoto se non lo conosci): ");
        String nome = scanner.nextLine().trim();
        System.out.println("Inserisci il livello del corso (lascia vuoto se non lo conosci): ");
        String livello = scanner.nextLine().trim();
        System.out.println("Inserisci l'ID del corso (lascia vuoto se non lo conosci): ");
        String id = scanner.nextLine().trim();
        System.out.println("Inserisci la lingua del corso (lascia vuoto se non la conosci): ");
        String lingua = scanner.nextLine().trim();

        // Mappa per inerire i risultati
        Map<String, Corso> mappaCorsiCercati = new HashMap<>();

        // Ricerca per ID prioritario
        if (!id.isEmpty()) 
        {
            Corso corso = mappaCorsiTotali.get(id);
            if (corso != null) 
            {
                mappaCorsiCercati.put(id, corso);
            } 
        } 
        else 
        {
            // Ricerca filtrata per altri parametri
            for (Corso corso : mappaCorsiTotali.values()) 
            {
                boolean nomeCorrisponde = nome.isEmpty() || corso.getNome().equalsIgnoreCase(nome);
                boolean livelloCorrisponde = livello.isEmpty() || corso.getLivello().equalsIgnoreCase(livello);
                boolean linguaCorrisponde = lingua.isEmpty() || corso.getLingua().equalsIgnoreCase(lingua);

                if (nomeCorrisponde && livelloCorrisponde && linguaCorrisponde) 
                {
                    mappaCorsiCercati.put(corso.getId(), corso);
                }
            }
        }

        // Risultati finali
        if (mappaCorsiCercati.isEmpty()) 
        {
            System.out.println("Nessun corso trovato con i criteri forniti.");
        }

        return mappaCorsiCercati;
    }


    //Funzione per selezionare un corso da quelli cercati
    public void selezionaCorso(Map<String, Corso> mappaCorsiCercati)
    {
        System.out.println("I corsi trovati sono: ");
        for(Corso corso: mappaCorsiCercati.values())
        {
            System.out.println(corso.getNome());
            System.out.println(corso.getId());
        }

        System.out.println("Inserisci l'id di un corso: ");
        scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        corsoSelezionato = mappaCorsiCercati.get(id);
    }

    //Funzione per l'iscrizione ad un corso
    public void iscrizioneCorso()
    {
        float costo = corsoSelezionato.getCosto();

        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        String formattedFutureDate = dateFormat.format(futureDate);
        
        if (costo == 0)
        {
            Iscrizione iscrizione = new Iscrizione(formattedCurrentDate, formattedFutureDate, studente.getId(), corsoSelezionato.getId());
            aggiungiIscrizione(iscrizione);
        }
        else
        {
            Iscrizione iscrizione = pagamentoIscrizione(costo);
            if(iscrizione==null)
            {
                System.out.println("Pagamento non andato a buon fine");
            }
        }
    }

    //Funzione per il pagamento dell'iscrizione
    public Iscrizione pagamentoIscrizione(float costo)
    {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        String formattedFutureDate = dateFormat.format(futureDate);
        boolean confermaPagamento = false;

        DatiPagamento datiPagamento = studente.usaDatiPagamento();

        if(datiPagamento == null)
        {
            System.out.println("Non hai inserito i dati di pagamento");
            return null;
        }

        // Presumiamo che sia sempre vero anche se serve un sistema di pagamento esterno
        confermaPagamento = true;

        if(confermaPagamento)
        {
            Iscrizione iscrizione = new Iscrizione(formattedCurrentDate, formattedFutureDate, studente.getId(), corsoSelezionato.getId());
            aggiungiIscrizione(iscrizione);

            Pagamento pagamento = new Pagamento(formattedCurrentDate, costo, datiPagamento);

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

    //Funzione per il collegmaneto di un iscrizione tra studente e corso
    public void aggiungiIscrizione(Iscrizione iscrizione)
    {
        corsoSelezionato.aggiungiIscrizione(studente, iscrizione);
        studente.aggiungiIscrizione(corsoSelezionato, iscrizione);
        System.out.println("Iscrizione avvenuta con successo");
    }

    //UC5
    
    //Funzione per caricare un appunto tra quelli dello studente
    public void caricaAppunto()
    {
        String titolo;
        String formato;
        String file;
        String data;

        System.out.println("Inserisci i dati relativi all'appunto: ");
        System.out.println("Inserisci il titolo: ");
        titolo = scanner.nextLine();
        System.out.println("Inserisci il formato: ");
        formato = scanner.nextLine();
        System.out.println("Inserisci il file: ");
        file = scanner.nextLine();
        System.out.println("Inserisci la data: ");
        data = scanner.nextLine();

        Appunto appunto = new Appunto(titolo, formato, file, data);
        studente.aggiungiAppunto(appunto);
    }
    
    //UC6

    //Funzione per la creazione di un gruppo studio
    public GruppoStudio creaGruppoStudio()
    {
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

        GruppoStudio gruppoStudio = new GruppoStudio(nome, studente.getId(), password, lingua, durata);
        gruppoStudio.aggiungiStudente(studente);
        return gruppoStudio;
    }

    //Funzione per l'iscrizione ad un gruppo studio
    public void iscrizioneGruppoStudio()
    {
        String nome;
        String password;

        System.out.println("Inserisci il nome del gruppo studio: ");
        nome = scanner.nextLine();
        System.out.println("Inserisci la password del gruppo studio: ");
        password = scanner.nextLine();

        for(GruppoStudio gruppoStudio: this.gruppiStudio.values())
        {
            if(gruppoStudio.getNome().equals(nome))
            {
                if(gruppoStudio.passwordCorretta(password))
                {
                    if (gruppoStudio.verificaIscrizione(studente) == false)
                    {
                        gruppoStudio.aggiungiStudente(studente);
                        System.out.println("Password corretta, iscrizione avvenuta con successo");
                        System.out.println("Benvenuto nel gruppo studio " + gruppoStudio.getNome());
                        System.out.println("Admin: " + gruppoStudio.getAdmin());
                        System.out.println("Lingua: " + gruppoStudio.getLingua());
                        System.out.println("Numero studenti: " + gruppoStudio.getNumeroStudenti());
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
            else
            {
                System.out.println("Gruppo studio non trovato");
            }
        }
    }
}