package br.com.unifor.pas.templatemethod;

public class Ufc extends Universidade {
	
	public double mediaFinal(double av1, double av2, double af) {
		double mediaAvs = super.mediaAvs(av1, av2);
		if (mediaAvs >= 7) {
			return mediaAvs;
		}
		return ((mediaAvs + af) / 2);
	}
	
	public String situacao(double mediaFinal) {
		String s;
		if (mediaFinal >= 7) {
			s = "Aprovado com coceito A";
		} else if (mediaFinal >= 5) {
			s = "Aprovado com conceito B";
		} else {
			s = "Reprovado";
		}
		return s;
	}

}
