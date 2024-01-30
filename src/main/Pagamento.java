public class Pagamento 
{
    private String id;
    private String dataPagamento;
    private float costo;
    private DatiPagamento datiPagamento;
    
    public Pagamento(String dataPagamento, float costo, DatiPagamento datiPagamento)
    {
        this.id = StudyHub.generaId();
        this.dataPagamento = dataPagamento;
        this.costo = costo;
        this.datiPagamento = datiPagamento;
    }

    public String getId()
    {
        return id;
    }

    public String getDataPagamento()
    {
        return dataPagamento;
    }

    public float getCosto()
    {
        return costo;
    }

    public DatiPagamento getDatiPagamento()
    {
        return datiPagamento;
    }
}
