package Modelo;

import java.util.ArrayList;


public class Industrial extends Construccion {
	
	private static int costo = 10;
	private static float  porcentajeDeRecuperacion= 3;
	private static int consumoElectrico = 2;
	private static ArrayList<ServiciosRequeridos> servicios = new ArrayList<ServiciosRequeridos>();
	
	public static ArrayList<ServiciosRequeridos> serviciosRequeridos(){
		
		servicios.add(ServiciosRequeridos.RUTA);
		servicios.add(ServiciosRequeridos.LUZ);
		return servicios;
	}
	
	public static int energiaNecesaria(){
		return consumoElectrico;
	}

	public static int costoDeConstruir(){
		return costo;
	}
	
	public Industrial(Superficie lugarDondeSeConstruyo){
		
		this.estadoEstructura = (float)100.0;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.dibujo = "I";
	}

	public Industrial() {
		this.estadoEstructura = (float)100.0;
		this.consumoElectrico = 2;
		this.dibujo = "I";
	}
	public float getPorcentajeDeRecuperacion() {
		return porcentajeDeRecuperacion;
	}

}
