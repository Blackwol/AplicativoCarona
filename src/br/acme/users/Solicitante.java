package br.acme.users;
import java.util.Date;

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
import br.acme.location.Lugar;
import br.acme.storage.RepositorioMotorista;
import br.acme.storage.*;
import br.acme.location.Viagem;

public class Solicitante extends Usuario {
	private Date dataNascimento;
	private int numeroCelular;
	private Lugar[] lugares;
	private Viagem[] viagens;
	private RepositorioViagem repViagem = new RepositorioViagem();
	private RepositorioMotorista repMotorista = new RepositorioMotorista();
	private RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
	int contadorViagem = 0;
	
	                //Construtor
	
	public Solicitante(){
		
	}
	
	//Construtor para DataBase
	public Solicitante(long id, String email, String senha, String nome){
		
	}
	
	//Construtor menu
	public Solicitante(String cpf, String email, String senha, String nome,
			String sexo, int numeroCelular){
		
	}
	
	public Solicitante(long id, String cpf, String email, String senha, String nome,
			String sexo, int numeroCelular){
		super(id, cpf, nome, email, senha, sexo);
		setNumeroCelular(numeroCelular);
		lugares = new Lugar[10];
		viagens = new Viagem[10];
				
	}
	
	        //Gets e sets

	
	public void setRepViagem(RepositorioViagem repViagem){
		this.repViagem = repViagem;
	}
	
	public RepositorioViagem getRepViagem(){
		return repViagem;
	}
	
	public void setRepMotoristas(RepositorioMotorista repMotorista){
		this.repMotorista = repMotorista;
	}
	
	public RepositorioMotorista getRepMotorista(){
		return repMotorista;
	}
	
	public void setViagens(Viagem[] viagens){
		this.viagens = viagens;
	}
	
	public void setNumeroCelular(int numeroCelular){
		this.numeroCelular = numeroCelular;
	}

	public int getNumeroCelular(){
		return numeroCelular;
	}
	
	public void setLugares(Lugar[] lugares){
		this.lugares = lugares;
	}
	
	public Viagem[] getViagens(){
		return viagens;
	}
	
	public Lugar[] getLugares(){
		return lugares;
	}
	
	public void setDataNascimento(Date dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataNascimento(){
		return dataNascimento;
	}
	
	public RepositorioViagem getRepViagens(){
		return repViagem;
	}
	
	        //Métodos
	
	//Método solicitar carona
	public void solicitarCarona(Viagem carona){
		boolean achar = true;
		for(int i = 0; i < 10; i++){      //Procura o proximo motorista disponivel
			if(repMotorista.getMotoristas()[i].getDisponivel()){
				repMotorista.getMotoristas()[i].getViagens()[contadorViagem] = carona;   //Adicionar a viagem no motorista disponivel 
				System.out.println("Motorista a caminho!");   //Ajuda a ver se o método funciona
				contadorViagem++;
				achar = false;
				break;
			}
		}
		if(achar){
			System.out.println("Nenhum motorista disponivel!");
		}
	}     
	
	//Método cancelar carona
	public void cancelarCarona(long idViagem){
		boolean achar = true;
		for(int i = 0; i < 10; i++){
			if(idViagem == repViagem.getViagens()[i].getIdViagem()){
				repViagem.remover(idViagem);
				achar = false;
				break;
			}
		}
		if(achar == true){
			System.out.println("Nao existe viagem com esse ID");
		}
	}      
	
	//Método histórico
	public void historico(){
			System.out.println(repSolicitante.buscarTodos());
		
	}
	
	//toString com os dados que faltam no usuario
	public String toString(){
		return (super.toString() + "; Numero celular: " + numeroCelular);
	}
	
	//Método validar
		public void validar() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
		SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
		IdInvalidoException{
			if(this.getId() < 0){
				throw new IdInvalidoException("Id Invalido, digite um id maior do que zero");
			}
			
			else if(this.getNome() == ""){
				throw new NomeVazioException("Nome vazio, digite um nome valido");
			}
			
			else if(this.getNome() == null){
				throw new NomeNullException("Digite um nome valido");
			}
			
			else if(this.getEmail() == null){
				throw new EmailNullException("Digite um email valido");
			}
			
			else if(this.getEmail() == ""){
				throw new EmailVazioException("Email vazio, digite um email valido");
			}
			
			else if(this.getSenha() == ""){
				throw new SenhaVaziaException("Senha vazia, digite uma senha valida");
			}
			
			else if(this.getSenha() == null){
				throw new SenhaNullException("Digite uma senha valida");
			}
			
			else if(this.getSexo() == ""){
				throw new SexoVazioException("Sexo vazio, digite um sexo valido");
			}
			
			else if(this.getSexo() == null){
				throw new SexoNullException("Digite um sexo valido");
			}
			
			else if(this.getCpf() == ""){
				throw new CpfVazioException("CPF vazio, digite um CPF valido");
			}
			
			else if(this.getCpf() == null){
				throw new CpfNullException("Digite um CPF valido");
			}
			
			else if(this.getId() < 0){
				throw new IdInvalidoException("Digite um ID valido(maior do que zero)");
			}
		}
		
		public boolean validarCpf(Solicitante solicitante) throws CpfInvalidoException{
			String cpf = solicitante.getCpf();
			if(cpf.matches("[a-z]") == true){
				throw new CpfInvalidoException("Digite um CPF valido: ");
			}
			return cpf.matches("[a-z]");
		}
		
	
}
