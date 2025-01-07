package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contenuto
{
    private String titolo;
    private String file;
    private String data;
    private String formato;
    private String id;

    public Contenuto(String titolo, String formato, String file)
    {
        this.titolo = titolo;
        SimpleDateFormat dataCreazione = new SimpleDateFormat("dd/MM/yyyy");
        this.data = dataCreazione.format(new Date());
        this.formato = formato;
        this.file = file;
        this.id = StudyHub.generaId();
    }

    public String getId()
    {
        return id;
    }


    public String getTitolo()
    {
        return titolo;
    }

    public String getData()
    {
        return data;
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