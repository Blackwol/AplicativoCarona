package br.acme.main;
import java.util.Scanner;

import br.acme.exception.*;
import br.acme.users.*;
import br.acme.storage.*;

public class MenuGerente {

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
				cadastrarSolicitante();				
				break;
			case 2:
				removerSolicitante();				
				break;
			case 3:
				adicionarMotorista();				
				break;
			case 4:
				removerMotorista();				
				break;
			case 5:
				listarSolicitantes();
				break;
			case 6:
				listarMotoristas();				
				break;
			case 7:
				listarViagens();				
				break;
			case 8:
				sair();
				break;
			default:
				System.out.println("Opcao invalida!! Digite uma opcao valida: ");
			}
		}while(opcao < 0 || opcao > 8);
		entrada.close();
	}
	
	public static void menu(){
		System.out.println("MENU GERENTE");
		System.out.println("1. Cadastrar solicitante");
		System.out.println("2. Remover solicitante");
		System.out.println("3. Adicionar motorista");
		System.out.println("4. Remover motorista");
		System.out.println("5. Listar solicitantes");
		System.out.println("6. Listar motoristas");
		System.out.println("7. Lista de todas as viagens");
		System.out.println("8. Sair");
		System.out.println("Digite sua opcao: ");
	}
	
	public static void cadastrarSolicitante() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException, EmailJaExisteException, IdJaExisteException{
		Gerente gerente = DataBase.lerBaseGerente();
		boolean t;
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		//@SuppressWarnings("resource")
		Scanner x = new Scanner(System.in);
		System.out.println("Cadastrar um solicitante");
		System.out.println("Digite um ID: ");
		long id = x.nextLong();
		for(int i = 0; i < 10; i++){
			if(repSolicitante.getSolicitantes()[i] != null){
				if(id == repSolicitante.getSolicitantes()[i].getId()){
					System.out.println("ID ja cadastrado. Digite outro ID");
					id = x.nextLong();
				}
			}
		}
		System.out.println("Digite o nome do solicitante(começar com letra maiuscula): ");
		String nome = x.nextLine();
		t = nome.matches("[A-Z][a-z]{2,}");
		if(t == false){
			do{
				System.out.println("Nome invalido. Digite outro nome(letra maiuscula): ");
				nome = x.nextLine();
			}while(nome.matches("[A-Z][a-z]{2,}") == false);
		}
		System.out.println("Digite o CPF do solicitante(11 digitos): ");
		String cpf = x.nextLine();
		t = cpf.matches("[0-9]{11}");
		if(t == false){
			do{
				System.out.println("CPF invalido. Digite outro CPF(11 digitos): ");
				cpf = x.nextLine();
			}while(cpf.matches("[0-9]{11}") == false);
		}
		System.out.println("Digite a senha do solicitante(minimo 6 digitos e so numeros): ");
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
					System.out.println("Esse email ja esta cadastrado. Digite outro email: ");
					email = x.nextLine();
				}
			}
		}
		System.out.println("Digite o sexo do solicitante(masculino = M/feminino = F e usar letra maiuscula): ");
		String sexo = x.nextLine();
		t = sexo.matches("[A-Z]{1}");
		if(t == false){
			do{
				System.out.println("Sexo invalido. Digite um sexo valido sexo(M/F): ");
				sexo = x.nextLine();
			}while(sexo.matches("[A-Z]{1}") == false);
		}
		System.out.println("Digite o numero do celular do solicitante: ");
		int numeroCelular = x.nextInt();
		Solicitante solicitante = new Solicitante(id, cpf, email, senha, nome, sexo, numeroCelular);
		gerente.cadastrarSolicitante(solicitante);
		DataBase.SalvarEstado(repSolicitante);
		DataBase.SalvarEstado(gerente);
		x.close();
	}	
	
	
	public static void removerSolicitante(){
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		Scanner x = new Scanner(System.in);
		System.out.println("Remover solicitante");
		System.out.println(repSolicitante.buscarTodos());
		System.out.println("Digite o ID do solicitante que deseja remover: ");
		long id = x.nextLong();
		repSolicitante.remover(id);
		DataBase.SalvarEstado(repSolicitante);
		x.close();
	}
	
	public static void adicionarMotorista() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, 
	SexoVazioException, IdInvalidoException, 
	CpfInvalidoException, EmailJaExisteException, IdJaExisteException{
		RepositorioMotorista repMotorista = DataBase.lerBaseMotoristas();
		//@SuppressWarnings("resource")
		Scanner x = new Scanner(System.in);
		boolean t;
		System.out.println("Adicionar motorista");
		System.out.println("Digite um ID: ");
		long id = x.nextLong();
		for(int i = 0; i < 10; i++){
			if(repMotorista.getMotoristas()[i] != null){
				if(id == repMotorista.getMotoristas()[i].getId()){
					System.out.println("ID ja cadastrado. Digite outro ID que nao esteja cadastrado: ");
					id = x.nextLong();
				}
			}
		}
		System.out.println("Digite o nome(começar com letra maiuscula): ");
		String nome = x.nextLine();
		t = nome.matches("[A-Z][a-z]{2,}");
		if(t == false){
			do{
				System.out.println("Nome invalido. Digite um nome valido(Começar com letra maiuscula): ");
				nome = x.nextLine();
			}while(nome.matches("[A-Z][a-z]{2,}") == false);
		}
		System.out.println("Digite o CPF: ");
		String cpf = x.nextLine();
		t = cpf.matches("[0-9]{11}");
		if(t == false){
			do{
				System.out.println("CPF invalido. Digite outro CPF: ");
				cpf = x.nextLine();
			}while(cpf.matches("[0-9]{11}") == false);
		}
		System.out.println("Digite a senha(minimo 6 digitos e numerica): ");
		String senha = x.nextLine();
		t = senha.matches("[0-9]{6,}");
		if(t == false){
			do{
				System.out.println("Senha invalida. Digite outra senha(numerica): ");
				nome = x.nextLine();
			}while(senha.matches("[0-9]{6,}") == false);
		}
		System.out.println("Digite o email: ");
		String email = x.nextLine();
		for(int i = 0; i < 10; i++){
			if(repMotorista.getMotoristas()[i] != null){
				if(email == repMotorista.getMotoristas()[i].getEmail()){
					System.out.println("Email ja cadastrado. Digite um email que nao esteja cadastrado: ");
					email = x.nextLine();
				}
			}
		}
		System.out.println("Digite o sexo(M = masculino/F = feminino usar letra maiuscula): ");
		String sexo = x.nextLine();
		t = sexo.matches("[A-Z]{1}");
		if(t == false){
			do{
				System.out.println("Sexo invalido. Digite outro sexo(masculino = M/feminino = F usar letra maiuscula): ");
				sexo = x.nextLine();
			}while(sexo.matches("[A-Z]{1}") == false);
		}
		System.out.println("Digite a disponibilidade do motorista(true = disponivel/ false = indisponivel): ");
		boolean disponivel = x.hasNext();
		Motorista motorista = new Motorista(id, cpf, nome, senha, email, sexo, disponivel);
		repMotorista.adicionar(motorista);
		//DataBase.SalvarEstado(gerente);
		DataBase.SalvarEstado(repMotorista);
		x.close();
	}
	
	public static void removerMotorista(){
		Gerente gerente = DataBase.lerBaseGerente();
		RepositorioMotorista repMotorista = DataBase.lerBaseMotoristas();
		Scanner x = new Scanner(System.in);
		System.out.println("Remover motorista");
		System.out.println(repMotorista.buscarTodos());
		System.out.println("Digite o ID do motorista que deseja remover: ");
		long id  = x.nextLong();
		gerente.removerMotorista(id);
		DataBase.SalvarEstado(gerente);
		DataBase.SalvarEstado(repMotorista);
		x.close();
	}
	
	public static void listarSolicitantes(){
		System.out.println("Listar solicitantes");
		DataBase.lerBaseSolicitante();
	}
	
	
	public static void listarMotoristas(){
		System.out.println("Listar motoristas");
		DataBase.lerBaseMotoristas();
	}
	
	
	
	public static void listarViagens(){
		RepositorioViagem repViagem = new RepositorioViagem();
		System.out.println("Lista viagens");
		System.out.println(repViagem.buscarTodos());
	}
	
	
	
	public static void sair(){
		System.out.println("Encerrar programa");
		System.exit(0);
	}
		
}
