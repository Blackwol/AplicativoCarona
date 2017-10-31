package br.acme.tests;
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
import br.acme.storage.RepositorioSolicitante;
import br.acme.users.Solicitante;


public class TesteRepositorioSolicitante {
	public static void main(String[] args) throws CpfNullException, NomeNullException, SenhaNullException, 
	EmailNullException, SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, 
	SenhaVaziaException, SexoVazioException, IdInvalidoException, CpfInvalidoException{
		
		   //Criar objetos solicitantes 
		Solicitante s1 = new Solicitante(123, "49284958493", "fdodo", "password", "Pedro", "Masculino", 35565455);
		Solicitante s2 = new Solicitante(456, "12345678905", "svsde", "senha", "Lucia", "Feminino", 11111111);
		Solicitante s3 = new Solicitante(1, "09876543265", "aaaaa", "qwerty", "Joao", "Masculino", 22222222);
		RepositorioSolicitante solicitantes = new RepositorioSolicitante();
		
		
		  //Teste adicionar
		solicitantes.adicionar(s1);
		solicitantes.adicionar(s2);
		solicitantes.adicionar(s3);
		System.out.println(s1.getId());
		System.out.println(s1.getNome());
		System.out.println(s1.getSexo());
		System.out.println(s2.getId());
		System.out.println(s2.getNome());
		System.out.println(s2.getSexo());
		
		   //Teste remover
		solicitantes.remover(456);
		
		
		
		  //Teste alterar
		solicitantes.alterar(s3);
		
		
		
		  //Teste buscar
		solicitantes.buscar(123);
		
		
		  //Teste buscar todos
		solicitantes.buscarTodos();
		
		
	}
}
