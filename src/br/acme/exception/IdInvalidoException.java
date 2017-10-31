package br.acme.exception;

@SuppressWarnings("serial")
public class IdInvalidoException extends Exception{

	public IdInvalidoException(String msgErro){
		super(msgErro);
	}
}
