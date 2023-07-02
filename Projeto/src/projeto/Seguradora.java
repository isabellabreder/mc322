package projeto;
import java.util.List;
import java.util.LinkedList;
import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
    //atributos de uma seguradora
    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Seguro> listaSeguros = new ArrayList<Seguro>();
    private static List<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

    //construtor
    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaSeguradoras.add(this);
    }

    //getters da classe
    public String getCnpj(){
        return cnpj;
    }

    public String getNome(){
        return nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public String getEmail(){
        return email;
    }

    public String getEndereco(){
        return endereco;
    }

    public List<Cliente> getListaClientes(){
        return listaClientes;
    }

    public List<Seguro> getListaSeguros(){
        return listaSeguros;
    }

    public static List<Seguradora> getListaSeguradoras(){
        return listaSeguradoras;
    }

    //setters da classe
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setListaClientes(List<Cliente> listaClientes){
        this.listaClientes = listaClientes;
    }

    public void setListaSeguros(List<Seguro> listaSeguros){
        this.listaSeguros = listaSeguros;
    }

    //métodos da classe

    //cadastra um cliente adicionando ele na listaClientes; retorna true se foi adicionado corretamente, e false caso contraŕio
    public boolean cadastrarCliente(Cliente cliente){
        listaClientes.add(cliente);
        if (listaClientes.contains(cliente)){
            return true;
        } else {
            return false;
        }
    }

    //remove um cliente da seguradora removendo ele da listaClientes, na qual é consultado através do nome
    public boolean removerCliente(String cliente){
        boolean remover = false;
        for (Cliente _cliente : listaClientes){
            if(_cliente.getNome() == cliente){
                listaClientes.remove(_cliente);
                remover = true;
            }
        }
        return remover;
    }

    //lista os clientes por nome
    public void listarClientes(String tipoCliente){
        for (Cliente cliente : listaClientes){
            if(cliente.getTipoCliente() == tipoCliente){
                System.out.println(cliente.getNome());
            }
        }
    }
    
    //gera seguro PF
    public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, ClientePF cliente, Veiculo veiculo){
        SeguroPF seguro = new SeguroPF(dataInicio, dataFim, this, veiculo, cliente);
        listaSeguros.add(seguro);
        return true;
    }

    //gera seguro PJ
    public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, ClientePJ cliente, Frota frota){
        SeguroPJ seguro = new SeguroPJ(frota, cliente, dataInicio, dataFim, this);
        listaSeguros.add(seguro);
        return true;
    }

    //cancela um seguro
    public boolean cancelarSeguro(Seguro seguro){
        listaSeguros.remove(seguro);
        return true;
    }

    
    //todo    
    public int calcularReceita() {
        int receita = 0;
    	for (Seguro seguro : this.listaSeguros){
            receita += seguro.getValorMensal();
        }
        return receita;
    }

    @Override
    public String toString(){
    	return "Nome: " + this.nome + "\nTelefone: " + this.telefone + "\nE-mail: " + this.email + "\nEndereço: " + this.endereco + "\nNúmero de Clientes: " + this.listaClientes.size() + "\nNúmero de Seguros: " + this.listaSeguros.size();
    }
}