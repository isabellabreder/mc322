package projeto;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
    //atributos de um cliente
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    private double valorSeguro;
    private int qtVeiculos;

    //construtor
    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.valorSeguro = 0;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //getters da classe
    public String getNome(){
        return this.nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public String getTipoCliente(){
        return "";
    }

    public List<Veiculo> getListaVeiculos(){
        return this.listaVeiculos;
    }
    
    public double getValorSeguro() {
    	return this.valorSeguro;
    }

    public int getQtVeiculos(){
        return this.qtVeiculos;
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
    
    public void setValorSeguro(double valorSeguro) {
    	this.valorSeguro = valorSeguro;
    }
    
    //métodos de um cliente
    public boolean cadastraVeiculo(Veiculo veiculo){
        this.listaVeiculos.add(veiculo);
        this.qtVeiculos += 1;
        return listaVeiculos.contains(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo){
        this.listaVeiculos.remove(veiculo);
        this.qtVeiculos -= 1;
        if (listaVeiculos.contains(veiculo)){
            return false;
        } else {
            return true;
        }
    }

    public double calculaScore() {
    	return calculaScore();
    }
    
    //faz a sobrecarga do método toString(), retornando as propriedades do objeto
    public String toString(){
        return "Nome: " + this.nome + "\nEndereço: " + this.endereco + "\nVeículos: " + this.listaVeiculos;
    }

}