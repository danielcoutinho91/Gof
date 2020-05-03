package br.com.unifor.pas.prototype;

import java.util.ArrayList;

public class Playstation extends Console {

	public Playstation(String empresa, String nome, int ano, String cor, ArrayList<String> midias) {
		super();
		this.empresa = empresa;
		this.nome = nome;
		this.ano = ano;
		this.cor = cor;
		this.midias = midias;
	}
	
	@Override
	public Console clone() throws CloneNotSupportedException {
		return (Playstation)super.clone();
	}
	
}
