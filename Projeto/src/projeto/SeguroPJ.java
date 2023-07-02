package projeto;
import java.time.LocalDate;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    //construtor
    public SeguroPJ(Frota frota, ClientePJ cliente, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora){
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }

    //getters da classe
    public Frota getFrota() {
        return frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    //setters da classe
    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    public double calcularValor(Cliente cliente){
        ClientePJ _cliente = (ClientePJ) cliente;
        _cliente.getIdade();
        int qtFuncionarios = this.getListaCondutores().size();
        return (CalcSeguro.VALOR_BASE.getValor() * ( 10 + (qtFuncionarios)/10.0));
    }

}
