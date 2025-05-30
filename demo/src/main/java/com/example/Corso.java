package com.example;

import java.util.*;

public class Corso 
{
    private String nome;
    private String id;
    private String livello;
    private float costo;
    private String creatore;
    private String lingua;
    private int numeroStudenti;
    private int dimensioneMassima;
    private int durata;

    private Map<String, Iscrizione> mappaIscrizioni;
    private Map<String, Contenuto> mappaContenuti;

    public Corso(String nome, String livello, float costo, String creatore, String lingua, int durata, int dimensioneMassima)
    {
        this.nome = nome;
        this.livello = livello;
        this.costo = costo;
        this.creatore = creatore;
        this.lingua = lingua;
        this.numeroStudenti = 0;
        this.durata = durata;
        this.dimensioneMassima = dimensioneMassima;
        this.id = StudyHub.generaId();
        creaMappaIscrizioni();
        creaMappaContenuti();
    }

    public void aggiungiIscrizione(Studente studente, Iscrizione iscrizione)
    {
        mappaIscrizioni.put(studente.getId(), iscrizione);
        numeroStudenti++;
    }

    public void rimuoviIscrizione(Studente studente)
    {
        mappaIscrizioni.remove(studente.getId());
        numeroStudenti--;
    }

    private Map<String, Iscrizione> creaMappaIscrizioni()
    {
         this.mappaIscrizioni = new HashMap<String, Iscrizione>();
         return mappaIscrizioni;
    }

    private Map<String, Contenuto> creaMappaContenuti()
    {
         this.mappaContenuti = new HashMap<String, Contenuto>();
         return mappaContenuti;
    }

    public float getCosto()
    {
        return costo;
    }

    public String getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public String getLivello()
    {
        return livello;
    }

    public String getLingua()
    {
        return lingua;
    }

    public void aggiungiContenuto(Contenuto contenuto)
    {
        mappaContenuti.put(contenuto.getId(), contenuto);
    }

    public void rimuoviContenuto(Contenuto contenuto)
    {
        mappaContenuti.remove(contenuto.getId());
    }

    public String getCreatore()
    {
        return creatore;
    }

    public int getDurata()
    {
        return durata;
    }

    public int getDimensioneMassima()
    {
        return dimensioneMassima;
    }

    public Map<String, Iscrizione> getMappaIscrizioni()
    {
        return mappaIscrizioni;
    }

    public Map<String, Contenuto> getMappaContenuti()
    {
        return mappaContenuti;
    }

    public int getNumeroStudenti()
    {
        return numeroStudenti;
    }
}