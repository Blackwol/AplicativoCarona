package br.acme.exception;

@SuppressWarnings("serial")
public class EmailNullException extends Exception{

	public EmailNullException(String msgErro){
		super(msgErro);
	}
}
