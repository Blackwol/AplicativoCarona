package br.acme.exception;

@SuppressWarnings("serial")
public class CpfVazioException extends Exception{
	public CpfVazioException(String msgErro){
		super(msgErro);
	}
}
