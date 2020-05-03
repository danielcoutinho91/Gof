package br.com.unifor.pas.strategy;

public class Circulo implements Figura {
	
	public double calculaArea(double r) {
		return Math.PI * Math.pow(r, 2);
	}

}
