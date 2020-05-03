package br.com.unifor.pas.memento;

public class Configuracao {
	
	private String sistema;
	private String placa;
	private String memoria;
	
	public Configuracao(String sistema, String placa, String memoria) {
		this.sistema = sistema;
		this.placa = placa;
		this.memoria = memoria;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	
	public void showInfo() {
		System.out.println("Sistema: " + sistema);
		System.out.println("Placa: " + placa);
		System.out.println("Memória: " + memoria);
		System.out.println("");
	}
	


}
