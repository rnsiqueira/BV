package br.com.rnsiqueira.calculos;

import java.math.BigDecimal;

import br.com.rnsiqueira.modelo.Papel;

public class RegraCorrecaoDescida implements RegraCorrecao {

	private double dif;
	private Papel papel;

	public double diferenca(Papel papel) {
		this.papel = papel;

		if (papel.getValorA() >= papel.getValorB()) {
			dif = papel.getValorA() - papel.getValorB();

			return dif;

		}

		else {
			dif = papel.getValorB() - papel.getValorA();

			return dif;

		}

	}

	public BigDecimal valorBaixo() {
		double newValor = papel.getValorB() + ((dif / 100) * 38.2);

		BigDecimal valor = new BigDecimal(newValor);

		return valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public BigDecimal valorMedio() {
		double newValor = papel.getValorB() + ((dif / 100) * 50);

		BigDecimal valor = new BigDecimal(newValor);

		return valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public BigDecimal valorAlto() {
		double newValor = papel.getValorB() + ((dif / 100) * 61.8);

		BigDecimal valor = new BigDecimal(newValor);

		return valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}

	public BigDecimal pullBack() {
		double newValor = valorAlto().doubleValue() - (dif * 2.1);
		BigDecimal valor = new BigDecimal(newValor);
		return valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

}
