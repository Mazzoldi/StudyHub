import java.util.*;

public class Corso 
{
    private String nome;
    private String id;
    private String livello;
    private String costo;
    private String creatore;
    private String lingua;
    private int numero;
    private int durata;

    private Map<String, Studente> mappaStudenti;
    private Map<String, Contenuto> mappaContenuti;

    public Corso(String nome, String livello, String costo, String creatore, String lingua, int durata)
    {
        this.nome = nome;
        this.livello = livello;
        this.costo = costo;
        this.creatore = creatore;
        this.lingua = lingua;
        this.numero = 0;
        this.durata = durata;
        this.id = StudyHub.generaId();
        creaMappaStudenti();
        creaMappaContenuti();
    }

    public void aggiungiStudente(Studente studente)
    {
        mappaStudenti.put(studente.getIdStudente(), studente);
        numero++;
    }

    private Map<String, Studente> creaMappaStudenti()
    {
         Map<String, Studente> mappaStudenti = new HashMap<String, Studente>();
         return mappaStudenti;
    }

    private Map<String, Contenuto> creaMappaContenuti()
    {
         Map<String, Contenuto> mappaContenuti = new HashMap<String, Contenuto>();
         return mappaContenuti;
    }

}
