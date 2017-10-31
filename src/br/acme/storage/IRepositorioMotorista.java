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

public interface IRepositorioMotorista {
	
	public void adicionar(Motorista motorista) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException;
	
	public void remover(long id);
	
	public void alterar(Motorista alterador) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException;
	
	public Motorista buscar(long id);
	
	public Motorista[] buscarTodos();
}
