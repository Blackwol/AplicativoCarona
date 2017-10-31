package br.acme.location;
import br.acme.users.Motorista;
import br.acme.users.Solicitante;

public class Viagem {
	private long idViagem;
	private Solicitante cliente;
	private Motorista motorista;
	private Lugar origem;
	private Lugar destino;
	private double valorDaViagem;
	private String formaDePagamento;
	
	      //Construtor com atributos
	
	public Viagem(){
		
	}
	
	public Viagem(Lugar origem, Lugar destino, String formaDePagamento){
	    setOrigem(origem);
		setDestino(destino);
		setFormaDePagamento(formaDePagamento);
	}
	
	
	public Viagem(long idViagem, Solicitante cliente, Motorista motorista, Lugar origem, 
			Lugar destino, double valorDaViagem, String formaDePagamento){
		setIdViagem(idViagem);
		setCliente(cliente);
		setMotorista(motorista);
		setOrigem(origem);
		setDestino(destino);
		setValorDaViagem(valorDaViagem);
		setFormaDePagamento(formaDePagamento);
	}
	
	
	   
	//Método toString
	public String toString(){
		return("ID viagem: " + idViagem + "; Cliente: "+ cliente.getNome() + "; Motorista: " + motorista.getNome() +
				 "; Origem: " + origem.getEndereco() + "; Destino: " + destino.getEndereco() + "; Valor: " + 
				valorDaViagem + "; Forma de pagamento: " + formaDePagamento);
	}
	
	
	   //Gets e sets
	
	public void setIdViagem(long idViagem){
		this.idViagem = idViagem;
	}
	
	public void setCliente(Solicitante Cliente){             
		this.cliente = Cliente;
	}
	public void setMotorista(Motorista Motorista){
		this.motorista = Motorista;
	}
	public void setOrigem(Lugar Origem){
		this.origem = Origem;
	}
	public void setDestino(Lugar Destino){
		this.destino = Destino;
	}
	public void setValorDaViagem(double ValorDaViagem){
		this.valorDaViagem = ValorDaViagem;
	}
	public void setFormaDePagamento(String FormaDePagamento){
		this.formaDePagamento = FormaDePagamento;
	}
	public long getIdViagem(){
		return idViagem;
	}
	public Solicitante getCliente(){
		return cliente;
	}
	public Motorista getMotorista(){
		return motorista;
	}
	public Lugar getOrigem(){
		return origem;
	}
	public Lugar getDestino(){
		return destino;
	}
	public double getValorDaViagem(){
		return valorDaViagem;
	}
	public String getFormaDePagamento(){
		return formaDePagamento;
	}
	
}
