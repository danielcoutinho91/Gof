package br.com.unifor.pas.iterator;

import java.util.ArrayList;

public class ListaProdutosIterator {
	
	Produto[] produtos;
	int posicao = 0;	
	
	public ListaProdutosIterator(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	public Object next() {
		Produto produto = produtos[posicao];
		posicao++;
		return produto;
	}
	
	public boolean hasNext() {
		if (posicao >= produtos.length || produtos[posicao] == null) {
            return false;
        } else {
            return true;
        }
	}

}
