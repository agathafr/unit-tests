package nutricao;

public class CalculosNecessidadeEnergetica {
	int idade;
	double peso;
	int op;

	public double calculaTaxaMetabolicaBasalMulher(int idade, double peso) throws IdadeException  {
		double taxaMetabolicaBasalMulher;
		if (idade < 0)
			throw new IdadeException("Não existe idade negativa!");
		else if (idade < 10) 
			throw new IdadeException("Cálculo válido a partir de 10 anos!");
		else if (idade < 18)
			taxaMetabolicaBasalMulher = 12.2 * peso + 746;
		else if (idade < 30)
			taxaMetabolicaBasalMulher = 14.7 * peso + 496;
		else if (idade < 60)
			taxaMetabolicaBasalMulher = 8.7 * peso + 829;
		else 
			taxaMetabolicaBasalMulher = 10.5 * peso + 596;

		return taxaMetabolicaBasalMulher;
	}

	public double calculaTaxaMetabolicaBasalHomem(int idade, double peso) throws IdadeException{
		double taxaMetabolicaBasalHomem;
		if (idade < 0)
			throw new IdadeException("Não existe idade negativa!");
		else if (idade < 10)
			throw new IdadeException("Cálculo válido a partir de 10 anos!");
		else if (idade < 18)
			taxaMetabolicaBasalHomem = 17.5 * peso + 651;
		else if (idade < 30)
			taxaMetabolicaBasalHomem = 15.3 * peso + 679;
		else if (idade < 60)
			taxaMetabolicaBasalHomem = 8.7 * peso + 879;
		else 
			taxaMetabolicaBasalHomem = 13.5 * peso + 487;

		return taxaMetabolicaBasalHomem;
	}

	public double setFatorAtividadeMulher(int op) {
		double fatorialAtividade;

		switch (op) {
		case 1:

			fatorialAtividade = 1.2;
			break;

		case 2:

			fatorialAtividade = 1.3;
			break;

		case 3:

			fatorialAtividade = 1.45;
			break;
		case 4:

			fatorialAtividade = 1.5;
			break;
		case 5:

			fatorialAtividade = 1.7;
			break;

		default:
			fatorialAtividade = 0;
		}
		return fatorialAtividade;
	}

	public double setFatorAtividadeHomem(int op) {
		double fatorialAtividade;

		switch (op) {
		case 1:

			fatorialAtividade = 1.2;
			break;

		case 2:
			fatorialAtividade = 1.4;
			break;

		case 3:
			fatorialAtividade = 1.5;
			break;
		case 4:
			fatorialAtividade = 1.6;
			break;
		case 5:
			fatorialAtividade = 1.8;
			break;

		default:
			fatorialAtividade = 0;
		}
		return fatorialAtividade;
	}

	public double calculaNecessidadeEnergeticaMulher(int idade, double peso, int op) throws IdadeException {
		return calculaTaxaMetabolicaBasalMulher(idade, peso) * setFatorAtividadeMulher(op);
	}

	public double calculaNecessidadeEnergeticaHomem(int idade, double peso, int op) throws IdadeException {
		return calculaTaxaMetabolicaBasalHomem(idade, peso) * setFatorAtividadeHomem(op);
	}
}
