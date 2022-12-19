package Modelo;

import java.util.ArrayList;

public class EstacionDeBomberos extends Construccion{
	
	private static int costo = 1500;
	private float reconstruccion = 100;
	private static float estadoTotal = 100; 
	private float estadoConstruccion;
	private float porcentajeDeRecuperacion;
	private float recuperacion;
	private float estado; 
	private float estadoDeRecuperacion; 
	
	public static float costoDeConstruir() {
		
		return costo;
	}
	
	public EstacionDeBomberos(Tierra unaTierra) {
		// TODO Auto-generated constructor stub
	}
	
	public EstacionDeBomberos(Superficie lugarDondeSeConstruyo){
		
		this.estadoEstructura = (float)100.0;
		this.dibujo = "B";
	}
	
	
	public EstacionDeBomberos() {
		this.estadoEstructura = (float)100.0;
		this.dibujo = "B";
		
	}
	public float obtenerEstado() {
		return (float)100.0;
	}

	//public void aplicarReconstruccionA(Construccion unaConstruccion) {
		//unaConstruccion.recuperarEstructura(100);
		
	//}
	
	//ver bien este metodo que no funciona correctamente
	public void aplicarReconstruccionA(Construccion unaConstruccion){
		//this.estadoConstruccion = unaConstruccion.obtenerEstado();
		//this.porcentajeDeRecuperacion = unaConstruccion.getPorcentajeDeRecuperacion();
		//this.estado = (this.estadoTotal - this. estadoConstruccion); //me da el porcentaje daniado
		//this.estadoDeRecuperacion = (estado * porcentajeDeRecuperacion)/100; //me da el porcentaje de recuperacion de la construccion
		//return (this.estado = this.estado + this.estadoDeRecuperacion);
		if ((unaConstruccion.obtenerEstado()+unaConstruccion.getPorcentajeDeRecuperacion())<= 100){
			unaConstruccion.recuperarEstructura(unaConstruccion.obtenerEstado()+unaConstruccion.getPorcentajeDeRecuperacion());
		}
		else{
			unaConstruccion.recuperarEstructura(100);
		}
	}
	
}