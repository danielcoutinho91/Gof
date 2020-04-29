package br.com.unifor.strategy;

public class Circulo implements Figura {
	
	public double calculaArea(double r) {
		return Math.PI * Math.pow(r, 2);
	}

}
