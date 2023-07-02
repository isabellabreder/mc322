package projeto;
import java.time.LocalDate;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    //construtor
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente){
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //getters da classe
    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public ClientePF getCliente() {
        return this.cliente;
    }

    //setters da classe
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    public double calcularValor(Cliente cliente){
        ClientePF _cliente = (ClientePF) cliente;
        int idade = _cliente.getIdade();

        int qtdveiculos = _cliente.getqtdVeiculos();
        return CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.getFatorIdade(idade) * qtdveiculos;
    }

}