package projeto;

public enum CalcSeguro { 
	VALOR_BASE (10.0),
	FATOR_0_30 (1.25),
	FATOR_30_60 (1.0),
	FATOR_60_90 (1.5);
	
	public final double valor;

	CalcSeguro(double valor){
		this.valor = valor;	
	}

	public double getValor(){
		return valor;
	}
	
	public static double getFatorIdade(int idade){
		if (idade >= 0 && idade < 30){
			return FATOR_0_30.getValor();
		} else if (idade >= 30 && idade < 60){
			return FATOR_30_60.getValor();
		} else if (idade >= 60 && idade < 90){
			return FATOR_60_90.getValor();
		} else {
			return 0;
		}
	}
}
