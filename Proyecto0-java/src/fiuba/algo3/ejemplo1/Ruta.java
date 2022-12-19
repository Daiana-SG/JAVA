package fiuba.algo3.ejemplo1;



public class Ruta {
	
	private int coordenadaX;
	private int coordenadaY;
	private Hectarea ubicacion;
	
	public Ruta(int posicionEnX,int posicionEnY){
		
		this.coordenadaX = posicionEnX;
		this.coordenadaY = posicionEnY;
	
	}

	public  Ruta(Hectarea unaUbicacion) {
					
				this.ubicacion = unaUbicacion;
		}

	public Hectarea ubicacion() {
		return this.ubicacion; 
	}
		
}


