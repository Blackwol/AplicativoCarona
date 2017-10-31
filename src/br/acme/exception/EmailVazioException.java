package br.acme.exception;

@SuppressWarnings("serial")
public class EmailVazioException extends Exception{
	
	public EmailVazioException(String msgErro){
		super(msgErro);
	}
}
