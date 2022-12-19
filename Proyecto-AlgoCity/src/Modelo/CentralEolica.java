package Modelo;

public class CentralEolica extends CentralElectrica{
	
	private static int costo = 1000;
	private static float  porcentajeDeRecuperacion= 15;
	
	public static int costoDeConstruir(){
		return costo;
	}
	
	
	public CentralEolica(Superficie lugarDondeSeConstruyo){
		
		this.consumoElectrico = 0;
		this.estadoEstructura= (float)100.0;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.radio = 4;
		this.capacidadDeAbastecimiento = 100;
		this.esCentralElectrica = true;
		this.dibujo = "Ce";
		
	}

	public CentralEolica() {

		this.consumoElectrico = 0;
		this.estadoEstructura= (float)100.0;
		this.radio = 4;
		this.capacidadDeAbastecimiento = 100;
		this.esCentralElectrica = true;
		this.dibujo = "Ce";
		
	}
	public float getPorcentajeDeRecuperacion() {
		return porcentajeDeRecuperacion;
	}
}
