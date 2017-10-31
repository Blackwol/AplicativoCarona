package br.acme.storage;
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
import br.acme.users.Motorista;


public class RepositorioMotorista implements IRepositorioMotorista {
	
	public static Object repositorio;
	private Motorista[] motoristas;
	private int contadorAdicionar;
	private int contadorRemover;
	//private long id = 1;
	
	
	public RepositorioMotorista(){
		this.motoristas = new Motorista[10];
		this.contadorAdicionar = 0;
		this.contadorRemover = 0;
	}
	
	   //Método adicionar
	public void adicionar(Motorista adicionarMotorista) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException{
		adicionarMotorista.validar();
		//adicionarMotorista.validarCpf(adicionarMotorista);
		boolean achar = true;
		for(int i = 0; i < 10; i++){
			if(motoristas[i] != null){
				if(adicionarMotorista.getId() == motoristas[i].getId()){
					System.out.println("Ja existe um motorista com esse ID");
					achar = false;
					break;
				
			}
		 }
		}
		if(achar == true){
			motoristas[contadorAdicionar] = adicionarMotorista;
			contadorAdicionar++;
			//motoristas[contadorAdicionar].setId(id);
			//id++;
		}
	}
	
	 //Método remover
		public void remover(long id){
			boolean achar = true;
			for(int i = 0;i < 10; i++){         //Busca um ID igual para remover
				if(motoristas[i] != null){
					if(id == motoristas[i].getId()){        
						motoristas[i] = motoristas[contadorRemover];
						motoristas[contadorRemover] = null;
						System.out.println("Motorista removido");
						achar = false;
						break;
					}
				}
			}
			if(achar){            //Se nao existir ID igual 
				System.out.println("Nao existe nenhum motorista com esse ID.");
			}
		}
	
	  //Método alterar
	public void alterar(Motorista alterador) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException{
		boolean achar = true;
		alterador.validar();
		alterador.validarCpf(alterador);
		for(int i = 0; i< 10; i++){          //Busca um ID igual para alterar
			if(motoristas[i] != null){
				if(alterador.getId() == motoristas[i].getId()){
					motoristas[i] = alterador;
					System.out.println("O solicitante foi alterado.");
					achar = false;
					break;
				}
			}
		}
		if(achar){             //Se nao achar ID igual
			System.out.println("O solicitante nao foi alterado.");
		}
	}
	
	  //Método buscar
	public Motorista buscar(long id){
		Motorista buscador = null;
		for(int j = 0; j< 10; j++){         //Busca o motorista com o mesmo ID
			if(motoristas[j] != null){
				if(id == motoristas[j].getId()){
					buscador = motoristas[j];
					System.out.println(buscador);
					break;
				}
			}
		}
		return buscador;        //Retorna o buscador(motorista)
	}
	
	  //Método buscar todos
	public Motorista[] buscarTodos(){
		Motorista[] buscador = new Motorista[10];  //Iguala todos os motoristas à buscadores
		for(int i = 0; i < 10; i++){
			if(motoristas[i] != null){
				buscador[i] = motoristas[i];
				System.out.println(buscador[i]);
			}
		}
		return buscador;       //retorna os buscadores(motoristas)
	}
	
	//Método toString
	public String toString(){
		String dados = "";
		for(int i = 0; i < 10; i++){
			if(motoristas[i] != null){
				dados = this.motoristas[i].toString();
			}
		}
		return dados;
	}
	
	//Get set
	
	public void setMotoristas(Motorista[] motoristas){
		this.motoristas = motoristas;
	}
	
	public Motorista[] getMotoristas(){
		return motoristas;
	}
	
}