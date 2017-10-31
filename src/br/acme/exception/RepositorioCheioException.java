package br.acme.exception;

@SuppressWarnings("serial")
public class RepositorioCheioException extends Exception {

	public RepositorioCheioException(String msgErro){
		super(msgErro);
	}
}
