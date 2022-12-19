package fiuba.algo3.ejemplo1;

public class Tuberia {
	
	private int coordenadaX;
	private int coordenadaY;
	private Hectarea ubicacion;
	
	public Tuberia(int posicionEnX,int posicionEnY){
		
		this.coordenadaX = posicionEnX;
		this.coordenadaY = posicionEnY;
	
	}

	public  Tuberia(Hectarea unaUbicacion) {
					
				this.ubicacion = unaUbicacion;
		}

	public Hectarea ubicacion() {
		return this.ubicacion; 
	}

}
