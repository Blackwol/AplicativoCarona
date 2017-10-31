package br.acme.tests;
import br.acme.location.Lugar;

public class TesteLugar {
	public static void main(String[] args){
		
		//Criar objeto tipo Lugar
		Lugar l1 = new Lugar("Casa", "Rua N");
		
		//Testar método toString
		System.out.println(l1);
	}
}
