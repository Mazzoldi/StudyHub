package com.example;

import java.util.*;
import java.text.SimpleDateFormat;

public class Studente
{
    Scanner scanner = new Scanner(System.in);

    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String luogoNascita;
    private String residenza;
    private String dataIscrizioneSito;
    private String id;
    private String livello;
    private int numeroCorsi;

    private Map<String, Appunto> mappaAppunti;
    private Map<String, Iscrizione> mappaIscrizioni;
    private Map<String, DatiPagamento> mappaDatiPagamento;
    private Map<String, Corso> mappaCorsiCreati;

    public Studente(String username, String password, String nome, String cognome, String dataNascita, String luogoNascita, String residenza, String livello)
    {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.residenza = residenza;
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        this.dataIscrizioneSito = data.format(new Date());
        this.livello = livello;
        this.numeroCorsi = 0;
        this.id = StudyHub.generaId();
        creaMappaAppunti();
        creaMappaIscrizioni();
        creaMappaDatiPagamento();
        creaMappaCorsiCreati();
    }

    public DatiPagamento creaDatiPagamento(String metodo, String numeroCarta, String nome, String cognome)
    {
        if (mappaDatiPagamento.containsKey(numeroCarta))
        {
            return mappaDatiPagamento.get(numeroCarta);
        }

        DatiPagamento nuoviDatiPagamento = new DatiPagamento(metodo, numeroCarta, nome, cognome);
        mappaDatiPagamento.put(numeroCarta, nuoviDatiPagamento);
        return nuoviDatiPagamento;
    }

    public void aggiungiIscrizione(Corso corso, Iscrizione iscrizione)
    {
        mappaIscrizioni.put(corso.getId(), iscrizione);
        numeroCorsi++;
    }

    private Map<String, Appunto> creaMappaAppunti()
    {
         this.mappaAppunti = new HashMap<String, Appunto>();
         return mappaAppunti;
    }

    private Map<String, Iscrizione> creaMappaIscrizioni()
    {
         this.mappaIscrizioni = new HashMap<String, Iscrizione>();
         return mappaIscrizioni;
    }

    public Map<String, DatiPagamento> creaMappaDatiPagamento()
    {
        this.mappaDatiPagamento = new HashMap<String, DatiPagamento>();
        return mappaDatiPagamento;
    }

    public Map<String, Corso> creaMappaCorsiCreati()
    {
        this.mappaCorsiCreati = new HashMap<String, Corso>();
        return mappaCorsiCreati;
    }

    public String getId()
    {
        return this.id;
    }

    public DatiPagamento usaDatiPagamento()
    {
        System.out.println("Inserisci il numero della carta (formato XXXX-XXXX-XXXX-XXXX): ");
        String numeroCarta = scanner.nextLine();

        return mappaDatiPagamento.get(numeroCarta);
    }

    public Map<String, Corso> getMappaCorsiCreati()
    {
        return mappaCorsiCreati;
    }

    public void aggiungiAppunto(Appunto appunto)
    {
        mappaAppunti.put(appunto.getId(), appunto);
    }

    public boolean verificaPassword(String password)
    {
        return this.password.equals(password);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    public String getDataNascita()
    {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita)
    {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita()
    {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita)
    {
        this.luogoNascita = luogoNascita;
    }

    public String getResidenza()
    {
        return residenza;
    }

    public void setResidenza(String residenza)
    {
        this.residenza = residenza;
    }

    public String getDataIscrizioneSito()
    {
        return dataIscrizioneSito;
    }

    public void setDataIscrizioneSito(String dataIscrizioneSito)
    {
        this.dataIscrizioneSito = dataIscrizioneSito;
    }

    public String getLivello()
    {
        return livello;
    }

    public void setLivello(String livello)
    {
        this.livello = livello;
    }

    public int getNumeroCorsi()
    {
        return numeroCorsi;
    }

    public void setNumeroCorsi(int numeroCorsi)
    {
        this.numeroCorsi = numeroCorsi;
    }

    public Map<String, Appunto> getMappaAppunti()
    {
        return mappaAppunti;
    }

    public Map<String, Iscrizione> getMappaIscrizioni()
    {
        return mappaIscrizioni;
    }

    public Map<String, DatiPagamento> getMappaDatiPagamento()
    {
        return mappaDatiPagamento;
    }
}