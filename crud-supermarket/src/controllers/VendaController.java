package controllers;

import java.util.ArrayList;

import models.Venda;
import models.ProdutoVenda;

public class VendaController {

	ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	public void SetVenda(String cpfCliente, String nomeFormaPagamento, ArrayList<ProdutoVenda> produtos){

		Venda venda = new Venda();
		
		venda.cpfCliente = cpfCliente;
		venda.nomeFormaPagamento = nomeFormaPagamento;
		venda.produtos = produtos;
		
		vendas.add(venda);
		
	}
	
	public void ListVendas() {
		System.out.println("::. Lista de Vendas .::");
		for(Venda venda : vendas) {
			System.out.println("---\nCPF: " + venda.cpfCliente);
			System.out.println("\nForma de Pagamento: " + venda.nomeFormaPagamento);
			System.out.println("\nProdutos da venda: ");
			for(ProdutoVenda produtos : venda.produtos) {
				System.out.println("\nProduto: " + produtos.nomeProduto);
				System.out.println("Quantidade produto: " + produtos.quantidade);
			}
		}
	}
	
	public void ListVendasPorFormaPagamento(String formaPagamento) {
		System.out.println("::. Lista de Vendas feita por "+ formaPagamento +" .::");
		for(Venda venda : vendas) {
			if(formaPagamento.contains(venda.nomeFormaPagamento.toString())) {
				System.out.println("---\nCPF: " + venda.cpfCliente);
				System.out.println("\nForma de Pagamento: " + venda.nomeFormaPagamento);
				System.out.println("\nProdutos da venda: ");
				for(ProdutoVenda produtos : venda.produtos) {
					System.out.println("\nProduto: " + produtos.nomeProduto);
					System.out.println("Quantidade produto: " + produtos.quantidade);
				}
			}
		}
	}
	
}
