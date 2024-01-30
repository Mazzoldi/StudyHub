import java.util.*;

public class Iscrizione 
{
    private String dataIscrizione;
    private String dataScadenza;
    private String idStudente;
    private String idCorso;
    private Map<String, Pagamento> mappaPagamenti;

    public Iscrizione(String dataIscrizione, String dataScadenza, String idStudente, String idCorso)
    {
        this.dataIscrizione = dataIscrizione;
        this.dataScadenza = dataScadenza;
        this.idStudente = idStudente;
        this.idCorso = idCorso;
        creaMappaPagamenti();
    }

    private Map<String, Pagamento> creaMappaPagamenti()
    {
        Map<String, Pagamento> mappaPagamenti = new HashMap<String, Pagamento>();
        return mappaPagamenti;
    }

    public void aggiungiPagamento(Pagamento pagamento)
    {
        mappaPagamenti.put(pagamento.getId(), pagamento);
    }

    public String getIdStudente()
    {
        return idStudente;
    }

    public String getIdCorso()
    {
        return idCorso;
    }

    public String getDataScadenza()
    {
        return dataScadenza;
    }

    public String getDataIscrizione()
    {
        return dataIscrizione;
    }

    public Map<String, Pagamento> getMappaPagamenti()
    {
        return mappaPagamenti;
    }
}
