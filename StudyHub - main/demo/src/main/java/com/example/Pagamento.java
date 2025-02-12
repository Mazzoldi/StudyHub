package com.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Pagamento 
{
    private String id;
    private String dataPagamento;
    private float costo;
    private DatiPagamento datiPagamento;
    
    public Pagamento(float costo, DatiPagamento datiPagamento)
    {
        this.id = StudyHub.generaId();
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedCurrentDate = dateFormat.format(currentDate);
        this.dataPagamento = formattedCurrentDate;
        this.costo = costo;
        this.datiPagamento = datiPagamento;
    }

    public String getId()
    {
        return id;
    }

    public String getDataPagamento()
    {
        return dataPagamento;
    }

    public float getCosto()
    {
        return costo;
    }

    public DatiPagamento getDatiPagamento()
    {
        return datiPagamento;
    }
}