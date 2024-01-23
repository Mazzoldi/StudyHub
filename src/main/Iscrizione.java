import java.util.*;

public class Iscrizione 
{
    private String dataIscrizione;
    private String dataScadenza;
    private String id;

    public Iscrizione(String dataIscrizione, String dataScadenza)
    {
        this.dataIscrizione = dataIscrizione;
        this.dataScadenza = dataScadenza;
        this.id = StudyHub.generaId();
    }
}
