package projeto;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private List<Sinistro> listaSinistros = new ArrayList<Sinistro>();

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = new ArrayList<Sinistro>();
    }

    //getters da classe
    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public List<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    //setters da classe
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setDataNasc(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public boolean adicionarSinistro(LocalDate data, String endereco, Seguro seguro){
        Sinistro sinistro = new Sinistro(data, endereco, this, seguro);
        listaSinistros.add(sinistro);
        //TODO
        //seguro.corrigeValor();
        return true;
    }

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    public String toString(){
        return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nData de nascimento: " + this.getDataNascimento() + "\nEndereco: " + this.getEndereco() + "\nTelefone: " + this.getTelefone();
    }
}