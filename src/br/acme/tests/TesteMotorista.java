package br.acme.tests;
import br.acme.location.Viagem;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;
import br.acme.location.Lugar;

public class TesteMotorista {
	public static void main(String[] args){
		
		//Criar objeto tipo Motorista
		Motorista m1 = new Motorista(1, "3457347", "Carlos", "asdfg", "sdbs", "Masculino", true);
		Motorista m2 = new Motorista(2, "9747347", "Carla", "qwert", "scvcv", "Feminino", true);
		Motorista m3 = new Motorista(2, "7475347", "Luiz", "bvvxx", "sfssd", "Masculino", false);
		//Criar objeto Solicitante
		Solicitante s1 = new Solicitante(1, "53465465", "apsfp", "Pass", "Julio", "Masculino", 564356786);
		Solicitante s2 = new Solicitante(2, "53465465", "apsfp", "Pass", "Julia", "Feminino", 564356786);
		
		//Criar objetos Lugar
		Lugar l1 = new Lugar("Casa", "Rua X");
		Lugar l2 = new Lugar("Trabalho", "Rua Y");
		
		//Criar objeto tipo Viagem
		Viagem v1 = new Viagem(2, s1, m1, l1, l2,  20.0, "Dinheiro");
		Viagem v2 = new Viagem(1, s2, m2, l2, l1,  15.0, "Cartao");
		Viagem v3 = new Viagem(3, s2, m1, l1, l2,  10.0, "Cartao");
		
		
		//Testar metodo responderPedido
		m3.responderPedido(m1 ,v2);
		m1.responderPedido(m2 , v3);
		m2.responderPedido(m3 , v1);
		
		//Testar metodo historico
		m1.historico();
		m2.historico();
		
		//Testar toString
		System.out.println(m1);
	}
}
