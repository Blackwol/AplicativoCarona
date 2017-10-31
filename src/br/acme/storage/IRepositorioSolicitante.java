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

public interface IRepositorioSolicitante {
	
	public void adicionar(Solicitante adicionarSolicitante) throws CpfNullException, NomeNullException, 
	SenhaNullException, EmailNullException, SexoNullException, CpfVazioException, NomeVazioException, 
	EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, CpfInvalidoException;
	
	public void remover(long id);
	
	public void alterar(Solicitante alterador) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException;
	
	public Solicitante buscar(long id);
	
	public Solicitante[] buscarTodos();
}
