package br.acme.storage;
import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import br.acme.exception.RepositorioCheioException;
//import br.acme.location.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.ArrayList;

import br.acme.users.*;

public class DataBase {

	public DataBase(){
		
	}
	
	   //nome --> eh o nome e caminho do arquivo
	   //str --> eh oq vai ser gravado
	   //Gravar dados
	
	public static void gravarDados(String nome, String str, String extensao) {
		FileWriter arq;
		try {
			arq = new FileWriter(nome + "." + extensao);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(str);
			arq.close();
			System.out.println("arquivo gravado em: " + nome + "." + extensao);
		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo");
		}
	}
	
	public static void SalvarEstado(RepositorioMotorista repMotorista){
		gravarDados("Dados-do-motorista", repMotorista.toString(), "txt");
	}
	
	public static void SalvarEstado(RepositorioSolicitante repSolicitante){
		gravarDados("Dados-do-solicitante", repSolicitante.toString(), "txt");
	}
	
	public static void SalvarEstado(RepositorioViagem repViagem){
		gravarDados("Dados-da-viagem", repViagem.toString(), "txt");
	}
	
	public static void SalvarEstado(Gerente gerente){
		SalvarEstado(gerente.getRepMotorista());
		SalvarEstado(gerente.getRepSolicitante());
	}
	
	public static void lerDados(String nome){
		System.out.println("Conteudo do arquivo texto " + nome + ": \n");
		try{
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while(linha != null){
				System.out.printf("%s\n", linha);
				linha = lerArq.readLine();
			}
			arq.close();
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		System.out.println();
	}
	
	
	public static RepositorioMotorista lerBaseMotoristas(){
		RepositorioMotorista repMotorista = new RepositorioMotorista();
		lerDados("Dados-do-motorista.txt");
		return repMotorista;
	}
	
	public static RepositorioSolicitante lerBaseSolicitante(){
		RepositorioSolicitante repSolicitante = new RepositorioSolicitante();
		lerDados("Dados-do-solicitante.txt");
		return repSolicitante;
	}
	
	public static RepositorioViagem lerBaseViagem(){
		RepositorioViagem repViagem = new RepositorioViagem();
		lerDados("Dados-da-viagem.txt");
		return repViagem;
	}
	
	//lerBase motorista/solicitante pelo gerente
	public static Gerente lerBaseGerente(){
		Gerente gerente = new Gerente();
		gerente.setRepMotorista(DataBase.lerBaseMotoristas());
		gerente.setRepSolicitante(DataBase.lerBaseSolicitante());
		return gerente;
	}
	
}

