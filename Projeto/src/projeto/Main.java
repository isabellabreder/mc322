package projeto;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args){
        //instancia um cliente PF
        ClientePF clientepf = new ClientePF("Isabella Breder", "Barão Geraldo", "123.456.789-00", "Feminino", LocalDate.of(2023, 04, 25), "Superior incompleto", LocalDate.of(2001, 01, 01), "Classe X");

        //instancia um cliente PJ
        ClientePJ clientepj = new ClientePJ("Empresa", "Barão Geraldo", "84.111.993/0001-69", LocalDate.of(2023, 04, 25));
        
        System.out.println("Validação de CPF e CNPJ:");
        System.out.println("O CPF "+clientepf.getCPF()+" de "+clientepf.getNome()+" é valido? "+clientepf.validarCPF(clientepf.getCPF()));
        System.out.println("O CNPJ "+clientepj.getCNPJ()+" de "+clientepj.getNome()+" é válido? "+clientepj.validarCNPJ(clientepj.getCNPJ()));
        System.out.println("\n");

        //adiciona 1 veículo em cada cliente
        Veiculo veiculo_pf = new Veiculo("XXX-0000", "Fiat", "Uno", 2000);
        Veiculo veiculo_pj = new Veiculo("AAA-1111", "Chevrolet", "Prisma", 1998);
        clientepf.setVeiculo(veiculo_pf);
        clientepj.setVeiculo(veiculo_pj);
 
        System.out.println("Veículos adicionados:");
        System.out.println("Veículos de "+clientepf.getNome()+": "+clientepf.getListaVeiculos());
        System.out.println("Veículos de "+clientepj.getNome()+": "+clientepj.getListaVeiculos());
        System.out.println("\n");

        //instancia 1 objeto de Seguradora
        Seguradora seguradora = new Seguradora("Seguradora", "(19)90000-1111", "seguradora@seguradora.com", "Barão Geraldo");

        //cadastra 2 clientes em seguradora
        seguradora.cadastrarCliente(clientepf);
        seguradora.cadastrarCliente(clientepj);

        //gera 1 sinistro
        seguradora.gerarSinistro("25/04/2023", "Barão Geraldo", veiculo_pj, clientepj);

        //chama o método toString() de cada classe
        System.out.println("toString() de Cliente:");
        System.out.println(clientepf.toString());
        System.out.println(clientepj.toString());
        System.out.println("\ntoString() de Sinistro:");
        System.out.println(seguradora.getListaSinistros().get(0).toString());
        System.out.println("\ntoString() de Seguradora:");
        System.out.println(seguradora.toString());
        System.out.println("\ntoString() de Veículo:");
        System.out.println(clientepf.getListaVeiculos().get(0).toString());
        System.out.println("\n");
        
        //chama os métodos listarClientes, visualizarSinistro e listarSinistros
        System.out.println("Função listarClientes para PF:");
        seguradora.listarClientes("PF");
        System.out.println("\nFunção visualizarSinistro para Empresa:");
        seguradora.visualizarSinistro("Empresa");
        System.out.println("\nFunção listarSinistros");
        seguradora.listarSinistros();
        System.out.println("\n");
        
        //implementação de um menu simples de escolha para visualizar dados de ..
        Scanner scanner = new Scanner(System.in);
        int indice;
        System.out.println("Menu simples. Escolha uma opção: ");
        System.out.println("1 - Nome da seguradora");
        System.out.println("2 - Telefone da seguradora");
        System.out.println("3 - E-mail da seguradora");
        System.out.println("4 - Endereço da seguradora");

        indice = scanner.nextInt();
        if(indice == 1){
            System.out.println(seguradora.getNome());
        } else if(indice == 2){
            System.out.println(seguradora.getTelefone());
        } else if(indice == 3){
            System.out.println(seguradora.getEmail());
        } else if(indice == 4){
            System.out.println(seguradora.getEndereco());
        }
        scanner.close();
    }
}