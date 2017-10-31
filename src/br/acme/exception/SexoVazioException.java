package br.acme.exception;

@SuppressWarnings("serial")
public class SexoVazioException extends Exception{

	public SexoVazioException(String msgErro){
		super(msgErro);
	}
}
