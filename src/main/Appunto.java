import java.util.*;

public class Appunto 
{
    private String titolo;
    private String dataCaricamento;
    private String formato;
    private String id;

    public Appunto(String titolo, String dataCaricamento, String formato)
    {
        this.titolo = titolo;
        this.dataCaricamento = dataCaricamento;
        this.formato = formato;
        this.id = StudyHub.generaId();
    }
}
