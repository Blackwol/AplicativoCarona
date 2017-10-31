package br.acme.location;
public class Lugar {
	private String identificadorDeLugar;
	private String endereco;
	
	public Lugar(){         //Construtor sem os atributos
		
	}
	
	public Lugar(String identificadorDeLugar, String endereco){   //Construtor com os atributos
		setIdentificadorDeLugar(identificadorDeLugar);
		setEndereco(endereco);
	}
	
	
	//toString
	public String toString(){
		return("Endereço: " + endereco + "\nIdentificador de lugar: " + identificadorDeLugar);
	}
	
	public void setIdentificadorDeLugar(String IdentificadorDeLugar){      //Sets e gets a partir daqui
		this.identificadorDeLugar = IdentificadorDeLugar;
	}
	public void setEndereco(String Endereco){
		this.endereco = Endereco;
	}
	public String getIdentificadorDeLugar(){
		return identificadorDeLugar;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
}
