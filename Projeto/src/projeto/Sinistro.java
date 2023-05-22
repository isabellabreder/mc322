package projeto;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Sinistro {
    //atributos de um sinistro 
    private final int id;
    private LocalDate data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    private static List<Integer> idsGerados = new ArrayList<>();

    //construtor
    public Sinistro(LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        boolean existe = true;
        int novoId = 0;
        while (existe){
            //gera um id aleatorio entre 111111 e 999999
            Random aleatorio = new Random();
            novoId = aleatorio.nextInt(888889) + 111111;

            //verifica se o id eh unico
            if (!idsGerados.contains(novoId)){
                idsGerados.add(novoId);
                existe = false;
            }
        }
        this.id = novoId;
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //getters da classe
    public int getId(){
        return id;
    }

    public LocalDate getData(){
        return data;
    }

    public String getEndereco(){
        return endereco;
    }

    public Seguradora getSeguradora(){
        return seguradora;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    //setters da classe
    public void setData(LocalDate data){
        this.data = data;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    //faz a sobrecarga do método toString(), retornando as propriedades do objeto
    public String toString(){
        return "ID: " + this.id + "\nData: " + this.data + "\nEndereço: " + this.endereco + "\nSeguradora: " + this.seguradora.getNome() + "\nVeículo: " + this.veiculo.getPlaca() + "\nCliente: " + this.cliente.getNome();
    }

}