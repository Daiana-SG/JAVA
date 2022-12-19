package Modelo;

public abstract class Construccion {
	
	protected float estadoEstructura;
	protected boolean esRuta = false;
	protected boolean esCentralElectrica = false;
	protected boolean esPozoDeAgua = false;
	protected int consumoElectrico;
	protected Superficie lugarDeConstruccion;
	protected String dibujo;
	private static float  porcentajeDeRecuperacion; 
	
	public float obtenerEstado() {
		return estadoEstructura;
	}

	
	public void daniarEnPorcentaje(float porcentajeDeDanio) {
		
		this.estadoEstructura = this.estadoEstructura - porcentajeDeDanio;

	}
	//ver sila recuperar tiene que estar aca o en la clase Estacion de Bomberos
	public void recuperarEstructura( float porcentajeDeRecuperacion){
		this.estadoEstructura = porcentajeDeRecuperacion;
	}
	
	
	public Superficie obtenerLugarDeConstruccion(){
		return this.lugarDeConstruccion;
	}
	
	public void asignarLugarDeConstruccion(Superficie superficieAsignada){
		
		this.lugarDeConstruccion = superficieAsignada;
	}

	public String dibujar(){
		return this.dibujo;
	}
	
	public boolean esRuta(){
		return this.esRuta;
	}
	
	public boolean esCentralElectrica(){
		return this.esCentralElectrica;
	}


	public float getPorcentajeDeRecuperacion() {
		return porcentajeDeRecuperacion;
	}


	public boolean esPozoDeAgua() {
			return (this.esPozoDeAgua);
	}

}
