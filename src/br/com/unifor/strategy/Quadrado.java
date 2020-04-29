package br.com.unifor.strategy;

public class Quadrado implements Figura {
	
	public double calculaArea(double l) {
		return Math.pow(l, 2);
	}
	
}
