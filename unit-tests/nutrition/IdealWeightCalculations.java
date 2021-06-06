package nutricao;

public class CalculosPesoIdeal {
	static final double IMC_DESEJADO_HOMEM = 22.0;
	static final double IMC_DESEJADO_MULHER = 21.0;
	static final String MSG = "Não existe idade negativa";

	double peso;
	double altura;
	int idade;

	public double calculaIMC(double peso, double altura) {
		return peso / (altura * altura);
	}

	public String classificaPeso(double peso, double altura) {
		var classificacao = "";
		if (calculaIMC(peso, altura) < 20)
			classificacao = "Abaixo do peso";
		else if (calculaIMC(peso, altura) < 25)
			classificacao = "Peso normal";
		else if (calculaIMC(peso, altura) < 30)
			classificacao = "Sobrepeso";
		else if (calculaIMC(peso, altura) < 40)
			classificacao = "Obeso";
		else
			classificacao = "Obeso mórbido";

		return classificacao;
	}

	public int calculaPesoIdealCrianca(int idade) throws IdadeException {
		if(idade < 0)
			throw new IdadeException(MSG);
		else if (idade < 3 || idade > 10)
			throw new IdadeException("Cálculo válido de 3 anos a 10 anos!");
		return idade * 2 + 9;
	}

	public double calculaPesoIdealMulherAdulta(double altura, int idade) throws IdadeException {
		if(idade < 0)
			throw new IdadeException(MSG);
		else if (idade < 18 || idade > 64)
			throw new IdadeException("Cálculo válido de 18 a 64 anos!");
		return IMC_DESEJADO_MULHER * (altura * altura);
	}

	public double calculaPesoIdealHomemAdulto(double altura, int idade) throws IdadeException {
		if(idade < 0)
			throw new IdadeException(MSG);
		else if (idade < 18 || idade > 64)
			throw new IdadeException("Cálculo válido de 18 a 64 anos!");
		return IMC_DESEJADO_HOMEM * (altura * altura);
	}

	public double calculaPesoIdealHomemIdoso(int idade, double altura) throws IdadeException {
		double imcPercentil;
		
		if (idade < 0)
			throw new IdadeException(MSG);
		else if (idade < 65)
			throw new IdadeException("Cálculo válido a partir dos 65 anos!");
		else if (idade < 70)
			imcPercentil = 24.3;
		else if (idade < 75)
			imcPercentil = 25.1;
		else if (idade < 80)
			imcPercentil = 23.9;
		else if (idade < 85)
			imcPercentil = 23.7;
		else
			imcPercentil = 23.1;

		return imcPercentil * (altura * altura);
	}

	public double calculaPesoIdealMulherIdosa(int idade, double altura) throws IdadeException {
		double imcPercentil;
		
		if (idade < 0)
			throw new IdadeException(MSG);
		else if (idade < 65)
			throw new IdadeException("Cálculo válido a partir dos 65 anos!");
		else if (idade < 70)
			imcPercentil = 26.5;
		else if (idade < 75)
			imcPercentil = 26.3;
		else if (idade < 80)
			imcPercentil = 26.1;
		else if (idade < 85)
			imcPercentil = 25.5;
		else
			imcPercentil = 23.6;

		return imcPercentil * (altura * altura);
	}
}
