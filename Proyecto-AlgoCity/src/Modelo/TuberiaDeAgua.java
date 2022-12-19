package Modelo;

public class TuberiaDeAgua {
	
	private boolean conectadaAPozo;
	
	// por el momento el constructor asume que se crea conectada
	public TuberiaDeAgua(){
		this.conectadaAPozo = true;
	}
	
	public boolean estaConectada(){
		return this.conectadaAPozo;
	}
}
