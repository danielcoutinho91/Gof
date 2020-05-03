package br.com.unifor.pas.templatemethod;

public abstract class Universidade {

	public double mediaAvs(double av1, double av2) {
		return ((av1 + av2) / 2);
	}
	
	public abstract double mediaFinal(double av1, double av2, double av3);
	
	public abstract String situacao(double mediaFinal);
	
}
