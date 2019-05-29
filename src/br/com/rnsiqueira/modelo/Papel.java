package br.com.rnsiqueira.modelo;

import java.util.ArrayList;
import java.util.List;

public class Papel {

	private List<Double> lista;
	private double valorA;
	private double valorB;
	
	
	public Papel() {
		lista = new ArrayList<>();
	}
	
	public double getValorA() {
		return valorA;
	}
	public void setValorA(double valorA) {
		this.valorA = valorA;
	}
	public double getValorB() {
		return valorB;
	}
	public void setValorB(double valorB) {
		this.valorB = valorB;
	}
	public List<Double> getLista() {
		return lista;
	}
	
	
	
	

}
