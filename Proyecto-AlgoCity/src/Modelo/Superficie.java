package Modelo;

public abstract class Superficie {
	
	protected Construccion construccion;
	protected String dibujo;
	protected boolean esAgua;
	protected boolean esTierra;
	
	public void construir(Construccion construccion){
		this.construccion = construccion;
		construccion.asignarLugarDeConstruccion(this); 
	}
	
	public boolean tieneConstruccion(){
		return (this.construccion != null);
	}
	
	public String dibujar() {
		if(this.tieneConstruccion()){
			return this.construccion.dibujar();
		}
		else{
		return this.dibujo; // Prueba, proximamente Interfaz
		}
	}
	
	/*
	 * Si la superficie no tiene una construccion no resta danio
	 */
	public void modificarEstadoConstruccion(float porcentajeAModificar){
		if(this.tieneConstruccion())
		construccion.daniarEnPorcentaje(porcentajeAModificar);
	}
	
	public float obtenerEstadoConstruccion(){
		return construccion.obtenerEstado();
	}
	
	public Construccion obtenerConstruccion(){
		return this.construccion;
	}

	public boolean esAgua() {
		
		return this.esAgua;
	}
	
	public boolean esTierra() {
		
		return this.esTierra;
	}

	public boolean tieneLuz(){
		
		return false;
	}

	public abstract boolean puedoConstruirResidencia();

	public abstract boolean puedoConstruirComercio();

	public abstract boolean puedoConstruirIndustria();

	public abstract boolean puedoConstruirEdificioTerrestre();

	public abstract boolean puedoConstruirPozoDeAgua();

}