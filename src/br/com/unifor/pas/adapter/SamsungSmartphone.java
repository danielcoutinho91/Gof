package br.com.unifor.pas.adapter;

public class SamsungSmartphone implements Smartphone {
	
	public void call() {
		System.out.println("Smartphone Samsung fazendo ligação");
	}
	
	public void text() {
		System.out.println("Smartphone Samsung envivando mensagem de texto");
	}
	
	public void wifi() {
		System.out.println("Smartphone Samsung conectando a rede WiFi");
	}

}
