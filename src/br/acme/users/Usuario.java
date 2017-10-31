package br.acme.users;
//import br.acme.storage.*;


import br.acme.exception.CpfNullException;
import br.acme.exception.CpfVazioException;
import br.acme.exception.EmailNullException;
import br.acme.exception.EmailVazioException;
import br.acme.exception.IdInvalidoException;
import br.acme.exception.NomeNullException;
import br.acme.exception.NomeVazioException;
import br.acme.exception.SenhaNullException;
import br.acme.exception.SenhaVaziaException;
import br.acme.exception.SexoNullException;
import br.acme.exception.SexoVazioException;

public abstract class Usuario {
	private long id;
	private String cpf;
	private String nome;
	private String senha;
	private String email;
	private String sexo;
	
	
	public Usuario(){
		
	}
	
	public Usuario(long id, String cpf, String nome, String senha, String email, String sexo){
		setId(id);
		setCpf(cpf);
		setNome(nome);
		setSenha(senha);
		setEmail(email);
		setSexo(sexo);
	}

	
	//Gets e sets
		public void setId(long id){
			this.id = id;
		}
		
		public void setCpf(String cpf){
			this.cpf = cpf;
		}
		
		public void setNome(String nome){
			this.nome = nome;
		}
		
		public void setSenha(String senha){
			this.senha = senha;
		}
		
		public void setEmail(String email){
			this.email = email;
		}
		
		public void setSexo(String sexo){
			this.sexo = sexo;
		}
		
		public long getId(){
			return id;
		}
		
		public String getCpf(){
			return cpf;
		}
		
		public String getNome(){
			return nome;
		}
		
		public String getSenha(){
			return senha;
		}
		
		public String getEmail(){
			return email;
		}
		
		public String getSexo(){
			return sexo;
		}
		
		
		
		public String toString(){
			return ("ID: " + id + "; CPF: "+ cpf +"; Nome: " + nome + "; Senha: " + senha + "; Email: "+ email +
					"; Sexo: "+ sexo);
		}
		
		public abstract void validar() throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
		SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
		IdInvalidoException;
		


}
