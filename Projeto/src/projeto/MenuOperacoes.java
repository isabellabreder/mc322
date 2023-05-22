package projeto;

public enum MenuOperacoes {
	CADASTRAR(1),
	LISTAR(2),
	EXCLUIR(3),
	GERAR_SINISTRO(4),
	TRANSFERIR_SEGURO(5),
	CALCULAR_RECEITA_SEGURADORA(6),
	SAIR(0),
	CADASTRAR_CLIENTE_PF(11),
	CADASTRAR_CLIENTE_PJ(12),
	CADASTRAR_VEICULO(13),
	CADASTRAR_SEGURADORA(14),
	CLIENTE_POR_SEGURADORA(21),
	SINISTROS_POR_SEGURADORA(22),
	SINISTROS_POR_CLIENTE(23),
	VEICULOS_POR_CLIENTE(24),
	VEICULOS_POR_SEGURADORA(25),
	EXCLUIR_CLIENTE(31),
	EXCLUIR_VEICULO(32),
	EXCLUIR_SINISTRO(33),
	VOLTAR(-1);
	
	public final double operacao;
	
	MenuOperacoes(int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}

	public static MenuOperacoes fromOperacao(int operacao) {
        for (MenuOperacoes op : values()) {
            if (op.getOperacao() == operacao) {
                return op;
            }
        }
        return null;
    }
}