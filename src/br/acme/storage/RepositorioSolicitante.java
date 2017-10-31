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
import br.acme.users.Solicitante;

public class RepositorioSolicitante implements IRepositorioSolicitante {
	
	public static Object repositorio;
	private Solicitante[] solicitantes;
	private int contadorAdicionar;
	//private long id = 1;
	
	   //Construtor
	public RepositorioSolicitante(){
		this.solicitantes = new Solicitante[10];
		this.contadorAdicionar = 0;
	}
	
	   //Método adicionar
	public void adicionar(Solicitante adicionarSolicitante) throws CpfNullException, NomeNullException, 
	SenhaNullException, EmailNullException, SexoNullException, CpfVazioException, NomeVazioException, 
	EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, CpfInvalidoException{
		adicionarSolicitante.validar();
		//adicionarSolicitante.validarCpf(adicionarSolicitante);
		boolean achar = true;
		for(int i = 0; i < 10; i++){    //Busca se ja existe um id igual
			if(solicitantes[i] != null){
				if(adicionarSolicitante.getId() == solicitantes[i].getId()){
					System.out.println("Ja existe um motorista com esse ID");
					achar = false;
					break;
				}

			}		
		}
		if(achar == true){        //Se n existir um ID igual entra aq e adiciona
			solicitantes[contadorAdicionar] = adicionarSolicitante;
			contadorAdicionar++;
			//solicitantes[contadorAdicionar].setId(id);
			//id++;
		}
	}
	
	  //Método remover
	public void remover(long id){
		boolean achar = true;
		for(int i = 0;i < 10; i++){         //Busca um ID igual para remover
			if(solicitantes[i] != null){
				if(id == solicitantes[i].getId()){        
					solicitantes[i] = null;
					System.out.println("Solicitante removido.");
					achar = false;
					break;
				}
			}
		}
		if(achar){            //Se nao existir ID igual 
			System.out.println("Nao existe nenhum solicitante com esse ID.");
		}
	}
	
	
	  //Método alterar
	public void alterar(Solicitante alterador) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException{
		boolean achar = true;
		for(int i = 0; i< 10; i++){          //Busca um ID igual para alterar
			if(solicitantes[i] != null){
				if(alterador.getId() == solicitantes[i].getId()){
					alterador.validar();
					alterador.validarCpf(alterador);
					solicitantes[i] = alterador;
					System.out.println("O solicitante foi alterado.");
					achar = false;
					break;
				}
			}
		}
		if(achar){             //Se nao achar ID igual
			System.out.println("O solicitante nao foi alterado. Nao existe solicitante com esse ID.");
		}
	}
	
	  //Método buscar
	public Solicitante buscar(long id){
		Solicitante buscador = null;
		for(int i = 0; i< 10; i++){          //Busca um solicitante com mesmo ID
			if(solicitantes[i] != null){
				if(id == solicitantes[i].getId()){
					buscador = solicitantes[i];
					System.out.println(buscador);
					break;
				}
			}
		}
		return buscador;       //retorna buscador(solicitante)
	}
	
	   //Método buscar todos
	public Solicitante[] buscarTodos(){
		Solicitante[] buscador = new Solicitante[10];
		for(int i = 0; i < 10; i++){        //Busca e iguala os buscadores aos solicitantes
			if(solicitantes[i] != null){
				buscador[i] = solicitantes[i];
				System.out.println(buscador[i].toString());
			}
		}
		return buscador;         
	}
	
	//Método toString
	public String toString(){
		String dados = "";
		for(int i = 0; i < 10; i++){
			if(solicitantes[i] != null){
				dados = this.solicitantes[i].toString();
			}
		}
		return dados;
	}
	
	//Set get
	
	public void setSolicitantes(Solicitante[] solicitantes){
		this.solicitantes = solicitantes;
	}
	
	public Solicitante[] getSolicitantes(){
		return solicitantes;
	}
	
	
}