package br.com.rnsiqueira.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.rnsiqueira.calculos.RegraCorrecao;
import br.com.rnsiqueira.calculos.RegraCorrecaoDescida;
import br.com.rnsiqueira.calculos.RegraCorrecaoSubida;
import br.com.rnsiqueira.modelo.Papel;

public class DayTradeTests {

	@Test
	public void conrrecaoSubida() {

		Papel papel = new Papel();
		RegraCorrecao gap = new RegraCorrecaoSubida();
		papel.setValorA(22.90);
		papel.setValorB(23.30);

		assertNotNull(gap.diferenca(papel));
		BigDecimal valorMedio = new BigDecimal(23.10);
		assertEquals(valorMedio.setScale(2, BigDecimal.ROUND_HALF_EVEN), gap.valorMedio());

		System.out.println("Força de Subida: " + gap.pullBack());

	}

	@Test
	public void conrrecaoDescida() {

		Papel papel = new Papel();
		RegraCorrecao gap = new RegraCorrecaoDescida();
		papel.setValorA(22.90);
		papel.setValorB(22.50);

		assertNotNull(gap.diferenca(papel));
		BigDecimal valorMedio = new BigDecimal(22.70);
		assertEquals(valorMedio.setScale(2, BigDecimal.ROUND_HALF_EVEN), gap.valorMedio());

		System.out.println("Força de Descida: " + gap.pullBack());

	}

	

}
