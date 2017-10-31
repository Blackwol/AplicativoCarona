package br.acme.exception;

@SuppressWarnings("serial")
public class NomeNullException extends Exception{
	
	public NomeNullException(String msgErro){
		super(msgErro);
	}
}
