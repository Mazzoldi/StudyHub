package com.example;

public class DatiPagamento 
{
    private String metodo;
    private String numeroCarta;
    private String nome;
    private String cognome;

    public DatiPagamento(String metodo, String numeroCarta, String nome, String cognome)
    {
        this.metodo = metodo;
        this.numeroCarta = numeroCarta;
        this.nome = nome;
        this.cognome = cognome;
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

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
}