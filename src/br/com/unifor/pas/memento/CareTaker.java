package br.com.unifor.pas.memento;

import java.util.ArrayList;

public class CareTaker {

	private ArrayList<Memento> mementoList = new ArrayList<Memento>();
	
	public void add(Memento configuracao) {
		mementoList.add(configuracao);
	}
	
	public Memento get(int index) {
		return mementoList.get(index);
	}
	
}
