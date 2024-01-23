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

    private Map<String, Appunto> mappaAppunti;
    private Map<String, Corso> mappaCorsi;

    public Studente(String nome, String cognome, String dataNascita, String luogoNascita, String residenza, String dataIscrizioneSito, String livello)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.residenza = residenza;
        this.dataIscrizioneSito = dataIscrizioneSito;
        this.livello = livello;
        this.id = StudyHub.generaId();
        creaMappaAppunti();
        creaMappaCorsi();
    }

    public DatiPagamento creaDatiPagamento(float importo, String metodo, String numeroCarta, String nome, String cognome)
    {
        return new DatiPagamento(importo, metodo, numeroCarta, nome, cognome);
    }

    private Map<String, Appunto> creaMappaAppunti()
    {
         Map<String, Appunto> mappaAppunti = new HashMap<String, Appunto>();
         return mappaAppunti;
    }

    private Map<String, Corso> creaMappaCorsi()
    {
         Map<String, Corso> mappaCorsi = new HashMap<String, Corso>();
         return mappaCorsi;
    }

    public String getIdStudente()
    {
        return this.id;
    }
}