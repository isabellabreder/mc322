package projeto;
import java.time.LocalDate;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;

    public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios){
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //getters da classe
    public String getCNPJ(){
        return this.cnpj;
    }

    public LocalDate getDataFundacao(){
        return this.dataFundacao;
    }

    @Override
    public String getTipoCliente(){
        return "PJ";
    }
    
    public int getQtdeFuncionarios() {
    	return this.qtdeFuncionarios;
    }

    //setters da classe
    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    
    public void setQtdeFuncionarios(int qtdeFuncionarios) {
    	this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //métodos de um cliente PJ
    @Override
    public double calculaScore() {
    	return CalcSeguro.VALOR_BASE.getValor()*(1+(this.qtdeFuncionarios/100))*super.getQtVeiculos();
    }

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEndereço: " + super.getEndereco() + "\nData de fundação: " + this.dataFundacao;
    }
}