package projeto;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppMain {
	public static void main(String[] args){
        
        boolean sair = false;
        while (!sair) {
            exibirMenuPrincipal();
            int operacao = lerOpcaoMenu();
            MenuOperacoes menuOperacao = MenuOperacoes.fromOperacao(operacao);
            if (menuOperacao != null) {
                switch (menuOperacao) {
                    case CADASTRAR:
                        executarOperacaoCadastrar();
                        break;
                    case LISTAR:
                        executarOperacaoListar();
                        break;
                    case EXCLUIR:
                        executarOperacaoExcluir();
                        break;
                    case GERAR_SINISTRO:
                        executarOperacaoGerarSinistro();
                        break;
                    case TRANSFERIR_SEGURO:
                        executarOperacaoTransferirSeguro();
                        break;
                    case CALCULAR_RECEITA_SEGURADORA:
                        executarOperacaoCalcularReceitaSeguradora();
                        break;
                    case SAIR:
                        sair = true;
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    private static void executarOperacaoCadastrar() {
        boolean voltar = false;
        while (!voltar) {
            exibirMenuCadastrar();
            int operacao = lerOpcaoMenu();
            MenuOperacoes menuOperacao = MenuOperacoes.fromOperacao(operacao);
            if (menuOperacao != null) {
                switch (menuOperacao) {
                    case CADASTRAR_CLIENTE_PF:
                        cadastrarClientePF();
                        break;
                    case CADASTRAR_CLIENTE_PJ:
                        cadastrarClientePJ();
                        break;
                    case CADASTRAR_VEICULO:
                        cadastrarVeiculo();
                        break;
                    case CADASTRAR_SEGURADORA:
                        cadastrarSeguradora();
                        break;
                    case VOLTAR:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    private static void executarOperacaoListar() {
        boolean voltar = false;
        while (!voltar) {
            exibirMenuListar();
            int operacao = lerOpcaoMenu();
            MenuOperacoes menuOperacao = MenuOperacoes.fromOperacao(operacao);
            if (menuOperacao != null) {
                switch (menuOperacao) {
                    case CLIENTE_POR_SEGURADORA:
                        listarClientesPorSeguradora();
                        break;
                    case SINISTROS_POR_SEGURADORA:
                        listarSinistrosPorSeguradora();
                        break;
                    case SINISTROS_POR_CLIENTE:
                        listarSinistrosPorCliente();
                        break;
                    case VEICULOS_POR_CLIENTE:
                        listarVeiculosPorCliente();
                        break;
                    case VEICULOS_POR_SEGURADORA:
                        listarVeiculosPorSeguradora();
                        break;
                    case VOLTAR:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    private static void executarOperacaoExcluir() {
        boolean voltar = false;
        while (!voltar) {
            exibirMenuExcluir();
            int operacao = lerOpcaoMenu();
            MenuOperacoes menuOperacao = MenuOperacoes.fromOperacao(operacao);
            if (menuOperacao != null) {
                switch (menuOperacao) {
                    case EXCLUIR_CLIENTE:
                        excluirCliente();
                        break;
                    case EXCLUIR_VEICULO:
                        excluirVeiculo();
                        break;
                    case EXCLUIR_SINISTRO:
                        excluirSinistro();
                        break;
                    case VOLTAR:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    private static void executarOperacaoGerarSinistro() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("********** Gerar Sinistro **********");
        System.out.print("Data do sinistro (formato: dd/MM/yyyy): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Endereço do sinistro: ");
        String endereco = scanner.nextLine();
        
        System.out.print("Nome do cliente segurado: ");
        String nome_cliente = scanner.nextLine();

        System.out.print("Placa do veículo envolvido: ");
        String placa = scanner.nextLine();

        System.out.print("Seguradora envolvida no sinistro: ");
        String nome_seguradora = scanner.nextLine();
        
        Seguradora seguradora = null;
        for (Seguradora _seguradora : Seguradora.getListaSeguradoras()){
            if(_seguradora.getNome().equals(nome_seguradora)){
                seguradora = _seguradora;
                break;
            }
        }

        Cliente cliente = null;
        for (Cliente _cliente : seguradora.getListaClientes()){
            if(_cliente.getNome().equals(nome_cliente)){
                cliente = _cliente;
                break;
            }
        }

        Veiculo veiculo = null;
        for (Veiculo _veiculo : cliente.getListaVeiculos()){
            if(_veiculo.getPlaca().equals(placa)){
                veiculo = _veiculo;
                break;
            }
        }

        Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
    
        System.out.println("Sinistro criado com sucesso:");
        System.out.println("ID: " + sinistro.getId());
        System.out.println("Data: " + sinistro.getData());
        System.out.println("Endereço: " + sinistro.getEndereco());
        System.out.println("Seguradora: " + sinistro.getSeguradora().getNome());
        System.out.println("Veículo: " + sinistro.getVeiculo().getPlaca());
        System.out.println("Cliente: " + sinistro.getCliente().getNome());
        scanner.close();
    }
    
    private static void executarOperacaoTransferirSeguro() {
        // Código para transferir o seguro de um cliente para outro
    }
    
    private static void executarOperacaoCalcularReceitaSeguradora() {
        // Código para calcular a receita da seguradora
    }
    
    private static void exibirMenuPrincipal() {
        System.out.println("********** Menu Principal **********");
        System.out.println("1. Cadastrar");
        System.out.println("2. Listar");
        System.out.println("3. Excluir");
        System.out.println("4. Gerar Sinistro");
        System.out.println("5. Transferir Seguro");
        System.out.println("6. Calcular Receita da Seguradora");
        System.out.println("0. Sair");
        System.out.println("************************************");
    }
    
    private static void exibirMenuCadastrar() {
        System.out.println("********** Menu Cadastrar **********");
        System.out.println("1.1 Cadastrar Cliente PF");
        System.out.println("1.2 Cadastrar Cliente PJ");
        System.out.println("1.3 Cadastrar Veículo");
        System.out.println("1.4 Cadastrar Seguradora");
        System.out.println("1.5 Voltar");
        System.out.println("************************************");
    }
    
    private static void exibirMenuListar() {
        System.out.println("*********** Menu Listar ************");
        System.out.println("2.1 Listar Clientes por Seguradora");
        System.out.println("2.2 Listar Sinistros por Seguradora");
        System.out.println("2.3 Listar Sinistros por Cliente");
        System.out.println("2.4 Listar Veículos por Cliente");
        System.out.println("2.5 Listar Veículos por Seguradora");
        System.out.println("2.6 Voltar");
        System.out.println("************************************");
    }
    
    private static void exibirMenuExcluir() {
        System.out.println("*********** Menu Excluir ***********");
        System.out.println("3.1 Excluir Cliente");
        System.out.println("3.2 Excluir Veículo");
        System.out.println("3.3 Excluir Sinistro");
        System.out.println("3.4 Voltar");
        System.out.println("************************************");
    }
    
    private static int lerOpcaoMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecione uma opção: ");
        return scanner.nextInt();
    }
    
    private static void cadastrarClientePF() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********** Cadastrar Cliente Pessoa Física **********");
        System.out.print("Nome da seguradora: ");
        String nome_seguradora = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (Validacao.validaNome(nome)){
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            if (Validacao.validaCPF(cpf)){
                System.out.print("Genero: ");
                String genero = scanner.nextLine();
                System.out.print("Data Licença: ");
                String dataLicencaString = scanner.nextLine();
                LocalDate dataLicenca = LocalDate.parse(dataLicencaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.print("Data de Nascimento (formato: dd/MM/yyyy): ");
                String dataNascimentoString = scanner.nextLine();
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.print("Educação: ");
                String educacao = scanner.nextLine();
                System.out.print("Classe econômica: ");
                String classe = scanner.nextLine();

                Cliente clientePF = new ClientePF(nome, endereco, cpf, genero, dataLicenca, educacao, dataNascimento, classe);

                Seguradora seguradora = null;
                for (Seguradora _seguradora : Seguradora.getListaSeguradoras()){
                    if(_seguradora.getNome().equals(nome_seguradora)){
                        seguradora = _seguradora;
                        break;
                    }
                }

                seguradora.cadastrarCliente(clientePF);
                System.out.println("Cliente Pessoa Física cadastrado com sucesso!");
            } else {
                System.out.println("O CPF informado é inválido! Tente cadastrar novamente.");
            }
            
            } else {
                System.out.println("O nome é inválido! Tente cadastrar novamente.");
            }
        
            scanner.close();
    }
    
    private static void cadastrarClientePJ() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********** Cadastrar Cliente Pessoa Jurídica **********");
        System.out.print("Nome da seguradora: ");
        String nome_seguradora = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        if(Validacao.validaCPNJ(cnpj)){
            System.out.print("Data Fundação (formato: dd/MM/yyyy): ");
            String dataFundacaoString = scanner.nextLine();
            LocalDate dataFundacao = LocalDate.parse(dataFundacaoString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Quantidade de funcionarios ");
            int funcionarios = scanner.nextInt();
    
            Cliente clientePJ = new ClientePJ(nome, endereco, cnpj, dataFundacao, funcionarios);
    
            Seguradora seguradora = null;
            for (Seguradora _seguradora : Seguradora.getListaSeguradoras()){
                if(_seguradora.getNome().equals(nome_seguradora)){
                    seguradora = _seguradora;
                    break;
                }
            }
    
            seguradora.cadastrarCliente(clientePJ);
            System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
        } else {
            System.out.println("O CNPJ informado é inválido! Tente cadastrar novamente.");
        }

        scanner.close();
    }
    
    private static void cadastrarVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********** Cadastrar Veículo **********");
        System.out.print("Nome do cliente: ");
        String nome_cliente = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano de fabricação: ");
        int anoFabricacao = scanner.nextInt();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

        Cliente cliente = null;
        for (Seguradora _seguradora : Seguradora.getListaSeguradoras()){
            for(Cliente _cliente : _seguradora.getListaClientes()){
                if(_cliente.getNome().equals(nome_cliente)){
                    cliente = _cliente;
                    break;
                }
            }
        }

        cliente.cadastraVeiculo(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        scanner.close();
    }
    
    private static void cadastrarSeguradora() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********** Cadastrar Seguradora **********");
        System.out.print("Nome da seguradora: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);

        System.out.println("Seguradora "+seguradora.getNome()+" cadastrada com sucesso!");
        scanner.close();
    }
    
    private static void listarClientesPorSeguradora() {
        // Código para listar clientes por seguradora
    }
    
    private static void listarSinistrosPorSeguradora() {
        // Código para listar sinistros por seguradora
    }
    
    private static void listarSinistrosPorCliente() {
        // Código para listar sinistros por cliente
    }
    
    private static void listarVeiculosPorCliente() {
        // Código para listar veículos por cliente
    }
    
    private static void listarVeiculosPorSeguradora() {
        // Código para listar veículos por seguradora
    }
    
    private static void excluirCliente() {
        // Código para excluir um cliente
    }
    
    private static void excluirVeiculo() {
        // Código para excluir um veículo
    }
    
    private static void excluirSinistro() {
        // Código para excluir um sinistro
    }
}