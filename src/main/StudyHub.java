import java.util.*;
import java.text.SimpleDateFormat;

public class StudyHub 
{
    private Studente studente;
    private Corso corsoSelezionato;
    Map<String, Corso> mappaCorsiTotali = new HashMap<String, Corso>();

    public static void main(String[] args) 
    {
        StudyHub studyHub = new StudyHub();

        Scanner scanner = new Scanner(System.in);
        int scelta;

        String titolo;
        String formato;
        String file;
        String data;
        String nome;
        String livello;
        String id;
        String lingua;

        do {
            System.out.println("Menu:");
            System.out.println("1. Carica appunto");
            System.out.println("2. Carica contenuto");
            System.out.println("3. Iscrizione ad un corso");
            System.out.println("4. Esci");

            System.out.print("Seleziona un'opzione: ");
            scelta = scanner.nextInt();

            switch (scelta) 
            {
                case 1:
                    System.out.println("Hai selezionato Carica appunto");
                    System.out.println("Inserisci i dati relativi all'appunto: ");
                    titolo = scanner.nextLine();
                    formato = scanner.nextLine();
                    file = scanner.nextLine();
                    data = scanner.nextLine();
                    studyHub.caricaAppunto(titolo, formato, file, data);
                    break;
                case 2:
                    System.out.println("Hai selezionato Carica contenuto");
                    System.out.println("Inserisci i dati relativi al contenuto: ");
                    titolo = scanner.nextLine();
                    formato = scanner.nextLine();
                    file = scanner.nextLine();
                    data = scanner.nextLine();
                    studyHub.caricaContenuto(titolo, formato, file, data);
                    break;
                case 3:
                    System.out.println("Hai selezionato Iscrizione ad un corso");
                    System.out.println("Inserisci i dati relativi al corso: ");
                    nome = scanner.nextLine();
                    livello = scanner.nextLine();
                    id = scanner.nextLine();
                    lingua = scanner.nextLine();
                    studyHub.selezionaCorso(studyHub.cercaCorso(nome, livello, id, lingua));
                    studyHub.iscrizioneCorso(studyHub.studente, studyHub.corsoSelezionato);
                    break;
                case 4:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        } while (scelta != 4);

        scanner.close();
        
    }

    public static String generaId()
    {
        return UUID.randomUUID().toString();
    }

    public void aggiungiIscrizione(Studente studente, Corso corso, Iscrizione iscrizione)
    {
        corso.aggiungiIscrizione(studente, iscrizione);
        studente.aggiungiIscrizione(corso, iscrizione);
    }

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
            boolean conferma = pagamentoIscrizione(studente, costo);
            if(!conferma)
            {
                System.out.println("Pagamento non andato a buon fine");
            }
        }
    }

    public boolean pagamentoIscrizione(Studente studente, float costo)
    {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        String formattedFutureDate = dateFormat.format(futureDate);
        boolean conferma = false;

        DatiPagamento datiPagamento = usaDatiPagamento(studente);

        if(datiPagamento == null)
        {
            System.out.println("Non hai inserito i dati di pagamento");
            return conferma;
        }

        // Presumiamo che sia sempre vero anche se serve un sistema di pagamento esterno
        conferma = true;

        if(conferma)
        {        
            Iscrizione iscrizione = new Iscrizione(formattedCurrentDate, formattedFutureDate, studente.getId(), corsoSelezionato.getId());
            aggiungiIscrizione(studente, corsoSelezionato, iscrizione);

            Pagamento pagamento = new Pagamento(formattedCurrentDate, costo, datiPagamento);

            iscrizione.aggiungiPagamento(pagamento);
        }

        conferma = true;
        return conferma;
    }

    public DatiPagamento usaDatiPagamento(Studente studente)
    {
        DatiPagamento datiPagamento = studente.usaDatiPagamento();
        return datiPagamento;
    }

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

    public void selezionaCorso(Map<String, Corso> mappaCorsiCercati)
    {
        System.out.println("I corsi trovati sono: ");
        for(Corso corso: mappaCorsiCercati.values())
        {
            System.out.println(corso.getNome());
        }

        System.out.println("Inserisci l'id di un corso: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        scanner.close();

        corsoSelezionato = mappaCorsiCercati.get(id);
    }

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

    public void caricaContenuto(String titolo, String formato, String file, String data)
    {
        Contenuto contenuto = new Contenuto(titolo, formato, file, data);

        corsoSelezionato.aggiungiContenuto(contenuto);
    }

    public void caricaAppunto(String titolo, String formato, String file, String data)
    {
        Appunto appunto = new Appunto(titolo, formato, file, data);

        studente.aggiungiAppunto(appunto);
    }
}
