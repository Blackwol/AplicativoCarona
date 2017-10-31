package br.acme.exception;

@SuppressWarnings("serial")
public class SenhaNullException extends Exception{
	
	public SenhaNullException(String msgErro){
		super(msgErro);
	}
}
