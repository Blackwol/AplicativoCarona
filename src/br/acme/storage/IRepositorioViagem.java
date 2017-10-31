package br.acme.storage;
import br.acme.location.Viagem;

public interface IRepositorioViagem {
	
	public void adicionar(Viagem adicionarViagem);
	
	public void remover(long id);
	
	public Viagem buscar(long id);
	
	public Viagem[] buscarTodos();
	
	
}
