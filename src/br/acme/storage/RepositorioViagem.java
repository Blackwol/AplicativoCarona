package br.acme.storage;
import br.acme.location.Viagem;


public class RepositorioViagem implements IRepositorioViagem {
	
	private Viagem[] viagens;
    private int contadorAdicionar;
    //private long id = 1;
    
    public RepositorioViagem(){
    	this.viagens = new Viagem[10];
    	this.contadorAdicionar = 0;
    }
	
	  //Método adicionar
	public void adicionar(Viagem adicionarViagem){
		boolean achar = true;
		for(int i = 0; i < 10; i++){
			if(viagens[i] != null){
				if(adicionarViagem.getIdViagem() == viagens[i].getIdViagem()){
					System.out.println("Ja existe essa viagem com esse ID");
					achar = false;
					break;
				}
			}
		}
		for(int i = 0; i < 10; i++){
			if(viagens[i] == null){
				System.out.println("Espaço disponivel para adicionar!");
				break;
			}
		}
		if(achar == true){
			viagens[contadorAdicionar] = adicionarViagem;
			contadorAdicionar++;
			//viagens[contadorAdicionar].setIdViagem(id);
			//id++;
		}
	}
	
	  //Método remover
	public void remover(long id){
		boolean achar = true;        
		for(int i = 0; i < 10; i++){           //Busca viagem com o mesmo ID e remove        
			if(viagens[i] != null){
				if(id == viagens[i].getIdViagem()){
					viagens[i] = null;
					System.out.println("Viagem removida.");
					achar = false;
					break;
				}
			}
		}
		if(achar){         //Se nao achar uma viagem com mesmo ID
			System.out.println("Id invalido.");
		}
	}
	
	  //Método buscar
	public Viagem buscar(long id){
		Viagem buscador = null;
		for(int i = 0; i < 10; i++){         
			if(viagens[i] != null){
				if(id == viagens[i].getIdViagem()){
					buscador = viagens[i];
					System.out.println(buscador);
					break;
				}
			}
		}
		return buscador;
}

	
	  //Método buscar todos
	public Viagem[] buscarTodos(){
		Viagem[] buscador = new Viagem[10];
		for(int i = 0; i < 10; i++){        //Iguala as viagens aos buscadores
			if(viagens[i] != null){
				buscador[i] = viagens[i];
				System.out.println(buscador[i].toString());
				}
			}
			
		return buscador;       //retorna os buscadores(viagens)
	}
	
	//Método toString
	public String toString(){
		String dados = "";
		for(int i = 0; i < 10; i++){
			if(viagens[i] != null){
				dados = this.viagens[i].toString();
			}
		}
		return dados;
	}
	
	//Set get
	
	public void setViagens(Viagem[] viagens){
		this.viagens = viagens;
	}
	
	public Viagem[] getViagens(){
		return viagens;
	}

}
