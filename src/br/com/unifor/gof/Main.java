package br.com.unifor.gof;

import java.util.Scanner;

import br.com.unifor.gof.composite.Departamento;
import br.com.unifor.gof.singleton.Conexao;

public class Main {

	public static void main(String[] args) {
		int opcao = -1;
		Scanner scan = new Scanner(System.in);
		
		
		while (opcao != 0) {
			System.out.print("Escolha um exemplo de padrão: \n");
			System.out.println("1  - Singleton");
			System.out.println("2  - Composite");
			System.out.println("3  - ToDo");
			System.out.println("4  - ToDo");
			System.out.println("5  - ToDo");
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
				System.out.println("\n3 = " + opcao + "\n");
				break;
				
			case 4:
				System.out.println("\n4 = " + opcao + "\n");
				break;
				
			case 5:
				System.out.println("\n5 = " + opcao + "\n");
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
