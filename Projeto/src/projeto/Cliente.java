package projeto;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
    //atributos de um cliente
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    //construtor
    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    //getters da classe
    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getTipoCliente(){
        return "";
    }

    public List<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }

    //setters da classe
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setVeiculo(Veiculo veiculo){
        this.listaVeiculos.add(veiculo);
    }

    //faz a sobrecarga do método toString(), retornando as propriedades do objeto
    public String toString(){
        return "Nome: " + this.nome + "\nEndereço: " + this.endereco + "\nVeículos: " + this.listaVeiculos;
    }

}