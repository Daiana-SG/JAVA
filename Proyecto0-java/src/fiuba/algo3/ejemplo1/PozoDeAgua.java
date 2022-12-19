package fiuba.algo3.ejemplo1;

public class PozoDeAgua {
	
	private int coordenadaX;
	private int coordenadaY;
	private Hectarea ubicacion;

	
	public void pozoDeAgua(int posicionEnX,int posicionEnY){
		
		this.coordenadaX = posicionEnX;
		this.coordenadaY = posicionEnY;
	}
			
	public PozoDeAgua(Hectarea unaHectarea) {
		this. ubicacion = unaHectarea;
	}

	public Hectarea ubicacion() {
		return this.ubicacion;
	}

}
