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
    private int numeroStudenti;
    private int numeroMaxStudenti;
    private Map<String, Studente> mappaStudenti;
    private Map<String, Appunto> mappaAppunti;

    public GruppoStudio(String nome, String admin, String password, String lingua, int numeroMaxStudenti)
    {
        this.nome = nome;
        this.admin = admin;
        this.password = password;
        this.lingua = lingua;
        this.numeroStudenti = 0;
        SimpleDateFormat dataCreazione = new SimpleDateFormat("dd/MM/yyyy");
        this.data = dataCreazione.format(new Date());
        this.numeroMaxStudenti = numeroMaxStudenti;
        this.id = StudyHub.generaId();
        creaMappaStudenti();
        creaMappaAppunti();
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

    public boolean aggiungiAppunto(Appunto appunto)
    {
        mappaAppunti.put(appunto.getId(), appunto);
        if(mappaAppunti.containsKey(appunto.getId()))
        {
            return true;
        }
        return false;
    }

    public boolean rimuoviAppunto(Appunto appunto)
    {
        mappaAppunti.remove(appunto.getId());
        if(mappaAppunti.containsKey(appunto.getId()))
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

    public Map<String, Appunto> creaMappaAppunti()
    {
        this.mappaAppunti = new HashMap<String, Appunto>();
        return mappaAppunti;
    }

    public String getId()
    {
        return id;
    }

    public String getAdmin()
    {
        return mappaStudenti.get(admin).getId();
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

    public int getNumeroStudenti()
    {
        return numeroStudenti;
    }

    public int getNumeroMaxStudenti()
    {
        return numeroMaxStudenti;
    }

    public Map<String, Studente> getMappaStudenti()
    {
        return mappaStudenti;
    }

    public Map<String, Appunto> getMappaAppunti()
    {
        return mappaAppunti;
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

    public void setNumeroStudenti(int numeroStudenti)
    {
        this.numeroStudenti = numeroStudenti;
    }

    public void setNumeroMaxStudenti(int numeroMaxStudenti)
    {
        this.numeroMaxStudenti = numeroMaxStudenti;
    }

    public void setMappaStudenti(Map<String, Studente> mappaStudenti)
    {
        this.mappaStudenti = mappaStudenti;
    }
}
