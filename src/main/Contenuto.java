import java.util.*;

public class Contenuto
{
    private String titolo;
    private String data;
    private String formato;
    private String id;

    public Contenuto(String titolo, String data, String formato)
    {
        this.titolo = titolo;
        this.data = data;
        this.formato = formato;
        this.id = StudyHub.generaId();
    }
}