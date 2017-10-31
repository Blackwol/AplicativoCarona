package br.acme.main;
import java.util.Scanner;
import br.acme.location.*;

import br.acme.exception.CpfInvalidoException;
import br.acme.exception.CpfNullException;
import br.acme.exception.CpfVazioException;
import br.acme.exception.EmailJaExisteException;
import br.acme.exception.EmailNullException;
import br.acme.exception.EmailVazioException;
import br.acme.exception.IdInvalidoException;
import br.acme.exception.IdJaExisteException;
import br.acme.exception.NomeNullException;
import br.acme.exception.NomeVazioException;
import br.acme.exception.SenhaNullException;
import br.acme.exception.SenhaVaziaException;
import br.acme.exception.SexoNullException;
import br.acme.exception.SexoVazioException;
import br.acme.storage.DataBase;
import br.acme.storage.RepositorioSolicitante;
import br.acme.users.Solicitante;
import br.acme.storage.RepositorioViagem;


public class MenuSolicitante {

	public static void main(String[] args) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException, EmailJaExisteException, IdJaExisteException{
		int opcao;
		Scanner entrada = new Scanner(System.in);
		
		do{
			menu();
			opcao = entrada.nextInt();
			switch(opcao){
			case 1:
				cadastro();
				break;
			case 2:
				login();
				break;
			case 3:
				sair();
				break;
			default:
				System.out.println("Opcao invalida! Digite uma opcao valida: ");
			}
		}while(opcao < 0 || opcao > 3);
		entrada.close();
	}
	
	
	public static void menu(){
		System.out.println("Menu solicitante");
		System.out.println("1. Cadastro");
		System.out.println("2. Login");
		System.out.println("3. Sair");
		System.out.println("Digite a sua opcao: ");
	}

	
	@SuppressWarnings("resource")
	public static void cadastro() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, SexoNullException, 
	CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, 
	CpfInvalidoException, EmailJaExisteException, IdJaExisteException{
		RepositorioSolicitante repSolicitante = DataBase.lerBaseSolicitante();
		Scanner x = new Scanner(System.in);
		boolean t;
		System.out.println("Cadastrar um solicitante");
		System.out.println("Digite um ID: ");
		long id = x.nextLong();
		for(int i = 0; i < 10; i++){
			if(repSolicitante.getSolicitantes()[i] != null){
				if(id == repSolicitante.getSolicitantes()[i].getId()){
					throw new IdJaExisteException("Esse ID ja esta cadastrado. Digite um ID que nao esteja cadastrado");
				}
			}
		}
		System.out.println("Digite o nome do solicitante: ");
		String nome = x.nextLine();
		t = nome.matches("[A-Z][a-z]{2,}");
		if(t == false){
			do{
				System.out.println("Nome invalido. Digite outro nome: ");
				nome = x.nextLine();
			}while(nome.matches("[A-Z][a-z]{2,}") == false);
		}
		System.out.println("Digite o CPF do solicitante: ");
		String cpf = x.nextLine();
		t = cpf.matches("[0-9]{11}");
		if(t == false){
			do{
				System.out.println("CPF invalido. Digite outro CPF: ");
				cpf = x.nextLine();
			}while(cpf.matches("[0-9]{11}") == false);
		}
		System.out.println("Digite a senha do solicitante: ");
		String senha = x.nextLine();
		t = senha.matches("[0-9]{6,}");
		if(t == false){
			do{
				System.out.println("Senha invalida. Digite outra senha(minimo 6 digitos e so numeros): ");
				senha = x.nextLine();
			}while(senha.matches("[0-9]{6,}") == false);
		}
		System.out.println("Digite o email do solicitante: ");
		String email = x.nextLine();
		for(int i = 0; i < 10; i++){
			if(repSolicitante.getSolicitantes()[i] != null){
				if(email == repSolicitante.getSolicitantes()[i].getEmail()){
					System.out.println("Esse email ja esta cadastrado. Digite um email que nao esteja cadastrado: ");
					email = x.nextLine();
				}
			}
		}
		System.out.println("Digite o sexo do solicitante(Masculino = M/ Feminino = F tem ser com letra maiuscula): ");
		String sexo = x.nextLine();
		t = sexo.matches("[A-Z]{1}");
		if(t == false){
			do{
				System.out.println("Sexo invalido. Digite outro sexo(M/F): ");
				sexo = x.nextLine();
			}while(sexo.matches("[A-Z]{1}") == false);
		}
		System.out.println("Digite o numero do celular do solicitante: ");
		int numeroCelular = x.nextInt();
		
		Solicitante solicitante = new Solicitante(id, cpf, email, senha, nome, sexo, numeroCelular);
		repSolicitante.adicionar(solicitante);
		DataBase.SalvarEstado(repSolicitante);
		x.close();
	}


	//Quando escolhem a opcao login
	public static void login() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, SexoNullException, 
	CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, 
	CpfInvalidoException, EmailJaExisteException, IdJaExisteException{
		int opcao;
		Scanner x = new Scanner(System.in);
		System.out.println("Digite seu email: ");
		String emailLogin = x.nextLine();
		System.out.println("Digite sua senha: ");
		String senhaLogin = x.nextLine();
		//for(int i = 0; i < 10; i++){
			//if(repSolicitante.getSolicitantes()[i] != null){
				//if(repSolicitante.buscar(i).getEmail().equals(emailLogin) && repSolicitante.buscar(i).getSenha().equals(senhaLogin)){
					RepositorioViagem repViagem = DataBase.lerBaseViagem();
					//Solicitante solicitante = repSolicitante.buscar(i);
					do{
						boolean t;
						RepositorioSolicitante repSolicitante = DataBase.lerBaseSolicitante();
						System.out.println("Bem vindo!");
						//System.out.println("Seu ID eh " + repSolicitante.buscar(i).getId());
						System.out.println("1. Pedir carona");
						System.out.println("2. Lista viagens");
						System.out.println("3. Alterar dados");
						System.out.println("4. Excluir conta");
						System.out.println("5. Logout");
						System.out.println("Digite sua opcao: ");
						opcao = x.nextInt();
						switch(opcao){
						case 1:
							System.out.println("Digite os dados pedidos a seguir");
							System.out.println("Identificador do lugar de origem(iniciar com letra maiuscula ex. Casa, Trabalho, etc..): ");
							String identificadorOrigem = x.nextLine();
							t = identificadorOrigem.matches("[-Z][a-z]{2,}");
							if(t == false){
								do{
									System.out.println("Identificador de origem incorreto. Digite um identificador valido(iniciar com letra maiuscula)");
									identificadorOrigem = x.nextLine();
								}while(identificadorOrigem.matches("[A-Z][a-z]{2,}") == false);
							}
							System.out.println("Digite o endereço de origem: ");
							String enderecoOrigem = x.nextLine();
							/*t = enderecoOrigem.matches("{3,}");
							if(t == false){
								do{
									System.out.println("Endereco de origem incorreto. Digite endereco correto: ");
									enderecoOrigem = x.nextLine();
								}while(enderecoOrigem.matches("{3,}") == false);
							}*/
							System.out.println("Digite identificador do destino(iniciar com letra maiuscula ex. Casa, Trabalho, etc..): ");
							String identificadorDestino = x.nextLine();
							t = identificadorDestino.matches("[A-Z][a-z]{2,}");
							if(t == false){
								do{
									System.out.println("Identificador de destino incorreto. Digite um "
											+ "identificador correto(iniciar com letra maiuscula ex. Casa, Trabalho etc..): ");
									identificadorDestino = x.nextLine();
								}while(identificadorDestino.matches("[A-Z][a-z]{2,}") == false);
							}
							System.out.println("Digite endereco de destino(iniciar com letra maiuscula): ");
							String enderecoDestino = x.nextLine();
							/*t = enderecoDestino.matches("[3,]");
							if(t == false){
								do{
									System.out.println("Endereco de destino incorreto(iniciar com letra maiuscula)");
									enderecoDestino = x.nextLine();
								}while(enderecoDestino.matches("[3,]") == false);
							}*/
							System.out.println("Escolha a forma de pagamento(iniciar com letra maiuscula -> Cartao/Dinheiro): ");
							String formaDePagamento = x.nextLine();
							t = formaDePagamento.matches("[A-Z][a-z]{5,}");
							if(t == false){
								do{
									System.out.println("Forma de pagamento incorreto. Digite uma forma correta(iniciar com letra maiuscula): ");
									formaDePagamento = x.nextLine();
								}while(formaDePagamento.matches("[A-Z][a-z]{5,}") == false);
							}
							Lugar origem = new Lugar(identificadorOrigem, enderecoOrigem);
							Lugar destino = new Lugar(identificadorDestino, enderecoDestino);
							Viagem carona = new Viagem(origem, destino, formaDePagamento);
							repViagem.adicionar(carona);
							//solicitante.solicitarCarona(carona);
							//DataBase.SalvarEstado(repSolicitante);
							DataBase.SalvarEstado(repViagem);
							x.close();
							break;
						case 2:
							for(int q = 0; q < 10; q++){
								System.out.println(repViagem.buscarTodos());
							}
							break;
						case 3:
							Scanner m = new Scanner(System.in);
							System.out.println("Para alterar os dados digite seu ID e depois os novos dados");
							long id = m.nextLong();
							for(int i = 0; i < 10; i++){
								if(repSolicitante.getSolicitantes()[i] != null){
									if(id == repSolicitante.getSolicitantes()[i].getId()){
										System.out.println("ID ja cadastrado. Digite outro ID");
										id = m.nextLong();
									}
								}
							}
							System.out.println("Digite o nome do solicitante(começar com letra maiuscula): ");
							String nome = x.nextLine();
							t = nome.matches("[A-Z][a-z]{2,}");
							if(t == false){
								do{
									System.out.println("Nome invalido. Digite outro nome(letra maiuscula): ");
									nome = m.nextLine();
								}while(nome.matches("[A-Z][a-z]{2,}") == false);
							}
							System.out.println("Digite o CPF do solicitante(11 digitos): ");
							String cpf = m.nextLine();
							t = cpf.matches("[0-9]{11}");
							if(t == false){
								do{
									System.out.println("CPF invalido. Digite outro CPF(11 digitos): ");
									cpf = m.nextLine();
								}while(cpf.matches("[0-9]{11}") == false);
							}
							System.out.println("Digite a senha do solicitante(minimo 6 digitos e so numeros): ");
							String senha = m.nextLine();
							t = senha.matches("[0-9]{6,}");
							if(t == false){
								do{
									System.out.println("Senha invalida. Digite outra senha(minimo 6 digitos e so numeros): ");
									senha = m.nextLine();
								}while(senha.matches("[0-9]{6,}") == false);
							}
							System.out.println("Digite o email do solicitante: ");
							String email = m.nextLine();
							for(int i = 0; i < 10; i++){
								if(repSolicitante.getSolicitantes()[i] != null){
									if(email == repSolicitante.getSolicitantes()[i].getEmail()){
										System.out.println("Esse email ja esta cadastrado. Digite outro email: ");
										email = m.nextLine();
									}
								}
							}
							System.out.println("Digite o sexo do solicitante(masculino = M/feminino = F e usar letra maiuscula): ");
							String sexo = m.nextLine();
							t = sexo.matches("[A-Z]{1}");
							if(t == false){
								do{
									System.out.println("Sexo invalido. Digite um sexo valido sexo(M/F): ");
									sexo = m.nextLine();
								}while(sexo.matches("[A-Z]{1}") == false);
							}
							System.out.println("Digite o numero do celular do solicitante: ");
							int numeroCelular = m.nextInt();
							
							Solicitante alterador = new Solicitante(id, cpf, email, senha, nome, sexo, numeroCelular);
							repSolicitante.alterar(alterador);
							DataBase.SalvarEstado(repSolicitante);
							x.close();
							break;
						case 4:
							DataBase.lerBaseSolicitante();
							System.out.println("Digite seu ID para excluir sua conta: ");
							long idRemover = x.nextLong();
							repSolicitante.remover(idRemover);
							DataBase.SalvarEstado(repSolicitante);
							x.close();
							break;
						case 5:
							logout();
							break;
						default:
							System.out.println("Opcao invalida!. Digite uma opcao valida: ");
						}
					}while(opcao == 0 || opcao > 5);
				
				//}
			//}
			//else{
				//System.out.println("Essa conta nao existe!");
			//}
		//}
		x.close();
    }
	public static void sair(){
		System.out.println("Encerrar o programa!");
		System.exit(0);
	}


	//Opcao pedir carona
	public static void pedirCarona(){
		//RepositorioSolicitante repSolicitante = DataBase.lerBaseSolicitante();
		RepositorioViagem repViagem = DataBase.lerBaseViagem();
		Scanner x = new Scanner(System.in);
		System.out.println("Digite os dados pedidos a seguir");
		System.out.println("Identificador do lugar de origem(ex. casa, trabalho, etc..): ");
		String identificadorOrigem = x.nextLine();
		System.out.println("Digite o endereço de origem: ");
		String enderecoOrigem = x.nextLine();
		System.out.println("Digite identificador do destino(ex. casa, trabalho, etc..): ");
		String identificadorDestino = x.nextLine();
		System.out.println("Digite endereco de destino: ");
		String enderecoDestino = x.nextLine();
		System.out.println("Escolha a forma de pagamento(cartao/dinheiro): ");
		String formaDePagamento = x.nextLine();
		Lugar origem = new Lugar(identificadorOrigem, enderecoOrigem);
		Lugar destino = new Lugar(identificadorDestino, enderecoDestino);
		Viagem carona = new Viagem(origem, destino, formaDePagamento);
		repViagem.adicionar(carona);
		x.close();
	}
	
	
	//Lista de viagens
	public static void listaViagens(){
		RepositorioViagem repViagem = DataBase.lerBaseViagem();
		System.out.println(repViagem.buscarTodos());
	}
	
	
	//Opcao alterar dados
	public static void alterarDados() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, SexoNullException,
	CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, 
	CpfInvalidoException, EmailJaExisteException{
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		boolean t;
		Scanner x = new Scanner(System.in);
		System.out.println("Para alterar os dados digite seu ID e depois os novos dados");
		long id = x.nextLong();
		System.out.println("Digite o nome do solicitante(1 letra maiuscula): ");
		String nome = x.nextLine();
		t = nome.matches("[A-Z][a-z]{2,}");
		if(t == false){
			do{
				System.out.println("Nome invalido. Digite outro nome(1 letra maiuscula): ");
				nome = x.nextLine();
			}while(nome.matches("[A-Z][a-z]{2,}") == false);
		}
		System.out.println("Digite o CPF do solicitante: ");
		String cpf = x.nextLine();
		t = cpf.matches("[0-9]{11}");
		if(t == false){
			do{
				System.out.println("CPF invalido. Digite outro CPF: ");
				cpf = x.nextLine();
			}while(cpf.matches("[0-9]{11}") == false);
		}
		System.out.println("Digite a senha do solicitante: ");
		String senha = x.nextLine();
		t = senha.matches("[0-9]{6,}");
		if(t == false){
			do{
				System.out.println("Senha invalida. Digite outra senha(minimo 6 digitos e so numeros): ");
				senha = x.nextLine();
			}while(senha.matches("[0-9]{6,}") == false);
		}
		System.out.println("Digite o email do solicitante: ");
		String email = x.nextLine();
		for(int i = 0; i < 10; i++){
			if(email == repSolicitante.getSolicitantes()[i].getEmail()){
				System.out.println("Esse email ja esta cadastrado. Digite outro email: ");
				email = x.nextLine();
			}
		}
		System.out.println("Digite o sexo do solicitante(Feminino = F/ Masculino = M): ");
		String sexo = x.nextLine();
		t = sexo.matches("[A-Z][1]");
		if(t == false){
			do{
				System.out.println("Sexo invalido. Digite um sexo valido(M/F): ");
				sexo = x.nextLine();
			}while(sexo.matches("[A-Z]{1}"));
		}
		System.out.println("Digite o numero do celular do solicitante: ");
		int numeroCelular = x.nextInt();
		Solicitante alterador = new Solicitante(id, cpf, email, senha, nome, sexo, numeroCelular);
		repSolicitante.alterar(alterador);
		DataBase.SalvarEstado(repSolicitante);
		x.close();
	}
	
	
	//Opcao excluir conta
	public static void excluirConta(){
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		Scanner x = new Scanner(System.in);
		System.out.println("Digite seu ID para excluir sua conta: ");
		long id = x.nextLong();
		repSolicitante.remover(id);
		DataBase.SalvarEstado(repSolicitante);
		x.close();
	}
	
	
	
	//Opcao Logout
	public static void logout() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, SexoNullException, 
	CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, 
	CpfInvalidoException, EmailJaExisteException, IdJaExisteException{
		int opcao;
		Scanner entrada = new Scanner(System.in);
		
		do{
			menu();
			opcao = entrada.nextInt();
			switch(opcao){
			case 1:
				cadastro();
				break;
			case 2:
				login();
				break;
			case 3:
				sair();
				break;
			default:
				System.out.println("Opcao invalida! Digite uma opcao valida: ");
			}
		}while(opcao == 0 || opcao > 3);
		entrada.close();
	}
}

