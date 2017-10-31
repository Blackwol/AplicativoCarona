package br.acme.tests;
import br.acme.location.Lugar;
import br.acme.location.Viagem;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;

public class TesteViagem {
	public static void main(String[] args){
		//Criar 2 objetos tipo Lugar
		Lugar origem = new Lugar("Casa", "Rua y");
		Lugar destino = new Lugar("Trabalho", "Predio U");
		
		//Criar objeto tipo Motorista
		Motorista m2 = new Motorista(435, "9747747", "Emerson", "afsvfg", "sçzxls", "Masculino", false);
		
		//Criar objeto tipo Solicitante
		Solicitante s2 = new Solicitante(454, "36095863", "cnkvoa", "paord", "Marcia", "Feminino", 12323678);
		
		//Criar objeto tipo Viagem
		Viagem v2 = new Viagem(12, s2, m2, origem, destino, 14.5, "Dinheiro");
		
		v2.setOrigem(origem);
		v2.setDestino(destino);
		v2.setMotorista(m2);
		v2.setCliente(s2);
		
		//Testar método toString
		System.out.println(v2);
	}
}
