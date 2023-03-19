package Projeto;
import java.lang.Character;
import java.lang.Integer;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {
    //atributos de um cliente
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private int idade;

    //construtor
    public Cliente(String nome, String cpf, String dataNascimento, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        setDataNascimento(dataNascimento);
        this.endereco = endereco;
    }

    //getters da classe
    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public String getEndereco(){
        return endereco;
    }
    
    public int getIdade(){
        return idade;
    }

    //setters da classe
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;

        //supondo a formatacao dd/MM/yyyy, calcula a idade:
        //infos data atual:
        Calendar dataAtual = Calendar.getInstance();
        Date agora = new Date();
        dataAtual.setTime(agora);

        //infos data de nascimento:
        Calendar nasc = Calendar.getInstance();
        DateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formatacao.parse(dataNascimento);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        nasc.setTime(data);

        //calculo da idade e atribuição à propriedade idade da classe
        int idade = (dataAtual.get(Calendar.YEAR) - nasc.get(Calendar.YEAR));
        if (dataAtual.get(Calendar.DAY_OF_YEAR) < nasc.get(Calendar.DAY_OF_YEAR)){
            this.idade = idade - 1;
        } else {
            this.idade = idade;
        }
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    //metodos de um cliente
    // to string?

    public boolean validarCPF(String cpf){
        boolean valido = false;

        //cria um array com os numerais em tipo char
        //char[] numericos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        //looping que compara cada char da string cpf com cada char do array numericos para remover caracteres nao numericos
        /*for (int i = 0; i < cpf.length(); i++){
            boolean numero = false;
            for (int j = 0; j < numericos.length; j++){
                if (cpf.charAt(i) == numericos[j]){
                    numero = true;
                }
            }
            if (!numero){
                String caractere = Character.toString(cpf.charAt(i));
                cpf = cpf.replaceAll(caractere, "");
            }
        }*/

        cpf = cpf.replaceAll("[^0-9]", "");

        //verificando se o cpf possui tem 11 digitos
        int dig1, dig2;
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

            //verificando se os digitos verificadores calculados sao iguais ao do cpf informado
            int dig1cpf = Integer.parseInt(Character.toString(cpf.charAt(9)));
            int dig2cpf = Integer.parseInt(Character.toString(cpf.charAt(10)));

            if (dig1cpf == dig1 && dig2cpf == dig2){
                valido = true;
            }
        }
        
        return valido;
    }

}
