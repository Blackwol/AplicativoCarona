package br.acme.main;
import java.util.Scanner;

import br.acme.exception.CpfInvalidoException;
import br.acme.exception.CpfNullException;
import br.acme.exception.CpfVazioException;
import br.acme.exception.EmailNullException;
import br.acme.exception.EmailVazioException;
import br.acme.exception.IdInvalidoException;
import br.acme.exception.NomeNullException;
import br.acme.exception.NomeVazioException;
import br.acme.exception.SenhaNullException;
import br.acme.exception.SenhaVaziaException;
import br.acme.exception.SexoNullException;
import br.acme.exception.SexoVazioException;
import br.acme.storage.*;

import br.acme.storage.DataBase;
import br.acme.users.Motorista;

public class MenuMotorista {

	public static void main(String[] args) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException{
		int opcao;
		Scanner entrada = new Scanner(System.in);
		
		do{
			menu();
			opcao = entrada.nextInt();
			switch(opcao){
			case 1:
				login();
				break;
			case 2:
				sair();
				break;
			default:
				System.out.println("Voce digitou uma opcao invalida! Digite uma opcao valida: ");
			}
		}while(opcao <= 0 || opcao > 2);
		entrada.close();
	}
	
	
	public static void menu(){
		System.out.println("Menu motorista");
		System.out.println("1. Login");
		System.out.println("2. Sair");
		System.out.println("Digite sua opcao: ");
	}
	
	
	public static void sair(){
		System.out.println("Encerrando o programa!");
		System.exit(0);
	}
	
	
	
	public static void login() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, SexoNullException, 
	CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, 
	CpfInvalidoException{
		
		Scanner x = new Scanner(System.in);
		int opcao;
		System.out.println("Digite seu email: ");
		String emailLogin = x.nextLine();
		System.out.println("Digite sua senha: ");
		String senhaLogin = x.nextLine();
		//for(int i = 0; i < 10; i++){
			//if(repMotorista.buscar(i) != null){
				//if(repMotorista.buscar(i).getEmail().equals(emailLogin) && repMotorista.buscar(i).getSenha().equals(senhaLogin)){
					do{
						boolean t;
						RepositorioMotorista repMotorista = DataBase.lerBaseMotoristas();
						System.out.println("Bem Vindo!!");
						//System.out.println("Seu ID é: " + repMotorista.buscar(i).getId());
						System.out.println("1. Alterar disponibilidade");
						System.out.println("2. Alterar dados");
						System.out.println("3. Excluir conta");
						System.out.println("4. Logout");
						System.out.println("Digite a sua opcao: ");
						opcao = x.nextInt();
						switch(opcao){
						case 1:
							System.out.println("Confirme seus dados e mude sua disponibilidade");
							System.out.println("Digite seu Id: ");
							long id = x.nextLong();
							System.out.println("Digite o nome: ");
							String nome = x.nextLine();
							System.out.println("Digite o CPF: ");
							String cpf = x.nextLine();
							System.out.println("Digite a senha: ");
							String senha = x.nextLine();
							System.out.println("Digite o email: ");
							String email = x.nextLine();
							System.out.println("Digite o sexo: ");
							String sexo = x.nextLine();
							System.out.println("Digite sua disponibilidade: ");
							boolean disponivel = x.hasNext();
							Motorista alterador = new Motorista(id, nome, senha, cpf, email, sexo, disponivel);
							repMotorista.alterar(alterador);
							DataBase.SalvarEstado(repMotorista);
							x.close();
							break;
						case 2:
							System.out.println("Digite seu ID e seus dados novos.");
							DataBase.lerBaseMotoristas();
							System.out.println("Digite seu Id: ");
							long id2 = x.nextLong();
							for(int i = 0; i < 10; i++){
								if(repMotorista.getMotoristas()[i] != null){
									if(id2 == repMotorista.getMotoristas()[i].getId()){
										System.out.println("ID ja cadastrado. Digite outro ID que nao esteja cadastrado: ");
										id2 = x.nextLong();
									}
								}
							}
							System.out.println("Digite o nome(começar com letra maiuscula): ");
							String nome2 = x.nextLine();
							t = nome2.matches("[A-Z][a-z]{2,}");
							if(t == false){
								do{
									System.out.println("Nome invalido. Digite um nome valido(Começar com letra maiuscula): ");
									nome2 = x.nextLine();
								}while(nome2.matches("[A-Z][a-z]{2,}") == false);
							}
							System.out.println("Digite o CPF: ");
							String cpf2 = x.nextLine();
							t = cpf2.matches("[0-9]{11}");
							if(t == false){
								do{
									System.out.println("CPF invalido. Digite outro CPF: ");
									cpf2 = x.nextLine();
								}while(cpf2.matches("[0-9]{11}") == false);
							}
							System.out.println("Digite a senha(minimo 6 digitos e numerica): ");
							String senha2 = x.nextLine();
							t = senha2.matches("[0-9]{6,}");
							if(t == false){
								do{
									System.out.println("Senha invalida. Digite outra senha(numerica): ");
									senha2 = x.nextLine();
								}while(senha2.matches("[0-9]{6,}") == false);
							}
							System.out.println("Digite o email: ");
							String email2 = x.nextLine();
							for(int i = 0; i < 10; i++){
								if(repMotorista.getMotoristas()[i] != null){
									if(email2 == repMotorista.getMotoristas()[i].getEmail()){
										System.out.println("Email ja cadastrado. Digite um email que nao esteja cadastrado: ");
										email2 = x.nextLine();
									}
								}
							}
							System.out.println("Digite o sexo(M = masculino/F = feminino usar letra maiuscula): ");
							String sexo2 = x.nextLine();
							t = sexo2.matches("[A-Z]{1}");
							if(t == false){
								do{
									System.out.println("Sexo invalido. Digite outro sexo(masculino = M/feminino = F usar letra maiuscula): ");
									sexo2 = x.nextLine();
								}while(sexo2.matches("[A-Z]{1}") == false);
							}
							System.out.println("Digite a disponibilidade do motorista(true = disponivel/ false = indisponivel): ");
							boolean disponivel2 = x.hasNext();
						Motorista alterador2 = new Motorista(id2, cpf2, nome2, senha2, email2, sexo2, disponivel2);
							repMotorista.alterar(alterador2);
							DataBase.SalvarEstado(repMotorista);
							break;
						case 3:
							DataBase.lerBaseMotoristas();
							System.out.println("Digite seu ID pra excluir sua conta: ");
							long idRemover = x.nextLong();
							repMotorista.remover(idRemover);
							DataBase.SalvarEstado(repMotorista);
							break;
						case 4:
							logout();
							break;
						default:
							System.out.println("Digite um numero valido: ");
						}
					}while(opcao < 0 || opcao > 4);
				//}
			//}
			//else{
				//System.out.println("Essa conta nao existe!");
			//}
			x.close();
		//}
	}
			
		
	
	
	public static void logout() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, SexoNullException, 
	CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, 
	CpfInvalidoException{
		int opcao;
		Scanner entrada = new Scanner(System.in);
		
		do{
			menu();
			opcao = entrada.nextInt();
			switch(opcao){
			case 1:
				login();
				break;
			case 2:
				sair();
				break;
			default:
				System.out.println("Voce digitou uma opcao invalida! Digite uma opcao valida: ");
			}
		}while(opcao < 0 || opcao > 2);
		entrada.close();
	}	
}

