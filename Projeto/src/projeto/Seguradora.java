package projeto;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Seguradora {
    //atributos de uma seguradora
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros = new LinkedList<Sinistro>();
    private List<Cliente> listaClientes = new ArrayList<Cliente>();

    //construtor
    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //getters da classe
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

    public List<Sinistro> getListaSinistros(){
        return listaSinistros;
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

    public void setListaSinistros(List<Sinistro> listaSinistros){
        this.listaSinistros = listaSinistros;
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

    //gera o sinistro de um veiculo de um cliente
    public boolean gerarSinistro(String data, String endereco, Veiculo veiculo, Cliente cliente){
        boolean adicionado = false;
        Sinistro _sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        listaSinistros.add(_sinistro); 
        if (listaSinistros.contains(_sinistro)){
            adicionado = true;
        }
        return adicionado;
    }

    //lista os sinistros de um cliente específico
    public boolean visualizarSinistro(String cliente){
        boolean listado = false;
        for(Sinistro sinistro : listaSinistros){
            if(sinistro.getCliente().getNome() == cliente){
                System.out.println(sinistro);
                listado = true;
            }
        }
        return listado;
    }

    //lista todos os sinistros da seguradora
    public void listarSinistros(){
        for (Sinistro sinistro : listaSinistros){
            System.out.println("ID do sinistro: " + sinistro.getId() + "        Cliente: " + sinistro.getCliente().getNome());
        }
    }

    @Override
    public String toString(){
    	return "Nome: " + this.nome + "\nTelefone: " + this.telefone + "\nE-mail: " + this.email + "\nEndereço: " + this.endereco + "\nNúmero de Clientes: " + this.listaClientes.size() + "\nNúmero de Sinistros: " + this.listaSinistros.size();
    }
}
