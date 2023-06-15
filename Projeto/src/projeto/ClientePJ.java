package projeto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;
    private List<Frota> listaFrotas = new ArrayList<Frota>();

    public ClientePJ(String nome, String endereco, String email, int telefone, String cnpj){
        super(nome, endereco, email, telefone); 
        this.cnpj = cnpj;
        this.listaFrotas = new ArrayList<Frota>();
    }

    //getters da classe
    public String getCNPJ(){
        return this.cnpj;
    }

    public LocalDate getDataFundacao(){
        return this.dataFundacao;
    }

    public List<Frota> getListaFrotas(){
        return this.listaFrotas;
    }

    @Override
    public String getTipoCliente(){
        return "PJ";
    }
    
    //setters da classe
    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public void setListaFrotas(List<Frota> listaFrotas){
        this.listaFrotas = listaFrotas;
    }

    //cadastra uma frota
    public boolean cadastrarFrota(Frota frota){
        boolean add = false;
        listaFrotas.add(frota);
        if (listaFrotas.contains(frota)){
            add = true;
        }
        return add;
    }

    //remove uma frota
    public boolean removefrota(Frota frota){
        boolean rm = false;
        listaFrotas.remove(frota);
        if (!listaFrotas.contains(frota)){
            rm = true;
        }
        return rm;
    }

    //TODO -> ATUALIZARFROTA()

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEndereço: " + super.getEndereco() + "\nData de fundação: " + this.dataFundacao;
    }
}