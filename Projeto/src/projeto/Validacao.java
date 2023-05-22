package projeto;
import java.lang.Character;
import java.lang.Integer;
import java.util.ArrayList; 

public class Validacao {
	
	public static boolean validaCPF(String cpf) {
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
	
	public static boolean validaCPNJ(String cnpj) {
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
	
	public static boolean validaNome(String nome) {
		return nome.replaceAll("[a-zA-Z]", "").isEmpty();
	}
}
