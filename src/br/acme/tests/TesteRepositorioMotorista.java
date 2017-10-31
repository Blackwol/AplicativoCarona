package br.acme.tests;
import br.acme.users.Motorista;
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
import br.acme.storage.RepositorioMotorista;

public class TesteRepositorioMotorista {
	public static void main(String[] args) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, 
	SexoVazioException, IdInvalidoException, CpfInvalidoException{
		
		    //Criar objetos tipo Motorista
		Motorista m2 = new Motorista(123, "09876567876", "Marcos", "pass", "zxcvb", "Masculino", true);
		Motorista m1 = new Motorista(987, "12340987654", "Julia", "word", "bvxz", "Feminino", false);
		Motorista m3 = new Motorista(121, "45678909876", "Julio", "dkwow", "ffpp", "Masculino", true);
		Motorista m4 = new Motorista(1, "4567845876", "Bruno", "dkwow", "ffpp", "Masculino", false);
		RepositorioMotorista motoristas = new RepositorioMotorista();
		
		
		
		   //Teste adicionar
		motoristas.adicionar(m1);
		motoristas.adicionar(m2);
		motoristas.adicionar(m3);
		motoristas.adicionar(m4);
		System.out.println(m1.getId());
		System.out.println(m1.getNome());
		System.out.println(m1.getSexo());
		System.out.println(m2.getId());
		System.out.println(m2.getNome());
		System.out.println(m2.getSexo());
		
		
		  //Teste remover
		motoristas.remover(987);
		
		
		  //Teste alterar
		motoristas.alterar(m3);
		
		
		
		  //Teste buscar
		motoristas.buscar(123);
		
		
		  //Teste buscar todos
		motoristas.buscarTodos();
		
	}
}
