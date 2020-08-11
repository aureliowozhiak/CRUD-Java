package views;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controllers.*;
import models.Cliente;
import models.ProdutoVenda;;

public class Main {

	static ClienteController clientes = new ClienteController();
	static FormaPagamentoController formasPagamento = new FormaPagamentoController();
	static ProdutoController produtos = new ProdutoController();
	static VendaController vendas = new VendaController();
	
	//Iago Canez Medeiros - 1833441
    public static void main(String[] args) throws NumberFormatException, IOException{
        System.out.println("\n::. Supermercado do Iago .::");
        System.out.println("\n");
        
			int op = 0;
			
			do {
			    System.out.println("\nEscolha uma opção e digite o numeral:");
			    System.out.println("1) Cadastrar cliente");
			    System.out.println("2) Cadastrar produto");
			    System.out.println("3) Cadastrar forma de pagamento");
			    System.out.println("4) Cadastrar venda");
			    System.out.println("5) Listar vendas");
			    System.out.println("6) Listar vendas por forma de pagamento");
			    System.out.println("7) Listar clientes");
			    System.out.println("8) Listar produtos");
			    System.out.println("9) Listar formas de pagamento");
			    System.out.println("0) Sair");

			    InputStreamReader streamReader = new InputStreamReader(System.in);
			    BufferedReader bufferedReader = new BufferedReader(streamReader);
			    op = 0;
			    
			    op = Integer.parseInt(bufferedReader.readLine());
			    
			    if(op >= 1 && op <= 12) {
			    	switch (op) {
					case 1:
						System.out.println("::. Cadastrar cliente .::");
						System.out.println("\n");
						System.out.println("Digite o CPF do cliente: ");	
						String cpf = bufferedReader.readLine().toString();
						
						System.out.println("Digite o nome do cliente: ");		
						String nome = bufferedReader.readLine();
										
						clientes.SetCliente(cpf, nome);
						break;
					case 2:
						System.out.println("::. Cadastrar produto .::");
						System.out.println("\n");
						System.out.println("Digite o nome do produto: ");	
						String nomeProduto = bufferedReader.readLine();
						
						System.out.println("Digite o preço do produto: ");	
						Double preco = Double.parseDouble(bufferedReader.readLine());
						
						System.out.println("Digite a quantidade em estoque do produto: ");	
						int quantidadeEstoque = Integer.parseInt(bufferedReader.readLine());
						
						produtos.SetProduto(nomeProduto, preco, quantidadeEstoque);
						
						break;
					case 3:
						System.out.println("::. Cadastrar forma de pagamento .::");
						System.out.println("\n");
						System.out.println("Digite o nome da forma de pagamento: ");	
						String nomeFormaPagamento = bufferedReader.readLine();
						
						formasPagamento.SetFormaPagamento(nomeFormaPagamento);
						
						break;
					case 4:
						System.out.println("::. Cadastrar venda .::");
						System.out.println("\n--Digite o CPF do cliente: ");	
						String cpfClienteVenda = bufferedReader.readLine();
						
						formasPagamento.ListFormasPagamento();

						System.out.println("\n--Digite a Forma de Pagamento: ");	
						String nomeFormaPagamentoVenda = bufferedReader.readLine();


						ArrayList<ProdutoVenda> produtosVenda = new ArrayList<ProdutoVenda>();
						
						int sairProdutos = 1;
						
						produtos.ListProdutos();

						
						do {

							ProdutoVenda produtoVenda = new ProdutoVenda();
							System.out.println("\n--Dos produtos a cima, digite o nome do produto: ");	
							produtoVenda.nomeProduto = bufferedReader.readLine();

							System.out.println("\n--Digite a quantidade para o produto em questão: ");	
							produtoVenda.quantidade = Integer.parseInt(bufferedReader.readLine());
							
							produtosVenda.add(produtoVenda);
							

							System.out.println("\n--Deseja adicionar mais produtos? 1 (sim) / 0 (não) ");	
							sairProdutos = Integer.parseInt(bufferedReader.readLine());
							
						}while(sairProdutos == 1);
						
						vendas.SetVenda(cpfClienteVenda, nomeFormaPagamentoVenda, produtosVenda);
						
						break;
					case 5:
						vendas.ListVendas();
						break;
					case 6:
						System.out.println("\n--Digite a forma de pagamento: ");	
						String formaPagamento = bufferedReader.readLine();
						vendas.ListVendasPorFormaPagamento(formaPagamento);
						
						break;
					case 7:
						clientes.ListClientes();
						break;
					case 8:
						produtos.ListProdutos();
						break;
					case 9:
						formasPagamento.ListFormasPagamento();
						break;
				
						
						//Apenas para testes e buscas extras
				case 10:

						System.out.println("\n--Digite o CPF do cliente: ");	
						String cpfBusca = bufferedReader.readLine();
						
						System.out.print(clientes.ListClientesPorCpf(cpfBusca));
						break;
			
				case 11:

					System.out.println("\n--Digite o nome de um produto para buscar: ");	
					String nomeProdutoBusca = bufferedReader.readLine();
					
					System.out.print(produtos.ListProdutoBusca(nomeProdutoBusca));
					break;
		
				case 12:
					System.out.println("\n--Digite uma forma de pagamento para buscar: ");	
					String nomeFormaPagamentoBusca = bufferedReader.readLine();
					
					System.out.print(formasPagamento.ListFormaPagamentoBusca(nomeFormaPagamentoBusca));
					break;
				
	
			default:
				break;
			};
			    }else {
			    	op = 0;
				    System.out.println("\n::. Sistema encerrado.::");
			    }
			    
			}while(op != 0);
		}
    
    
	}
	
