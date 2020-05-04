package br.com.unifor.pas.state;

public abstract class State {
	
	protected Aluno aluno;
	
	public abstract double getDesconto();
	
	public abstract void mudarState();
	
	public abstract String getDesempenho();

}
