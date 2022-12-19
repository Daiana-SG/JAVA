package Modelo;


public class RutaPavimentada extends Construccion {
	
	private static int costo = 10;

	public static int costoDeConstruir(){
		return costo;
	}
	
	public RutaPavimentada(Superficie lugarDondeSeConstruyo){
		
		this.esRuta = true;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.dibujo = "Rt";
	}

	public RutaPavimentada() {
		this.esRuta = true;
		this.dibujo = "Rt";
	}

}
