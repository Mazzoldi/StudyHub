import java.util.*;

public class Studente
{
    private String nome;
    private String cognome;
    private String dataNascita;
    private String luogoNascita;
    private String residenza;
    private String dataIscrizioneSito;
    private String id;
    private String livello;
    private int numeroCorsi;

    private Map<String, Appunto> mappaAppunti;
    private Map<String, Iscrizione> mappaIscrizioni;
    private Map<String, DatiPagamento> mappaDatiPagamento;

    public Studente(String nome, String cognome, String dataNascita, String luogoNascita, String residenza, String dataIscrizioneSito, String livello)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.residenza = residenza;
        this.dataIscrizioneSito = dataIscrizioneSito;
        this.livello = livello;
        this.numeroCorsi = 0;
        this.id = StudyHub.generaId();
        creaMappaAppunti();
        creaMappaIscrizioni();
        creaMappaDatiPagamento();
    }

    public DatiPagamento creaDatiPagamento(String metodo, String numeroCarta, String nome, String cognome)
    {
        return new DatiPagamento(metodo, numeroCarta, nome, cognome);
    }

    public void aggiungiIscrizione(Corso corso, Iscrizione iscrizione)
    {
        mappaIscrizioni.put(corso.getId(), iscrizione);
        numeroCorsi++;
    }

    private Map<String, Appunto> creaMappaAppunti()
    {
         Map<String, Appunto> mappaAppunti = new HashMap<String, Appunto>();
         return mappaAppunti;
    }

    private Map<String, Iscrizione> creaMappaIscrizioni()
    {
         Map<String, Iscrizione> mappaIscrizioni = new HashMap<String, Iscrizione>();
         return mappaIscrizioni;
    }

    public Map<String, DatiPagamento> creaMappaDatiPagamento()
    {
        Map<String, DatiPagamento> mappaDatiPagamento = new HashMap<String, DatiPagamento>();
        return mappaDatiPagamento;
    }

    public String getId()
    {
        return this.id;
    }

    public DatiPagamento usaDatiPagamento()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero della carta: ");
        String numeroCarta = scanner.nextLine();
        scanner.close();

        return mappaDatiPagamento.get(numeroCarta);
    }

}