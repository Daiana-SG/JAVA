package Modelo;

import java.util.ArrayList;


public class Comercial extends Construccion {

	private static int costo = 5;
	private static int consumoElectrico = 2;
	private static float  porcentajeDeRecuperacion= 7;
	private static ArrayList<ServiciosRequeridos> servicios = new ArrayList<ServiciosRequeridos>();
	
	public static ArrayList<ServiciosRequeridos> serviciosRequeridos(){
		
		servicios.add(ServiciosRequeridos.AGUA);
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
	
	
	public Comercial(Superficie lugarDondeSeConstruyo){
		
		this.estadoEstructura = (float)100.0;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.dibujo = "C";
	}


	public Comercial() {
		this.estadoEstructura = (float)100.0;
		this.dibujo = "C";
	}
	public float getPorcentajeDeRecuperacion() {
		return porcentajeDeRecuperacion;
	}
	

}
