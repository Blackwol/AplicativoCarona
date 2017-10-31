package br.acme.users;
import br.acme.exception.*;
import br.acme.storage.*;

public class Gerente extends Usuario {
	public static Object gerente;
	private Solicitante[] solicitantes = new Solicitante[10];
	private RepositorioMotorista repMotorista = new RepositorioMotorista();
	private RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
	
	//Construtor
	
	public Gerente(){
		
	}
	
	public Gerente(long id, String cpf, String nome, String senha, String email, String sexo){
		super(id, cpf, nome, senha, email, sexo);
	}
	
	      //Get set
	public void setSolicitantes(Solicitante[] solicitantes){
		this.solicitantes = solicitantes;
	}
	
	public void setRepMotorista(RepositorioMotorista repMotorista){
		this.repMotorista = repMotorista;
	}
	
	public void setRepSolicitante(RepositorioSolicitante repSolicitante){
		this.repSolicitante = repSolicitante;
	}
	
	public Solicitante[] getSolicitantes(){
		return solicitantes;
	}
	
	public RepositorioMotorista getRepMotorista(){
		return repMotorista;
	}
	
	public RepositorioSolicitante getRepSolicitante(){
		return repSolicitante;
	}
	         
	
	
	      //Métodos
	
	//Método cadastrar motorista
	public void cadastrarMotorista(Motorista motorista) throws CpfNullException, NomeNullException, SenhaNullException, 
	EmailNullException, SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, 
	SexoVazioException, IdInvalidoException, CpfInvalidoException {
		repMotorista.adicionar(motorista);
		System.out.println("Motorista adicionado!");
	} 
	
	//Método cadastrar solicitante
	public void cadastrarSolicitante(Solicitante solicitante) throws CpfNullException, NomeNullException, SenhaNullException, 
	EmailNullException, SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, 
	SexoVazioException, IdInvalidoException, CpfInvalidoException {
		repSolicitante.adicionar(solicitante);
		System.out.println("Solicitante adicionado!");
	} 
	 
	        //Método remover motorista
	public void removerMotorista(long id){
		repMotorista.remover(id);
	}       
	
	//Método listar motoristas
	public void listarMotoristas(){
		   	//Procura em todos os arrays e imprime
		System.out.println(repMotorista.buscarTodos());
	}                          
	
	
	//Método listar solicitantes
	public void listarSolicitantes(){
		       //Procura em todos os arrays e imprime
		System.out.println(repSolicitante.buscarTodos());
	}
	
	//Método toString
	public String toString(){
		return(super.toString());
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
		
		else if(this.getCpf().matches("[a-z]")){
			
		}
	}
	
	public boolean validarCpf(Gerente gerente) throws CpfInvalidoException{
		String cpf = gerente.getCpf();
		if(cpf.matches("[a-z]") == false){
			throw new CpfInvalidoException("Digite um CPF valido: ");
		}
		return cpf.matches("[a-z]");
	}
	
	
}
