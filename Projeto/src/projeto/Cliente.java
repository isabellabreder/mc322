package projeto;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
    //atributos de um cliente
    private String nome;
    private String endereco;
    private String email;
    private int telefone;
    private double valorSeguro;
    private int qtVeiculos;
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    //construtor
    public Cliente(String nome, String endereco, String email, int telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.valorSeguro = 0;
        listaClientes.add(this);
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

    public double getValorSeguro() {
    	return this.valorSeguro;
    }

    public int getQtVeiculos(){
        return this.qtVeiculos;
    }

    public String getEmail(){
        return this.email;
    }

    public int getTelefone(){
        return this.telefone;
    }

    public static List<Cliente> getListaClientes(){
        return listaClientes;
    }

    //setters da classe
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public void setValorSeguro(double valorSeguro) {
    	this.valorSeguro = valorSeguro;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    //faz a sobrecarga do método toString(), retornando as propriedades do objeto
    public String toString(){
        return "Nome: " + this.nome + "\nEndereço: " + this.endereco + "\nVeículos: " + this.listaVeiculos;
    }

}