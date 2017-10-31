package br.acme.exception;

@SuppressWarnings("serial")
public class SexoNullException extends Exception{

	public SexoNullException(String msgErro){
		super(msgErro);
	}
}
