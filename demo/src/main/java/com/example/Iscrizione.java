package com.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Iscrizione 
{
    private String dataIscrizione;
    private String dataScadenza;
    private String idStudente;
    private String idCorso;
    private Map<String, Pagamento> mappaPagamenti;

    public Iscrizione(String idStudente, String idCorso)
    {
        this.idStudente = idStudente;
        this.idCorso = idCorso;
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        this.dataIscrizione = formattedCurrentDate;
        String formattedFutureDate = dateFormat.format(futureDate);
        this.dataScadenza = formattedFutureDate;
        creaMappaPagamenti();
    }

    private Map<String, Pagamento> creaMappaPagamenti()
    {
        this.mappaPagamenti = new HashMap<String, Pagamento>();
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