package br.com.unifor.pas.singleton;

public class Conexao {
	
	private static Conexao instance = null;
	
	public static Conexao getConexao() {
		
		if (instance == null) {
			System.out.println("Criando nova conex�o");
			instance = new Conexao();
		} else {
			System.out.println("Retornando conex�o j� existente");
		}		
		
		return instance;
	}

}
