package com.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Iscrizione 
{
    private String id;
    private String dataIscrizione;
    private String dataScadenza;
    private String studente;
    private String corso;
    private Map<String, Pagamento> mappaPagamenti;

    public Iscrizione(String studente, String corso)
    {
        this.studente = studente;
        this.corso = corso;
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        this.dataIscrizione = formattedCurrentDate;
        String formattedFutureDate = dateFormat.format(futureDate);
        this.dataScadenza = formattedFutureDate;
        this.id = StudyHub.generaId();
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

    public boolean verificaPagamento(String idPagamento)
    {
        if (mappaPagamenti.containsKey(idPagamento))
        {
            return true;
        }
        return false;
    }

    public String getId()
    {
        return id;
    }

    public String getStudente()
    {
        return studente;
    }

    public String getCorso()
    {
        return corso;
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