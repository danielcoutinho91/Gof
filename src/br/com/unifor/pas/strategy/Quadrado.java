package br.com.unifor.pas.strategy;

public class Quadrado implements Figura {
	
	public double calculaArea(double l) {
		return Math.pow(l, 2);
	}
	
}
