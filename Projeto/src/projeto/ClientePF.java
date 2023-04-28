package projeto;
import java.lang.Character;
import java.lang.Integer;
import java.time.LocalDate;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica){
        super(nome, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }
    //getters da classe
    public String getCPF(){
        return cpf;
    }

    public String getGenero(){
        return genero;
    }

    public LocalDate getDataLicenca(){
        return dataLicenca;
    }

    public String getEducacao(){
        return educacao;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public String getClasseEconomica(){
        return classeEconomica;
    }

    @Override
    public String getTipoCliente(){
        return "PF";
    }

    //setters da classe
    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setDataLicenca(LocalDate dataLicenca){
        this.dataLicenca = dataLicenca;
    }

    public void setEducacao(String educacao){
        this.educacao = educacao;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }

    //métodos de um cliente

    //verifica se o cpf é válido
    public boolean validarCPF(String cpf){
        boolean valido = false;
        int dig1, dig2;
        
        //remove os caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        //verifica se o cpf possui tem 11 digitos
        if (cpf.length() == 11){
            //se sim, calcula o digito verificador
            int soma = 0;

            //multiplica os 9 primeiros digitos do cpf pelos pesos de 10 a 2
            for (int i = 0, j = 10; i < 9; i++, j--){
                int num = Integer.parseInt(Character.toString(cpf.charAt(i)));
                soma += j*num;
            }
            //o resto da divisao por 11 da soma determina o primeiro digito
            int resto = soma%11;
            if (resto == 0 || resto == 1){
                dig1 = 0;
            } else {
                dig1 = 11-resto;
            }
            soma = 0;

            //para descobrir o segundo digito, realiza o mesmo esquema, mas multiplicando os 10 primeiros digitos (verificador 1 incluso) por pesos de 11 a 2
            for (int i = 0, j = 11; i < 10; i++, j--){
                int num = Integer.parseInt(Character.toString(cpf.charAt(i)));
                if (i == 9){
                    num = dig1;
                }
                soma += j*num;
            }
            resto = soma%11;
            if (resto == 0 || resto == 1){
                dig2 = 0;
            } else {
                dig2 = 11-resto;
            }

            int dig1cpf = Integer.parseInt(Character.toString(cpf.charAt(9)));
            int dig2cpf = Integer.parseInt(Character.toString(cpf.charAt(10)));

             //verifica se os digitos verificadores calculados sao iguais ao do cpf informado
            if (dig1cpf == dig1 && dig2cpf == dig2){
                valido = true;
            }
        }
        
        return valido;
    }

    //faz a sobrescrita do método toString(), retornando as propriedades do objeto
    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEndereço: " + super.getEndereco() + "\nCPF: " + this.cpf + "\nGenero: " + this.genero + "\nData de licença: " + this.dataLicenca + "\nEducação: " + this.educacao + "\nData de nascimento: " + this.dataNascimento + "\nClasse econômica: " + this.classeEconomica;
    }
}