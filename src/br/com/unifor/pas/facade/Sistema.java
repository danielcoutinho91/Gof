package br.com.unifor.pas.facade;

public class Sistema {
	
	public Pessoa createPessoa(String nome, int idade, double salario) {
		Pessoa p = new Pessoa(nome, idade, salario);
		return p;
	}
	
	public Seguro createSeguro(String nome, String tipo) {
		Seguro s = new Seguro(nome, tipo);
		return s;
	}
	
	public Empresa createEmpresa(String nome, String tipo) {
		Empresa e = new Empresa(nome, tipo);
		return e;
	}
	
	public double calculaSeguro(Pessoa p, Seguro s) {
		double valor;
		double idade = p.getIdade();
		double salario = p.getSalario();
		String tipo = s.getTipo();
		
		if (tipo == "Veículo") {
			if (idade <= 30) {
				valor = 0.15 * salario;
			} else {
				valor = 0.05 * salario;
			}
		} else {
			if (idade > 30) {
				valor = 0.2 * salario;
			} else {
				valor = 0.1 * salario;
			}
		}
		
		return valor;
	}
	
	public double calculaBonus(Pessoa p, Empresa e) {
		double valor;
		double idade = p.getIdade();
		double salario = p.getSalario();
		String tipo = e.getTipo();
		
		if (tipo == "Privada") {
			if (salario <= 1200) {
				valor = 0.2 * salario;
			} else {
				valor = 0.1 * salario;
			}
		} else {
			if (salario <= 2000) {
				valor = 0.15 * salario;
			} else {
				valor = 0.05 * salario;
			}
		}
		
		return valor;
	}

}
