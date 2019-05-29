package br.com.rnsiqueira.calculos;

import java.math.BigDecimal;

import br.com.rnsiqueira.modelo.Papel;

public interface RegraCorrecao {

	double diferenca(Papel papel);

	BigDecimal valorBaixo();

	BigDecimal valorMedio();

	BigDecimal valorAlto();
	
	BigDecimal pullBack();

}
