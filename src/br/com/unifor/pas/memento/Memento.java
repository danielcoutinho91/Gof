package br.com.unifor.pas.memento;

public class Memento {
	
	private Configuracao configuracao;
	
	public Memento(Configuracao configuracao) {
		this.configuracao = configuracao;
	}
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}

}
