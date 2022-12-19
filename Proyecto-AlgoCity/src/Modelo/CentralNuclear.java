package Modelo;

public class CentralNuclear extends CentralElectrica {
	
	private static int costo = 10000;
	private static float  porcentajeDeRecuperacion= 3;
	
	public static int costoDeConstruir(){
		return costo;
	}

	
	public CentralNuclear(Superficie lugarDondeSeConstruyo){
		
		this.consumoElectrico = 0;
		this.estadoEstructura= (float)100.0;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.capacidadDeAbastecimiento = 1000;
		this.radio = 25;
		this.esCentralElectrica = true;
		this.dibujo = "Cn";
		
	}

	public CentralNuclear() {
		this.consumoElectrico = 0;
		this.estadoEstructura= (float)100.0;
		this.capacidadDeAbastecimiento = 1000;
		this.radio = 25;
		this.esCentralElectrica = true;
		this.dibujo = "Cn";
		
	}
	public float getPorcentajeDeRecuperacion() {
		return porcentajeDeRecuperacion;
	}
}
