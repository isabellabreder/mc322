package projeto;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;

    public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao){
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    //getters da classe
    public String getCNPJ(){
        return cnpj;
    }

    public LocalDate getDataFundacao(){
        return dataFundacao;
    }

    @Override
    public String getTipoCliente(){
        return "PJ";
    }

    //setters da classe
    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    //métodos de um cliente

    //verifica se o cnpj é válido
    public boolean validarCNPJ(String cnpj){
        boolean valido = false;
        int dig1, dig2;
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        
        //remove os caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        //verifica se o cnpj possui tem 14 digitos
        if (cnpj.length() == 14){
            //se sim, transforma os caracteres em uma lista de inteiros
            for (int i = 0; i < 14; i++){
                numeros.add(Integer.parseInt(Character.toString(cnpj.charAt(i))));
            }   

            //multiplica cada digito pelo seu peso, soma tudo e vê o resto da divisão por 11
            int soma = 5*numeros.get(0) + 4*numeros.get(1) + 3*numeros.get(2) + 2*numeros.get(3) + 9*numeros.get(4) + 8*numeros.get(5) + 7*numeros.get(6) + 6*numeros.get(7) + 5*numeros.get(8) + 4*numeros.get(9) + 3*numeros.get(10) + 2*numeros.get(11);
            int resto = soma%11;

            //se o resto for 0 ou 1, o primeiro digito verificador é 0
            if (resto == 0 || resto == 1){
                dig1 = 0;
            } else {
                //senão, é a diferença entre 11 e o resto
                dig1 = 11-resto;
            }

            //multiplica cada digito da base (12 primeiros) + o digito verificador 1 pelos seus pesos
            soma = 6*numeros.get(0) + 5*numeros.get(1) + 4*numeros.get(2) + 3*numeros.get(3) + 2*numeros.get(4) + 9*numeros.get(5) + 8*numeros.get(6) + 7*numeros.get(7) + 6*numeros.get(8) + 5*numeros.get(9) + 4*numeros.get(10) + 3*numeros.get(11) + 2*dig1;
            resto = soma%11;

            //a mesma regra se aplica ao digíto verificador 2
            if (resto == 0 || resto == 1){
                dig2 = 0;
            } else {
                //senão, é a diferença entre 11 e o resto
                dig2 = 11-resto;
            }

            int dig1cnpj = numeros.get(12);
            int dig2cnpj = numeros.get(13);
             //verifica se os digitos verificadores calculados sao iguais ao do cnpj informado
            if (dig1cnpj == dig1 && dig2cnpj == dig2){
                valido = true;
            }
        }
        return valido;
    }

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEndereço: " + super.getEndereco() + "\nData de fundação: " + this.dataFundacao;
    }
}