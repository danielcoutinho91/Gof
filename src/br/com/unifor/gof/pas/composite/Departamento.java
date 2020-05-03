package br.com.unifor.gof.pas.composite;

import java.util.ArrayList;

public class Departamento extends IDepartamento {
	
	private ArrayList<String> funcionarios = new ArrayList<>();
	private ArrayList<Departamento> departamentos = new ArrayList<>();
	
	public Departamento(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void showName() {
		System.out.println(this.nome);
	}
	
	@Override
	public void addFuncionario(String funcionario) {
		funcionarios.add(funcionario);
	}
	
	@Override
	public void removeFuncionario(String funcionario) {
		funcionarios.remove(funcionario);
	}
	
	@Override
	public void showFuncionarios() {
		for (String f : funcionarios) {
			System.out.println(f);
		}
		
		for (Departamento d : departamentos) {
			d.showFuncionarios();
		}
	}
	
	public void addDepartamento(Departamento departamento) {
		departamentos.add(departamento);
	}
	
	public void removeDepartamento(Departamento departamento) {
		departamentos.remove(departamento);
	}
	
	public void showDepartamentos() {
		for (Departamento d : departamentos) {
			d.showName();
			d.showDepartamentos();
		}
	}

}
