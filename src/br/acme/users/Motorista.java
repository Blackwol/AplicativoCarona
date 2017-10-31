package br.acme.users;
import br.acme.storage.RepositorioViagem;
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
import br.acme.location.Viagem;
import br.acme.storage.RepositorioMotorista;

public class Motorista extends Usuario {
	private boolean disponivel;
	private Viagem[] viagens = new Viagem[10];
	private RepositorioViagem repViagem = new RepositorioViagem();
	private RepositorioMotorista repMotorista = new RepositorioMotorista();
	int contadorViagem = 0;


	//Construtor
	
	public Motorista(){
		
	}
	
	//Construtor para DataBase
    public Motorista(long id, String email, String senha, String nome){
		
	}
    
    //Construtor para Menu
    public Motorista(String cpf, String nome, String senha, String email, 
			String sexo, boolean disponivel){
    	
    }
	
	public Motorista(long id, String cpf, String nome, String senha, String email, 
			String sexo, boolean disponivel){
		super(id, cpf, nome, senha, email, sexo);
		setDisponivel(disponivel);
	}
	
	//Gets e sets
	
	public void setViagens(Viagem[] viagens){
		this.viagens = viagens;
	}
	
	public void setRepViagens(RepositorioViagem viagens){
		this.repViagem = viagens;
	}
	
	public void setDisponivel(boolean disponivel){
		this.disponivel = disponivel;
	}
	
	public Viagem[] getViagens(){
		return viagens;
	}
	
	public boolean getDisponivel(){
		return disponivel;
	}
	
	public RepositorioViagem getRepViagens(){
		return repViagem;
	}
	
	//Métodos
	
	//Método responder pedido
	public void responderPedido(Motorista motorista ,Viagem viagem){
		if(disponivel){
			motorista.getViagens()[contadorViagem] = viagem;     //Adiciona o objeto viagem ao motorista
			System.out.println("Motorista a caminho!");        //Ajuda a identificar se o metodo esta funcionando
			contadorViagem++;
		}
		else{
			System.out.println("Motorista nao esta disponivel");
		}
	}
		
	
	//Método historico
	public void historico(){
		for(int i = 0; i < 10; i++){     //Passa por todas as viagens e as imprime
			System.out.println(repMotorista.buscarTodos()[i]);
		}
	}
	
	//toString com os dados que faltam no usuario
	public String toString(){
		return (super.toString() + "; Disponivel: " + disponivel);
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
		
		public void validarCpf(Motorista motorista) throws CpfInvalidoException{
			String cpf = motorista.getCpf();
			if(cpf.matches("[0-9]") == true){
				throw new CpfInvalidoException("Digite um CPF valido");
			}
		}

	

}




