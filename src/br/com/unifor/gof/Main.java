package br.com.unifor.gof;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.unifor.adapter.AppleAdapter;
import br.com.unifor.adapter.AppleSmartphone;
import br.com.unifor.adapter.SamsungSmartphone;
import br.com.unifor.adapter.Smartphone;
import br.com.unifor.facade.Empresa;
import br.com.unifor.facade.Pessoa;
import br.com.unifor.facade.Seguro;
import br.com.unifor.facade.Sistema;
import br.com.unifor.gof.composite.Departamento;
import br.com.unifor.gof.singleton.Conexao;
import br.com.unifor.templatemethod.Ufc;
import br.com.unifor.templatemethod.Unifor;

public class Main {

	public static void main(String[] args) {
		int opcao = -1;
		Scanner scan = new Scanner(System.in);
		
		
		while (opcao != 0) {
			System.out.print("Escolha um exemplo de padrão: \n");
			System.out.println("1  - Singleton");
			System.out.println("2  - Composite");
			System.out.println("3  - Façade");
			System.out.println("4  - Adapter");
			System.out.println("5  - Template Method");
			System.out.println("6  - ToDo");
			System.out.println("7  - ToDo");
			System.out.println("8  - ToDo");
			System.out.println("9  - ToDo");
			System.out.println("10 - ToDo\n");
			System.out.print("Opção: ");
			opcao = scan.nextInt();
			System.out.println("\n---------------------------------------------------");
			
			switch (opcao) {
			case 1:
				System.out.println("\n *** SINGLETON ***\n");
				System.out.println("Cria um conexão ao banco de dados. Se já existir, retorna a instância já existente.\n");
				// Na primeira vez irá criar uma conexão
				// Se escolher a opção "1 - Singleton" novamente, irá retornar a mesma conexão
				Conexao.getConexao();
				System.out.println("\n---------------------------------------------------\n");
				
				break;
				
			case 2:
				System.out.println("\n*** COMPOSITE ***\n");
				System.out.println("Cada departamento pode ser composto por mais departamentos");
				System.out.println("\n---------------------------------------------------\n");
				
				Departamento empresa = new Departamento("Empresa");
				Departamento departamentoRh = new Departamento("Departamento de RH");
				Departamento departamentoTi = new Departamento("Departamento de TI");
				Departamento departamentoDesenvolvimento = new Departamento("Departamento de Desenvolvimento");
				Departamento departamentoSuporte = new Departamento("Departamento de Suporte");
				
				//Empresa é o departamento principal
				// Departamentos de Ti e de Rh compõem a empresa
				empresa.addDepartamento(departamentoTi);
				empresa.addDepartamento(departamentoRh);
				
				// Os departamentos de desenvolvimento e suporte compõem o departamento de TI
				departamentoTi.addDepartamento(departamentoDesenvolvimento);
				departamentoTi.addDepartamento(departamentoSuporte);
				
				// Daniel e Guilherme são funcionários do departamento de desenvolvimento
				// Como o desenvolvimento compõe o TI, e este compõe a empresa, Daniel e Guilherme são funcionários de desenvolvimento, TI e Empresa
				departamentoDesenvolvimento.addFuncionario("Daniel");
				departamentoDesenvolvimento.addFuncionario("Guilherme");				
				// A mesma lógica para Vicente, mas ele é do departamento de suporte
				departamentoSuporte.addFuncionario("Vicente");
				// E Maria é funcionário do departamento de Rh e Empresa
				departamentoRh.addFuncionario("Maria");
				
				System.out.println("Departamentos da Empresa\n");
				// Mostra todos os seus departamentos e os de deus filhos
				empresa.showDepartamentos();
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Funcionários da Empresa\n");
				// Mostra todos os funcionários de todos os departamentos que o compõem e de seus filhos
				empresa.showFuncionarios();
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Departamentos do Departamento de TI\n");
				departamentoTi.showDepartamentos();
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Funcionários do Departamento de TI\n");
				departamentoTi.showFuncionarios();
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Funcionários do Departamento de Desenvolvimento\n");
				departamentoDesenvolvimento.showFuncionarios();
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Funcionários do Departamento de Suporte\n");
				departamentoSuporte.showFuncionarios();
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Funcionários do Departamento de RH\n");
				departamentoRh.showFuncionarios();
				System.out.println("\n---------------------------------------------------\n");
				
				break;
				
			case 3:
				System.out.println("\n*** FAÇADE ***\n");
				System.out.println("Uma única classe mais elevada e simplificada para um conjunto de classes de um subsitema");
				System.out.println("\n---------------------------------------------------\n");
				
				Sistema s = new Sistema();
				Pessoa p1 = s.createPessoa("Marcos", 29, 1000);
				Pessoa p2 = s.createPessoa("José", 62, 3500);
				Empresa ePrivada = s.createEmpresa("Unifor", "Privada");
				Empresa ePublica = s.createEmpresa("Prefeitura", "Pública");
				Seguro sVeiculo = s.createSeguro("Azul", "Veículo");
				Seguro sVida = s.createSeguro("Porto", "Vida");
				
				System.out.println("Cliente\t\tEmpresa\t\tTipo\t\tSalário\t\tBonus");
				System.out.println(p1.getNome() + "\t\t" + ePrivada.getNome() + "\t\t" + ePrivada.getTipo() + "\t\t" + p1.getSalario() + "\t\t" + s.calculaBonus(p1, ePrivada));
				System.out.println(p1.getNome() + "\t\t" + ePublica.getNome() + "\t" + ePublica.getTipo() + "\t\t" + p1.getSalario() + "\t\t" + s.calculaBonus(p1, ePublica));
				System.out.println(p2.getNome() + "\t\t" + ePrivada.getNome() + "\t\t" + ePrivada.getTipo() + "\t\t" + p2.getSalario() + "\t\t" + s.calculaBonus(p2, ePrivada));
				System.out.println(p2.getNome() + "\t\t" + ePublica.getNome() + "\t" + ePublica.getTipo() + "\t\t" + p2.getSalario() + "\t\t" + s.calculaBonus(p2, ePublica));
				
				System.out.println("\n---------------------------------------------------\n");
				
				System.out.println("Cliente\t\tSeguradora\tTipo\t\tSalário\t\tValor");
				System.out.println(p1.getNome() + "\t\t" + sVeiculo.getNome() + "\t\t" + sVeiculo.getTipo() + "\t\t" + p1.getSalario() + "\t\t" + s.calculaSeguro(p1, sVeiculo));
				System.out.println(p1.getNome() + "\t\t" + sVida.getNome() + "\t\t" + sVida.getTipo() + "\t\t" + p1.getSalario() + "\t\t" + s.calculaSeguro(p1, sVida));
				System.out.println(p2.getNome() + "\t\t" + sVeiculo.getNome() + "\t\t" + sVeiculo.getTipo() + "\t\t" + p2.getSalario() + "\t\t" + s.calculaSeguro(p2, sVeiculo));
				System.out.println(p2.getNome() + "\t\t" + sVida.getNome() + "\t\t" + sVida.getTipo() + "\t\t" + p2.getSalario() + "\t\t" + s.calculaSeguro(p2, sVida));
				System.out.println("\n---------------------------------------------------\n");
				break;
				
			case 4:
				System.out.println("\n*** ADAPTER ***\n");
				System.out.println("Converte a interface de uma classe para outra interface compatível com o esperado");
				System.out.println("\n---------------------------------------------------\n");
				
				ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();
				smartphones.add(new SamsungSmartphone());
				// Não é possível criar instância de AppleSmartphone para colocar na arraylist de Smartphone
				// Usa-se o adapter para que as assinaturas dos métodos sejam as mesmas de Smartphone
				// AppleAdapter terá os métodos com nomes corretos fazendo chamada aos métodos de AppleSmartphone
				smartphones.add(new AppleAdapter());
				
				System.out.println("\nTestando funções\n");				
				for (Smartphone smartphone : smartphones) {
					smartphone.call();
					smartphone.text();
					smartphone.wifi();
					System.out.println();
				}
				System.out.println("\n---------------------------------------------------\n");
				
				break;
				
			case 5:
				System.out.println("\n*** TEMPLATE METHOD ***\n");
				System.out.println("Define alguns métodos, permitindo que sejam alterados nas subclasses. \nOutros métodos são abstratos e cada subclasse implementa de uma forma diferente");
				System.out.println("\n---------------------------------------------------\n");
				
				Ufc ufc = new Ufc();
				Unifor unifor = new Unifor();
				double mf;
				
				System.out.println("UNIVERSIDADE\tAV1\tAV2\tAF\tMÉDIA FINAL\tSITUAÇÃO");
				mf = ufc.mediaFinal(9.0, 8.5, 0.0);
				System.out.println("UFC\t\t9.0\t8.5\t0.0\t" + mf + "\t\t" + ufc.situacao(mf));
				mf = ufc.mediaFinal(6.0, 7.5, 6.0);
				System.out.println("UFC\t\t6.0\t7.5\t6.0\t" + mf + "\t\t" + ufc.situacao(mf));
				mf = ufc.mediaFinal(5.0, 5.5, 4.0);
				System.out.println("UFC\t\t5.0\t5.5\t4.0\t" + mf + "\t\t" + ufc.situacao(mf));
				mf = unifor.mediaFinal(6.0, 7.0, 5.5);
				System.out.println("UNIFOR\t\t6.0\t7.0\t5.5\t" + mf + "\t\t" + unifor.situacao(mf));
				mf = unifor.mediaFinal(5.0, 5.0, 4.0);
				System.out.println("UNIFOR\t\t5.0\t5.0\t4.0\t" + mf + "\t\t" + unifor.situacao(mf));
				System.out.println("\n---------------------------------------------------\n");
				
				break;
				
			case 6:
				System.out.println("\n6 = " + opcao + "\n");
				break;
				
			case 7:
				System.out.println("\n7 = " + opcao + "\n");
				break;
				
			case 8:
				System.out.println("\n8 = " + opcao + "\n");
				break;
				
			case 9:
				System.out.println("\n9 = " + opcao + "\n");
				break;
			
			case 10:
				System.out.println("\n10 = " + opcao + "\n");
				break;
				
			case 0:
				System.out.println("\nExecução finalizada.\n");
				break;

			default:
				System.out.println("\nOpção inválida. Escolha novamente.\n");
				break;
			}
			
		}		

	}

}
