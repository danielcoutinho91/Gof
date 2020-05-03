package br.com.unifor.pas.facade;

import java.util.ArrayList;

public class Seguro {
	
	private String nome;
	private String tipo;

	public Seguro(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.nome = tipo;
	}

}
