package br.acme.exception;

@SuppressWarnings("serial")
public class CpfInvalidoException extends Exception{

	public CpfInvalidoException(String msgErro){
		super(msgErro);
	}
}
