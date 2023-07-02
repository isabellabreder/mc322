package projeto;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private List<Condutor> listaCondutores = new ArrayList<Condutor>();
    private double valorMensal;
    private static List<Integer> idsGerados = new ArrayList<Integer>();

    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
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
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = 0;
    }

    //getters da classe
    public int getId() {
        return this.id;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public List<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public List<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

     public double getValorMensal() {
        return this.valorMensal;
    }

    //setters da classe
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    
    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    
    public void setListaCondutores(List<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }
   
    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    //métodos da classe
    public boolean autorizarCondutor(Condutor condutor){
        if (listaCondutores.contains(condutor)){
            return false;
        }

        listaCondutores.add(condutor);
        return true;
    }

    public boolean desautorizarCondutor(Condutor condutor){
        listaCondutores.remove(condutor);
        if (listaCondutores.contains(condutor)){
            return false;
        } else {
            return true;
        }
    } 

    //todo
    public boolean gerarSinistro(LocalDate data, Condutor condutor, String endereco){
        Sinistro sinistro = new Sinistro(data, endereco, condutor, this);
        listaSinistros.add(sinistro);
        condutor.adicionarSinistro(data, endereco, this);
        return true;
    }

    public abstract double calcularValor(Cliente cliente);
    
    @Override
    public String toString(){
        return "Id: " + this.getId() + "\nSeguradora: " + this.getSeguradora().getNome(); 
    }
}
