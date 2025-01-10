package com.example;

import java.util.*;
import java.text.SimpleDateFormat;

public class GruppoStudio {
    private String nome;
    private String id;
    private String password;
    private String admin;
    private String lingua;
    private String data;
    private int durata;
    private int numeroStudenti;
    private Map<String, Studente> mappaStudenti;

    public GruppoStudio(String nome, String admin, String password, String lingua, int durata)
    {
        this.nome = nome;
        this.admin = admin;
        this.password = password;
        this.lingua = lingua;
        this.numeroStudenti = 0;
        SimpleDateFormat dataCreazione = new SimpleDateFormat("dd/MM/yyyy");
        this.data = dataCreazione.format(new Date());
        this.durata = durata;
        this.id = StudyHub.generaId();
        creaMappaStudenti();
    }

    public boolean verificaIscrizione(Studente studente)
    {
        if (mappaStudenti.containsKey(studente.getId()))
        {
            return true;
        }
        return false;
    }

    public boolean passwordCorretta(String password)
    {
        if (this.password.equals(password))
        {
            return true;
        }
        return false;
    }

    public boolean aggiungiStudente(Studente studente)
    {
        mappaStudenti.put(studente.getId(), studente);
        numeroStudenti++;
        if(mappaStudenti.containsKey(studente.getId()))
        {
            return true;
        }
        return false;
    }

    public boolean rimuoviStudente(Studente studente)
    {
        mappaStudenti.remove(studente.getId());
        numeroStudenti--;
        if(mappaStudenti.containsKey(studente.getId()))
        {
            return true;
        }
        return false;
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
        return mappaStudenti.get(admin).getUsername();
    }

    public String getNome()
    {
        return nome;
    }

    public String getPassword()
    {
        return password;
    }

    public String getLingua()
    {
        return lingua;
    }

    public String getDataCreazione()
    {
        return data;
    }

    public int getDurata()
    {
        return durata;
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

    public void setDurata(int durata)
    {
        this.durata = durata;
    }

    public void setMappaStudenti(Map<String, Studente> mappaStudenti)
    {
        this.mappaStudenti = mappaStudenti;
    }
}
