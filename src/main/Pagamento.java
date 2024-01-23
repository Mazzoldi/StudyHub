public class Pagamento 
{
    private String id;
    private String dataPagamento;
    
    public Pagamento(String id, String dataPagamento)
    {
        this.id = StudyHub.generaId();
        this.dataPagamento = dataPagamento;
    }
}
