package com.example;

import java.util.*;
import java.text.SimpleDateFormat;

public class StudyHub 
{
    private static StudyHub instance;

    //Creazione di un singleton per la classe StudyHub
    private Studente studente;
    private Corso corsoSelezionato;
    private Map<String, Corso> mappaCorsiTotali;
    private Map<String, Studente> studenti;
    private Map<String, Appunto> appunti;
    private Map<String, GruppoStudio> gruppiStudio;
    private static Scanner scanner;

    //Costruttore privato per la classe StudyHub
    private StudyHub()
    {
        this.studenti = new HashMap<String, Studente>();
        this.mappaCorsiTotali = new HashMap<String, Corso>();
        this.appunti = new HashMap<String, Appunto>();
        this.gruppiStudio = new HashMap<String, GruppoStudio>();
        this.studente = null;
        this.corsoSelezionato = null;
        loadData();
    }

    //Funzione per caricare i dati di prova
    private void loadData()
    {
        Corso corso1 = new Corso("Matematica", "Laurea Magistrale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso2 = new Corso("Fisica", "Laurea Triennale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso3 = new Corso("Inglese", "Laurea Triennale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso4 = new Corso("Italiano", "Laurea Triennale", 0, "Mario Rossi", "Italiano", 30);
        Corso corso5 = new Corso("Storia", "Laurea Magistrale", 0, "Mario Rossi", "Italiano", 30);
        mappaCorsiTotali.put(corso1.getId(), corso1);
        mappaCorsiTotali.put(corso2.getId(), corso2);
        mappaCorsiTotali.put(corso3.getId(), corso3);
        mappaCorsiTotali.put(corso4.getId(), corso4);
        mappaCorsiTotali.put(corso5.getId(), corso5);
        studente = new Studente("Mazzoldi", "1111", "Nicolò", "Mazzola", "12/09/2002", "Catania", "Catania", "02/01/2025", "Laurea Magistrale");
        studenti.put(studente.getId(), studente);
        Appunto appunto1 = new Appunto("Appunto1", "pdf", "appunto1.pdf", "02/01/2025");
        Appunto appunto2 = new Appunto("Appunto2", "pdf", "appunto2.pdf", "02/01/2025");
        Appunto appunto3 = new Appunto("Appunto3", "pdf", "appunto3.pdf", "02/01/2025");
        appunti.put(appunto1.getId(), appunto1);
        appunti.put(appunto2.getId(), appunto2);
        appunti.put(appunto3.getId(), appunto3);
        GruppoStudio gruppo1 = new GruppoStudio("Gruppo1", "Mazzoldi", "1111", "Italiano", 30);
        GruppoStudio gruppo2 = new GruppoStudio("Gruppo2", "Mazzoldi", "1111", "Italiano", 30);
        GruppoStudio gruppo3 = new GruppoStudio("Gruppo3", "Mazzoldi", "1111", "Italiano", 30);
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
            System.out.println("5. Logout");
            System.out.println("6. Esci");
            System.out.print("Seleziona un'opzione: ");
        }
        scelta = scanner.nextInt();
        scanner.nextLine();
        return scelta;
    }

    public Map<String, Corso> getMappaCorsiTotali()
    {
        return mappaCorsiTotali;
    }

    public Map<String, Studente> getStudenti()
    {
        return studenti;
    }

    public Map<String, Appunto> getAppunti()
    {
        return appunti;
    }

    public Studente getStudente()
    {
        return studente;
    }

    public Corso getCorsoSelezionato()
    {
        return corsoSelezionato;
    }
    
    public void setCorsoSelezionato(Corso corsoSelezionato)
    {
        this.corsoSelezionato = corsoSelezionato;
    }

    public static void main(String[] args) 
    {
        StudyHub studyHub = new StudyHub();
        int scelta;
        boolean isLogged = false;
        boolean running = true;
        String titolo;
        String formato;
        String file;
        String data;
        String nome;
        String livello;
        String id;
        String lingua;
        String cognome;
        String dataNascita;
        String luogoNascita;
        String residenza;
        String dataIscrizioneSito;
        String username;
        String password;

        do {
            scelta = studyHub.menu(isLogged);
            if (!isLogged) {
                switch (scelta) 
                {
                    case 1:
                        System.out.println("Hai selezionato Registrazione");
                        System.out.println("Inserisci i dati relativi allo studente: ");
                        nome = scanner.nextLine();
                        cognome = scanner.nextLine();
                        dataNascita = scanner.nextLine();
                        luogoNascita = scanner.nextLine();
                        residenza = scanner.nextLine();
                        dataIscrizioneSito = scanner.nextLine();
                        livello = scanner.nextLine();
                        username = scanner.nextLine();
                        password = scanner.nextLine();
                        studyHub.creaProfilo(username, password, nome, cognome, dataNascita, luogoNascita, residenza, dataIscrizioneSito, livello);
                        isLogged = true;
                        break;
                    case 2:
                        System.out.println("Hai selezionato Login");
                        System.out.println("Inserisci username: ");
                        username = scanner.nextLine();
                        System.out.println("Inserisci password: ");
                        password = scanner.nextLine();
                        for(Studente studente: studyHub.studenti.values())
                        {
                            if(studente.getUsername().equals(username) && studente.verificaPassword(password))
                            {
                                studyHub.studente = studente;
                                isLogged = true;
                                System.out.println("Login effettuato con successo");
                                break;
                            }
                        }
                        if (isLogged == false)
                        {
                            System.out.println("Username o password errati");
                        }
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
            else {
                switch (scelta) 
                {
                    case 1:
                        System.out.println("Hai selezionato Modifica profilo");
                        System.out.println("Inserisci i dati che vuoi modificare, invio per lasciarli immutati: ");
                        System.out.println("Inserisci il nome, attuale: " + studyHub.studente.getNome());
                        nome = scanner.nextLine();
                        System.out.println("Inserisci il cognome, attuale: " + studyHub.studente.getCognome());
                        cognome = scanner.nextLine();
                        System.out.println("Inserisci la data di nascita, attuale: " + studyHub.studente.getDataNascita());
                        dataNascita = scanner.nextLine();
                        System.out.println("Inserisci il luogo di nascita, attuale: " + studyHub.studente.getLuogoNascita());
                        luogoNascita = scanner.nextLine();
                        System.out.println("Inserisci la residenza, attuale: " + studyHub.studente.getResidenza());
                        residenza = scanner.nextLine();
                        System.out.println("Inserisci la data di iscrizione al sito, attuale: " + studyHub.studente.getDataIscrizioneSito());
                        dataIscrizioneSito = scanner.nextLine();
                        System.out.println("Inserisci il livello, attuale: " + studyHub.studente.getLivello());
                        livello = scanner.nextLine();
                        System.out.println("Inserisci lo username, attuale: " + studyHub.studente.getUsername());
                        username = scanner.nextLine();
                        System.out.println("Inserisci la password, attuale: " + studyHub.studente.getPassword());
                        password = scanner.nextLine();
                        studyHub.modificaProfilo(username, password, nome, cognome, dataNascita, luogoNascita, residenza, dataIscrizioneSito, livello);
                        break;
                    case 2:
                        System.out.println("Hai selezionato Carica appunto");
                        System.out.println("Inserisci i dati relativi all'appunto: ");
                        titolo = scanner.nextLine();
                        formato = scanner.nextLine();
                        file = scanner.nextLine();
                        data = scanner.nextLine();
                        studyHub.caricaAppunto(titolo, formato, file, data);
                        break;
                    case 3:
                        System.out.println("Hai selezionato Carica contenuto");
                        System.out.println("Inserisci i dati relativi al contenuto: ");
                        titolo = scanner.nextLine();
                        formato = scanner.nextLine();
                        file = scanner.nextLine();
                        data = scanner.nextLine();
                        studyHub.caricaContenuto(titolo, formato, file, data);
                        break;
                    case 4:
                        System.out.println("Hai selezionato Iscrizione ad un corso");
                        System.out.println("Inserisci i dati relativi al corso: ");
                        nome = scanner.nextLine();
                        livello = scanner.nextLine();
                        id = scanner.nextLine();
                        lingua = scanner.nextLine();
                        studyHub.selezionaCorso(studyHub.cercaCorso(nome, livello, id, lingua));
                        studyHub.iscrizioneCorso(studyHub.studente, studyHub.corsoSelezionato);
                        break;
                    case 5:
                        System.out.println("Hai selezionato Iscrizione ad un gruppo studio");
                        System.out.println("Inserisci i dati relativi al gruppo studio: ");
                        System.out.println("Inserisci l'id del gruppo studio: ");
                        id = scanner.nextLine();
                        System.out.println("Inserisci la password del gruppo studio: ");
                        password = scanner.nextLine();
                        GruppoStudio gruppoStudio = studyHub.gruppiStudio.get(id);
                        if(gruppoStudio != null)
                        {
                            if(gruppoStudio.verificaPassword(studyHub.studente, password))
                            {
                                System.out.println("Password corretta, iscrizione avvenuta con successo");
                                System.out.println("Benvenuto nel gruppo studio " + gruppoStudio.getNome());
                                System.out.println("Admin: " + gruppoStudio.getAdmin());
                                System.out.println("Lingua: " + gruppoStudio.getLingua());
                                System.out.println("Numero studenti: " + gruppoStudio.getNumeroStudenti());
                            }
                            else
                            {
                                System.out.println("Password errata, iscrizione non avvenuta");
                            }
                        }
                        else
                        {
                            System.out.println("Gruppo studio non trovato, iscrizione non avvenuta");
                        }
                    case 6:
                        System.out.println("Hai selezionato Logout");
                        isLogged = false;
                        break;
                    case 7:
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

    //UC1

    //Funzione per la creazione del profilo
    public void creaProfilo(String username, String password, String nome, String cognome, String dataNascita, String luogoNascita, String residenza, String dataIscrizioneSito, String livello)
    {
        studente = new Studente(username, password, nome, cognome, dataNascita, luogoNascita, residenza, dataIscrizioneSito, livello);
        studenti.put(studente.getId(), studente);
    }

    //UC2

    //Funzione per la modifica del profilo
    public void modificaProfilo(String username, String password, String nome, String cognome, String dataNascita, String luogoNascita, String residenza, String dataIscrizioneSito, String livello)
    {
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

    //UC2

    //Funzione per il caricamento di un contenuto
    public void caricaContenuto(String titolo, String formato, String file, String data)
    {
        Contenuto contenuto = new Contenuto(titolo, formato, file, data);
        
        corsoSelezionato.aggiungiContenuto(contenuto);
    }

    //Funzione per selezionare un corso
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
        scanner.close();

        corsoSelezionato = mappaCorsiCercati.get(id);
    }

    //UC3

    //Funzione per il collegmaneto di un iscrizione tra studente e corso
    public void aggiungiIscrizione(Studente studente, Corso corso, Iscrizione iscrizione)
    {
        corso.aggiungiIscrizione(studente, iscrizione);
        studente.aggiungiIscrizione(corso, iscrizione);
    }

    //Funzione per l'iscrizione ad un corso
    public void iscrizioneCorso(Studente studente, Corso corsoSelezionato)
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
            aggiungiIscrizione(studente, corsoSelezionato, iscrizione);
        }
        else
        {
            Iscrizione iscrizione = pagamentoIscrizione(studente, costo);
            if(iscrizione==null)
            {
                System.out.println("Pagamento non andato a buon fine");
            }
        }
    }

    //Funzione per il pagamento dell'iscrizione
    public Iscrizione pagamentoIscrizione(Studente studente, float costo)
    {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        String formattedFutureDate = dateFormat.format(futureDate);
        boolean confermaPagamento = false;

        DatiPagamento datiPagamento = usaDatiPagamento(studente);

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
            aggiungiIscrizione(studente, corsoSelezionato, iscrizione);

            Pagamento pagamento = new Pagamento(formattedCurrentDate, costo, datiPagamento);

            iscrizione.aggiungiPagamento(pagamento);
            return iscrizione;
        }
        else
        {
            return null;
        }
    }

    //Funzione per il prelievo dei dati pagamento
    public DatiPagamento usaDatiPagamento(Studente studente)
    {
        DatiPagamento datiPagamento = studente.usaDatiPagamento();
        return datiPagamento;
    }

    //Funzione per la ricerca di un corso a cui iscriversi
    public Map<String, Corso> cercaCorso(String nome, String livello, String id, String lingua)
    {
        Map<String, Corso> mappaCorsiCercati = new HashMap<String, Corso>();

        if(id != null)
        {
            Corso corso = mappaCorsiTotali.get(id);
            mappaCorsiCercati.put(id, corso);
        }
        else
        {
            for(Corso corso: mappaCorsiTotali.values())
            {
                if(nome == null || corso.getNome().equalsIgnoreCase(nome))
                {
                    if(livello == null || corso.getLivello().equalsIgnoreCase(livello))
                    {
                        if(lingua == null || corso.getLingua().equalsIgnoreCase(lingua))
                        {
                            mappaCorsiCercati.put(corso.getId(), corso);
                        }
                    }
                }
            }
        }

        return mappaCorsiCercati;
    }

    //Funzione per selezionare uno dei corsi creati da uno studente
    public void selezionaCorsoCreato(Studente studente)
    {
        Map<String, Corso> mappaCorsiCreati = studente.getMappaCorsiCreati();

        System.out.println("I tuoi corsi sono: ");
        for(Corso corso: mappaCorsiCreati.values())
        {
            System.out.println(corso.getNome());
        }

        System.out.println("Inserisci l'id di un corso: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        scanner.close();

        corsoSelezionato = mappaCorsiCreati.get(id);
    }

    //UC4
    
    //Funzione per caricare un appunto tra quelli dello studente
    public void caricaAppunto(String titolo, String formato, String file, String data)
    {
        Appunto appunto = new Appunto(titolo, formato, file, data);

        studente.aggiungiAppunto(appunto);
    }
}