package com.example;

import java.util.*;

public class GruppoStudio {
    private String nome;
    private String id;
    private String password;
    private String admin;
    private String lingua;
    private int numeroStudenti;
    private Map<String, Studente> mappaStudenti;

    public GruppoStudio(String nome, String admin, String password, String lingua, int durata)
    {
        this.nome = nome;
        this.admin = admin;
        this.password = password;
        this.lingua = lingua;
        this.numeroStudenti = 0;
        this.id = StudyHub.generaId();
        creaMappaStudenti();
    }

    public boolean verificaPassword(Studente studente, String password)
    {
        if (this.password.equals(password))
        {
            aggiungiStudente(studente);
            return true;
        }
        return false;
    }

    private void aggiungiStudente(Studente studente)
    {
        mappaStudenti.put(studente.getId(), studente);
        numeroStudenti++;
    }

    public void rimuoviStudente(Studente studente)
    {
        mappaStudenti.remove(studente.getId());
        numeroStudenti--;
    }

    private Map<String, Studente> creaMappaStudenti()
    {
        this.mappaStudenti = new HashMap<String, Studente>();
        return mappaStudenti;
    }

    public String getId()
    {
        return id;
    }

    public String getAdmin()
    {
        return admin;
    }

    public String getNome()
    {
        return nome;
    }

    public String getLingua()
    {
        return lingua;
    }

    public int getNumeroStudenti()
    {
        return numeroStudenti;
    }

    public Map<String, Studente> getMappaStudenti()
    {
        return mappaStudenti;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setAdmin(String admin)
    {
        this.admin = admin;
    }

    public void setLingua(String lingua)
    {
        this.lingua = lingua;
    }

    public void setMappaStudenti(Map<String, Studente> mappaStudenti)
    {
        this.mappaStudenti = mappaStudenti;
    }
}
