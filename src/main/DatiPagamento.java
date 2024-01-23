import java.util.*;

public class DatiPagamento 
{
    private float importo;
    private String metodo;
    private String numeroCarta;
    private String nome;
    private String cognome;

    public DatiPagamento(float importo, String metodo, String numeroCarta, String nome, String cognome)
    {
        this.importo = importo;
        this.metodo = metodo;
        this.numeroCarta = numeroCarta;
        this.nome = nome;
        this.cognome = cognome;
    }

    public float getImporto()
    {
        return importo;
    }

    public String getMetodo()
    {
        return metodo;
    }

    public String getNumeroCarta()
    {
        return numeroCarta;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }
}
