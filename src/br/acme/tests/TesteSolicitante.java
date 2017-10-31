package br.acme.tests;
import br.acme.exception.CpfInvalidoException;
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
import br.acme.location.Lugar;
import br.acme.users.Motorista;
import br.acme.location.Viagem;
import br.acme.users.Solicitante;

public class TesteSolicitante {
	public static void main(String[] args) throws CpfNullException, NomeNullException, SenhaNullException, EmailNullException, 
	SexoNullException, CpfVazioException, NomeVazioException, EmailVazioException, SenhaVaziaException, SexoVazioException, 
	IdInvalidoException, CpfInvalidoException{
		
		//Criar objeto Motorista
		Motorista m1 = new Motorista(1, "945647", "Joao", "asdfg", "sdbs", "Masculino", true);
		Motorista m2 = new Motorista(2, "9747347", "Mariana", "vfrrb", "bnjgs", "Feminino", false);
		
		//Criar objeto tipo Lugar
		Lugar l1 = new Lugar("Trabalho", "Rua O");
		Lugar l2 = new Lugar("Casa", "Av. A");
		
		//Criar objeto tipo Solicitante
		Solicitante s2 = new Solicitante(345, "36094863", "cnivna", "pbord", "Fabiana", "Feminino", 12323998);
		Solicitante s1 = new Solicitante(898, "54654654", "wicdk", "ududc", "Fabio", "Masculino", 96857434);
		
		//Criar objeto tipo Viagem
		Viagem v1 = new Viagem(1, s2, m1, l1, l2, 10.0, "Cartao");
		Viagem v2 = new Viagem(2, s1, m2, l2, l1, 20.0, "Dinheiro");
		
		s1.getRepMotorista().adicionar(m1);
		s1.getRepViagem().adicionar(v2);
		
		//Testar método solicitarCarona
		s1.solicitarCarona(v1);
		
		//Testar método cancelarCarona
		s1.cancelarCarona(2);
		
		//Testar método historico
		s1.historico();
		
		//Testar toString
		System.out.println(s2);
	}
}
