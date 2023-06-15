package projeto;

import java.util.List;
import java.util.ArrayList;

public class Frota {
    private String code;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(String code){
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //getters da classe
    public String getCode() {
        return code;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    //setters da classe
    public void setCode(String code)  {
        this.code = code;
    }
    
    public void setMapaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    //métodos da classe

    //adiciona um veiculo na frota
    public boolean adicionarVeiculo(Veiculo veiculo){
        boolean add = false;
        listaVeiculos.add(veiculo);
        if (listaVeiculos.contains(veiculo)){
            add = true;
        }
        return add;
    }

    //remove um veiculo da frota
    public boolean removerVeiculo(Veiculo veiculo){
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
        return "Código: " + this.getCode() + "\nLista de veículos: " + this.getListaVeiculos();
    }
}
