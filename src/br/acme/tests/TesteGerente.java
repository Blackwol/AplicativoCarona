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
import br.acme.users.Gerente;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;

public class TesteGerente {
	public static void main(String [] args) throws CpfNullException, NomeNullException, 
	SenhaNullException, EmailNullException, SexoNullException, CpfVazioException, NomeVazioException, 
	EmailVazioException, SenhaVaziaException, SexoVazioException, IdInvalidoException, CpfInvalidoException{
		
		//Criar objeto do tipo Motorista
		Motorista m1 = new Motorista(1, "6987653", "Joao", "pass", "sdbgvsd", "Masculino", true);
		Motorista m2 = new Motorista(2, "9029830", "Fabiana", "Word", "osdn", "Feminina", false);
		Motorista m3 = new Motorista(3, "9875482", "Luiza", "sdvomsdo", " bcvd", "Feminina", false);
		
		//Criar objeto tipo Gerente
		Gerente g1 = new Gerente(12, "23456789", "Anna", "vcxz", "svbsgf", "Feminino");
		
		//Criar objeto tipo Solicitante
		Solicitante s2 = new Solicitante(345, "36094863", "cnivna", "pbord", "Fabiana", "Feminino", 12323998);
		Solicitante s1 = new Solicitante(898, "54654654", "wicdk", "ududc", "Fabio", "Masculino", 96857434);
		
	    g1.getSolicitantes()[0] = s1;
	    g1.getSolicitantes()[1] = s2;
		
		
		//Testar métodos da classe Gerente
		g1.cadastrarMotorista(m1);
		g1.cadastrarMotorista(m2);
		g1.cadastrarMotorista(m3);
		g1.cadastrarSolicitante(s1);
		g1.cadastrarSolicitante(s2);
		g1.listarMotoristas();
		g1.listarSolicitantes();
		g1.removerMotorista(2);
		g1.removerMotorista(1);
		
		//Testar toString
		System.out.println(g1);
		
	}
}
