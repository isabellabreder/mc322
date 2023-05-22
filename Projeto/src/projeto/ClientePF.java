package projeto;
import java.time.LocalDate;
import java.time.Period;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento; 
    private String classeEconomica;
    private int idade; 

    public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica){
        super(nome, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
        this.setIdade();
    }
    //getters da classe
    public String getCPF(){
        return cpf;
    }

    public String getGenero(){
        return genero;
    }

    public LocalDate getDataLicenca(){
        return dataLicenca;
    }

    public String getEducacao(){
        return educacao;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public String getClasseEconomica(){
        return classeEconomica;
    }

    @Override
    public String getTipoCliente(){
        return "PF";
    }

    public int getIdade(){
        return idade;
    }

    //setters da classe
    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setDataLicenca(LocalDate dataLicenca){
        this.dataLicenca = dataLicenca;
    }

    public void setEducacao(String educacao){
        this.educacao = educacao;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }

    //calcula a idade da pessoa
    public void setIdade(){
        LocalDate atual = LocalDate.now();
        Period intervalo = Period.between(this.dataNascimento, atual);
        this.idade = intervalo.getYears();
    }

    //métodos de um cliente PF
    @Override
    public double calculaScore() {
    	return CalcSeguro.VALOR_BASE.getValor()*CalcSeguro.getFatorIdade(idade)*super.getQtVeiculos();
    }

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEndereço: " + super.getEndereco() + "\nCPF: " + this.cpf + "\nGenero: " + this.genero + "\nData de licença: " + this.dataLicenca + "\nEducação: " + this.educacao + "\nData de nascimento: " + this.dataNascimento + "\nClasse econômica: " + this.classeEconomica;
    }
}