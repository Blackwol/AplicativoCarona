package br.acme.exception;

@SuppressWarnings("serial")
public class CpfNullException extends Exception{
	public CpfNullException(String msgErro){
		super(msgErro);
	}
}
