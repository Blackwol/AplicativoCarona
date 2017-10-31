package br.acme.exception;

@SuppressWarnings("serial")
public class NomeVazioException extends Exception {
	
	public NomeVazioException(String msgErro){
		super(msgErro);
	}
}
