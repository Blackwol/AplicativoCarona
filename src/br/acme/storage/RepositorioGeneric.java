package br.acme.storage;
import java.util.ArrayList;
import br.acme.users.*;

import br.acme.exception.CpfInvalidoException;
import br.acme.exception.CpfNullException;
import br.acme.exception.CpfVazioException;
import br.acme.exception.EmailNullException;
import br.acme.exception.EmailVazioException;
import br.acme.exception.IdInvalidoException;
import br.acme.exception.NomeNullException;
import br.acme.exception.NomeVazioException;
import br.acme.exception.RepositorioCheioException;
import br.acme.exception.SenhaNullException;
import br.acme.exception.SenhaVaziaException;
import br.acme.exception.SexoNullException;
import br.acme.exception.SexoVazioException;

public class RepositorioGeneric<T> implements IRepositorio<T> {

	//Atributos
	ArrayList<T> genericos = new ArrayList<T>();
	private long proximoId;
	private int contador;
	
	
	//Construtor
	public RepositorioGeneric(){
		this.proximoId = 1;
	}
	
	//Gets e sets
	
	public void setProximoId(long proximoId){
		this.proximoId = proximoId;
	}
	
	public long getProximoId(){
		return proximoId;
	}
	
	public int getContador(){
		return contador;
	}

	
	@Override
	public void adicionarFixoId(T objeto) throws RepositorioCheioException {
		if (this.genericos.size() < 10) {
			genericos.add(objeto);
			this.contador++;
		} else {
			throw new RepositorioCheioException("Repositorio cheio!");
		}
	}
	

	@Override
	public void adicionar(T objeto) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException,
			SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException,
			SexoVazioException, IdInvalidoException, CpfInvalidoException, RepositorioCheioException {
		
		((Usuario) objeto).validar();
		
		if(this.genericos.size() < 10){
			genericos.add(objeto);
			this.proximoId++;
			this.contador++;
		}
		else{
			throw new RepositorioCheioException("Repositorio cheio!!");
		}
	}


	@Override
	public void remover(long id) {
		
		if(this.genericos == null){
			System.out.println("Repositorio vazio!");
		}
		else{
			genericos.remove(genericos.indexOf(this.buscar(id)));
		}
	}


	@Override
	public void alterar(T usuario) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException,
			SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException,
			SexoVazioException, IdInvalidoException, CpfInvalidoException {
		
		
	}


	@Override
	public T buscar(long id) {
		Solicitante s;
		Motorista m;
		for(T e : genericos){
			if(e.getClass() == Solicitante.class){
				s = (Solicitante) e;
				if(s.getId() == id){
					return e;
				}
			}
			else if(e.getClass() == Motorista.class){
				m = (Motorista) e;
				if(m.getId() == id){
					return e;
				}
			}
		}
		return null;
	}


	@Override
	public ArrayList<T> buscarTodos() {
		return genericos;
	}
	
	
	
}
