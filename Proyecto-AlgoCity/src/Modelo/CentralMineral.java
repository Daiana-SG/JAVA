package Modelo;

public class CentralMineral extends CentralElectrica{

	private static int costo = 3000;
	private static float  porcentajeDeRecuperacion= 10;
	
	public static int costoDeConstruir(){
		return costo;
	}

	public CentralMineral(Superficie lugarDondeSeConstruyo){
		
		this.consumoElectrico = 0;
		this.estadoEstructura= (float)100.0;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.radio = 10;
		this.capacidadDeAbastecimiento = 400;
		this.esCentralElectrica = true;
		this.dibujo = "Cm";
		
	}

	public CentralMineral() {
		this.consumoElectrico = 0;
		this.estadoEstructura= (float)100.0;
		this.capacidadDeAbastecimiento = 400;
		this.radio = 10;
		this.esCentralElectrica = true;
		this.dibujo = "Cm";
	}
	public float getPorcentajeDeRecuperacion() {
		return porcentajeDeRecuperacion;
	}
}