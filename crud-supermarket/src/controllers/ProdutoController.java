package controllers;

import java.util.ArrayList;

import models.Produto;

public class ProdutoController {

	ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public void SetProduto(String nomeProduto, double preco, int quantidadeEstoque){

		Produto produto = new Produto();

		produto.nome = nomeProduto;
		produto.preco = preco;
		produto.quantidadeEstoque = quantidadeEstoque;
		
		if(produtos.isEmpty()) {
			SetNovoProduto(produto);
		}else {
			if(!ListProdutoBusca(produto.nome)) {
				SetNovoProduto(produto);
			}else {
				System.out.println("\n Produto já existente na base X");
			}
		}
		
	}
	
	public void SetNovoProduto(Produto produto){
		produtos.add(produto);
		System.out.println("\n Produto cadastrado ✓");
				
	}
	
	public void ListProdutos() {

		System.out.println("::. Lista de Produtos .::");
		for(Produto produto : produtos) {
			System.out.println(
					"---\nProduto: " + produto.nome + 
					"\nPreço: " + produto.preco +
					"\nQuantida em estoque: " + produto.quantidadeEstoque);
		}
		
	}
	
	public Boolean ListProdutoBusca(String nomeProduto) {

		Boolean result = false;

		for(Produto produto : produtos) {
			if(nomeProduto.contains(produto.nome.toString())) {
				System.out.println(
						"---\nProduto: " + produto.nome + 
						"\nPreço: " + produto.preco +
						"\nQuantida em estoque: " + produto.quantidadeEstoque);
				result = !produto.nome.isEmpty();
			}
		}
		

		return result;
		
	}
}
