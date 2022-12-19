package Modelo;

public class Hectarea {

	private int coordenadaX;
	private int coordenadaY;
	private Superficie superficie;
	
	public Hectarea(int coordenadaX,int coordenadaY){
		
		this.coordenadaX     = coordenadaX;
		this.coordenadaY     = coordenadaY;
		this.superficie		 = null;
	}
	
	public static Hectarea hectareaConTierra(int x , int y){
		
		Hectarea nuevaHectarea = new Hectarea( x , y );
		nuevaHectarea.asignarSuperficie(new Tierra());
		return nuevaHectarea;
		
	}
	
	public static Hectarea hectareaConAgua(int x , int y){
		
		Hectarea nuevaHectarea = new Hectarea( x , y );
		nuevaHectarea.asignarSuperficie(new Agua());
		return nuevaHectarea;
		
	}
	
	public int getCoordenadaX(){
		return this.coordenadaX;
	}
	
	public int getCoordenadaY(){
		return this.coordenadaY;
	}
	
	public String dibujarSuperficie(){
		return superficie.dibujar();
	}
	
	public Superficie obtenerSuperficie(){
		return this.superficie;
	}
	
	public void asignarSuperficie(Superficie superficie){
		this.superficie = superficie;
	}
	
	/*
	 * Devuelve la distancia entre las hectareas, en cantidad de Ha.
	 */
	
	public int calcularDistancia (Hectarea otraHectarea){
		
		int distanciaEnX = (this.coordenadaX - otraHectarea.coordenadaX);
		if(distanciaEnX < 0)
			distanciaEnX = - distanciaEnX;
		
		int distanciaEnY = (this.coordenadaY - otraHectarea.coordenadaY);
		if(distanciaEnY < 0)
			distanciaEnY = - distanciaEnY;
		
		return (distanciaEnX + distanciaEnY);
	}
	
	public void daniarSuperficie(float porcentajeDanio){
		this.superficie.modificarEstadoConstruccion(porcentajeDanio);
	}

	public void construirResidencial(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirResidencial();
	}
	
	public void construirIndustrial(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirIndustrial();
	}
	
	public void construirComercial(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirComercial();
	}
	
	public void construirCentralEolica(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirCentralEolica();
	}
	
	public void construirCentralNuclear(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirCentralNuclear();
	}
	
	public void construirCentralMineral(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirCentralMineral();
	}
	
	public void construirRutaPavimentada(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirRutaPavimentada();
	}
	
	public void construirPozoDeAgua(){
		Agua agua = (Agua) this.superficie;
		
		agua.construirPozoDeAgua();
	}
	
	public void construirEstacionDeBomberos(){
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.construirEstacionDeBomberos();
	}

	public void crearLineaDeTension() {
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.crearLineaDeTension();
		
		
	}
	
	public void crearTuberiaDeAgua() {
		Tierra tierra = (Tierra) this.superficie;
		
		tierra.crearTuberiaDeAgua();
		
		
	}
	
}
