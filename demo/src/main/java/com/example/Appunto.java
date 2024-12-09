package com.example;

public class Appunto 
{
    private String titolo;
    private String data;
    private String formato;
    private String file;
    private String id;

    public Appunto(String titolo, String data, String formato, String file)
    {
        this.titolo = titolo;
        this.data = data;
        this.file = file;
        this.formato = formato;
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