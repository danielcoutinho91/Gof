package br.com.unifor.pas.iterator;

import java.util.ArrayList;

public class ListaProdutos {
	
	private static final int MAX = 10;
	private Produto[] produtos;
	private int posicao = 0;
	
	public ListaProdutos() {
		produtos = new Produto[MAX];
	}

	public void addProduto(String nome, double preco) {
		Produto p = new Produto(nome, preco);
		produtos[posicao] = p;
		posicao++;
	}
	
	public Produto[] getProdutos() {
		return produtos;
	}

}
