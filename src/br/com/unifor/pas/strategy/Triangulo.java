package br.com.unifor.pas.strategy;

public class Triangulo implements Figura {
	
	public double calculaArea(double l) {
		return (Math.pow(l, 2) * Math.sqrt(3)) / 4;
	}

}
