package br.com.unifor.pas.singleton;

public class Conexao {
	
	private static Conexao instance = null;
	
	public static Conexao getConexao() {
		
		if (instance == null) {
			System.out.println("Criando nova conexão");
			instance = new Conexao();
		} else {
			System.out.println("Retornando conexão já existente");
		}		
		
		return instance;
	}

}
