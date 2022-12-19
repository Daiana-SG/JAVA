package Modelo;


public class PozoDeAgua extends Construccion {
	private int coordenadaX;
	private int coordenadaY;	
	private Hectarea ubicacion;
	
	private static int costo = 250;

	public static int costoDeConstruir(){
		return costo;
	}

		
	public void pozoDeAgua(int posicionEnX,int posicionEnY){
		
		this.coordenadaX = posicionEnX;
		this.coordenadaY = posicionEnY;
			
	}
			
	public PozoDeAgua(Hectarea unaHectarea) {
		this. ubicacion = unaHectarea;
		this.estadoEstructura= (float)100.0;
	}


	public PozoDeAgua(Superficie lugarDondeSeConstruyo) {
		this.lugarDeConstruccion = lugarDondeSeConstruyo;
		this.dibujo ="P"; 
			
	}

	public PozoDeAgua() {
		this.dibujo ="P"; 
	}


	public Hectarea ubicacion() {
		return this.ubicacion;
	}

}
