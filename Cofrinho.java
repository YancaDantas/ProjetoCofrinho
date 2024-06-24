//Yanca Maria Dantas de Paula - RU: 4614912

package atividade.uninter;

import java.util.ArrayList;

public class Cofrinho {
	
	private ArrayList<Moeda> listaMoedas; 
	
	public Cofrinho() {
		this.listaMoedas = new ArrayList<>(); // Inicia a lista de moedas
	}
	
	// Método para adicionar moedas ao cofrinho
	public void adicionar (Moeda moeda) {
		this.listaMoedas.add(moeda); // Adiciona moedas na lista
	}
	
	//Remove moedas do cofrinho
	public void remove (Moeda moeda) {
		this.listaMoedas.remove(moeda); // Remove moedas da lista
	}
	
	// Lista as moedas que estão no cofrinho
	public void listagemMoedas() {
		// Verifica se o cofrinho está vazio e retorna uma mensagem
		if (this.listaMoedas.isEmpty()) {
			System.out.println("Sem moedas no cofrinho :(");
			return; 
		}
		
		// Informações sobre cada moeda da lista
		for (Moeda moeda : this.listaMoedas) {
			moeda.info();
		}
	}
	
	// Calcula o valor total das moedas convertidas
	public double totalConvertido() {
		
		if (this.listaMoedas.isEmpty()) {
			return 0;
		}
		double valorAcumulado = 0; // Retorna 0 se o cofrinho estiver vazio
		
		
		for (Moeda moeda : this.listaMoedas) {
			valorAcumulado = valorAcumulado + moeda.converter(); // Acumula o valor convertido da moeda
		}
		return valorAcumulado; 
		
	}
}
