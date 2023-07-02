package projeto;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    private int idade; 
    private List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public ClientePF(String nome, String endereco, String email, int telefone, String cpf, String genero, String educacao, LocalDate dataNascimento){
        super(nome, endereco, email, telefone);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = new ArrayList<Veiculo>();
        this.setIdade();
    }

    //getters da classe
    public String getCPF(){
        return this.cpf;
    }

    public String getGenero(){
        return this.genero;
    }

    public String getEducacao(){
        return this.educacao;
    }

    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

    @Override
    public String getTipoCliente(){
        return "PF";
    }

    public int getIdade(){
        return this.idade;
    }

    public int getqtdVeiculos(){
        return this.listaVeiculos.size();
    }

    //setters da classe
    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setEducacao(String educacao){
        this.educacao = educacao;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    //calcula a idade da pessoa
    public void setIdade(){
        LocalDate atual = LocalDate.now();
        Period intervalo = Period.between(this.dataNascimento, atual);
        this.idade = intervalo.getYears();
    }

    //cadastra um veiculo
    public boolean cadastrarVeiculo(Veiculo veiculo){
        boolean add = false;
        listaVeiculos.add(veiculo);
        if (listaVeiculos.contains(veiculo)){
            add = true;
        }
        return add;
    }

    //remove um veiculo
    public boolean removeVeiculo(Veiculo veiculo){
        boolean rm = false;
        listaVeiculos.remove(veiculo);
        if (!listaVeiculos.contains(veiculo)){
            rm = true;
        }
        return rm;
    }

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEndereço: " + super.getEndereco() + "\nCPF: " + this.cpf + "\nGenero: " + this.genero + "\nEducação: " + this.educacao + "\nData de nascimento: " + this.dataNascimento;
    }
}