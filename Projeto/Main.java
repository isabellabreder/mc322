package Projeto;

public class Main {
    public static void main(String[] args){
        Seguradora seguradora = new Seguradora("Seguradora teste", "(19) 0000-0000", "seguradora@teste.com", "Rua teste");
        System.out.println("Instanciação de uma seguradora. E-mail: " + seguradora.getEmail());

        Veiculo veiculo = new Veiculo("AAA-0000", "Marca teste", "Modelo teste");
        System.out.println("Instanciação de um veículo. Placa: " + veiculo.getPlaca());

        Sinistro sinistro = new Sinistro("01/01/2001", "Rua teste");
        System.out.println("Instanciação de um sinistro. ID: " + sinistro.getId());

        Cliente cliente = new Cliente("Cliente", "98053649092", "01/01/2001", "Rua teste");
        System.out.println("Instanciação de um cliente. Saída do método toString():\n" + cliente.toString());
        System.out.println("O CPF do cliente é válido? " + cliente.validarCPF(cliente.getCpf()));
    }
}