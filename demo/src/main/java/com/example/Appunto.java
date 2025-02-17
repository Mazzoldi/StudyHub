package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appunto 
{
    private String creatore;
    private String titolo;
    private String dataCreazione;
    private String dataUltimaModifica;
    private String formato;
    private String file;
    private int dimensione;
    private String id;

    public Appunto(String creatore, String titolo, String formato, String file, int dimensione)
    {
        this.creatore = creatore;
        this.titolo = titolo;
        SimpleDateFormat dataCreazione = new SimpleDateFormat("dd/MM/yyyy");
        this.dataCreazione = dataCreazione.format(new Date());
        this.dataUltimaModifica = dataCreazione.format(new Date());
        this.file = file;
        this.formato = formato;
        this.dimensione = dimensione;
        this.id = StudyHub.generaId();
    }

    public void modificaAppunto(String titolo, String file)
    {
        this.titolo = titolo;
        this.file = file;
        SimpleDateFormat dataModifica = new SimpleDateFormat("dd/MM/yyyy");
        this.dataUltimaModifica = dataModifica.format(new Date());
    }

    public String getId()
    {
        return id;
    }

    public String getCreatore()
    {
        return creatore;
    }

    public String getTitolo()
    {
        return titolo;
    }

    public String getDataCreazione()
    {
        return dataCreazione;
    }

    public String getFormato()
    {
        return formato;
    }

    public String getFile()
    {
        return file;
    }

    public String getDataUltimaModifica()
    {
        return dataUltimaModifica;
    }

    public int getDimensione()
    {
        return dimensione;
    }
}