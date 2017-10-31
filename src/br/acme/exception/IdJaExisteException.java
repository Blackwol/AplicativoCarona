package br.acme.exception;

@SuppressWarnings("serial")
public class IdJaExisteException extends Exception {

	public IdJaExisteException(String msgErro){
		super(msgErro);
	}
}

