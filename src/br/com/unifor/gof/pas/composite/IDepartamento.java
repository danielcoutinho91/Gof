package br.com.unifor.gof.pas.composite;

import java.util.ArrayList;

public abstract class IDepartamento {
	
	protected String nome;	
	protected ArrayList<String> funcionarios = new ArrayList<String>();
	
	public abstract void showName();
	
	public abstract void addFuncionario(String funcionario);
	
	public abstract void removeFuncionario(String funcionario);
	
	public abstract void showFuncionarios();

}
