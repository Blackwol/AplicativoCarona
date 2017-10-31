package br.acme.exception;

@SuppressWarnings("serial")
public class SenhaVaziaException extends Exception{
	public SenhaVaziaException(String msgErro){
		super(msgErro);
	}
}
