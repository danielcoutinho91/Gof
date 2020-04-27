package br.com.unifor.adapter;

public class AppleAdapter extends AppleSmartphone implements Smartphone {

	public void call() {
		this.makeCall();
	}
	
	public void text() {
		this.sendText();
	}
	
	public void wifi() {
		this.connectWifi();
	}
	
}
