package Modelo;

import java.util.ArrayList;


public class Residencial extends Construccion {
	
		private static int costo = 5;
		private static int consumoElectrico = 1;
		private static float  porcentajeDeRecuperacion= 10;
		private static ArrayList<ServiciosRequeridos> servicios = new ArrayList<ServiciosRequeridos>();
		
		public static ArrayList<ServiciosRequeridos> serviciosRequeridos(){
			
			servicios.add(ServiciosRequeridos.AGUA);
			servicios.add(ServiciosRequeridos.RUTA);
			servicios.add(ServiciosRequeridos.LUZ);
			return servicios;
		}
		
		public static int costoDeConstruir(){
			return costo;
		}
		
		public static int energiaNecesaria(){
			return consumoElectrico;
		}
		
		public Residencial(Superficie lugarDondeSeConstruyo){
		
		this.estadoEstructura = (float)100.0;
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.dibujo = "R";
	}

		public Residencial() {
			
			this.estadoEstructura = (float)100.0;
			this.consumoElectrico = 1;
			this.lugarDeConstruccion = null;
			this.dibujo = "R";
		}
		public float getPorcentajeDeRecuperacion() {
			return porcentajeDeRecuperacion;
		}
	
}
