package br.com.unifor.pas.memento;

public class Originator {
	
	private Configuracao configuracao;

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}
	
	public Memento saveConfiguracaoToMemento() {
		return new Memento(configuracao);
	}
	
	public void getConfiguracaoFromMemento(Memento memento) {
		configuracao = memento.getConfiguracao();
	}
	
}
