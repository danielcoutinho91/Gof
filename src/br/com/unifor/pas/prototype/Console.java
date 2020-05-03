package br.com.unifor.pas.prototype;

import java.util.ArrayList;

public abstract class Console implements Cloneable {
	
	protected String empresa;
	protected String nome;
	protected int ano;
	protected String cor;
	protected ArrayList<String> midias;	
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public ArrayList<String> getMidias() {
		return midias;
	}
	
	public void setMidias(ArrayList<String> midias) {
		this.midias = midias;
	}
	
	public void addMidia(String midia) {
		midias.add(midia);
	}
	
	public void showInfo() {
		System.out.println(nome);
		System.out.println("Empresa: " + empresa);
		System.out.println("Ano: " + ano);
		System.out.println("Cor: " + cor);
		System.out.print("Mídias: ");
		for (String midia : midias) {
			System.out.print(midia + " ");
		}
		System.out.println("\n");
	}
	
	public Console clone() throws CloneNotSupportedException {
		return (Console)super.clone();
	}
	

}
