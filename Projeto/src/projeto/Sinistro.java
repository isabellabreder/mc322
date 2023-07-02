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
    private Condutor condutor;
    private Seguro seguro;
    private static List<Integer> idsGerados = new ArrayList<>();

    //construtor
    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
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
        this.condutor = condutor;
        this.seguro = seguro;
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

    public Condutor getCondutor(){
        return condutor;
    }

    public Seguro getSeguro(){
        return seguro;
    }

    //setters da classe
    public void setData(LocalDate data){
        this.data = data;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setCondutor(Condutor condutor){
        this.condutor = condutor;
    }

    public void setSeguro(Seguro seguro){
        this.seguro = seguro;
    }

    //faz a sobrecarga do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "ID: " + this.id + "\nData: " + this.data + "\nEndereço: " + this.endereco + "\nCondutor: " + this.condutor.getNome() + "\nSeguro: " + this.seguro.getId();
    }
}