package Projeto;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Sinistro {
    //atributos de um sinistro
    private int id;
    private String data;
    private String endereco;
    private static List<Integer> idsGerados = new ArrayList<>();

    //construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
        this.setId();
    }

    //getters da classe
    public int getId(){
        return id;
    }

    public String getData(){
        return data;
    }

    public String getEndereco(){
        return endereco;
    }

    //setters da classe
    public void setId(){
        boolean existe = true;
        while (existe){
            //gera um id aleatorio entre 111111 e 999999
            Random aleatorio = new Random();
            int id = aleatorio.nextInt(888889) + 111111;

            //verifica se o id eh unico
            if (!idsGerados.contains(id)){
                this.id = id;
                idsGerados.add(id);
                existe = false;
            }
        }
    }

    public void setData(String data){
        this.data = data;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
}