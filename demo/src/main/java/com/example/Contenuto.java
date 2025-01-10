package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contenuto
{
    private String titolo;
    private String file;
    private String dataCreazione;
    private String dataUltimaModifica;
    private String formato;
    private String id;

    public Contenuto(String titolo, String formato, String file)
    {
        this.titolo = titolo;
        SimpleDateFormat dataCreazione = new SimpleDateFormat("dd/MM/yyyy");
        this.dataCreazione = dataCreazione.format(new Date());
        this.dataUltimaModifica = dataCreazione.format(new Date());
        this.formato = formato;
        this.file = file;
        this.id = StudyHub.generaId();
    }

    public void modificaContenuto(String titolo, String file)
    {
        this.titolo = titolo;
        this.file = file;
        SimpleDateFormat dataUltimaModifica = new SimpleDateFormat("dd/MM/yyyy");
        this.dataUltimaModifica = dataUltimaModifica.format(new Date());
    }

    public String getId()
    {
        return id;
    }


    public String getTitolo()
    {
        return titolo;
    }

    public String getDataCreazione()
    {
        return dataCreazione;
    }

    public String getDataUltimaModifica()
    {
        return dataUltimaModifica;
    }

    public String getFormato()
    {
        return formato;
    }

    public String getFile()
    {
        return file;
    }
}