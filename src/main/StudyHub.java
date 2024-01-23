import java.util.*;

public class StudyHub 
{
    public static void main(String[] args) 
    {
        
    }

    // Genera un ID univoco
    public static String generaId()
    {
        return UUID.randomUUID().toString();
    }

    public void aggiungiStudente(Corso corso, Studente studente)
    {
        corso.aggiungiStudente(studente);
    }

    
}
