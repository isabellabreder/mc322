package projeto;

public class Veiculo {
    //atributos de um veiculo
    private String placa;
    private String marca;
    private String modelo; 
    private int anoFabricacao;

    //construtor
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    //getters da classe
    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getAnoFabricacao(){
        return anoFabricacao;
    }

    //setters da classe
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setAnoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }

    //faz a sobrecarga do método toString(), retornando as propriedades do objeto
    public String toString(){
        return "Placa: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nAno de fabricação: " + this.anoFabricacao;
    }
}
