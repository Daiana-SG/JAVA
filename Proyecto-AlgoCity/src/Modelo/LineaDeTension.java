package Modelo;

public class LineaDeTension {
	
	private static int costo = 10;
	
	public static int costoDeConstruir(){
		return costo;
	}
	
	private boolean conectadaACentral;
	
	// por el momento el constructor asume que se crea conectada
	public LineaDeTension() {
		this.conectadaACentral = true;
	}
	
	public boolean estaConectada(){
		return this.conectadaACentral;
	}

}
