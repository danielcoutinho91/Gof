package br.com.unifor.pas.gof;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.unifor.gof.pas.composite.Departamento;
import br.com.unifor.gof.pas.singleton.Conexao;
import br.com.unifor.gof.pas.state.Aluno;
import br.com.unifor.pas.adapter.AppleAdapter;
import br.com.unifor.pas.adapter.AppleSmartphone;
import br.com.unifor.pas.adapter.SamsungSmartphone;
import br.com.unifor.pas.adapter.Smartphone;
import br.com.unifor.pas.facade.Empresa;
import br.com.unifor.pas.facade.Pessoa;
import br.com.unifor.pas.facade.Seguro;
import br.com.unifor.pas.facade.Sistema;
import br.com.unifor.pas.iterator.ListaProdutos;
import br.com.unifor.pas.iterator.ListaProdutosIterator;
import br.com.unifor.pas.iterator.Produto;
import br.com.unifor.pas.memento.CareTaker;
import br.com.unifor.pas.memento.Configuracao;
import br.com.unifor.pas.memento.Originator;
import br.com.unifor.pas.prototype.Console;
import br.com.unifor.pas.prototype.Playstation;
import br.com.unifor.pas.strategy.Circulo;
import br.com.unifor.pas.strategy.Figura;
import br.com.unifor.pas.strategy.Quadrado;
import br.com.unifor.pas.strategy.Triangulo;
import br.com.unifor.pas.templatemethod.Ufc;
import br.com.unifor.pas.templatemethod.Unifor;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		int opcao = -1;
		Scanner scan = new Scanner(System.in);
		
		
		while (opcao != 0) {
			System.out.print("Escolha um exemplo de padrão: \n");
			System.out.println("1  - Singleton");
			System.out.println("2  - Composite");
			System.out.println("3  - Façade");
			System.out.println("4  - Adapter");
			System.out.println("5  - Template Method");
			System.out.println("6  - Strategy");
			System.out.println("7  - Iterator");
			System.out.println("8  - Prototype");
			System.out.println("9  - Memento");
			System.out.println("10 - State\n");
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
				System.out.println("\n*** STRATEGY ***\n");
				System.out.println("Define uma família de algoritmos de encapsula cada um deles. \nPermite que o algoritmo varie independente do cliente");
				System.out.println("\n---------------------------------------------------\n");
				
				// Cada figura tem um cálculo da área diferente
				Figura quadrado = new Quadrado();
				Figura triangulo = new Triangulo();
				Figura circulo = new Circulo();
				
				int l = 3;
				System.out.println("Cálculo das áreas para cada figura\n");
				System.out.println("Quadrado: \t" + quadrado.calculaArea(l));
				System.out.println("Triângulo: \t" + triangulo.calculaArea(l));
				System.out.println("Círculo: \t" + circulo.calculaArea(l));
				System.out.println("\n---------------------------------------------------\n");
				
				break;
				
			case 7:
				System.out.println("\n*** ITERATOR ***\n");
				System.out.println("É usado para percorrer os itens de uma coleção sem violar o seu encapsulamento ");
				System.out.println("\n---------------------------------------------------\n");
				
				// Cria nova lista de produtos
				ListaProdutos lista = new ListaProdutos();
				
				// Adiciona produtos a lista
				lista.addProduto("Cadeira", 49.99);
				lista.addProduto("Mesa", 129.90);
				lista.addProduto("Cama", 299.99);
				lista.addProduto("Televisão", 499.90);
				
				// Cria o iterator passando os produtos da lista
				ListaProdutosIterator listaProdutosIt = new ListaProdutosIterator(lista.getProdutos());
				
				System.out.println("Lista de Produtos\n");
				// Enquanto tiver um próximo elemento, executa o código dentro do while
				while (listaProdutosIt.hasNext()) {
					// Pega o próximo produto da lista
					System.out.println(listaProdutosIt.next());
				}
				System.out.println("\n---------------------------------------------------\n");
				break;
				
			case 8:
				System.out.println("\n*** PROTOTYPE ***\n");
				System.out.println("É usado para percorrer os itens de uma coleção sem violar o seu encapsulamento ");
				System.out.println("\n---------------------------------------------------\n");
				
				// Criando primeira instância
				ArrayList<String> midias = new ArrayList<String>();
				midias.add("CD");
				Console ps1 = new Playstation("Sony", "Playstation", 1994, "Cinza", midias);
				ps1.showInfo();
				
				// Criando segunda instância a partir da primeira
				Console ps2 = ps1.clone();				
				// Mudando apenas os campos que irão modificar
				ps2.setNome("Playstation 2");
				ps2.setAno(2000);
				ps2.setCor("Preto");
				ps2.addMidia("DVD");
				ps2.showInfo();
				
				// Criando terceira instância a partir da segunda
				Console ps3 = ps2.clone();
				//Mudando apenas os campos que irão modificar
				ps3.setNome("Playstation 3");
				ps3.setAno(2006);
				ps3.addMidia("Blu-ray");
				ps3.showInfo();
				
				System.out.println("\n---------------------------------------------------\n");
				break;
				
			case 9:
				System.out.println("\n*** MEMENTO ***\n");
				System.out.println("Guarda o estado atual de um objeto sem violar o encapsulamento e permite recuperá-lo no futuro");
				System.out.println("\n---------------------------------------------------\n");
				
				Originator originator = new Originator();
				CareTaker caretaker = new CareTaker();
				
				Configuracao config1 = new Configuracao("Windows", "Intel", "4GB");
				Configuracao config2 = new Configuracao("Linux", "Nvidia", "8GB");
				Configuracao config3 = new Configuracao("Apple", "ATI", "16GB");
				
				// Originator recebe a configuração 1
				originator.setConfiguracao(config1);
				
				// Caretaker salva a configuração que está atualmento no originator
				caretaker.add(originator.saveConfiguracaoToMemento());
				
				// Originator recebe a configuração 2				
				originator.setConfiguracao(config2);
				
				// Salva a configuração 2 no caretaker
				caretaker.add(originator.saveConfiguracaoToMemento());
				
				// Originator recebe a configuração 3
				originator.setConfiguracao(config3);
				
				// Imprime a configuração que está atualmente no originator
				originator.getConfiguracao().showInfo();
				
				// Originator recebe a primeira configuração salva no caretaker
				originator.getConfiguracaoFromMemento(caretaker.get(0));
				
				// Imprime a configuração que está atualmente no originator
				originator.getConfiguracao().showInfo();
				
				// Originator recebe a segunda configuração salva no caretaker
				originator.getConfiguracaoFromMemento(caretaker.get(1));
				
				// Imprime a configuração que está atualmente no originator
				originator.getConfiguracao().showInfo();
				
				System.out.println("\n---------------------------------------------------\n");
				break;
			
			case 10:
				System.out.println("\n*** STATE ***\n");
				System.out.println("Permite que um objeto mude o comportamento de seus métodos de acordo com o seu estado atual");
				System.out.println("\n---------------------------------------------------\n");
				
				Aluno a1 = new Aluno("Mateus", 9.5, 1000);
				Aluno a2 = new Aluno("Luiz", 8.2, 1000);
				Aluno a3 = new Aluno("Carlos", 6.5, 1000);
				Aluno a4 = new Aluno("Caio", 3.0, 1000);
				ArrayList<Aluno> alunos = new ArrayList<Aluno>();
				alunos.add(a1);
				alunos.add(a2);
				alunos.add(a3);
				alunos.add(a4);
				
				for (Aluno aluno : alunos) {
					System.out.println("Nome: \t\t" + aluno.getNome());
					System.out.println("Média: \t\t" + aluno.getMedia());
					System.out.println("Mensalidade: \t" + aluno.getMensalidade());
					System.out.println("Desempenho: \t" + aluno.getState().getDesempenho());
					System.out.println("Desconto: \t" + aluno.getState().getDesconto());
					System.out.println();
				}				
				
				System.out.println("\n---------------------------------------------------\n");
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
