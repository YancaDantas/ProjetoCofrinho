package atividade.uninter;

import java.util.Scanner;

public class Menu {

	private Scanner sc; // Objeto para leitura de entrada do usuário
	private Cofrinho cofrinho; // Objeto que representa o cofrinho com as moedas


	public Menu() {
		sc = new Scanner(System.in); // Inicia o objeto de leitura
		cofrinho = new Cofrinho(); // Inicia o objeto do cofrinho vazio
	}

    // Exibe o menu principal 
	public void mostrarMenuPrincipal() {
		System.out.println("COFRINHO:");
		System.out.println("1- Adicionar moeda:");
		System.out.println("2- Remover moeda");
		System.out.println("3- Listar moedas");
		System.out.println("4- Calcular valor total convertido para real");
		System.out.println("0- Encerrar");
		
		String opcaoSelec = sc.next(); // Lê a opção digitada pelo usuário

		// Verifica a opção selecionada e realiza o comando
		switch (opcaoSelec) {
			case "0":
				System.out.println("Sistema encerrado!");
				break;

			case "1":
				exibirMenuAddMoedas(); //Adiciona moedas
				
				break;

			case "2":
				exibirRemoveMoedas(); // Remove moedas
				mostrarMenuPrincipal(); // Volta ao menu principal
				
				break;

			case "3":
				cofrinho.listagemMoedas(); // Exibe a lista das moedas que estão no cofrinho
				mostrarMenuPrincipal(); // Volta ao menu principal
				break;

			case "4":
				double valorTotalConvertido = cofrinho.totalConvertido(); // Calcula o valor total em Real
				System.out.println("Valor total convertido para real: " + valorTotalConvertido);
				mostrarMenuPrincipal(); // Volta ao menu principal
				
				break;

			default:
				System.out.println("Opção inválida."); // Mensagem caso a opção não seja válida
				break;
		}
	}

    // Exibe o menu para add moedas
	private void exibirMenuAddMoedas() {
		System.out.println("Escolha a moeda:");
		System.out.println("1- Real");
		System.out.println("2- Dólar");
		System.out.println("3- Euro");

		int tipoMoeda = sc.nextInt(); // Lê a opção de moeda digitada pelo usuário

		System.out.println("Digite o valor:");

		String valorMoeda = sc.next(); // Lê o valor da moeda digitado pelo usuário como String

		valorMoeda = valorMoeda.replace(",", "."); // Substitui vírgulas por pontos para permitir a conversão para double
		double valorMoedaFinal = Double.parseDouble(valorMoeda); // Converte o valor para double

		Moeda moeda = null;

		// Verifica o tipo de moeda selecionada e cria o objeto correspondente
		if (tipoMoeda == 1) {
			moeda = new Real(valorMoedaFinal);
		} else if (tipoMoeda == 2) {
			moeda = new Dolar(valorMoedaFinal);
		} else if (tipoMoeda == 3) {
			moeda = new Euro(valorMoedaFinal);
		} else {
			System.out.println("Digite uma opção válida");
			mostrarMenuPrincipal(); // Volta ao menu principal
			return; 
		}

		cofrinho.adicionar(moeda); // Adiciona a moeda criada no cofrinho
		System.out.println("Moeda adicionada!");
		mostrarMenuPrincipal(); // Volta ao menu principal
		return;
	}

    // Exibe o menu para remover moedas
	private void exibirRemoveMoedas() {
		System.out.println("Escolha a moeda:");
		System.out.println("1- Real");
		System.out.println("2- Dólar");
		System.out.println("3- Euro");

		int tipoMoeda = sc.nextInt(); // Lê a opção de moeda digitada pelo usuário

		System.out.println("Qual o valor deseja remover?:");

		String valorMoeda = sc.next(); // Lê o valor da moeda digitado pelo usuário como String

		valorMoeda = valorMoeda.replace(",", "."); // Substitui vírgula por ponto e permite a conversão para double
		double valorMoedaFinal = Double.parseDouble(valorMoeda); // Converte o valor para double
        
		
		Moeda moeda = null;

		// Verifica o tipo de moeda selecionada e cria o objeto correspondente
		if (tipoMoeda == 1) {
			moeda = new Real(valorMoedaFinal);
		} else if (tipoMoeda == 2) {
			moeda = new Dolar(valorMoedaFinal);
		} else if (tipoMoeda == 3) {
			moeda = new Euro(valorMoedaFinal);
		} else {
			System.out.println("Digite uma opção válida"); 
			mostrarMenuPrincipal(); // Volta ao menu principal 
            return;
		}

		cofrinho.remove(moeda); // Remove a moeda do cofrinho
		
	}
}
