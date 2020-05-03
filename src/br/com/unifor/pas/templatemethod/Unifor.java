package br.com.unifor.pas.templatemethod;

public class Unifor extends Universidade {
	
	public double mediaFinal(double av1, double av2, double av3) {
		double mediaAvs = super.mediaAvs(av1, av2);
		return ((mediaAvs + av3) / 2);
	}
	
	public String situacao(double mediaFinal) {
		String s;
		if (mediaFinal >= 5) {
			s = "Aprovado";
		} else {
			s = "Reprovado";
		}
		return s;
	}
	
}
