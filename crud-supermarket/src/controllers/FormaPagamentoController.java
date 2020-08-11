package controllers;

import java.util.ArrayList;

import models.FormaPagamento;

public class FormaPagamentoController {

	ArrayList<FormaPagamento> formasPagamento = new ArrayList<FormaPagamento>();
	
	public void SetFormaPagamento(String nome){

		FormaPagamento formaPagamento = new FormaPagamento();
		
		formaPagamento.nome = nome;
		
		if(formasPagamento.isEmpty()) {
			SetNovaFormaPagamento(formaPagamento);
		}else {
			
			if(!ListFormaPagamentoBusca(nome)) {
				SetNovaFormaPagamento(formaPagamento);
			}else {
				System.out.println("\n Forma de pagamento já existente na base X");
			}
		}
		
	}
	
	public void SetNovaFormaPagamento(FormaPagamento formaPagamento) {
		
		formasPagamento.add(formaPagamento);
		System.out.println("\n Forma de pagamento cadastrada ✓");
				
	}
	
	public void ListFormasPagamento() {

		System.out.println("::. Lista de Formas de Pagamento .::");
		for(FormaPagamento formaPagamento : formasPagamento) {
			System.out.println("---\nForma de pagamento:"+formaPagamento.nome);
		}
		
	}
	
public Boolean ListFormaPagamentoBusca(String nomeFormaPagamento) {
		
		Boolean result = false;
		
		for(FormaPagamento formaPagamento : formasPagamento) {
			if(nomeFormaPagamento.contains(formaPagamento.nome.toString())) {
				System.out.println("---\nForma pagamento: " + formaPagamento.nome);
				result = !formaPagamento.nome.isEmpty();
			}
		}

		return result;
	}
}
