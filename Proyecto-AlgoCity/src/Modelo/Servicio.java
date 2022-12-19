package Modelo;

public abstract class Servicio {
	
	protected int costo;
	protected Superficie lugarDeConstruccion;
	protected String dibujo;
	
	
	public Superficie obtenerLugarDeConstruccion(){
		return this.lugarDeConstruccion;
	}

	public String dibujar(){
		return this.dibujo;
	}

}
