package controllers;

import java.util.ArrayList;

import models.Cliente;

public class ClienteController{
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void SetCliente(String cpf, String nome){
		
		Cliente cliente = new Cliente();
		
		cliente.cpf = cpf;
		cliente.nome = nome;

		if(clientes.isEmpty()) {
			SetNovoCliente(cliente);
		}else {
			
			if(!ListClientesPorCpf(cliente.cpf)) {
				SetNovoCliente(cliente);
			}else {
				System.out.println("\n CPF já existente na base X");
			}
		}
	}
	
	public void SetNovoCliente(Cliente cliente){

		clientes.add(cliente);
		System.out.println("\n Cliente cadastrado ✓");
		
	}
	
	public void ListClientes() {

		System.out.println("::. Lista de Clientes .::");
		for(Cliente cliente : clientes) {
			System.out.println(
					"---\nCPF: " + cliente.cpf + 
					"\nNome: " + cliente.nome);
		}
	}
	

	public Boolean ListClientesPorCpf(String cpf) {
		
		Boolean result = false;
		
		for(Cliente cliente : clientes) {
			if(cpf.contains(cliente.cpf.toString())) {
				System.out.println("---\nCPF: " + cliente.cpf);
				System.out.println("---\nNome: " + cliente.nome);
				result = !cliente.cpf.isEmpty();
			}
		}

		return result;
	}
	
	
	
}
