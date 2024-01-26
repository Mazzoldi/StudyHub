import java.util.*;
import java.text.SimpleDateFormat;

public class StudyHub 
{
    public static void main(String[] args) 
    {
        
    }

    public static String generaId()
    {
        return UUID.randomUUID().toString();
    }

    public void aggiungiIscrizione(Studente studente, Corso corso, Iscrizione iscrizione)
    {
        corso.aggiungiIscrizione(studente, iscrizione);
        studente.aggiungiIscrizione(corso, iscrizione);
    }

    public void iscrizioneCorso(Studente studente, Corso corso)
    {
        float costo = corso.getCosto();

        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();

        cal.add(Calendar.DATE, 30);
        Date futureDate = cal.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedCurrentDate = dateFormat.format(currentDate);
        String formattedFutureDate = dateFormat.format(futureDate);
        
        if (costo == 0)
        {
            Iscrizione iscrizione = new Iscrizione(formattedCurrentDate, formattedFutureDate, studente.getId(), corso.getId());
            aggiungiIscrizione(studente, corso, iscrizione);
        }
        else
        {
            boolean conferma = pagamentoIscrizione(studente, costo);
            if(conferma)
            {        
                Iscrizione iscrizione = new Iscrizione(formattedCurrentDate, formattedFutureDate, studente.getId(), corso.getId());
                aggiungiIscrizione(studente, corso, iscrizione);

                Pagamento pagamento = new Pagamento(formattedCurrentDate);
            }
        }
    }

    public boolean pagamentoIscrizione(Studente studente, float costo)
    {
        boolean conferma = false;

        DatiPagamento datiPagamento = usaDatiPagamento(studente);

        if(datiPagamento == null)
        {
            System.out.println("Non hai inserito i dati di pagamento");
            return conferma;
        }

        conferma = true;
        return conferma;
    }

    public DatiPagamento usaDatiPagamento(Studente studente)
    {
        DatiPagamento datiPagamento = studente.usaDatiPagamento();
        return datiPagamento;
    }
}
