package br.acme.exception;

@SuppressWarnings("serial")
public class EmailJaExisteException extends Exception {
	public EmailJaExisteException(String msgErro){
		super(msgErro);
	}
}
