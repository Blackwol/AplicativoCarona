package br.acme.tests;
import br.acme.users.*;
import br.acme.storage.*;
/*import br.acme.exception.CpfInvalidoException;
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
import br.acme.exception.SexoVazioException;*/
import br.acme.location.*;

public class TesteDataBase {
	public static void main(String[] args) throws Exception{
		
		//Criar objetos tipo Motorista
		Motorista m1 = new Motorista(1, "3457347", "Carlos", "asdfg", "sdbs", "Masculino", true);
		Motorista m2 = new Motorista(2, "9747347", "Carla", "qwert", "scvcv", "Feminino", true);
		Motorista m3 = new Motorista(3, "7475347", "Luiz", "bvvxx", "sfssd", "Masculino", false);
		Motorista m4 = new Motorista(4, "09876543212", "Bruno", "1234567", "ckmdkc", "M", true);
		
		//Criar objeto tipo RepositorioMotorista
		RepositorioMotorista repMotorista = new RepositorioMotorista();
		
		//Criar objetos tipo Solicitante
		Solicitante s1 = new Solicitante(1, "36094863", "cnivna", "pbord", "Fabiana", "Feminino", 12323998);
		Solicitante s2 = new Solicitante(2, "54654654", "1234567", "ududc", "Fabio", "Masculino", 96857434);
		Solicitante s3 = new Solicitante(3, "12345678909", "1234567", "asdfg", "Pedro", "M", 86456764);
		
		//Criar objeto tipo RepositorioSolicitante
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		
		//Criar obejtos tipo Lugar
		Lugar l1 = new Lugar("Casa", "Rua N");
		Lugar l2 = new Lugar("Trabalho", "Av. X");
		Lugar l3 = new Lugar("Trabalho", "Agamenon");
		Lugar l4 = new Lugar("Casa", "Rua N");
		
		//Criar objetos tipo Viagem
		Viagem v1 = new Viagem(1, s1, m1, l1, l2, 14.5, "Dinheiro");
		Viagem v2 = new Viagem(2, s2, m2, l2, l3, 14.5, "Dinheiro");
		Viagem v3 = new Viagem(3, s3, m3, l3, l4, 14.5, "Dinheiro");
		
		//Criar objeto tipo RepositorioViagem/Motorista/Solicitante
		RepositorioViagem repViagem = new RepositorioViagem();
		
		
		//Criar objeto tipo Gerente
		Gerente g1 = new Gerente(1, "23456789", "Anna", "vcxz", "svbsgf", "Feminino");
		
		//Adicionar motoristas
		repMotorista.adicionar(m1);
		repMotorista.adicionar(m2);
		repMotorista.adicionar(m3);
		repMotorista.adicionar(m4);
		
		//Adicionar solicitantes
		repSolicitante.adicionar(s1);
		repSolicitante.adicionar(s2);
		repSolicitante.adicionar(s3);
		
		//Adicionar viagens
		repViagem.adicionar(v1);
		repViagem.adicionar(v2);
		repViagem.adicionar(v3);
		
		//Adicionar motorista pelo gerente
		g1.cadastrarMotorista(m1);
		g1.cadastrarMotorista(m2);
		g1.cadastrarMotorista(m3);
		g1.cadastrarMotorista(m4);
		g1.cadastrarSolicitante(s1);
		g1.cadastrarSolicitante(s2);
		g1.cadastrarSolicitante(s3);
		
		//Testar os metodos da DataBase
		DataBase.SalvarEstado(repMotorista);
		DataBase.SalvarEstado(repSolicitante);
		DataBase.SalvarEstado(repViagem);
		DataBase.SalvarEstado(g1);
		
		
		DataBase.lerBaseMotoristas();
		DataBase.lerBaseSolicitante();
		DataBase.lerBaseViagem();
	}
}
