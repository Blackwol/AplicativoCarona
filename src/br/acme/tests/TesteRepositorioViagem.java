package br.acme.tests;
import br.acme.location.Viagem;
import br.acme.storage.RepositorioViagem;
import br.acme.users.Solicitante;
import br.acme.users.Motorista;
import br.acme.location.Lugar;


public class TesteRepositorioViagem {
	public static void main(String[] args){
		
		//Criar objeto Solicitante
		Solicitante s1 = new Solicitante(1, "53465465", "apsfp", "Pass", "Julio", "Masculino", 564356786);
		
		//Criar objeto Motorista
		Motorista m1 = new Motorista(435, "9747347", "Carlos", "asdfg", "sdbs", "Masculino", true);
		
		//Criar obejetos Viagem
		Lugar l1 = new Lugar("Casa", "Av. U");
		Lugar l2 = new Lugar("Trabalho", "Rua P");
		
		
		   //Criar objetos tipo Viagem
		Viagem v1 = new Viagem(123, s1, m1, l1, l2, 15.0 , "Cartao");
		Viagem v2 = new Viagem(456, s1, m1, l1, l2, 10.0, "Dinheiro");
		RepositorioViagem viagens = new RepositorioViagem();
		
		  //Teste adicionar
		viagens.adicionar(v1);
		viagens.adicionar(v2);
		System.out.println(v1.getIdViagem());
		System.out.println(v1.getFormaDePagamento());
		System.out.println(v1.getValorDaViagem());
		System.out.println(v2.getIdViagem());
		System.out.println(v2.getFormaDePagamento());
		System.out.println(v2.getValorDaViagem());
		
		
		  //Teste remover
		viagens.remover(123);
		
		
		  //Teste buscar
		viagens.buscar(123);
		
		
		  //Teste buscar todos
		viagens.buscarTodos();
		
		
	}
}
