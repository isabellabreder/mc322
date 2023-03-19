package Projeto;
import java.util.Random;
//import java.util.ArrayList;

public class Sinistro {
    //atributos de um sinistro
    private int id;
    private String data;
    private String endereco;
    private int[] idsGerados;

    //construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
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
            //gerando um id aleatorio entre 111111 e 999999
            Random aleatorio = new Random();
            int id = aleatorio.nextInt(888889) + 111111;

            //verificando se o id eh unico
            existe = false;
            for (int i = 0; i < idsGerados.length; i++){
                if (id == idsGerados[i]){
                    existe = true;
                }
            }
            if (!existe){
                this.id = id;
                //add o id no array
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